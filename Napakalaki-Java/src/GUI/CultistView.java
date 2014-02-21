/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import napakalaki.Cultist;
import napakalaki.CultistPlayer;

/**
 *
 * @author juanantoniomarinsanchez
 */
public class CultistView extends javax.swing.JPanel {
    Cultist cultistModel;
    /**
     * Creates new form CultistView
     */
    public CultistView() {
        initComponents();
    }
    public void setCultist(Cultist c){
        this.cultistModel = c;
        if(this.cultistModel.getName() =="Sectario1")        
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cultista/c001.png")));
        if(this.cultistModel.getName() =="Sectario2")        
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cultista/c002.png")));
        if(this.cultistModel.getName() =="Sectario3")        
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cultista/c003.png")));
        if(this.cultistModel.getName() =="Sectario4")        
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cultista/c004.png")));
        if(this.cultistModel.getName() =="Sectario5")        
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cultista/c005.png")));
        if(this.cultistModel.getName() =="Sectario6")        
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cultista/c006.png")));
        this.descripcionSectario1.setText("+"+c.getBasicValue()+" por cada sectario en juego ("+CultistPlayer.getTotalCultistPlayers()+") = "+ c.getSpecialValue());
        this.descripcionSectario2.setText("No puedes dejar de ser sectario.");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImagen = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelDescripciones = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        descripcionSectario1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        descripcionSectario2 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setLayout(new java.awt.BorderLayout());

        panelImagen.setBackground(new java.awt.Color(255, 225, 188));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cultista/c001.png"))); // NOI18N
        panelImagen.add(jLabel1);

        add(panelImagen, java.awt.BorderLayout.CENTER);

        panelDescripciones.setBackground(new java.awt.Color(255, 225, 188));
        panelDescripciones.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 225, 188));

        descripcionSectario1.setFont(new java.awt.Font("Trajan Pro", 1, 10)); // NOI18N
        descripcionSectario1.setText("+1 por sectario en juego");
        descripcionSectario1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(descripcionSectario1);

        panelDescripciones.add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setBackground(new java.awt.Color(255, 225, 188));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hair.png"))); // NOI18N
        jPanel2.add(jLabel2);

        descripcionSectario2.setFont(new java.awt.Font("Trajan Pro", 1, 10)); // NOI18N
        descripcionSectario2.setText("Sectario por siempre");
        jPanel2.add(descripcionSectario2);

        panelDescripciones.add(jPanel2, java.awt.BorderLayout.SOUTH);

        add(panelDescripciones, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel descripcionSectario1;
    private javax.swing.JLabel descripcionSectario2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panelDescripciones;
    private javax.swing.JPanel panelImagen;
    // End of variables declaration//GEN-END:variables
}
