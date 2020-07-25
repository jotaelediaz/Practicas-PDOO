/*
    Napakalaki - PDOO
    Desarrolladores: Juan Luis Díaz - Joaquín Baca
*/

package napakalaki;

import java.util.ArrayList;


public class CultistPlayer extends Player {
   
    private static int totalCultistPlayers = 0;
    private Cultist myCultistCard;
    
    public CultistPlayer (Player p, Cultist c) { 
        super(p); // Copiamos el jugador en el jugador de esta clase (Ya que esta clase es hija de Player)
        this.myCultistCard = c; // Carta de Sectario asignada al jugador
        totalCultistPlayers++; // Incrementamos el número de jugadores sectarios
    }
    
    public static int getTotalCultistPlayers() {
        return totalCultistPlayers;
    }
    
    public Cultist getMyCultistCard() {
        return myCultistCard;
    }
    
    @Override
    protected boolean shouldConvert() {
        //Sobreescribe el método shouldConvert de Player: Si el jugador ya es Sectario, no tiene que volver a transformarse más
        return false;
    }
    
    @Override
    protected int getOponentLevel(Monster m) {
        //Sobreescribe el método getOponent level añadiendo el valor de la carta.       
        int special = m.getSpecialValue();
            
        return special;
    }
    
    @Override
    protected float computeGoldCoinsValue( ArrayList<Treasure> t ) {
        //Sobreescribe el método computeGoldCoinsValue para que las monedas de oro valgan el doble para los jugadores sectarios.
        float totalGoldCoins = 0;
        float levels;
        
        for (Treasure treasure : t) {
            totalGoldCoins += (treasure.getGoldCoins() * 2);
        }
        
        levels = totalGoldCoins/1000;
        
        return levels;
    }
    
    @Override
    public int getCombatLevel() {
        //Sobreescribe el método getCombatLevel sumando el nivel del jugador más el incremento de su carta de sectario
        int level = super.getCombatLevel();
        level += myCultistCard.getSpecialValue();
        
        return level;
    }
}
