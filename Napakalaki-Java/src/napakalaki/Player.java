/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author Juanaco
 */
public class Player {
    private boolean dead = false;
    private String name;
    private int level=1;
    private ArrayList<Treasure> visibleTreasures = new ArrayList<Treasure>();
    private ArrayList<Treasure> hiddenTreasures = new ArrayList<Treasure>();
    private BadStuff pendingBadStuff;
    
    
    
    public Player(String name){
        this.name = name;
        this.initTreasures();
    }
    public Player(Player p){
        this.dead = p.dead;
        this.name = p.name;
        this.level = p.level;
        this.visibleTreasures = p.visibleTreasures;
        this.hiddenTreasures = p.hiddenTreasures;
        this.pendingBadStuff = p.pendingBadStuff;
        this.initTreasures();
    }
    public void setLevel(int l){
        level = l;
    }
    public boolean isDead(){
        return this.dead;
    }
    public int getOponentLevel(Monster m){
        return m.getBasicValue();
    }
    public boolean shouldConvert(){
        int tiroDado =  Dice.getInstance().nextNumber("Has muerto","Si sacas un 6 te conviertes en cultista");
        if(tiroDado==6){
            return true;
        }
        else{
            return false;
        }
    }
    public int getCombatLevel(){
        int combatLevel = this.level;
        boolean necklace = false;
            for(int i=0; i<=visibleTreasures.size()-1; i++)
                if(visibleTreasures.get(i).getType() == TreasureKind.NECKLACE)
                    necklace = true;
            for(int i=0; i<=visibleTreasures.size()-1; i++){
                if(necklace)
                    combatLevel += visibleTreasures.get(i).getMaxBonus();
                else
                    combatLevel += visibleTreasures.get(i).getMinBonus();
            }
        return combatLevel;
    }
    public ArrayList<Treasure> getHiddenTreasures(){
        return this.hiddenTreasures;
    }
    public ArrayList<Treasure> getVisibleTreasures(){
        return this.visibleTreasures;
    }
    private void bringToLife(){
        this.dead = false;
    }
    private void incrementLevel(int i){
        this.level = this.level + i;
    }
    private void decrementLevel(int i){
        int lecturaA = this.level-i;
        if(lecturaA<1) this.level = 1;
        else this.level = lecturaA;
    }
    private void setPendingBadStuff(BadStuff b){
        pendingBadStuff = b;
    }
    private void die(){
        setLevel(1);
        CardDealer dealer = CardDealer.getInstance();
        for(int i=0; i<visibleTreasures.size(); i++){
            dealer.giveTreasureBack(visibleTreasures.get(i));
        }
        visibleTreasures.clear();
        for(int i=0; i<hiddenTreasures.size(); i++){
            dealer.giveTreasureBack(hiddenTreasures.get(i));
        }
        hiddenTreasures.clear();
        dieIfNoTreasures();
    }
    private void discardNecklaceVisible(){
            for(Treasure tre: visibleTreasures){
                if(tre.getType() == TreasureKind.NECKLACE){
                    discardVisibleTreasure(tre);
                }
            }
    }
    
    private void dieIfNoTreasures(){
        if(visibleTreasures.isEmpty()){
            if(hiddenTreasures.isEmpty()){
                dead = true;
            }
        }
    }
    
    private int computeGoldCoinsValue(ArrayList<Treasure> t){
        int monedas=0, niveles;
        for(Treasure tre: t ){
            monedas += tre.getGoldCoins();
        }
        niveles = (int)(monedas/1000);
        return niveles;
    }
    
    private boolean canIBuyLevels(int i){
        int levelaux;
        boolean comprobante = false;
        levelaux = level + i;
        if(levelaux < 10){
            comprobante = true;
        }
        return comprobante;
    }
    
    public void applyPrize(Monster currentMonster){
        int nLevels = currentMonster.getLevelsGained();
        incrementLevel(nLevels);
        int nTreasures = currentMonster.getTreasuresGained();
        if(nTreasures>0){
            CardDealer dealer = CardDealer.getInstance();
            for(int i=0; i<nTreasures; i++){
                hiddenTreasures.add(dealer.nextTreasure());
            }
        }
    }
    
    public CombatResult combat(Monster m){
        CombatResult combatResult;
        int myLevel = getCombatLevel();
        int monsterLevel = this.getOponentLevel(m);
        if(myLevel>monsterLevel){
            applyPrize(m);
            if(getLevels()>=10){
                combatResult = CombatResult.WinAndWinGame;
            }
            else{
                combatResult = CombatResult.Win;
            }
        }else{
            Dice dice = Dice.getInstance();
            int escape = dice.nextNumber("Has perdido el combate!!","Con un 5 o 6 podras escapar");
            if(escape<5){
                boolean amIDead = m.kills();
                
                if(amIDead){
                    die();
                    combatResult = CombatResult.LoseAndDie;
                }else{
                    if(shouldConvert()==true){
                        combatResult = CombatResult.LoseAndConvert;
                    }
                    else{
                        
                        BadStuff bad = m.getBadStuff();
                        applyBadStuff(bad);
                        combatResult = CombatResult.Lose;
                    }

                }
            }else{
                combatResult = CombatResult.LoseAndEscape;
            }
        }
        discardNecklaceVisible();
        return combatResult;    
    }
    
