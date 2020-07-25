/**
 *
 * @author jotaelediaz & joaquinbaca
 */
package napakalaki;

import java.util.ArrayList;
import static java.lang.Math.min;

public class BadConsequence {
    
    private String text; //Descripción mal rollo
    private int levels; //Niveles que se pierden
    private int nVisibleTreasures; //Número de tesoros visibles que se pierden
    private int nHiddenTreasures; //Número te tesoros ocultos que se pierden
    private boolean death; // Mal rollo tipo muerte
    ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList(); //Tipo de tesoros ocultos que se pierden
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList(); //Tipo de tesoros visibles que se pierden
    
    
    public BadConsequence(String text, int levels, int nVisible, int nHidden) {
        this.text = text;
        this.levels = levels;
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
    }
    
    public BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden) {
        this.text = text;
        this.levels = levels;
        this.specificVisibleTreasures = tVisible;
        this.specificHiddenTreasures = tHidden;
    }
  
    
    public BadConsequence(String text, boolean death) {
        this.text = text;
        this.death = death;
    }
    
    public String getText(){ return this.text; }
    public int getLevels() { return this.levels; }
    public int getnVisible() { return this.nVisibleTreasures; }
    public int getnHidden() { return this.nHiddenTreasures; }
    public ArrayList<TreasureKind> getSpecificVisibleTreasures() { return this.specificVisibleTreasures; }
    public ArrayList<TreasureKind> getSpecificHiddenTreasures() { return this.specificHiddenTreasures; }
    public boolean getDeath() { return this.death; }
    
    public boolean isEmpty() { 
        
        boolean empty = false;
        
        if(levels == 0 && nHiddenTreasures == 0 && nVisibleTreasures == 0 && specificHiddenTreasures.isEmpty() && specificVisibleTreasures.isEmpty()) {
            empty = true;
        }
        
        return empty;
    }
    
    
    public void substractVisibleTreasure(Treasure t) {
            
        //Si el mal rollo tiene tesoros visibles de un tipo específico, sustraemos uno del tipo dado
        if (!specificVisibleTreasures.isEmpty()) {
            
            TreasureKind aux;
            
            for (int i=0; i<specificVisibleTreasures.size(); i++) {
                do {
                    aux = specificVisibleTreasures.get(i);
                    if (aux == t.getKind() ) {
                        specificVisibleTreasures.remove(aux);
                    }
                } while(aux != t.getKind() );
            }
        }     
        
        //Si el mal rollo tiene tesoros visibles por número, sustraemos uno
        if (nVisibleTreasures != 0) {
            nVisibleTreasures--;
        }
                
    }
    
    public void substractHiddenTreasure(Treasure t) {
                
        //Si el mal rollo tiene tesoros ocultos de un tipo específico, sustraemos uno del tipo dado
        if (!specificHiddenTreasures.isEmpty()) {
            
            TreasureKind aux;
            
            for (int i=0; i<specificHiddenTreasures.size(); i++) {
                do {
                    aux = specificHiddenTreasures.get(i);
                    if (aux == t.getKind() ) {
                        specificHiddenTreasures.remove(aux);
                    }
                } while(aux != t.getKind() );
            }
        }     
        
        //Si el mal rollo tiene tesoros ocultos por número, sustraemos uno
        if (nHiddenTreasures != 0) {
            nHiddenTreasures--;
        }
    }
    
    public BadConsequence adjustToFitTreasureList(ArrayList<Treasure> v, ArrayList<Treasure> h) {
        
        BadConsequence adjustedBad;
        
        //Si el mal rollo es de tipo numérico...
        if(specificVisibleTreasures.isEmpty() && specificHiddenTreasures.isEmpty()){
        
            int numVisibles;
            numVisibles = (v.size() > nVisibleTreasures? nVisibleTreasures : v.size());
            int numHidden;
            numHidden = (h.size() > nHiddenTreasures? nHiddenTreasures : h.size());
        
            adjustedBad = new BadConsequence(this.text,0,numVisibles,numHidden);
        
        
        } else {  //Si el mal rollo funciona por tipos específicos de tesoro
                
            final ArrayList<TreasureKind> listHidden = new ArrayList<>();
            final ArrayList<TreasureKind> listVisible = new ArrayList<>();
                
                
            for (TreasureKind tKind : TreasureKind.values()) {
                
                
                /* --- TESOROS VISIBLES --- */
                int min1 = 0, min2 = 0; 
                        
                for (TreasureKind specificVisibleTreasure : specificVisibleTreasures) {
                    if (specificVisibleTreasure == tKind) { min1++; }
                }
                
                
                for (Treasure v1 : v) {
                    if (v1.getKind()== tKind) { min2++; }
                }
                 
                
                for(int i = 0; i < min(min1, min2);  i++){
                            listVisible.add(tKind); 
                }
                   
                
                /* --- TESOROS OCULTOS --- */
                
                min1 = 0;
                min2 = 0; // Reset Contadores
                
                for (TreasureKind specificHiddenTreasure : specificHiddenTreasures) {
                    if (specificHiddenTreasure == tKind) { min1++; }
                }
                        
                for (Treasure h1 : h) {
                    if (h1.getKind() == tKind) { min2++; }
                }
                        
                
                for(int i = 0; i < min(min1, min2);  i++) {
                    listHidden.add(tKind); 
                }
            }
                
            adjustedBad = new BadConsequence(text, 0, listVisible, listHidden);
        }
        return adjustedBad;
            
    }
        
        
    
    public boolean myBadConsequenceIsDeath() {
        boolean isdead = false;
        if(death){
            isdead=true;
        }
        return isdead;
    }
    
    public String toString() {
         
        String salida = text;
        
        if(levels != 0) {
            salida += " || Niveles: "+Integer.toString(levels);
        }
        
        
        if( specificVisibleTreasures.isEmpty() == false || nVisibleTreasures != 0 ) {
        
            salida += " || Tesoros Visibles Perdidos: ";
            
            if( nVisibleTreasures != 0 ) { 
                salida += Integer.toString(nVisibleTreasures); 
            } 
            
            if( specificVisibleTreasures.isEmpty() == false ) {
                
                String stringVisibleTreasures="";
                for(int i=0; i < specificVisibleTreasures.size(); i++){
                    stringVisibleTreasures += ( specificVisibleTreasures.get(i).toString() )+" ";
                }
                
                salida+= "( "+stringVisibleTreasures+")"; 
            }
           
        }
        
        
        if( specificHiddenTreasures.isEmpty() == false || nHiddenTreasures != 0 ) {
        
            salida += " || Tesoros Ocultos Perdidos: ";
            
            if( nHiddenTreasures != 0 ) { 
                salida += Integer.toString(nHiddenTreasures); 
            } 
            
            if( specificHiddenTreasures.isEmpty() == false ) { 
                
                String stringHiddenTreasures ="";
                
                for(int i=0; i < specificHiddenTreasures.size(); i++){
                    stringHiddenTreasures += ( specificHiddenTreasures.get(i).toString() )+" ";
                }
                salida+= "( "+stringHiddenTreasures+")"; 
            } 
        }
        
        if(death) {
            salida += " || KO ";
        }

        return salida;
    }
}