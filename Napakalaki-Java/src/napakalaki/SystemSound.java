/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package napakalaki;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Jose
 */
public class SystemSound {
    /*
    File intro = new File("./src/Sounds/intro.wav");
    File victory = new File("./src/Sounds/victoria.wav");
    File bothhand = new File("./src/Sounds/bothhand.wav");
    File onehand = new File("./src/Sounds/onehand.wav");
    AudioInputStream audioIntro, audioVictory, audioOne, audioBoth;
    Clip intrO, victorY, bothhanD, onehanD;
    */
    HashMap <String, Clip> sonidos;
    
    private static SystemSound instance = null;
    
    public int addClip(String filename){
        File filetmp = new File(filename);
        try {
            AudioInputStream aistmp = AudioSystem.getAudioInputStream(filetmp);
            Clip cliptmp= AudioSystem.getClip();
            cliptmp.open(aistmp);
            sonidos.put(filename, cliptmp);
            return 0;
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(SystemSound.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SystemSound.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(SystemSound.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;

        }
    
    private SystemSound() throws LineUnavailableException {
        sonidos = new HashMap<String,Clip>();
        this.addClip("./src/Sounds/intro.wav");
        this.addClip("./src/Sounds/victoria.wav");
        this.addClip("./src/Sounds/bothhand.wav");
        this.addClip("./src/Sounds/onehand.wav");
        this.addClip("./src/Sounds/punch.wav");
        this.addClip("./src/Sounds/gold.wav");
        this.addClip("./src/Sounds/dead.wav");
        this.addClip("./src/Sounds/scape.wav");
        /*try {
            this.audioIntro = AudioSystem.getAudioInputStream(intro);
            this.intrO  = AudioSystem.getClip();
            intrO.open(audioIntro);
            
            this.audioVictory = AudioSystem.getAudioInputStream(victory);
            this.victorY  = AudioSystem.getClip();
            victorY.open(audioVictory);
            
            this.audioOne = AudioSystem.getAudioInputStream(onehand);
            this.onehanD  = AudioSystem.getClip();
            onehanD.open(audioOne);
            
            this.audioBoth = AudioSystem.getAudioInputStream(bothhand);
            this.bothhanD  = AudioSystem.getClip();
            bothhanD.open(audioBoth);
            
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(SystemSound.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SystemSound.class.getName()).log(Level.SEVERE, null, ex);
        }
        */        
    }
    
    public int playSound(String name, Boolean loop){
        if(sonidos.get(name)==null){
            System.out.println("Clip de audio "+name+" no encontrado.");
            return -1;}
        else if(loop){
            sonidos.get(name).loop(Clip.LOOP_CONTINUOUSLY);
            System.out.println("Clip de audio "+name+" reproduciendo en loop.");}
            else{
                System.out.println("Clip de audio "+name+" reproducido.");
                sonidos.get(name).start();
                }
        return 0;
        
    }
    
    public static SystemSound getInstace(){
        if(instance==null){
            try {
                instance = new SystemSound();
            } catch (LineUnavailableException ex) {
                Logger.getLogger(SystemSound.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return instance;
    }
    
    public int stopSound(String name){
        if(sonidos.get(name)==null)
            return -1;
        else{
            sonidos.get(name).stop();
            sonidos.get(name).setFramePosition(0);
        }
        
        
        return 0;
    }
    
}
