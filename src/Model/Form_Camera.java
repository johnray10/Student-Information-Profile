/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author JayJomJohn
 */
public class Form_Camera extends javax.swing.JFrame {

    private Dimension ds = new Dimension(679, 501);
    private Dimension cs = WebcamResolution.VGA.getSize();
    private Webcam wCam = Webcam.getDefault();
    private WebcamPanel wCamPanel = new WebcamPanel(wCam, ds, false);

    public Form_Camera() {
        initComponents();
        btnStart.setVisible(true);
        btnCaptured.setVisible(false);
        wCam.setViewSize(cs);
        wCamPanel.setFillArea(true);
        panelCamera.setLayout(new FlowLayout());
        panelCamera.add(wCamPanel);
        ImageIcon myimage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Image/CAMERAICON.png")));
        Image img1 = myimage.getImage();
        Image img2 = img1.getScaledInstance(btnCaptured.getWidth(), btnCaptured.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon i = new ImageIcon(img2);
        btnCaptured.setIcon(i);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnCaptured = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnStart = new javax.swing.JButton();
        panelCamera = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1300, 650));
        setPreferredSize(new java.awt.Dimension(1300, 650));
        setSize(new java.awt.Dimension(1300, 650));
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        jPanel1.setBackground(new java.awt.Color(1, 50, 67));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCaptured.setBackground(new java.awt.Color(1, 50, 67));
        btnCaptured.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCaptured.setOpaque(true);
        btnCaptured.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCapturedMouseClicked(evt);
            }
        });
        jPanel1.add(btnCaptured, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 550, 117, 66));

        btnBack.setBackground(new java.awt.Color(153, 0, 51));
        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("BACK");
        btnBack.setBorderPainted(false);
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.setFocusPainted(false);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 580, 140, 30));

        btnStart.setBackground(new java.awt.Color(0, 102, 51));
        btnStart.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnStart.setForeground(new java.awt.Color(255, 255, 255));
        btnStart.setText("START");
        btnStart.setBorderPainted(false);
        btnStart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnStart.setFocusPainted(false);
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });
        jPanel1.add(btnStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 50, 142, 35));

        panelCamera.setBackground(java.awt.Color.black);

        javax.swing.GroupLayout panelCameraLayout = new javax.swing.GroupLayout(panelCamera);
        panelCamera.setLayout(panelCameraLayout);
        panelCameraLayout.setHorizontalGroup(
            panelCameraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 679, Short.MAX_VALUE)
        );
        panelCameraLayout.setVerticalGroup(
            panelCameraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        jPanel1.add(panelCamera, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, -1, 480));

        getContentPane().add(jPanel1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    Thread t = new Thread() {
        @Override
        public void run() {
            wCamPanel.start();
        }
    };

    private void btnCapturedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCapturedMouseClicked
        try {
            File file = new File(String.format("capture-%d.jpg", System.currentTimeMillis()));
            ImageIO.write(wCam.getImage(), "JPG", file);
            JOptionPane.showMessageDialog(this, "Successfully Captured :\n" + file.getAbsolutePath(), "ATTENTIOB", 1);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error in :\n" + ex.getMessage(), "CamCap", 0);
        }
    }//GEN-LAST:event_btnCapturedMouseClicked

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        t.stop();
        wCamPanel.stop();
        this.hide();      
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        t.setDaemon(true);
        t.start();
        btnCaptured.setVisible(true);
        btnStart.setVisible(false);
    }//GEN-LAST:event_btnStartActionPerformed

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
            java.util.logging.Logger.getLogger(Form_Camera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Camera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Camera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Camera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Camera().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    public javax.swing.JLabel btnCaptured;
    private javax.swing.JButton btnStart;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelCamera;
    // End of variables declaration//GEN-END:variables
}
