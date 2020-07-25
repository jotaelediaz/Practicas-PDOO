/* Napakalaki - Práctica 2 - PDOO

Desarrolladores: JotaEle Díaz - Joaquín Baca
@author jotaele / @joaquinbaca

*/

package napakalaki;

import java.util.ArrayList;

public class Player {
    
    private boolean dead = true;
    private String name;
    private int level = 1;
    private ArrayList<Treasure> visibleTreasures = new ArrayList();
    private ArrayList<Treasure> hiddenTreasures = new ArrayList();
    private BadConsequence pendingBadConsequence;

    
    public Player(String name) {
        this.name = name;
    }
    
    // Constructor de Copia (Crea un nuevo jugador copia de otro)
    public Player(Player p) {  
        this.dead = p.dead;
        this.name = p.name;
        this.level = p.level;
        this.visibleTreasures = p.visibleTreasures;
        this.hiddenTreasures = p.hiddenTreasures;
        this.pendingBadConsequence = p.pendingBadConsequence;
    }
    
    //Devuelve el nivel de combate del monstruo al que se enfrenta el jugador.
    protected int getOponentLevel(Monster m) {
        return m.getCombatLevel();
    }
    
    // Esta función determina si el jugador debe pasar a ser Sectario o no.
    protected boolean shouldConvert() {
        // Un jugador pasa a ser sectario si tras tirar (tras haber perdido contra un monstruo y no haber muerto) el dato obtiene un 6.
 
        Dice dado = Dice.getInstance();
        int num = dado.nextNumber("Has perdido, ¡Pero no todo iba a ser malo!","¡Saca un 6 y te convertirás en un Sectario!");
        
        if (num == 6) { return true; }
        else { return false; }

    }
    
    private void bringToLife() {
        this.dead = false;
    }
    
    public int getCombatLevel() {
        
        int combatLevel = this.level;
        boolean hasTheNecklace = false;
        
        for (Treasure visibleTreasure : this.visibleTreasures) {
            if (visibleTreasure.getKind() == TreasureKind.necklace) { hasTheNecklace = true; }
        }
  
        if (hasTheNecklace) {
            for(Treasure visibleTreasure : this.visibleTreasures) {
                combatLevel = combatLevel + visibleTreasure.getMaxBonus();
            }            
        } else {
            for(Treasure visibleTreasure : this.visibleTreasures) {
                combatLevel = combatLevel + visibleTreasure.getMinBonus();
            }            
        }
        
        return combatLevel;
        
    }
    
    private void incrementLevels(int l) {
        this.level = level + l;
    }
    
    private void decrementLevels(int l) {
        
        this.level = level - l;
 
        if (level < 1) { level = 1; } // Si el nivel en que se queda es menor que 1, lo dejamos en 1.
        
    }
    
    private void setPendingBadConsequence (BadConsequence b) {
        this.pendingBadConsequence = b;
    }
    
    private void dielfNoTreasures() {
        
        if (visibleTreasures.isEmpty() && hiddenTreasures.isEmpty() ) {
            this.dead = true; 
        }
    }
    
    private void discardNecklaceIfVisible() {
        
        for (int i= 0; i<visibleTreasures.size();i++) {
            
            if (visibleTreasures.get(i).getKind() == TreasureKind.necklace) {
                
                CardDealer dealer = CardDealer.getInstance();
                
                dealer.giveTreasureBack(visibleTreasures.get(i));
                visibleTreasures.remove(visibleTreasures.get(i));             
                
            }
            
        }   
        
    }
    
    private void die() {
      
      setLevel(1);
      CardDealer dealer = CardDealer.getInstance();
      
      for(Treasure visibleTreasure : this.visibleTreasures){  
          dealer.giveTreasureBack(visibleTreasure);
      }
      
      visibleTreasures.clear();
      
      for(Treasure hiddenTreasure : this.hiddenTreasures){
          dealer.giveTreasureBack(hiddenTreasure);
      }
      
      hiddenTreasures.clear();
      dielfNoTreasures();  
        
    }
    
