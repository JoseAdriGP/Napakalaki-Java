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
public class Napakalaki {
    private static final Napakalaki instance = new Napakalaki();
    private ArrayList<Player> players;
    private Player currentPlayer;
    private Monster currentMonster;
    private CardDealer dealer = CardDealer.getInstance(); 
    
    private Napakalaki(){}
    private void initPlayers(ArrayList<String> names){
        players = new ArrayList();
        int numero = names.size();
        for(int i = 0; i < numero; i++){
            players.add(new Player(names.get(i)));
            System.out.println("Creado el jugador "+names.get(i));
        }
    }
    private Player nextPlayer(){
        if(currentPlayer == null){
            // No hacemos players.size-1 ya que math.random genera un numero entre 0 y 1 pero nunca 1.
            // math.random devuelve un double por eso le hacemos un int delante
            currentPlayer = players.get((int)(Math.random()*players.size()));
        }else{
            //Obtenemos el indice del jugador actual, le sumamos 1 ya que este es el siguiente, y le hacemos modulo para que si llega al final vuelva a la 1ª pos.
            currentPlayer = players.get((players.indexOf(currentPlayer)+1)%players.size());
        }
        return currentPlayer;
    }
    public static Napakalaki getInstance(){
        return instance;
    }
    public CombatResult developCombat(){
        CombatResult result = currentPlayer.combat(currentMonster);
        if(result == CombatResult.LoseAndConvert){
            Cultist cartaCultist = CardDealer.getInstance().nextCultist();
            CultistPlayer newCultistPlayer = new CultistPlayer(currentPlayer, cartaCultist);
            int posicionPlayer = this.players.indexOf(currentPlayer);
            this.players.set(posicionPlayer, newCultistPlayer);
            this.currentPlayer = newCultistPlayer;
        }
        dealer.giveMonsterBack(currentMonster);
        
        return result;
    }
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){
        for(int i=0; i<=treasures.size()-1; i++){
            currentPlayer.discardVisibleTreasure(treasures.get(i));
            dealer.giveTreasureBack(treasures.get(i));
        }
    }
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){
        for(int i=0; i<=treasures.size()-1; i++){
            currentPlayer.discardHiddenTreasure(treasures.get(i));
            dealer.giveTreasureBack(treasures.get(i));
        }
    }
    public void makeTreasureVisible(ArrayList<Treasure> treasures){
        for(int i=0; i<treasures.size(); i++)
            currentPlayer.makeTreasureVisible(treasures.get(i));
    }
    public boolean buyLevels(ArrayList<Treasure> visible, ArrayList<Treasure> hidden){
        boolean canI = currentPlayer.buyLevels(visible, hidden);
        return canI;
    }
    public void initGame(ArrayList<String> players){
        dealer.initCards();
        this.initPlayers(players);
        this.nextTurn();
    }
    public Player getCurrentPlayer(){
        return this.currentPlayer;
    }
    public Monster getCurrentMonster(){
        return this.currentMonster;
    }
    public boolean canMakeTreasureVisible(Treasure t){
        return false;
    }
    public boolean nextTurn(){
        boolean stateOK = nextTurnIsAllowed();
        if(stateOK){
            currentMonster = dealer.nextMonster();
            currentPlayer = this.nextPlayer();
            boolean dead = currentPlayer.isDead();
            if(dead){
                currentPlayer.initTreasures();
            }
        }
        return stateOK;
    }
    public boolean nextTurnIsAllowed(){
        if(currentPlayer==null) return true;
        return currentPlayer.validState();
    }
    public boolean endOfGame(CombatResult result){
        if(result == CombatResult.WinAndWinGame){
            return true;
        }else{
            return false;
        }
    }
    //Examen
    public boolean regalarTesoro(ArrayList<Treasure> tre){
        Treasure t = tre.get(0);
        boolean oculto = currentPlayer.canMakeGift(t);
        int lv = 10;
        if(oculto){
            for(Player pla: players)
                if(pla != currentPlayer)
                    if(pla.getLevels()<lv)
                        lv=pla.getLevels();
            for(Player pla: players)
                if(pla != currentPlayer)
                    if(!pla.isCultist())
                        if(pla.getLevels()==lv){
                            pla.getHiddenTreasures().add(t);
                            currentPlayer.discardHiddenTreasure(t);
                        }
        }else{
            System.out.println("No se puede regalar el tesoro");
        }
        return oculto;
    }
    
    //Fin Exámen
          
}
