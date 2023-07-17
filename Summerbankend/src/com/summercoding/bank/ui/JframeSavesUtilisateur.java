/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.summercoding.bank.ui;

import com.summercoding.bank.controleur.Controleur;
import com.summercoding.bank.entity.Admin;
import com.summercoding.bank.entity.Utilisateur;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cynthiaabi
 */
public class JframeSavesUtilisateur extends javax.swing.JFrame {
    
    Controleur controleur = new Controleur();
    
    String whatAction ;
    
    JframeHome homePage ;
    
   

    /**
     * Creates new form JframeLoginUtilisateur
     */
    public JframeSavesUtilisateur(String action, int iduser, JframeHome hp) {
        initComponents();  // this is the default method where all the code is wriiten
                           // to add more commands or default configurations we do it here
        
        homePage  = hp;
        
        whatAction = action;
        
        if (whatAction.equals("add")) {
            
            buttonUpdate.setVisible(false);
            buttonDelete.setVisible(false);
            labelIdUser.setVisible(false);
            champIdUser.setVisible(false);
            
        }
        
        else if (whatAction.equals("update")) {
            
            try {
                
                buttonAdd.setVisible(false);
                
                Utilisateur utilisateur = controleur.routeVersGetOneUtilisateur(iduser);
                
                ChampLogin.setText(utilisateur.getLogin());
                ChampNom.setText(utilisateur.getNom());
                ChampPassword.setText(utilisateur.getPassword());
                ChampPrenom.setText(utilisateur.getPrenom());
                
                if (utilisateur.getGenre().equals("feminine") || utilisateur.getGenre().equals("Feminine")  ) {
                    
                    radioButtonFeminine.setSelected(true);
                    
                }
                
                else {
                    
                    
                    radioButtonMasculin.setSelected(true);
                }
                
                int adminid = utilisateur.getIdadmin();
                
                Admin admin = controleur.routeVersGetOne(adminid);
                
                String text = admin.getIdadmin() + " " + admin.getLogin();
                
                ComboBoxAdmin.setSelectedItem(text.split("")[0] );
                
                
                LocalDate date = utilisateur.getDatenaiss();
                
                int yearss = date.getYear();
                
                int month = date.getMonthValue();
                
                int day = date.getDayOfMonth();
                
                ComboBoxYear.setSelectedItem(yearss);
                
                ComboBoxMonth.setSelectedItem(month);
                
                ComboBoxDay.setSelectedItem(day);
                
                
                
                
                
                champIdUser.setText(utilisateur.getIduser()+"");
                
                //LocalDate datenaiss = utilisateur.getDatenaiss();
                
                //String date = datenaiss.toString();
                
                //char[] dateArray = date.toCharArray();
                
                
                           
                
            } 
            
            catch (SQLException ex) {
                Logger.getLogger(JframeSavesUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
        radioButtonFeminine.setSelected(true);
        
        for (int i = 2023; i >= 1900; i-- ) {
            
            ComboBoxYear.addItem(i + "");
        }
        
        
        for (int i=1; i<=12; i++) {
            
            ComboBoxMonth.addItem(i + "");
            
           
        }
        
        for (int i=1; i<=31; i++) {
            
            ComboBoxDay.addItem(i + "");
        }
        
         
        
        
        try {
            
            for (Admin admin : controleur.routeVersListAdmin()) {  // admin is a loop variable of type Admin which iterates over each
                                                                   // listAdmin returned by the function and performs the action
                                                                   // in the for loop
                ComboBoxAdmin.addItem(admin.getIdadmin() + " " + admin.getLogin());
            }
        } 
        
        catch (SQLException ex) {
            Logger.getLogger(JframeSavesUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
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

        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ChampLogin = new javax.swing.JTextField();
        ChampNom = new javax.swing.JTextField();
        ChampPrenom = new javax.swing.JTextField();
        ChampPassword = new javax.swing.JPasswordField();
        ComboBoxYear = new javax.swing.JComboBox<>();
        ComboBoxMonth = new javax.swing.JComboBox<>();
        ComboBoxDay = new javax.swing.JComboBox<>();
        radioButtonFeminine = new javax.swing.JRadioButton();
        radioButtonMasculin = new javax.swing.JRadioButton();
        ComboBoxAdmin = new javax.swing.JComboBox<>();
        buttonAdd = new javax.swing.JButton();
        ButtonCancel = new javax.swing.JButton();
        buttonUpdate = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        labelIdUser = new javax.swing.JLabel();
        champIdUser = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SignUp Utilisateur");

        jLabel1.setText("Login\n");

        jLabel2.setText("Nom\n");

        jLabel3.setText("Prenom");

        jLabel4.setText("Password");

        jLabel5.setText("Date Naissance");

        jLabel6.setText("Genre");

        jLabel7.setText("Id Admin");

        ComboBoxMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxMonthActionPerformed(evt);
            }
        });

        radioButtonFeminine.setText("Feminine\n");
        radioButtonFeminine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonFeminineActionPerformed(evt);
            }
        });

