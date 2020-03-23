/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconcentration;

import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author lee_c
 */
public class ConcentrationGUI extends javax.swing.JFrame {

    JLabel[] allImages = new JLabel[16];
    Image albumImages[] = new Image[8];
    List<Integer> gridValues = new ArrayList<Integer>();
    List<Integer> picked = new ArrayList<Integer>();
    Image coverImage;
    private Toolkit tools;
    //JLabel lastPickedLabel, clickedLabel;//problem with removing items from screen 
    //List<JLabel> guessedImages = new ArrayList<JLabel>();

    public void loadImages() {
        coverImage = tools.getImage(getClass().getResource("vinyl.jpg"));
        albumImages[0] = tools.getImage(getClass().getResource("backinblack.jpg"));
        albumImages[1] = tools.getImage(getClass().getResource("billyJoel.jpg"));
        albumImages[2] = tools.getImage(getClass().getResource("doublelive.jpg"));
        albumImages[3] = tools.getImage(getClass().getResource("eaglesgrthit.jpg"));
        albumImages[4] = tools.getImage(getClass().getResource("hotelcalifornia.jpg"));
        albumImages[5] = tools.getImage(getClass().getResource("ledzeppeniv.jpg"));
        albumImages[6] = tools.getImage(getClass().getResource("theWall.jpg"));
        albumImages[7] = tools.getImage(getClass().getResource("thriller.jpg"));

        for (int x = 0; x < 16; x++) {
            gridValues.add(x % 8);//load with a modulus of 8  
        }
        Collections.shuffle(gridValues);
    }

    public void removeMouse() {
        Component panelItems[];
        panelItems = panelGrid.getComponents();
        for (int x = 0; x < panelItems.length; x++) {
            panelItems[x].removeMouseListener(ml);
        }
    }

    public void addMouse() {
        Component panelItems[];
        panelItems = panelGrid.getComponents();
        for (int x = 0; x < panelItems.length; x++) {
            panelItems[x].addMouseListener(ml);
        }
    }
    MouseListener ml = new MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            clickALabel(evt);
        }
    };

    private void clickALabel(java.awt.event.MouseEvent evt) {
        JLabel clickedLabel = (JLabel) evt.getSource();
        clickedLabel.removeMouseListener(ml);//not in notes yet
        try {
            int labelNum = Integer.parseInt(clickedLabel.getText());
            picked.add(labelNum);//hold onto the number - just to simplify later
            //clickedLabel.setIcon(getImage(albumImages[labelNum % 8]));
            clickedLabel.setIcon(getImage(albumImages[gridValues.get(labelNum)]));
            if (picked.size() == 2) {
                removeMouse();
                jButton1.setVisible(true);
            }
        } catch (NumberFormatException numberFormatException) {
            JOptionPane.showMessageDialog(this, clickedLabel.getName() + " failed");
            return;
            //this should never fail
        }
    }

    public ImageIcon getImage(Image theImage) {
        Image scaledAlbum = theImage.getScaledInstance(125, 125,
                Image.SCALE_SMOOTH);
        return new ImageIcon(scaledAlbum);
    }

    public void createLabels() {
        JLabel aLabel;

        for (int x = 0; x < 16; x++) {
            aLabel = new JLabel();
            aLabel.setSize(150, 150);
            aLabel.setIcon(getImage(coverImage));
            aLabel.setFont(new java.awt.Font("Times New Roman", 0, 0));//invisible
            aLabel.setText(x + "");//holding the number of the box a
            //see this code using a junk label
            /* aLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    clickALabel(evt);
                }
            });*/
            allImages[x] = aLabel;
            aLabel.addMouseListener(ml);
            panelGrid.add(aLabel);
        }
    }

    /**
     * Creates new form ConcentrationGUI
     */
    public ConcentrationGUI() {
        initComponents();
        tools = Toolkit.getDefaultToolkit();
        loadImages();
        createLabels();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGrid = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelGrid.setMinimumSize(new java.awt.Dimension(620, 620));
        panelGrid.setLayout(new java.awt.GridLayout(4, 4, 5, 5));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(panelGrid, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelGrid, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(jButton1)))
                .addContainerGap(121, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (gridValues.get(picked.get(0)) == gridValues.get(picked.get(1))) {
            JOptionPane.showMessageDialog(this, "Match");
            //remove from the board
            allImages[picked.get(0)].setVisible(false);
            //lastPickedLabel.removeMouseListener();
            allImages[picked.get(1)].setVisible(false);
        } else {
            allImages[picked.get(0)].setIcon(getImage(coverImage));
            allImages[picked.get(1)].setIcon(getImage(coverImage));
            allImages[picked.get(0)].addMouseListener(ml);
            allImages[picked.get(1)].addMouseListener(ml);
        }
        picked.clear();
        //guessedImages.clear();
        addMouse();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConcentrationGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConcentrationGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConcentrationGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConcentrationGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConcentrationGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel panelGrid;
    // End of variables declaration//GEN-END:variables
}
