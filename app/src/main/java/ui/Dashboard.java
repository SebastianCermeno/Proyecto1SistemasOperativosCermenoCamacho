/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import comparadorpc.LogicMaster;

/**
 *
 * @author andre
 */
public class Dashboard extends javax.swing.JFrame {
    
    public static LogicMaster puppetMaster;

    /**
     * Creates new form Dashboard
     */
    public Dashboard(LogicMaster puppetMaster) {
        initComponents();
        this.puppetMaster = puppetMaster;
        this.setVisible(true);
        this.setLocationRelativeTo(null);
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
        jLabel13 = new javax.swing.JLabel();
        placasBaseAlmacen_DELL = new javax.swing.JTextField();
        placasBaseAlmacen_DELL1 = new javax.swing.JTextField();
        placasBaseAlmacen_DELL2 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        placasBaseAlmacen_DELL3 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        placasBaseAlmacen_DELL4 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        placasBaseAlmacen_DELL5 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel13.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Ganancias en Bruto");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(30, 80, 230, 30);

        placasBaseAlmacen_DELL.setBackground(new java.awt.Color(255, 255, 255));
        placasBaseAlmacen_DELL.setForeground(new java.awt.Color(51, 51, 51));
        placasBaseAlmacen_DELL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placasBaseAlmacen_DELLActionPerformed(evt);
            }
        });
        jPanel1.add(placasBaseAlmacen_DELL);
        placasBaseAlmacen_DELL.setBounds(40, 120, 160, 30);

        placasBaseAlmacen_DELL1.setBackground(new java.awt.Color(255, 255, 255));
        placasBaseAlmacen_DELL1.setForeground(new java.awt.Color(51, 51, 51));
        placasBaseAlmacen_DELL1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placasBaseAlmacen_DELL1ActionPerformed(evt);
            }
        });
        jPanel1.add(placasBaseAlmacen_DELL1);
        placasBaseAlmacen_DELL1.setBounds(40, 310, 160, 30);

        placasBaseAlmacen_DELL2.setBackground(new java.awt.Color(255, 255, 255));
        placasBaseAlmacen_DELL2.setForeground(new java.awt.Color(51, 51, 51));
        placasBaseAlmacen_DELL2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placasBaseAlmacen_DELL2ActionPerformed(evt);
            }
        });
        jPanel1.add(placasBaseAlmacen_DELL2);
        placasBaseAlmacen_DELL2.setBounds(40, 220, 160, 30);

        jLabel28.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setText("DASHBOARD");
        jPanel1.add(jLabel28);
        jLabel28.setBounds(280, 10, 180, 30);

        jLabel14.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Costos Operativos");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(30, 170, 230, 30);

        jLabel15.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Utilidad total del estudio");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(30, 270, 250, 30);

        placasBaseAlmacen_DELL3.setBackground(new java.awt.Color(255, 255, 255));
        placasBaseAlmacen_DELL3.setForeground(new java.awt.Color(51, 51, 51));
        placasBaseAlmacen_DELL3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placasBaseAlmacen_DELL3ActionPerformed(evt);
            }
        });
        jPanel1.add(placasBaseAlmacen_DELL3);
        placasBaseAlmacen_DELL3.setBounds(420, 310, 160, 30);

        jLabel16.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Utilidad total del estudio");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(410, 270, 250, 30);

        placasBaseAlmacen_DELL4.setBackground(new java.awt.Color(255, 255, 255));
        placasBaseAlmacen_DELL4.setForeground(new java.awt.Color(51, 51, 51));
        placasBaseAlmacen_DELL4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placasBaseAlmacen_DELL4ActionPerformed(evt);
            }
        });
        jPanel1.add(placasBaseAlmacen_DELL4);
        placasBaseAlmacen_DELL4.setBounds(420, 220, 160, 30);

        jLabel17.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Costos Operativos");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(410, 170, 230, 30);

        placasBaseAlmacen_DELL5.setBackground(new java.awt.Color(255, 255, 255));
        placasBaseAlmacen_DELL5.setForeground(new java.awt.Color(51, 51, 51));
        placasBaseAlmacen_DELL5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placasBaseAlmacen_DELL5ActionPerformed(evt);
            }
        });
        jPanel1.add(placasBaseAlmacen_DELL5);
        placasBaseAlmacen_DELL5.setBounds(420, 120, 160, 30);

        jLabel18.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Ganancias en Bruto");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(410, 80, 230, 30);

        wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/dashboard_wallpp.png"))); // NOI18N
        jPanel1.add(wallpaper);
        wallpaper.setBounds(0, 0, 733, 370);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void placasBaseAlmacen_DELLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placasBaseAlmacen_DELLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_placasBaseAlmacen_DELLActionPerformed

    private void placasBaseAlmacen_DELL1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placasBaseAlmacen_DELL1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_placasBaseAlmacen_DELL1ActionPerformed

    private void placasBaseAlmacen_DELL2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placasBaseAlmacen_DELL2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_placasBaseAlmacen_DELL2ActionPerformed

    private void placasBaseAlmacen_DELL3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placasBaseAlmacen_DELL3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_placasBaseAlmacen_DELL3ActionPerformed

    private void placasBaseAlmacen_DELL4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placasBaseAlmacen_DELL4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_placasBaseAlmacen_DELL4ActionPerformed

    private void placasBaseAlmacen_DELL5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placasBaseAlmacen_DELL5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_placasBaseAlmacen_DELL5ActionPerformed

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard(puppetMaster).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField placasBaseAlmacen_DELL;
    private javax.swing.JTextField placasBaseAlmacen_DELL1;
    private javax.swing.JTextField placasBaseAlmacen_DELL2;
    private javax.swing.JTextField placasBaseAlmacen_DELL3;
    private javax.swing.JTextField placasBaseAlmacen_DELL4;
    private javax.swing.JTextField placasBaseAlmacen_DELL5;
    private javax.swing.JLabel wallpaper;
    // End of variables declaration//GEN-END:variables
}
