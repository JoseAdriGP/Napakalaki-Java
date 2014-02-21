package napakalaki;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jose
 */
public class Prize {
    private int treasures;
    private int levels;
    
    public Prize(int t, int l){
        this.treasures = t;
        this.levels = l;
    }
    
    public int getTreasures(){
        return this.treasures;
    } 
    public int getLevel(){
        return this.levels;
    } 
    @Override
    public String toString(){
        return "Tesoros = " + Integer.toString(this.treasures) + " Niveles = " + Integer.toString(this.levels);
    }
}
