/* Napakalaki - Práctica 2 - PDOO

Desarrolladores: JotaEle Díaz - Joaquín Baca
@author jotaele

*/
package napakalaki;


public class Treasure implements Card {
    private String name;
    private int goldCoins;
    private int minBonus;
    private int maxBonus;
    private TreasureKind Kind;
    
    public Treasure (String n, int g, int min, int max, TreasureKind t) {
        this.name = n;
        this.goldCoins = g;
        this.minBonus = min;
        this.maxBonus = max;
        this.Kind = t;
        
    }
    
    public String getName() {return name;}
    public TreasureKind getKind() {return Kind;}
    public int getMinBonus() { return minBonus; }
    public int getMaxBonus() { return maxBonus; }
    public int getGoldCoins() { return goldCoins; }
    
    
    @Override
    public int getBasicValue() {
        //Devuelve el bonus mínimo del tesoro
        return getMinBonus();
    }
    
    @Override
    public int getSpecialValue() {
        //Devuelve el bonus máximo (Al tener el collar) del tesoro
        return getMaxBonus();
    }
    
    public String toString() {
        String salida;
        salida = name+" ("+Kind+") | Bonus: ["+minBonus+"/"+maxBonus+"] | Valor: "+goldCoins+" piezas de oro\n";
        return salida;
    }
    
}
