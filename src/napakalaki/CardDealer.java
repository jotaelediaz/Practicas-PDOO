/**
 *
 * @author jotaelediaz & joaquinbaca
 *
 */

package napakalaki;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class CardDealer {
    
    
    private ArrayList<Monster> unusedMonsters = new ArrayList();
    private ArrayList<Monster> usedMonsters = new ArrayList();
    private ArrayList<Treasure> unusedTreasures = new ArrayList();
    private ArrayList<Treasure> usedTreasures = new ArrayList();
    private ArrayList<Cultist> unusedCultist = new ArrayList();
    
    private static final CardDealer instance = new CardDealer();
    
    private CardDealer() { } // El constructor privado asegura que no se puede instanciar desde otras clases
 
    public static CardDealer getInstance() {
        return instance;
    }
    
    
    
    
    
    private void initTreasureCardDeck() {
        
        
        Treasure SiMiAmo = new Treasure("¡Sí, mi amo!",0,4,7,TreasureKind.helmet);
        unusedTreasures.add(SiMiAmo);
        
        
        Treasure BotasDeInvestigacion = new Treasure("Botas de investigación",600,3,4,TreasureKind.shoe);
        unusedTreasures.add(BotasDeInvestigacion);
        
        
        Treasure CapuchaDeCthulhu = new Treasure("Capucha de Cthulhu",500,3,5,TreasureKind.helmet);
        unusedTreasures.add(CapuchaDeCthulhu);
        
        
        Treasure APruebaDeBabas = new Treasure("A prueba de babas",400,2,5,TreasureKind.armor);
        unusedTreasures.add(APruebaDeBabas);
        
        
        Treasure BotasDeLluviaAcida = new Treasure("Botas de lluvia ácida",800,1,1,TreasureKind.bothHand);
        unusedTreasures.add(BotasDeLluviaAcida);
        
        
        Treasure CascoMinero = new Treasure("Casco minero",400,2,4,TreasureKind.helmet);
        unusedTreasures.add(CascoMinero);
        
        
        Treasure AmetralladoraThompson = new Treasure("Ametralladora Thompson",600,4,8,TreasureKind.bothHand);
        unusedTreasures.add(AmetralladoraThompson);
        
        
        Treasure CamisetaDeLaUGR = new Treasure("Camiseta de la UGR",100,1,7,TreasureKind.armor);
        unusedTreasures.add(CamisetaDeLaUGR);
        
        
        Treasure ClavoDeRailFerroviario = new Treasure("Clavo de rail ferrroviario",400,3,6,TreasureKind.oneHand);
        unusedTreasures.add(ClavoDeRailFerroviario);
        
        
        Treasure CuchilloDeSushiArcano = new Treasure("Cuchillo de sushi arcano",300,2,3,TreasureKind.oneHand);
        unusedTreasures.add(CuchilloDeSushiArcano);
        
        
        Treasure FezAlopodo = new Treasure("Fez alopodo",700,3,5,TreasureKind.helmet);
        unusedTreasures.add(FezAlopodo);
        
        
        Treasure HachaPrehistorica = new Treasure("Hacha prehistorica",500,2,5,TreasureKind.oneHand);
        unusedTreasures.add(HachaPrehistorica);
        
        
        Treasure ElAparatoDeTesla = new Treasure("El aparato de Pr. Tesla",900,4,8,TreasureKind.armor);
        unusedTreasures.add(ElAparatoDeTesla);
        
        
        Treasure Gaita = new Treasure("Gaita",500,4,5,TreasureKind.bothHand);
        unusedTreasures.add(Gaita);
        
        
        Treasure Insecticida = new Treasure("Insecticida",300,2,3,TreasureKind.oneHand);
        unusedTreasures.add(Insecticida);
        
        
        Treasure EscopetaDeTresCañones = new Treasure("Escopeta de tres cañones",700,4,6,TreasureKind.bothHand);
        unusedTreasures.add(EscopetaDeTresCañones);
        
        
        Treasure GarabatoMistico = new Treasure("Garabato místico",300,2,2,TreasureKind.oneHand);
        unusedTreasures.add(GarabatoMistico);
        
        
        Treasure LaFuerzaDeMRT = new Treasure("La Fuerza De Mr. T",1000,10,10,TreasureKind.necklace);
        unusedTreasures.add(LaFuerzaDeMRT);
        
        
        Treasure LaRebecaMetalica = new Treasure("La Rebeca Metálica",400,2,3,TreasureKind.armor);
        unusedTreasures.add(LaRebecaMetalica);
        
        
        Treasure MazoDeLosAntiguos = new Treasure("Mazo de los antiguos",200,3,4,TreasureKind.oneHand);
        unusedTreasures.add(MazoDeLosAntiguos);
        
        
        Treasure Necroplayboyrecon = new Treasure("Necropleybloyrecón",300,3,5,TreasureKind.oneHand);
        unusedTreasures.add(Necroplayboyrecon);
        
        
        Treasure Lanzallamas = new Treasure("Lanzallamas",800,2,8,TreasureKind.bothHand);
        unusedTreasures.add(Lanzallamas);
        
        
        Treasure Necromicon = new Treasure("Necromicon",100,1,1,TreasureKind.oneHand);
        unusedTreasures.add(Necromicon); 
        
        
        Treasure Necronomicon = new Treasure("Necrocomicon",800,5,7,TreasureKind.bothHand);
        unusedTreasures.add(Necronomicon); 
        
        
        Treasure LinternaADosManos = new Treasure("Linterna a dos manos",400,3,6,TreasureKind.bothHand);
        unusedTreasures.add(LinternaADosManos); 
        
        
        Treasure Necronomigon = new Treasure("Necronomigon",200,2,4,TreasureKind.oneHand);
        unusedTreasures.add(Necronomigon); 
        
        
        Treasure Necrotelecon = new Treasure("Necrotelecon",300,2,3,TreasureKind.helmet);
        unusedTreasures.add(Necrotelecon); 
        
        
        Treasure PorraPreternatural = new Treasure("Porra Preternatural",200,2,3,TreasureKind.oneHand);
        unusedTreasures.add(PorraPreternatural);
        
        
        Treasure TentaculoDePega = new Treasure("Tentaculo de pega",200,0,1,TreasureKind.helmet);
        unusedTreasures.add(TentaculoDePega); 
        
        
        Treasure ZapatoDejaAmigos = new Treasure("Zapato deja-amigos",500,0,1,TreasureKind.shoe);
        unusedTreasures.add(ZapatoDejaAmigos);
        
        
        Treasure Shogulador = new Treasure("Shogulador",600,1,1,TreasureKind.bothHand);
        unusedTreasures.add(Shogulador);
        
        
        Treasure VaritaDeAtizamiento = new Treasure("Varita de Atizamiento",400,3,4,TreasureKind.oneHand);
        unusedTreasures.add(VaritaDeAtizamiento); 
        
        
        
        
        
    }
    
    private void initMonsterCardDeck() {
        
      Prize monsterPrize = new Prize(4, 2);
        BadConsequence monsterBC = new BadConsequence("Pierdes 5 niveles", 5, 0, 0 );
        ArrayList<TreasureKind> tVisibleList= new ArrayList();
        ArrayList<TreasureKind> tHiddenList= new ArrayList();
    
        Monster reyDeRosa = new Monster("El rey de rosa", 13, monsterPrize, monsterBC, 0); //Creo e inicializo al Rey de Rosa.
        unusedMonsters.add(reyDeRosa);
   
        
        
        
        monsterPrize = new Prize(2,1);
        
        tVisibleList.add(TreasureKind.armor);
        tHiddenList.add(TreasureKind.armor);
        monsterBC = new BadConsequence("Pierdes tu armadura visible y otra oculta", 0, tVisibleList, tHiddenList );
        
        Monster byakhees = new Monster("3 Byakhees de bonanza",8,monsterPrize, monsterBC, 0);
        unusedMonsters.add(byakhees);
        
        
        
        
        
        monsterPrize = new Prize(1,1);
        tVisibleList = new ArrayList();
        tHiddenList = new ArrayList();
        tVisibleList.add(TreasureKind.helmet);
        monsterBC = new BadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible", 0, tVisibleList, tHiddenList);
        
        Monster chibithulhu = new Monster("Chibithulhu",2,monsterPrize, monsterBC, 0);
        unusedMonsters.add(chibithulhu);
        
        
        
        
        monsterPrize = new Prize(1,1);
        tVisibleList = new ArrayList();
        tHiddenList = new ArrayList();
        tVisibleList.add(TreasureKind.shoe);
        monsterBC = new BadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible.",0,tVisibleList, tHiddenList);
        
        Monster sopor = new Monster("El sopor de Dunwich", 2, monsterPrize, monsterBC, 0);
        unusedMonsters.add(sopor);
        
        
        
        
        monsterPrize = new Prize(4,1);
        tVisibleList = new ArrayList();
        tHiddenList = new ArrayList();
        tVisibleList.add(TreasureKind.oneHand);
        tHiddenList.add(TreasureKind.oneHand);
        monsterBC = new BadConsequence("Te atrapan para llevarte de fiesta. Pierdes 1 mano visible y 1 oculta.",0, tVisibleList, tHiddenList);
        
        Monster angeles = new Monster("Ángeles de la noche ibicenca", 14, monsterPrize, monsterBC, 0);
        unusedMonsters.add(angeles);
        
        
        
        
        
        monsterPrize = new Prize(3,1);
        monsterBC = new BadConsequence("Pierdes todos tus tesoros visibles", 0, 6, 0);
        
        Monster gorron = new Monster("El gorrón en el umbral", 10, monsterPrize, monsterBC, 0);
        unusedMonsters.add(gorron);
        
        
        
        
        monsterPrize = new Prize(2,1);
        tVisibleList = new ArrayList();
        tHiddenList = new ArrayList();
        tVisibleList.add(TreasureKind.armor);
        monsterBC = new BadConsequence("Pierdes la armadura visible", 0, tVisibleList, tHiddenList);
        
        
        Monster munchcraft = new Monster("H.P. Munchcraft", 6, monsterPrize, monsterBC, 0);
        unusedMonsters.add(munchcraft);
        
        
        
        
        
        monsterPrize = new Prize(1,1);
        tVisibleList = new ArrayList();
        tHiddenList = new ArrayList();
        tVisibleList.add(TreasureKind.armor);
        monsterBC = new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible", 0, tVisibleList, tHiddenList);
        
        Monster bichgooth = new Monster("Bichgooth", 2, monsterPrize, monsterBC, 0);
        unusedMonsters.add(bichgooth);
        
        
        
        
        
        
        monsterPrize = new Prize(1,1);
        monsterBC = new BadConsequence("Toses los pulmones y pierdes dos niveles", 2, 0, 0);
        
        Monster redactora = new Monster("La que redacta en las tinieblas", 2, monsterPrize, monsterBC, 0);
        unusedMonsters.add(redactora);
        
        
        
        
        
        monsterPrize = new Prize(2, 1);
        monsterBC = new BadConsequence("Estos monstruos son bastantes superficiales y te aburren mortalmente. Estás muerto", true);
    
        Monster LosHondos = new Monster("Los hondos", 8, monsterPrize, monsterBC, 0);
        unusedMonsters.add(LosHondos);
    



        monsterPrize = new Prize(2, 1);
        monsterBC = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos", 2, 0, 2);
    
        Monster SemillasCthulhu = new Monster("Semillas Cthulhu", 4, monsterPrize, monsterBC, 0);
        unusedMonsters.add(SemillasCthulhu);
    



        monsterPrize = new Prize(2, 1);
        tVisibleList = new ArrayList();
        tHiddenList = new ArrayList();
        tVisibleList.add(TreasureKind.oneHand);
        monsterBC = new BadConsequence("Te intentas escaquear. Pierdes una mano visible", 0, tVisibleList, tHiddenList);

        Monster Dameargo = new Monster("Dameargo", 1, monsterPrize, monsterBC, 0);
        unusedMonsters.add(Dameargo);
    



        
        monsterPrize = new Prize(1, 1);
        monsterBC = new BadConsequence("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0);

        Monster PollipolipoVolante = new Monster("Pollipólipo Volante", 3, monsterPrize, monsterBC, 0);
        unusedMonsters.add(PollipolipoVolante);



        
        
        monsterPrize = new Prize(3, 1);
        monsterBC = new BadConsequence("No le gusta que pronuncien mal su nombre. Estás muerto", true);

        Monster YskhtihyssgGoth = new Monster("YskhtihyssgGoth", 12, monsterPrize, monsterBC, 0);
        unusedMonsters.add(YskhtihyssgGoth);



        
        monsterPrize = new Prize(4, 1);
        monsterBC = new BadConsequence("La familia te atrapa. Estás muerto", true);

        Monster FamiliaFeliz = new Monster("Familia feliz", 1, monsterPrize, monsterBC, 0);
        unusedMonsters.add(FamiliaFeliz);
    
  
    
        monsterPrize= new Prize(2,1);
        tVisibleList=new ArrayList();
        tHiddenList = new ArrayList();
        tVisibleList.add(TreasureKind.bothHand); 
        monsterBC= new BadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible",2,tVisibleList,tHiddenList);

        Monster Roboggoth = new Monster("Roboggoth",8,monsterPrize,monsterBC, 0);
        unusedMonsters.add(Roboggoth);
    
    
    
    
    
        monsterPrize= new Prize(1,1);
        tVisibleList= new ArrayList();
        tHiddenList = new ArrayList();
        tVisibleList.add(TreasureKind.helmet);
        monsterBC= new BadConsequence("Te asusta en la noche. Pierdes un casco visible",0,tVisibleList,tHiddenList);

        Monster ElEspia = new Monster("El Espía",5,monsterPrize,monsterBC, 0);
        unusedMonsters.add(ElEspia);
    
    
    
    
    
        monsterPrize= new Prize(1,1);
        monsterBC= new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles",2,5,0);

        Monster ElLenguas= new Monster("El Lenguas",20,monsterPrize,monsterBC, 0);
        unusedMonsters.add(ElLenguas);
        

        
        
        monsterPrize = new Prize(1,1);
        tVisibleList= new ArrayList();
        tHiddenList = new ArrayList();
        tVisibleList.add(TreasureKind.bothHand); 
        tVisibleList.add(TreasureKind.oneHand); 
        monsterBC = new BadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos",3, tVisibleList, tHiddenList);
        
        Monster bicefalo = new Monster("Bicéfalo", 20, monsterPrize, monsterBC, 0);
        unusedMonsters.add(bicefalo);
        
        
        /* -- MONSTRUOS CON VARIACIÓN DE NIVEL PARA JUGADORES SECTARIOS -- */        

        
        monsterPrize = new Prize(3,1);
        tVisibleList = new ArrayList();
        tHiddenList = new ArrayList();
        tVisibleList.add(TreasureKind.oneHand);
        monsterBC = new BadConsequence("Pierdes 1 mano visible", 0, tVisibleList, tHiddenList);
        
        Monster malIndecible = new Monster("El mal indecible impronunciable", 10, monsterPrize, monsterBC, -2);
        unusedMonsters.add(malIndecible);
                
        
                

        monsterPrize = new Prize(2,1);
        monsterBC = new BadConsequence("Pierdes tus tesoros visibles. Jajaja", 0, 6, 0);
        
        Monster testigos = new Monster("Testigos Oculares", 6, monsterPrize, monsterBC, 2);
        unusedMonsters.add(testigos);
                        
        
                

        monsterPrize = new Prize(2,5);
        monsterBC = new BadConsequence("Hoy no es tu día de suerte. Mueres", true);
        
        Monster granCthulhu = new Monster("El gran cthulhu", 20, monsterPrize, monsterBC, 4);
        unusedMonsters.add(granCthulhu);
        
        
        
        
        monsterPrize = new Prize(2,1);
        monsterBC = new BadConsequence("Tu gobierno te recorta 2 niveles", 2, 0, 0);
        
        Monster politico = new Monster("Serpiente Político", 8, monsterPrize, monsterBC, -2);
        unusedMonsters.add(politico);
        
        
        
        
        monsterPrize = new Prize(1,1);
        tVisibleList = new ArrayList();
        tHiddenList = new ArrayList();
        tVisibleList.add(TreasureKind.helmet);
        tVisibleList.add(TreasureKind.armor);
        tHiddenList.add(TreasureKind.oneHand);
        tHiddenList.add(TreasureKind.oneHand);
        monsterBC = new BadConsequence("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas", 0, tVisibleList, tHiddenList);
        
        Monster felpuggoth = new Monster("Felpuggoth", 2, monsterPrize, monsterBC, 5);
        unusedMonsters.add(felpuggoth);
        
        
        
        
        monsterPrize = new Prize(4,2);
        monsterBC = new BadConsequence("Pierdes 2 niveles", 2, 0, 0);
        
        Monster shoggoth = new Monster("Shoggoth", 16, monsterPrize, monsterBC, -4);
        unusedMonsters.add(shoggoth);
        
        
        
        
        monsterPrize = new Prize(1,1);
        monsterBC = new BadConsequence("Pintalabios negro. Pierdes 2 niveles", 2, 0, 0);
        
        Monster lolita = new Monster("Lolitagooth", 2, monsterPrize, monsterBC, 3);
        unusedMonsters.add(lolita);
        
    }  
    
    private void initCultistCardDeck() {
        unusedCultist.add(new Cultist("Sectario 1", 1));
        unusedCultist.add(new Cultist("Sectario 2", 2));
        unusedCultist.add(new Cultist("Sectario 3", 1));
        unusedCultist.add(new Cultist("Sectario 4", 2));
        unusedCultist.add(new Cultist("Sectario 5", 1));
        unusedCultist.add(new Cultist("Sectario 6", 1));
    }
    
    void shuffleTreasures() {
      long seed = System.nanoTime();  
      Collections.shuffle(unusedTreasures, new Random(seed));  
    }
    
    void shuffleMonsters() {
        long seed = System.nanoTime();
        Collections.shuffle(unusedMonsters, new Random(seed));
    }
    
    void shuffleCultists() {
        long seed = System.nanoTime();
        Collections.shuffle(unusedCultist, new Random(seed));
    }
    
    public Treasure nextTreasure() {
        
        //Si la baraja de tesoros sin usar está vacía...
        if (unusedTreasures.isEmpty()) {
            
            ArrayList<Treasure> auxtreasures = unusedTreasures;
            
            unusedTreasures = usedTreasures;
            usedTreasures = auxtreasures;
            shuffleMonsters(); 
            
        }
        
        Treasure next = unusedTreasures.remove(0);
        
        return next;
    }
    
    public Monster nextMonster() {
        
        //Si la baraja de monstruos sin usar está vacía...
        if (unusedMonsters.isEmpty()) {
            
            ArrayList<Monster> auxmonstruos = unusedMonsters;
            
            unusedMonsters = usedMonsters;
            usedMonsters = auxmonstruos;
            shuffleTreasures(); 
            
        }
        
        Monster next = unusedMonsters.remove(0);
        
        return next;
    }
    
    public Cultist nextCultist() {
        
        Cultist next = unusedCultist.remove(0);
        
        return next;
    }
    
    public void giveTreasureBack(Treasure t) {
      usedTreasures.add(t);  
    }
    
    public void giveMonsterBack(Monster m) {
      usedMonsters.add(m);  
    }
 
    
    
    public void initCards() {
        initTreasureCardDeck();
        initMonsterCardDeck();
        initCultistCardDeck();
        
        //Barajamos al empezar...
        shuffleTreasures(); 
        shuffleMonsters(); 
        shuffleCultists();
    }
    
    
    
    
}
