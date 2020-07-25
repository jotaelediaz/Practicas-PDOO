

package napakalaki;

public class Monster implements Card {
    
    private String name; //Nombre del monstruo
    private int combatlevel; //Nivel de combate del monstruo
    private Prize monsterPrize; //Buen rollo del monstruo
    private BadConsequence monsterBadConsequence; //Mal rollo del monstruo
    private int levelChangeAgainstCultistPlayer; //Incremento/Decremento del nivel del monstruo al luchar con un jugador Sectario

    
    public Monster(String name, int level, Prize mPrize, BadConsequence mBC, int levelChange) {
        this.name = name;
        this.combatlevel = level;
        this.monsterPrize = mPrize;
        this.monsterBadConsequence = mBC;
        this.levelChangeAgainstCultistPlayer = levelChange;
    }
    
    
    public String getName() { 
        return this.name; }
    
    public int getCombatLevel() { 
        return this.combatlevel; }
    
    public BadConsequence getBadConsequence() { 
        return monsterBadConsequence; }
    
    public Prize getPrize() { 
        return monsterPrize; }
    
    public int getLevelsGained() { 
        return monsterPrize.getLevels(); }
    
    public int getTreasuresGained() { 
        return monsterPrize.getTreasures(); }
    
    public boolean kills() {
        return monsterBadConsequence.getDeath(); }
    
    public int getLevelChangeAgainstCultistPlayer() {
        return levelChangeAgainstCultistPlayer; 
    }
    
    @Override
    public int getBasicValue() {
        //Devuelve el nivel de combate del monstruo
        return this.getCombatLevel();
    }
    
    @Override
    public int getSpecialValue() {
        //Devuelve el nivel de combate del monstruo ante un jugador Sectario
        int num = this.getCombatLevel();
        num += this.levelChangeAgainstCultistPlayer;
        
        return num;
    }
    
    
    public String toString() {
        return "---------------------------------------\n"+
                name+
                "\n---------------------------------------"+
                "\nNivel >> "+Integer.toString(combatlevel)+
                "\nBuen Rollo >> "+(this.monsterPrize.toString())+
                "\nMal Rollo >> "+this.monsterBadConsequence.toString();
    }
    


}
