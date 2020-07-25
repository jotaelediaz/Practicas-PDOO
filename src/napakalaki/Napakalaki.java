/**
 *
 * @author jotaelediaz & joaquinbaca
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Random;


public class Napakalaki {
    
    private Monster currentMonster;
    private Player currentPlayer;
    private ArrayList<Player> players = new ArrayList();
    private CardDealer dealer = CardDealer.getInstance();
   
   
    
    public static final Napakalaki instance = new Napakalaki();
    
    private Napakalaki() { }// El constructor privado asegura que no se puede instanciar desde otras clases
 
    public static Napakalaki getInstance() {
        return instance;
    }
    
   
    
    
    private void initPlayers(ArrayList<String> names) {   
        for(String name : names) {
            Player jugador = new Player(name);
            this.players.add(jugador);
        }
        
    }
    
    private Player nextPlayer() {
        
        if(currentPlayer == null) {  //Si aún no ha jugado nadie (Es la primera tirada)
            
            //Decidimos al azar un jugador para que sea el actual.
            Random r = new Random();  
            int n = r.nextInt( ( (players.size()) -1 ) + 1);
            
            return this.players.get(n);
            
        } else {  //Si ya había un jugador actual, pasamos al siguiente
            
            int indice = players.indexOf(currentPlayer);
            
            if( indice == players.size()-1 ) {
                return this.players.get(0);
            } else {
                return this.players.get(indice+1);
            }
       }
              
    }
    
    private boolean nextTurnIsAllowed() {
        return currentPlayer.validState();
    }
    
    public CombatResult developCombat() {
        
        CombatResult resultado = currentPlayer.combat(currentMonster);
        dealer.giveMonsterBack(currentMonster);
        
        if (resultado == CombatResult.LoseAndConvert) { // Si el resultado es transformarse en Sectario...
            
            Cultist c = dealer.nextCultist(); // Sacamos una carta de sectario de la baraja
            
            CultistPlayer CultPlayer = new CultistPlayer( this.getCurrentPlayer(), c); // Creamos un nuevo sectario usnado la copia del jugador actual y la carta de sectario 
            
            int index = players.indexOf(getCurrentPlayer()); // Obtenemos el índice del jugador actual en la lista de jugadores
            players.set(index, CultPlayer); // Borramos el jugador actual de la lista de jugadores y lo sustituimos por el jugador Sectario que hemos creado 
            currentPlayer = players.get(index); // Ponemos como jugador actual al sectario creado
        }
        
        return resultado;
        
    }
    
    public void discardVisibleTreasures(ArrayList<Treasure> treasures) {
        
        for (Treasure treasure : treasures) {        
            currentPlayer.discardVisibleTreasure(treasure);
            //dealer.giveTreasureBack(treasure);
        }
    }
    
    public void discardHiddenTreasures(ArrayList<Treasure> treasures) {
        for (Treasure treasure : treasures){
            currentPlayer.discardHiddenTreasure(treasure);
            //dealer.giveTreasureBack(treasure);
        }
    }
    
    public boolean makeTreasuresVisible(ArrayList<Treasure> treasures) {
        
        boolean canI = true;
        
        for(Treasure treasure : treasures){ 
            if (!currentPlayer.makeTreasureVisible(treasure)) { canI = false; }
        }
        
        return canI;
    }
    
    public boolean buyLevels(ArrayList<Treasure> visible, ArrayList<Treasure> hidden) {
        
        boolean canI;
        canI = currentPlayer.buyLevels(visible, hidden);
        
        return canI;
    }
    
    public void initGame(ArrayList<String> players) {
        
        initPlayers(players);  //Se inicializan los jugadores
        dealer.initCards();   //Se inicializan las cartas
        nextTurn();          //Pasamos turno
        
    }
    
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    
    public Monster getCurrentMonster() {
        return currentMonster;
    }
    
    public boolean nextTurn() {
        
        boolean stateOK = false;
        
        if ( currentPlayer != null) {
            stateOK = nextTurnIsAllowed();
        } else {
            stateOK = true;
        }
        
        if (stateOK) {
             currentMonster = dealer.nextMonster();
             currentPlayer = nextPlayer();
             
             boolean dead = currentPlayer.isDead();
             
             if (dead) {
                 currentPlayer.initTreasures();
             }
        }
       
       return stateOK; 
    }
    
    public boolean endOfGame(CombatResult result) {
        
        boolean isEnd = false;
        if (result == CombatResult.WinAndWinGame) { isEnd = true; }
        
        return isEnd;
        
    }
    
}
