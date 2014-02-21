/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author Jose
 */
public class BadStuff {
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    //Constructor visibilidad publica
    public BadStuff(String t, int l, int nVisible, int nHidden){
        this.text = t;
        this.levels = l;
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
    }
    //Constructor visibilidad publica
    public BadStuff(String t, boolean death){
        this.text = t;
        this.death = death;
    }
    //Constructor visibilidad publica
    public BadStuff(String t, int l, ArrayList<TreasureKind> v, ArrayList<TreasureKind> h){
        this.text = t;
        this.levels = l;
        this.specificVisibleTreasures = v;
        this.specificHiddenTreasures = h;
    }
    
    public boolean isEmpty(){
        boolean comprobante = true;
        System.out.println("LLega hasta aqui");
        if(nVisibleTreasures > 0 || nHiddenTreasures > 0 || levels > 0 || !specificHiddenTreasures.isEmpty() || !specificVisibleTreasures.isEmpty())
            comprobante = false;
        return comprobante;
    }
    
    public boolean kills(){
        return false;
    }
    
//Consultores básicos    
    public String getText(){
        return this.text;
    }
    
    public int getLevels(){
        return this.levels;
    }
    
    public int getNVisibleTreasures(){
        return this.nVisibleTreasures;
    }
    
    public int getNHiddenTreasures(){
        return this.nHiddenTreasures;
    }
    
    public boolean getDeath(){
        return this.death;
    }
    
    public ArrayList getSpecificHiddenTreasures(){
        return this.specificHiddenTreasures;
    }
    
    public ArrayList getSpecificVisibleTreasures(){
        return this.specificVisibleTreasures;
    }
    
    public void substractVisibleTreasure(Treasure t){
        if(!specificVisibleTreasures.isEmpty()){
            for(TreasureKind tre: specificVisibleTreasures)
                if(tre.equals(t.getType()))
                    specificVisibleTreasures.remove(tre);
        }else{
            if(nVisibleTreasures > 0){
                nVisibleTreasures--;
            }
        }
    }
    
    public void substractHiddenTreasure(Treasure t){
         if(!specificHiddenTreasures.isEmpty()){
            for(TreasureKind tre: specificHiddenTreasures)
                if(tre.equals(t.getType()))
                    specificHiddenTreasures.remove(tre);
        }else{
            if(nHiddenTreasures > 0){
                nHiddenTreasures--;
            }
        }
    }
    
    public BadStuff adjustToFitTreasureList(ArrayList<Treasure> v, ArrayList<Treasure> h){
        BadStuff pendingBadStuff;
        
        ArrayList<TreasureKind> visible = new ArrayList();
        ArrayList<TreasureKind> oculto = new ArrayList();        
        
        if(specificHiddenTreasures.size()>0){
            for(int i=0; i<specificHiddenTreasures.size(); i++){
                for(int j=0; j<h.size(); j++){
                    if(specificHiddenTreasures.get(i) == h.get(j).getType())
                        oculto.add(specificHiddenTreasures.get(i));
                }          
            }        
        }
        
        if (specificVisibleTreasures.size()>0){       
            for(int i=0; i<specificVisibleTreasures.size(); i++){
                for(int j=0; j<v.size(); j++){
                    if(specificVisibleTreasures.get(i)==v.get(j).getType())
                        visible.add(specificVisibleTreasures.get(i));
                }          
            }
        }
        
        if(specificVisibleTreasures.size()==0 && specificHiddenTreasures.size()==0){     
            for(int i=0; i<specificHiddenTreasures.size() && i<nVisibleTreasures;i++)
                oculto.add(v.get(i).getType());
            for(int i=0; i<specificVisibleTreasures.size() && i<nHiddenTreasures; i++)
                visible.add(h.get(i).getType());
        }
        
        pendingBadStuff = new BadStuff("BadStuff Personal",0,visible,oculto);
        
        return pendingBadStuff;
    }
    
    public boolean myBadStuffIsDeath(){
        boolean comprobante = false;
        if(death)
            comprobante = true;
        return comprobante;
        
    }
    @Override
    public String toString(){
        return "Niveles perdidos = " + Integer.toString(levels) + " Numero de tesoros visibles = " + Integer.toString(nVisibleTreasures)+ " Numero de tesoros ocultos = "+Integer.toString(nHiddenTreasures)+" Muerte = "+Boolean.toString(death)+" Tesoros ocultos = "+specificHiddenTreasures+" Tesoros visibles = "+specificVisibleTreasures;
    }
}