    protected float computeGoldCoinsValue( ArrayList<Treasure> t ) {
        
        float totalGoldCoins = 0;
        float levels;
        
        for (Treasure treasure : t) {
            totalGoldCoins += treasure.getGoldCoins();
        }
        
        levels = totalGoldCoins/1000;
        
        return levels;
    }
    
    private boolean canIBuyLevels(int l) {
        boolean ICan = true;
        
        if (this.level+l >= 10 ) {
            ICan = false;
        }
        
        
        return ICan;
    }
    
    private void applyPrize(Monster currentMonster) {
        
        
        int nLevels = currentMonster.getLevelsGained();
        incrementLevels(nLevels);
        int nTreasures = currentMonster.getTreasuresGained();
        
        if (nTreasures > 0) {
            
            CardDealer dealer = CardDealer.getInstance();
            
            for (int i = 0; i<nTreasures; i++) {
                Treasure treasure = dealer.nextTreasure();
                hiddenTreasures.add(treasure);
            }
        }
    }
    
    private void applyBadConsequence(BadConsequence bad) {
        
        int nLevels = bad.getLevels();
        decrementLevels(nLevels);
        
        BadConsequence pendingBad = bad.adjustToFitTreasureList(visibleTreasures,hiddenTreasures);
        setPendingBadConsequence(pendingBad);
        
    }
    
    private boolean canMakeTreasureVisible(Treasure t) {    
        
        boolean puedo = false;
        
        //Gestión de los objetos según si son de dos manos, una mano u otros
        if(t.getKind() == TreasureKind.bothHand) {
          
            if ( howManyVisibleTreasures(TreasureKind.bothHand) == 0 && howManyVisibleTreasures(TreasureKind.oneHand) == 0) {
                puedo = true;
            }
            
        } else if(t.getKind() == TreasureKind.oneHand) {
            
            if ( howManyVisibleTreasures(TreasureKind.bothHand) == 0 && howManyVisibleTreasures(TreasureKind.oneHand) < 2) {
                puedo = true;
            }
            
        } else {
            
            if ( howManyVisibleTreasures( t.getKind() ) < 1 ) {
                puedo = true;
            }
            
        }      
        return puedo;
    }
    
    
    private int howManyVisibleTreasures(TreasureKind tKind) {
        
        int number = 0;
        
        for (Treasure visibleTreasure : (this).visibleTreasures ) {
            if (visibleTreasure.getKind() == tKind) { number++; }
        }
        
        return number;
    }
    
    public boolean isDead() {
        return this.dead;
    }
    
    public ArrayList<Treasure> getHiddenTreasures() {
        return this.hiddenTreasures;
    }
    
    public ArrayList<Treasure> getVisibleTreasures() {
        return this.visibleTreasures;
    }
    
    public CombatResult combat(Monster m) {
        
        CombatResult result;
        int myLevel = this.getCombatLevel();
        int monsterLevel = this.getOponentLevel(m);
        
        if(myLevel>monsterLevel){ //Ha ganado el jugador
            applyPrize(m);
            
            if(getLevel() >= 10) { //Comprobamos si el jugador ha ganado la partida (Nivel >= 10)
                result = CombatResult.WinAndWinGame;
            } else {
                result = CombatResult.Win;
            }
        
        } else {   //Ha perdido el jugador
            Dice dice = Dice.getInstance();
            int escape = dice.nextNumber("Has sido derrotado, pero aún puedes escapar.","Podrás huir si consigues sacar un 5 o un 6");
            
            if(escape < 5){  // No escapa el jugador
                boolean amIDead = m.kills();
                
                if(amIDead){
                    die();
                    result= CombatResult.LoseAndDie;
                }
                else {
                    BadConsequence bad = m.getBadConsequence();
                    applyBadConsequence(bad);
                    
                    boolean convert = this.shouldConvert(); // Se convertirá en sectario?
                    
                    if(convert) { 
                        result = CombatResult.LoseAndConvert; // Pierde y se convierte en sectario
                    } else { 
                        result = CombatResult.Lose; // Pierde
                    }
                } 
            } else { //El jugador escapa
                result = CombatResult.LoseAndEscape;
            }
        }
    discardNecklaceIfVisible();        
    return result;
    }
    
