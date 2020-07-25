/**
 *
 * @author jotaelediaz & joaquinbaca
 */
package napakalaki;


public class Prize {
    
    private int treasures; // Número de tesoros que ganas
    private int levels; // Número de niveles que subes

    
    
    public Prize(int treasures, int level) {
        this.treasures = treasures;
        this.levels = level;
    }
    

    public int getLevels() {
        return levels;
    }
    
    public int getTreasures() {
        return treasures;
    }
    
    public String toString() {
        return "Tesoros: " + Integer.toString(treasures)+" | Niveles: "+Integer.toString(levels);
    }
    
}
