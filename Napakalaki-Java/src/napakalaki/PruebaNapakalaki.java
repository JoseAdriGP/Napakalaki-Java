/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import GUI.*;
import java.util.ArrayList;

/**
 *
 * @author juanantoniomarinsanchez
 */
public class PruebaNapakalaki {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Napakalaki napakalakiModel = Napakalaki.getInstance();
        NapakalakiView napakalakiView = new NapakalakiView();
        Dice.createInstance(napakalakiView);
        
        
        ArrayList<String> names = new ArrayList();
        PlayerNamesCapture namesCapture = new PlayerNamesCapture(napakalakiView, true);
        names = namesCapture.getNames();
        napakalakiModel.initGame(names);
        napakalakiView.setNapakalaki(napakalakiModel);
        napakalakiView.showView();
        
        
        
//        Napakalaki juego = Napakalaki.getInstance();
//        ArrayList<String> nombres = new ArrayList();
//        nombres.add("Jugador 1");
//        nombres.add("Jugador 2");
//        nombres.add("Jugador 3");
//        nombres.add("Jugador 4");
//        juego.initGame(nombres);
        
//        //Mostrar todos los monstruos (nombre, nivel de combate, buen rollo y mal rollo) que
//        //tengan un nivel de combate superior a 10.
//        System.out.println("NIVEL SUPERRIOR A 10");
//        for (int i=0; i<monsters.size(); i++){
//            if(monsters.get(i).getCombatLevel()>10){ 
//                System.out.println("Nombre: "+monsters.get(i).getName()+" Nivel de combate: "+monsters.get(i).getCombatLevel()+" Buen Rollo: "+monsters.get(i).getPrice().toString()+" Mal rollo:"+monsters.get(i).getBc().getText());
//            }
//        }
//        //Mostrar todos los monstruos (nombre, nivel de combate, buen rollo y mal rollo) que
//        //tengan un mal rollo que implique sólo pérdida de niveles
//        System.out.println("SOLO PERDIDA DE NIVELES:");
//        for (int i=0; i<monsters.size(); i++){
//            if(monsters.get(i).getBc().getLevels()>0 && monsters.get(i).getBc().getNHiddenTreasures()==0 && monsters.get(i).getBc().getNVisibleTreasures()==0 && monsters.get(i).getBc().getSpecificHiddenTreasures().isEmpty() &&monsters.get(i).getBc().getSpecificVisibleTreasures().isEmpty()){ 
//                System.out.println("Nombre: "+monsters.get(i).getName()+" Nivel de combate: "+monsters.get(i).getCombatLevel()+" Buen Rollo: "+monsters.get(i).getPrice().toString()+" Mal rollo:"+monsters.get(i).getBc().getText());
//            }
//        }
//        //Mostrar todos los monstruos (nombre, nivel de combate, buen rollo y mal rollo) que
//        //tengan un buen rollo que indique una ganancia de niveles superior a 1
//        System.out.println("GANANCIA DE NIVELES SUPERIOR A 1:");
//        for (int i=0; i<monsters.size(); i++){
//            if(monsters.get(i).getPrice().getLevel()>1){ 
//                System.out.println("Nombre: "+monsters.get(i).getName()+" Nivel de combate: "+monsters.get(i).getCombatLevel()+" Buen Rollo: "+monsters.get(i).getPrice().toString()+" Mal rollo:"+monsters.get(i).getBc().getText());
//            }
//        }
//        
//        
//        //Mostrar todos los monstruos (nombre, nivel de combate, buen rollo y mal rollo) que
//        //tengan un mal rollo que suponga la pérdida de un determinado tipo de tesoros ya
//        //sea visibles y/o ocultos.
//        System.out.println("PERDIDA DE UN DETERMINADO TIPO DE TESOROS:");
//        for (int i=0; i<monsters.size(); i++){
//            if(monsters.get(i).getBc().getSpecificHiddenTreasures().isEmpty() == false || monsters.get(i).getBc().getSpecificVisibleTreasures().isEmpty() == false){ 
//                System.out.println("Nombre: "+monsters.get(i).getName()+" Nivel de combate: "+monsters.get(i).getCombatLevel()+" Buen Rollo: "+monsters.get(i).getPrice().toString()+" Mal rollo:"+monsters.get(i).getBc().getText());
//            }
//        }
    }
}