    public void applyBadStuff(BadStuff b){
        int nLevels = b.getLevels();
        decrementLevel(nLevels);
        // fallaba por la función, que no está implementada en BadStuff
       BadStuff pendingBad = b.adjustToFitTreasureList(visibleTreasures, hiddenTreasures);
       setPendingBadStuff(pendingBad);
    }   
    
    public void makeTreasureVisible(Treasure t){
        boolean canI = canMakeTreasureVisible(t);
        if(canI){
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }    
    }
    
    public boolean canMakeTreasureVisible(Treasure t){
        boolean comprobante = true;
        int dosArmas=1;
        if(visibleTreasures.isEmpty()){
            comprobante = true;
        }else{
            for(Treasure tre: visibleTreasures){
                if(t.getType()==TreasureKind.ONEHAND && tre.getType()==TreasureKind.ONEHAND && dosArmas<2){
                    comprobante = true;
                    dosArmas++;
                }
                else if(tre.getType() == t.getType()){
                    comprobante = false;
                }
                else if(tre.getType()==TreasureKind.BOTHHAND && t.getType()==TreasureKind.ONEHAND){
                    comprobante = false;
                }
                else if(t.getType()==TreasureKind.BOTHHAND && tre.getType()==TreasureKind.ONEHAND){
                    comprobante = false;
                }
            }
        }
        return comprobante;
    }
    
    public void discardVisibleTreasure(Treasure t){
        visibleTreasures.remove(t);
        if(pendingBadStuff != null && !pendingBadStuff.isEmpty()){
            pendingBadStuff.substractVisibleTreasure(t);
        }
        this.dieIfNoTreasures();
    }
    
    public void discardHiddenTreasure(Treasure t){
        hiddenTreasures.remove(t);
        if(pendingBadStuff != null && !pendingBadStuff.isEmpty()){
            pendingBadStuff.substractHiddenTreasure(t);
        }
        this.dieIfNoTreasures();
    }
    
    public boolean buyLevels(ArrayList<Treasure> visible, ArrayList<Treasure> hidden){
        int levelsMayBought = computeGoldCoinsValue(visible);
        levelsMayBought = levelsMayBought + computeGoldCoinsValue(hidden);
        boolean canI = canIBuyLevels(levelsMayBought);
        if(canI)
            incrementLevel(levelsMayBought);
        CardDealer dealer = CardDealer.getInstance();
        for(int i=0; i<visible.size(); i++){
            dealer.giveTreasureBack(visible.get(i));
        }
        for(int i=0; i<hidden.size(); i++){
            dealer.giveTreasureBack(hidden.get(i));
        }
        visibleTreasures.removeAll(visible);
        hiddenTreasures.removeAll(hidden);
        return canI;        
    }
    
    public boolean validState(){
        boolean comprobante = false;
        if(this.pendingBadStuff !=null){
            if(pendingBadStuff.isEmpty()){
                if(hiddenTreasures.size() < 5){
                    comprobante = true;
                }
            }
        }
        if(this.pendingBadStuff == null){ 
            if(hiddenTreasures.size() < 5){
                    comprobante = true;
                }
            else{
                comprobante = false;
            }
        }
        return comprobante;
    }
    
    public void initTreasures(){
        CardDealer dealer = CardDealer.getInstance();
        Dice dice = Dice.getInstance();
        bringToLife();
        Treasure treasure = dealer.nextTreasure();
        hiddenTreasures.add(treasure);
        int number = dice.nextNumber(this.name+" esta inicializando tesoros", "1 un tesoro, 2-6 dos y 6 para 3 tesoros");
        if(number < 6 && number > 1){
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
        if(number == 6){
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
    }
    
    public boolean hasVisibleTreasures(){
        boolean comprobante = false;
        if(visibleTreasures.size() != 0){
            comprobante = true;
        }
        return comprobante;
    }
    
    public int getLevels(){
        return this.level;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int howManyVisibleTreasures(TreasureKind tKind){
        int contador=0;
        for(Treasure tre: visibleTreasures){
            if(tre.getType() == tKind){
                contador++;
            }
        }
        return contador;
    }
    //Examen
    public boolean canMakeGift(Treasure t){
        boolean puedo=false;
        for(Treasure tre: hiddenTreasures)
            if(tre == t)
                puedo=true;
        return puedo;
    }
    public boolean isCultist(){
        return false;
    }
    //Fin Exámen
}
