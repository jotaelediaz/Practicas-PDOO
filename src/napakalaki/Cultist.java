/**
 *
 * @author jotaele
 */

package napakalaki;


public class Cultist implements Card {
    
    private String name;
    private int gainedLevels;
    
    Cultist(String name, int gainedl) {
        this.name = name;
        this.gainedLevels = gainedl;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public int getBasicValue() {
        //El nivel de combate de un jugador es su nivel
        return gainedLevels;
    }
    
    public int getSpecialValue() {
        //El nivel de combate de un jugador sectario es el nivel normal + nivel de la carta de Sectario * numero de sectarios
        return getBasicValue() * CultistPlayer.getTotalCultistPlayers();
    }
}