        radioButtonMasculin.setText("Masculin");
        radioButtonMasculin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonMasculinActionPerformed(evt);
            }
        });

        ComboBoxAdmin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        ComboBoxAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxAdminActionPerformed(evt);
            }
        });

        buttonAdd.setText("add");
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });

        ButtonCancel.setText("Cancel\n\n\n");
        ButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCancelActionPerformed(evt);
            }
        });

        buttonUpdate.setText("update");
        buttonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateActionPerformed(evt);
            }
        });

        buttonDelete.setText("delete");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        labelIdUser.setText("Id User");

        champIdUser.setEditable(false);
        champIdUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                champIdUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelIdUser)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(ButtonCancel))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ChampLogin, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ChampNom, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ChampPrenom, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ChampPassword, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(buttonDelete)
                                        .addGap(55, 55, 55)
                                        .addComponent(buttonUpdate)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                        .addComponent(buttonAdd)))
                                .addGap(21, 21, 21))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(champIdUser)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(radioButtonFeminine)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(radioButtonMasculin)
                                        .addGap(58, 58, 58))
                                    .addComponent(ComboBoxAdmin, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(ComboBoxYear, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ComboBoxMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ComboBoxDay, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(ChampLogin)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ChampNom, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ChampPrenom, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ChampPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboBoxYear, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboBoxMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboBoxDay, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(radioButtonFeminine)
                        .addComponent(radioButtonMasculin)))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBoxAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(labelIdUser))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(champIdUser, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonCancel)
                    .addComponent(buttonDelete)
                    .addComponent(buttonUpdate)
                    .addComponent(buttonAdd))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboBoxAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxAdminActionPerformed

    private void ComboBoxMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxMonthActionPerformed
        // TODO add your handling code here:
        int  m =  Integer.parseInt(ComboBoxMonth.getSelectedItem().toString());
        
        
            
        if (m == 2) {
            
            ComboBoxDay.removeAllItems();
                
            
            for (int j = 1; j<=29; j++ ) {
                
            ComboBoxDay.addItem(j + "");
                
            }
            
        }
        
            
        else {
            
               ComboBoxDay.removeAllItems();
            
                    
                for (int j =1; j<=31; j++) {
            
                ComboBoxDay.addItem(j + "");  
                    
                   
            }
        
    }//GEN-LAST:event_ComboBoxMonthActionPerformed
}
    
    
    private void radioButtonFeminineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonFeminineActionPerformed
        // TODO add your handling code here:
        
        radioButtonMasculin.setSelected(false);
    }//GEN-LAST:event_radioButtonFeminineActionPerformed

    private void radioButtonMasculinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonMasculinActionPerformed
        // TODO add your handling code here:
        radioButtonFeminine.setSelected(false);
    }//GEN-LAST:event_radioButtonMasculinActionPerformed

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        try {
            // TODO add your handling code here:
            
            String login = ChampLogin.getText();
            String nom  =  ChampNom.getText();
            String prenom = ChampNom.getText();
            String password = ChampPassword.getText();
            String genre = radioButtonFeminine.getText();
            
            if (radioButtonMasculin.isSelected()) {
                
                genre = radioButtonMasculin.getText();
            }
            
            String yearString = ComboBoxYear.getSelectedItem().toString();
            
            int year = Integer.parseInt(yearString);
            
            //int year = Integer.parseInt(ComboBoxYear.getSelectedItem().toString());
            
            int month = Integer.parseInt(ComboBoxMonth.getSelectedItem().toString());
            int day = Integer.parseInt(ComboBoxDay.getSelectedItem().toString());
            
            LocalDate datenaiss = LocalDate.of(year, month, day);
            
            String idAdminString = ComboBoxAdmin.getSelectedItem().toString().split(" ")[0];
            
            int idadmin = Integer.parseInt(idAdminString);
            
            
            controleur.saveUtilisateur(login, nom, prenom, password, datenaiss, genre, idadmin);
            
            JOptionPane.showMessageDialog(null,"Success");
        } 
        
        catch (SQLException ex) {
            Logger.getLogger(JframeSavesUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
    }//GEN-LAST:event_buttonAddActionPerformed

    private void ButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCancelActionPerformed
        // TODO add your handling code here:
        
        this.dispose();
    }//GEN-LAST:event_ButtonCancelActionPerformed

    private void champIdUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_champIdUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_champIdUserActionPerformed

    private void buttonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateActionPerformed
        try {
            // TODO add your handling code here:
            
            String login = ChampLogin.getText();
            String nom = ChampNom.getText();
            String prenom = ChampNom.getText();
            String password = ChampPassword.getText();
            
            String idadminString = ComboBoxAdmin.getSelectedItem().toString();
            
            int idadmin = Integer.parseInt(idadminString);
            
            String yearString = ComboBoxYear.getSelectedItem().toString();
            
            int year = Integer.parseInt(yearString);
            
            int month = Integer.parseInt(ComboBoxMonth.getSelectedItem().toString());
            
            int day = Integer.parseInt(ComboBoxDay.getSelectedItem().toString());
            
            LocalDate datenaiss = LocalDate.of(year, month,day);
            
            String iduserString = champIdUser.getText();
            
            int iduser = Integer.parseInt(iduserString);
            
            controleur.routeVersUpdateUtilisateur(iduser, login, nom, prenom, password, datenaiss, prenom, idadmin);
            
            this.dispose();
            
            refreshTable();
        } 
        
        catch (SQLException ex) {
            Logger.getLogger(JframeSavesUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
            
            JOptionPane.showMessageDialog(null,"internal error. Try again later");
        }
        
        
       
    }//GEN-LAST:event_buttonUpdateActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        try {
            // TODO add your handling code here:
            
            String iduserString = champIdUser.getText();
            
            int iduser = Integer.parseInt(iduserString);
            
            controleur.routeVersDeleteUtilisateur(iduser);
            
            this.dispose();
            
            refreshTable();
        } 
        
        catch (SQLException ex) {
            Logger.getLogger(JframeSavesUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
            
            JOptionPane.showMessageDialog(null,"internal error. Try again later");
        }
        
    }//GEN-LAST:event_buttonDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(JframeSavesUtilisateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JframeSavesUtilisateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JframeSavesUtilisateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JframeSavesUtilisateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JframeSavesUtilisateur("add",0,null).setVisible(true);
            }
        });
    }
    
    private void refreshTable () {
        
        try {
            List<Utilisateur> listUtilisateur = controleur.routeVersGetListUtilisateur();
            
            DefaultTableModel model = new DefaultTableModel();
            
            model.addColumn("id");
            model.addColumn("login");
            model.addColumn("nom");
            model.addColumn("prenom");
            model.addColumn("datenaiss");
            model.addColumn("genre");
            
            for (Utilisateur utilisateur : listUtilisateur) {
                
                model.addRow(new Object[]{utilisateur.getIduser() + "", utilisateur.getLogin(), utilisateur.getNom(), utilisateur.getPrenom(),utilisateur.getDatenaiss(),utilisateur.getGenre() });
            }
            
            homePage.getTable().setModel(model);
        } 
        
        catch (SQLException ex) {
            Logger.getLogger(JframeSavesUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonCancel;
    private javax.swing.JTextField ChampLogin;
    private javax.swing.JTextField ChampNom;
    private javax.swing.JPasswordField ChampPassword;
    private javax.swing.JTextField ChampPrenom;
    private javax.swing.JComboBox<String> ComboBoxAdmin;
    private javax.swing.JComboBox<String> ComboBoxDay;
    private javax.swing.JComboBox<String> ComboBoxMonth;
    private javax.swing.JComboBox<String> ComboBoxYear;
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JTextField champIdUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel labelIdUser;
    private javax.swing.JRadioButton radioButtonFeminine;
    private javax.swing.JRadioButton radioButtonMasculin;
    // End of variables declaration//GEN-END:variables
}