    public boolean makeTreasureVisible(Treasure t) {
        
        boolean canI = canMakeTreasureVisible(t);
        
        if(canI){
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        
        }
        
        return canI;
    }
    
    public void discardVisibleTreasure(Treasure t) {
        
        visibleTreasures.remove(t);
        
        if (pendingBadConsequence != null && !pendingBadConsequence.isEmpty() ) {
            pendingBadConsequence.substractVisibleTreasure(t);
        }
        
        CardDealer dealer = CardDealer.getInstance();
        dealer.giveTreasureBack(t); 
        
        dielfNoTreasures();
        
    }
    
    public void discardHiddenTreasure(Treasure t) {
        
        hiddenTreasures.remove(t); 
       
        if(pendingBadConsequence !=null && pendingBadConsequence.isEmpty() == false){
           pendingBadConsequence.substractHiddenTreasure(t);
        }
        
        CardDealer dealer = CardDealer.getInstance();
        dealer.giveTreasureBack(t); 
        
        dielfNoTreasures();
    }
    
    public boolean buyLevels(ArrayList<Treasure> visible, ArrayList<Treasure> hidden) {
        
        boolean canI;
        float levelsMayBought;
        
        levelsMayBought = computeGoldCoinsValue(visible);
        levelsMayBought += computeGoldCoinsValue(hidden);
        
        int levels =(int)(levelsMayBought);
        
        canI = canIBuyLevels(levels);
        
        if (levelsMayBought < 1.0) { canI = false; }
        
        if (canI) {
            incrementLevels(levels);
        
            visibleTreasures.removeAll(visible);
            hiddenTreasures.removeAll(hidden);

            CardDealer dealer = CardDealer.getInstance();

            for (Treasure treasure : visible) {          
                dealer.giveTreasureBack(treasure);
            }

            for (Treasure treasure : hidden) {          
                dealer.giveTreasureBack(treasure);
            }
        }
        return canI;  
    }
    
    public boolean validState() {
        
        boolean isValid=false;
        
        if ( this.pendingBadConsequence == null && this.hiddenTreasures.size() <= 4) {
                isValid = true;
        } else {
            if (this.pendingBadConsequence.isEmpty() == true && this.hiddenTreasures.size() <= 4)
                isValid = true;
        } 
        
        
        return isValid;
    }
    
    public void initTreasures() {
        
        CardDealer dealer = CardDealer.getInstance();
        Dice dice = Dice.getInstance();
        
        bringToLife();
        
        Treasure treasure = dealer.nextTreasure();
        hiddenTreasures.add(treasure);
        
        
        int number = dice.nextNumber(name+", ¿con cuantos tesoros empezarás?","1 = Un tesoro, 2-5: Dos tesoros, 6: Tres tesoros");
        
        if (number > 1) {
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
        
        if (number == 6) {
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
        
    }
    
    public boolean hasVisibleTreasures() {
        
        boolean hasVisibles = false;
        
        if (this.visibleTreasures.size() > 0) {
            hasVisibles = true;
        }
        
        return hasVisibles;
    }
    
    public int getLevel() {
      return this.level;
    }
    
    public String getName() {
      return this.name;
    }
    
    public void setLevel(int l) {
       this.level = l;
    }
    
    public BadConsequence getPendingBadConsequence() {
        return pendingBadConsequence;
    }
    
    
    @Override
    public String toString() {
        
        String salida = this.name;
        salida += " (Nivel ";
        salida += this.level;
        salida += ")";
        if (this.dead) {
            salida += " (MUERTO)";
        }
        
        salida += "\n";
        
        return salida;
    }
}
