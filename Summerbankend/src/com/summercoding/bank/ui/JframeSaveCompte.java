/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.summercoding.bank.ui;

import com.summercoding.bank.controleur.Controleur;
import com.summercoding.bank.entity.Admin;
import com.summercoding.bank.entity.Compte;
import com.summercoding.bank.entity.Utilisateur;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cynthiaabi
 */
public class JframeSaveCompte extends javax.swing.JFrame {
    
    Controleur controleur = new Controleur();
    
    String whatAction;
    
    JframeHome homePage;

    /**
     * Creates new form JframeSaveCompte
     */
    public JframeSaveCompte(String action, int idcompte, JframeHome hp) {
        initComponents();
        
        whatAction = action;
        
        homePage = hp;
        
        if (whatAction.equals("add")) {
            
            updateButton.setVisible(false);
            deleteButton.setVisible(false);
            idCompteLabel.setVisible(false);
            champIdCompte.setVisible(false);
            
        }
        
        else if (whatAction.equals("update")) {
            
            try {
                
                ButtonAdd.setVisible(false);
                
                Compte compte = controleur.routeVersGetOneCompte(idcompte);
                
                champIdCompte.setText(compte.getIdcompte()+"");
                
                ChampSolde.setText(compte.getSolde()+"");
                
                int adminNumber = compte.getIdadmin();
                
                Admin admin = controleur.routeVersGetOne(adminNumber);
                
                String adminString = admin.getIdadmin() + "" + admin.getLogin();
                
                ComboBoxIdAdmin.setSelectedItem(adminString.split("")[0]);
                
                int userNumber = compte.getIduser();
                
                Utilisateur utilisateur = controleur.routeVersGetOneUtilisateur(userNumber);
                
                String user = utilisateur.getIduser() + "" + utilisateur.getLogin();
                
                ComboBoxIdUser.setSelectedItem(user.split("")[0]);
                
            } 
            
            
            catch (SQLException ex) {
                Logger.getLogger(JframeSaveCompte.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            
            
            
        }
        
        
        
        
        try {
            for (Admin admin : controleur.routeVersListAdmin()) {
                
                ComboBoxIdAdmin.addItem(admin.getIdadmin() + " " + admin.getLogin());
            }
        } 
        
        catch (SQLException ex) {
            Logger.getLogger(JframeSaveCompte.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            for (Utilisateur utilisateur : controleur.routeVersGetListUtilisateur()) {
                
                ComboBoxIdUser.addItem(utilisateur.getIduser() + " " + utilisateur.getLogin());
            }
            
        } 
        catch (SQLException ex) {
            Logger.getLogger(JframeSaveCompte.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ChampSolde = new javax.swing.JTextField();
        ComboBoxIdUser = new javax.swing.JComboBox<>();
        ComboBoxIdAdmin = new javax.swing.JComboBox<>();
        ButtonAdd = new javax.swing.JButton();
        ButtonCancel = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        idCompteLabel = new javax.swing.JLabel();
        champIdCompte = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create Compte");

        jLabel1.setText("Solde");

        jLabel2.setText("Id User");

        jLabel3.setText("Id Admin");

        ButtonAdd.setText("add");
        ButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAddActionPerformed(evt);
            }
        });

        ButtonCancel.setText("Cancel");
        ButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCancelActionPerformed(evt);
            }
        });

