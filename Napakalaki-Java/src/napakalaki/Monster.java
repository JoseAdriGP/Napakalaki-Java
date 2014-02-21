/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import napakalaki.BadStuff;
import napakalaki.Card;
import napakalaki.Prize;

/**
 *
 * @author juanantoniomarinsanchez
 */
public class Monster implements Card {
    private String name;
    private String id;
    private int combatLevel;
    private BadStuff badStuff;
    private Prize prize;
    private int levelChangeAgainstCultistPlayer;
    //No aparece en el diagrama UML
    /*public Monster(String name, int combatLevel){
        this.name = name;
        this.combatLevel = combatLevel;
    }*/
    public Monster(String n, int l, BadStuff b, Prize p, int lc, String id){
        this.name = n;
        this.combatLevel = l;
        this.badStuff = b;
        this.prize = p;
        this.levelChangeAgainstCultistPlayer = lc;
        this.id = id;
    }
    public String getName(){
        return this.name;
    }
    public String getId(){
        return this.id;
    }
    public Prize getPrize(){
        return this.prize;
    }
    public int getCombatLevel(){
        return this.combatLevel;
    }
    public BadStuff getBadStuff(){
        return this.badStuff;
    }
    public int getLevelsGained(){
        return this.prize.getLevel(); 
    }
    public int getTreasuresGained(){
        return this.prize.getTreasures();
    }
    public boolean kills(){
        boolean comprobante = false; 
        if(badStuff.getDeath())
            comprobante = true;
        return comprobante;
    }
    @Override
    public String toString(){
        return "Nombre = " + this.name + " niveles = " + Integer.toString(this.combatLevel)+ " " + this.badStuff + " "+this.prize;
    }

    @Override
    public int getBasicValue() {
        return this.getCombatLevel();
    }

    @Override
    public int getSpecialValue() {
        return (this.getCombatLevel() + this.levelChangeAgainstCultistPlayer);
    }
}