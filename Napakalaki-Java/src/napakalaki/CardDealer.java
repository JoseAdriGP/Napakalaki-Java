/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Juanaco
 */
public class CardDealer {
    private static final CardDealer instance = new CardDealer();
    private ArrayList<Monster>  unusedMonsters= new ArrayList();
    private ArrayList<Monster>  usedMonsters= new ArrayList();
    private ArrayList<Treasure>  unusedTreasures= new ArrayList();
    private ArrayList<Treasure>  usedTreasures= new ArrayList();
    private ArrayList<Cultist> unusedCultists=new ArrayList();
    //No viene en el diagrama pero es que no se como se implementa sin esto...
    private ArrayList<Cultist> usedCultists=new ArrayList();
    private CardDealer(){}
    private void initTreasureCardDeck(){
        unusedTreasures.add(new Treasure("¡Si mi amo!","t001", 0, 4, 7, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Botas de investigacion","t002", 600, 3, 4, TreasureKind.SHOE));
        unusedTreasures.add(new Treasure("Capucha de Cthulhu","t003", 500, 3, 5, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("A prueba de babas","t004", 400, 2, 5, TreasureKind.ARMOR));
        //Esto tiene que ser un fallo por cojones (el siguiente objeto)
        unusedTreasures.add(new Treasure("Botas de lluvia acida","t005", 800, 1, 1, TreasureKind.BOTHHAND));
        unusedTreasures.add(new Treasure("Casco minero","t006", 400, 2, 4, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Ametralladora Thompson","t007", 600, 4, 8, TreasureKind.BOTHHAND));
        unusedTreasures.add(new Treasure("Camiseta de la UGR","t008", 100, 1, 7, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Clavo de rail ferroviario","t009", 400, 3, 6, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Cuchillo de sushi arcano","t010", 300, 2, 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Fez alopodo","t011", 700, 3, 5, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Hacha prehistorica","t012", 500, 2, 5, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("El aparato del Pr. Tesla","t013", 900, 4, 8, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Gaita","t014", 500, 4, 5, TreasureKind.BOTHHAND));
        unusedTreasures.add(new Treasure("Insecticida","t015", 300, 2, 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Escopeta de 3 caÃ±ones","t016", 700, 4, 6, TreasureKind.BOTHHAND));
        unusedTreasures.add(new Treasure("Garabato mistico","t017", 300, 2, 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("La fuerza de Mr. T","t018", 1000, 0, 0, TreasureKind.NECKLACE));
        unusedTreasures.add(new Treasure("La rebeca metalica","t019", 400, 2, 3, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Mazo de los antiguos","t020", 200, 3, 4, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necro-playboycon","t021", 300, 3, 5, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Lanzallamas","t022", 800, 4, 8, TreasureKind.BOTHHAND));
        unusedTreasures.add(new Treasure("Necro-comicon","t023", 100, 1, 1, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necronomicon","t024", 800, 5, 7, TreasureKind.BOTHHAND));
        unusedTreasures.add(new Treasure("Linterna a 2 manos","t025", 400, 3, 6, TreasureKind.BOTHHAND));
        unusedTreasures.add(new Treasure("Necro-gnomicon","t026", 200, 2, 4, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necrotelecom","t027", 300, 2, 3, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Porra preternatural","t028", 200, 2, 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Tentaculo de pega","t029", 200, 0, 1, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Zapato deja-amigos","t030", 500, 0, 1, TreasureKind.SHOE));
        unusedTreasures.add(new Treasure("Shogulador","t031", 600, 1, 1, TreasureKind.BOTHHAND));
        unusedTreasures.add(new Treasure("Varita de atizamiento","t032", 400, 3, 4, TreasureKind.ONEHAND));
    }
    private void initMonsterCardDeck(){
       Prize pz; BadStuff bs; 
        ArrayList<TreasureKind> tvp; 
        ArrayList<TreasureKind> top; 
        //El rey de rosa 
        bs = new BadStuff("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0); 
        pz = new Prize(4,2); 
        unusedMonsters.add(new Monster("El rey de rosa", 13, bs, pz,0,"m001")); 
        
        //Angeles de la noche 
        tvp = new ArrayList(); 
        tvp.add(TreasureKind.ONEHAND); 
        top = new ArrayList(); 
        top.add(TreasureKind.ONEHAND); 
        bs = new BadStuff("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta", 0, tvp, top); 
        pz = new Prize(4,1); 
        unusedMonsters.add(new Monster("Angeles de la noche ibicenca", 14,bs, pz,0,"m002")); 
        
        //3 Byakhees de bonanza 
        tvp = new ArrayList(); 
        tvp.add(TreasureKind.ARMOR); 
        top = new ArrayList(); 
        top.add(TreasureKind.ARMOR); 
        bs = new BadStuff("Pierdes tu armadura visible y otra oculta", 0,tvp,top); 
        pz = new Prize(2,1); 
        unusedMonsters.add(new Monster("3 Byakhees de bonanza", 8,bs, pz,0,"m003")); 
        
        //Chibithulhu 
        tvp = new ArrayList(); 
        tvp.add(TreasureKind.HELMET); 
        top = new ArrayList(); 
        bs = new BadStuff("Embobados con el lindo primigenio, te descartas de tu casco visible", 0, tvp, top); 
        pz = new Prize(1,1); 
        unusedMonsters.add(new Monster("Chibithulhu", 2,bs, pz,0,"m004"));
        
        //El sopor de Dunwich 
        tvp = new ArrayList(); 
        tvp.add(TreasureKind.SHOE); 
        top = new ArrayList(); 
        bs = new BadStuff("El primordial bostezo contagioso. Pierdes el calzado visible", 0, tvp, top); 
        pz = new Prize(1,1); 
        unusedMonsters.add(new Monster("El sopor de Dunwich ", 2,bs, pz,0,"m005"));
        
        //El gorron en el umbral 
        ///////////////////////////////////////////////A tener en cuenta dependiendo de los tesoros del jugador 
        bs = new BadStuff("Pierdes todos tus tesoros visibles", 0, 0, 0); 
        pz = new Prize(3,1); 
        unusedMonsters.add(new Monster("El gorron en el umbral ", 10,bs, pz,0,"m006"));
        
        //H.P. Munchcraft 
        tvp = new ArrayList(); 
        tvp.add(TreasureKind.ARMOR); 
        top = new ArrayList(); 
        bs = new BadStuff("Pierdes la armadura visible", 0, tvp, top); 
        pz = new Prize(2,1); 
        unusedMonsters.add(new Monster("H.P. Munchcraft ", 6,bs, pz,0,"m007"));
        
        //Bichgooth 
        tvp = new ArrayList(); 
        tvp.add(TreasureKind.ARMOR); 
        top = new ArrayList(); 
        bs = new BadStuff("Sientes bichos bajo la ropa. Descarta la armadura visible", 0, tvp, top); 
        pz = new Prize(1,1); 
        unusedMonsters.add(new Monster("Bichgooth", 2,bs, pz,0,"m008"));
        
        //La que redacta en las tinieblas 
        bs = new BadStuff("Toses los pulmones y pierdes 2 niveles", 2, 0, 0); 
        pz = new Prize(1,1); 
        unusedMonsters.add(new Monster("La que redacta en las tinieblas ", 2,bs, pz,0,"m009"));
        
        //Los hondos 
        ////////////////////////////////////Reducir el nivel del jugador hasta dejarlo en nivel 1 
        bs = new BadStuff("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto", 0, 0, 0); 
        pz = new Prize(2,1); 
        unusedMonsters.add(new Monster("Los hondos", 8,bs, pz,0,"m010"));
        
        //Semillas Cthulhu 
        bs = new BadStuff("Pierdes 2 niveles y 2 tesoros ocultos", 2, 0, 2); 
        pz = new Prize(2,1); 
        unusedMonsters.add(new Monster("Semillas Cthulhu", 4,bs, pz,0,"m011"));
        
        //Dameargo
        tvp = new ArrayList(); 
        tvp.add(TreasureKind.ONEHAND); 
        top = new ArrayList(); 
        bs = new BadStuff("Te intentas escaquear. Pierdes un arma de mano visible", 0, tvp, top); 
        pz = new Prize(2,1); 
        unusedMonsters.add(new Monster("Dameargo", 1,bs, pz,0,"m012"));
        
        //Pollipolipo volante        
        bs = new BadStuff("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0); 
        pz = new Prize(1,1); 
        unusedMonsters.add(new Monster("Pollipolipo volante", 3,bs, pz,0,"m013"));
        
        //Yskhtihyssg-Goth    
        ////////////////////////////////////Reducir el nivel del jugador hasta dejarlo en nivel 1 
        bs = new BadStuff("No le hace gracia que pronuncien mal su nombre. Estas muerto", true); 
        pz = new Prize(3,1);
        unusedMonsters.add(new Monster("Yskhtihyssg-Goth ", 12,bs, pz,0,"m014"));
        
        //Familia feliz 
        ////////////////////////////////////Reducir el nivel del jugador hasta dejarlo en nivel 1 
        bs = new BadStuff("La familia te atrapa. Estas muerto",true); 
        pz = new Prize(4,1);
        unusedMonsters.add(new Monster("Familia feliz ", 1,bs, pz,0,"m015"));
        
        //Roboggoth 
        tvp = new ArrayList(); 
        tvp.add(TreasureKind.BOTHHAND); 
        top = new ArrayList(); 
        bs = new BadStuff("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible ", 2, tvp, top); 
        pz = new Prize(2,1); 
        unusedMonsters.add(new Monster("Roboggoth", 8,bs, pz,0,"m016"));
        
        //El espia 
        tvp = new ArrayList(); 
        tvp.add(TreasureKind.HELMET); 
        top = new ArrayList(); 
        bs = new BadStuff("Te asusta en la noche. Pierdes un casco visible.", 0, tvp, top); 
        pz = new Prize(1,1); 
        unusedMonsters.add(new Monster("El espia", 5,bs, pz,0,"m017"));
        
        //El lenguas          
        bs = new BadStuff("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.", 2, 5, 0); 
        pz = new Prize(1,1); 
        unusedMonsters.add(new Monster("El lenguas ", 20,bs, pz,0,"m018"));
        
        //Bicefalo 
        tvp = new ArrayList(); 
        tvp.add(TreasureKind.ONEHAND); 
        top = new ArrayList(); 
        bs = new BadStuff("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.", 3, tvp, top); 
        pz = new Prize(1,1); 
        unusedMonsters.add(new Monster("Bicefalo", 20,bs, pz,0,"m019")); 
        //*********MONSTRUOS CON SECTARIOS*************
        
        //El mal indecible impronunciable
        tvp = new ArrayList(); 
        tvp.add(TreasureKind.ONEHAND); 
        top = new ArrayList(); 
        bs = new BadStuff("Pierdes una mano visible.", 0, tvp, top); 
        pz = new Prize(3,1); 
        unusedMonsters.add(new Monster("El mal indecible impronunciable", 10,bs, pz,-2,"m020")); 
        
        //Testigos Oculares
        tvp = new ArrayList(); 
        tvp.add(TreasureKind.ONEHAND); 
        top = new ArrayList(); 
        bs = new BadStuff("Pierdes tus tesoros visibles. Jajaja", 0, tvp, top); 
        pz = new Prize(2,1); 
        unusedMonsters.add(new Monster("Testigos Oculares", 6,bs, pz,+2,"m021")); 
        
        //El gran Cthulhu         
        bs = new BadStuff("Hoy no es tu dia de suerte. Mueres.",true); 
        pz = new Prize(2,5); 
        unusedMonsters.add(new Monster("El gran Cthulhu", 20,bs, pz,+4,"m022"));
        
        //Serpiente Politico         
        bs = new BadStuff("Tu gobierno te recorta 2 niveles.", 2, 0, 0); 
        pz = new Prize(2,1); 
        unusedMonsters.add(new Monster("Serpiente Politico", 8,bs, pz,-2,"m023"));
        
        //Felpuggoth
        tvp = new ArrayList(); 
        tvp.add(TreasureKind.HELMET); 
        tvp.add(TreasureKind.ARMOR); 
        top = new ArrayList(); 
        top.add(TreasureKind.ONEHAND);
        bs = new BadStuff("Pierdes tu casco y tu armadura visible. Pierdes tu arma de mano ocultas", 0, tvp, top); 
        pz = new Prize(1,1); 
        unusedMonsters.add(new Monster("Felpuggoth", 2,bs, pz,+5,"m024")); 
        
        //Shoggoth         
        bs = new BadStuff("Pierdes 2 niveles.", 2, 0, 0); 
        pz = new Prize(4,2); 
        unusedMonsters.add(new Monster("Shoggoth", 16,bs, pz,-4,"m025"));
        
        //Lolitagooth         
        bs = new BadStuff("Pintalabios negro. Pierdes 2 niveles.", 2, 0, 0); 
        pz = new Prize(1,1); 
        unusedMonsters.add(new Monster("Lolitagooth", 2,bs, pz,+3,"m026"));
    }
    private void initCultistCardDeck(){
        unusedCultists.add(new Cultist("Sectario1",1));
        unusedCultists.add(new Cultist("Sectario2",2));
        unusedCultists.add(new Cultist("Sectario3",1));
        unusedCultists.add(new Cultist("Sectario4",2));
        unusedCultists.add(new Cultist("Sectario5",1));
        unusedCultists.add(new Cultist("Sectario6",1));
    }
    private void shuffleTreasures(){
        Collections.shuffle(unusedTreasures);
    }
    private void shuffleMonsters(){
        Collections.shuffle(unusedMonsters);
    }
    private void shuffleCultists(){
        Collections.shuffle(unusedCultists);
    }
    public static CardDealer getInstance(){
        return instance;
    }
    
    public Treasure nextTreasure(){
        if(unusedTreasures.size() == 0){
            unusedTreasures = usedTreasures;
            usedTreasures = new ArrayList();
            shuffleTreasures();
        }    
        int posicion = unusedTreasures.size() - 1; 
        System.out.println(Integer.toString(posicion));
        Treasure tre = unusedTreasures.get(posicion);
        giveTreasureBack(tre);
        unusedTreasures.remove(tre);
        return tre;
    }
    public Monster nextMonster(){
        if(unusedMonsters.size() == 0){
            unusedMonsters = usedMonsters;
            usedMonsters = new ArrayList();
            shuffleMonsters();
        }    
        int posicion = unusedMonsters.size() - 1; 
        Monster mon = unusedMonsters.get(posicion);
        giveMonsterBack(mon);
        unusedMonsters.remove(mon);
        return mon;
    }
    public Cultist nextCultist(){
        if(this.unusedCultists.size() == 0){
            this.unusedCultists = this.usedCultists;
            this.usedCultists = new ArrayList();
            this.shuffleCultists();
        }    
        int posicion = this.unusedCultists.size() - 1; 
        Cultist tre = this.unusedCultists.get(posicion);
        this.giveCultistBack(tre);
        this.unusedCultists.remove(tre);
        return tre;
    }
    public void giveTreasureBack(Treasure t){
        usedTreasures.add(t);
    }
    public void giveMonsterBack(Monster m){
        usedMonsters.add(m);
    }
    public void giveCultistBack(Cultist c){
        this.usedCultists.add(c);
    }
    public void initCards(){
        this.initMonsterCardDeck();
        this.initTreasureCardDeck();
        this.initCultistCardDeck();
        shuffleMonsters();
        shuffleTreasures();
        shuffleCultists();
    }
}