        deleteButton.setText("delete\n");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        updateButton.setText("update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        idCompteLabel.setText("Id Compte");

        champIdCompte.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(idCompteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(133, 133, 133)
                        .addComponent(champIdCompte))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                        .addGap(88, 88, 88)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ChampSolde)
                            .addComponent(ComboBoxIdUser, 0, 238, Short.MAX_VALUE)
                            .addComponent(ComboBoxIdAdmin, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ButtonCancel)
                        .addGap(62, 62, 62)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(updateButton)
                        .addGap(34, 34, 34)
                        .addComponent(ButtonAdd)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChampSolde, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBoxIdUser, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBoxIdAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idCompteLabel)
                    .addComponent(champIdCompte, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonCancel)
                    .addComponent(ButtonAdd)
                    .addComponent(deleteButton)
                    .addComponent(updateButton))
                .addContainerGap(142, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAddActionPerformed
        try {
            // TODO add your handling code here:
            
            String soldeString = ChampSolde.getText();
            
            double solde = Double.parseDouble(soldeString);
            
            String idAdminString = ComboBoxIdAdmin.getSelectedItem().toString().split(" ")[0];
            
            int idadmin = Integer.parseInt(idAdminString);
            
            String idUserString = ComboBoxIdUser.getSelectedItem().toString().split(" ")[0];
            
            int iduser = Integer.parseInt(idUserString);
            
            controleur.routeVersSaveCompte(solde, iduser, idadmin);
            
            JOptionPane.showMessageDialog(null, "Success");
        } 
        
        catch (SQLException ex) {
            Logger.getLogger(JframeSaveCompte.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_ButtonAddActionPerformed

    private void ButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCancelActionPerformed
        // TODO add your handling code here:
        
        this.dispose();
    }//GEN-LAST:event_ButtonCancelActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        try {
            // TODO add your handling code here:
            
            String idCompteString = champIdCompte.getText();
            
            int idcompte = Integer.parseInt(idCompteString);
            
            controleur.routeVersDeleteCompte(idcompte);
            
            
            this.dispose();
            
            refreshTable();
            
            
        } 
        
        catch (SQLException ex) {
            Logger.getLogger(JframeSaveCompte.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        try {
            // TODO add your handling code here:
            
            
            String idCompteString = champIdCompte.getText();
            
            int idcompte = Integer.parseInt(idCompteString);
            
            String soldeString = ChampSolde.getText();
            
            double solde = Double.parseDouble(soldeString);
            
            String idAdminString = ComboBoxIdAdmin.getSelectedItem().toString().split(" ")[0];
            
            int idadmin = Integer.parseInt(idAdminString);
            
            String idUserString = ComboBoxIdUser.getSelectedItem().toString().split(" ")[0];
            
            int iduser = Integer.parseInt(idUserString);
            
            controleur.routeVersUpdateCompte(idcompte, solde, iduser, idadmin);
            
            this.dispose();
            
            refreshTable();
        } 
        
        
        catch (SQLException ex) {
            Logger.getLogger(JframeSaveCompte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateButtonActionPerformed

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
            java.util.logging.Logger.getLogger(JframeSaveCompte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JframeSaveCompte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JframeSaveCompte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JframeSaveCompte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JframeSaveCompte("add",0,null).setVisible(true);
            }
        });
    }
    
    private void refreshTable() {
        
        try {
            
            List<Compte> listCompte = controleur.routeVersGetListCompte();
            
            DefaultTableModel model = new DefaultTableModel();
            
            model.addColumn("idCompte");
            model.addColumn("Solde");
            model.addColumn("idUser");
            model.addColumn("idAdmin");
            
            for (Compte compte : listCompte) {
                
                model.addRow(new Object[]{compte.getIdcompte() + "", compte.getSolde(), compte.getIduser(), compte.getIdadmin() });
                
                
            }
            
            homePage.getTable().setModel(model);
        }
        
        
        
        catch (SQLException ex) {
            Logger.getLogger(JframeSaveCompte.class.getName()).log(Level.SEVERE, null, ex);
        }
            
         
    } 
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAdd;
    private javax.swing.JButton ButtonCancel;
    private javax.swing.JTextField ChampSolde;
    private javax.swing.JComboBox<String> ComboBoxIdAdmin;
    private javax.swing.JComboBox<String> ComboBoxIdUser;
    private javax.swing.JTextField champIdCompte;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel idCompteLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
