/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author juanantoniomarinsanchez
 */
public class CultistPlayer extends Player {
    private static int totalCultistPlayers = 0;
    private Cultist myCultistCard;
    
    public CultistPlayer(Player p, Cultist c){
        super(p);  
        this.myCultistCard = c;
        CultistPlayer.totalCultistPlayers = CultistPlayer.totalCultistPlayers + 1;
    }
    public Cultist getMyCultistCard(){
        return this.myCultistCard;
    }
    @Override
    public int getCombatLevel(){
        int retornoCombate;
        retornoCombate = super.getCombatLevel() + this.myCultistCard.getSpecialValue();
        return retornoCombate;
    }
    @Override
    public boolean shouldConvert(){
        return false;
    }
    
    @Override
    public int getOponentLevel(Monster m){
        return m.getSpecialValue();
    }

    private int computeGoldCoinsValue(ArrayList<Treasure> t){
        int monedas=0, niveles;
        for(Treasure tre: t ){
            monedas += tre.getGoldCoins();
        }
        //Los cultist duplican su valor
        monedas = monedas *2;
        niveles = (int)(monedas/1000);
        return niveles;
    }
    public static int getTotalCultistPlayers(){
        return totalCultistPlayers;
    }
    //Examen
    @Override
    public boolean canMakeGift(Treasure t){
        return false;
    }
    @Override
    public boolean isCultist(){
        return true;
    }
    //Fin Exámen
    
}
