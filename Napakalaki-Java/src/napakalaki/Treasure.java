package napakalaki;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Juanaco
 */
public class Treasure implements Card {
    private String name;
    private String id;
    private int goldCoins;
    private int minBonus;
    private int maxBonus;
    private TreasureKind type;
    //Constructor de Treasure visible
    public Treasure(String n,String id, int g, int min, int max, TreasureKind t){
        this.name = n;
        this.id = id;
        this.goldCoins = g;
        this.minBonus = min;
        this.maxBonus = max;
        this.type = t;
    }
    //Get id
    public String getId(){
        return this.id;
    }
    //Get del  Name 
    public String getName(){
        return this.name;
    }
    //Get de monedas de oro
    public int getGoldCoins(){
        return this.goldCoins;
    }
    //Get de el bonus minimo
    public int getMinBonus(){
        return this.minBonus;
    }
    //Get del el bonus maximo
    public int getMaxBonus(){
        return this.maxBonus;
    }
    //Get del tipo de tesoro
    public TreasureKind getType(){
        return this.type; 
    }

    @Override
    public int getBasicValue() {
       return this.minBonus;
    }

    @Override
    public int getSpecialValue() {
       return this.maxBonus; 
    }
}
