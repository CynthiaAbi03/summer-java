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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author cynthiaabi
 */
public class JframeHome extends javax.swing.JFrame {
    
    
    JframeSavesUtilisateur SignUpUtilisateur = new JframeSavesUtilisateur();
    Controleur controleur = new Controleur ();
    JframeSaveCompte createCompte = new JframeSaveCompte();
    String whatMenu;

    public JTable getTable() {
        return Table;
    }

    public void setTable(JTable Table) {
        this.Table = Table;
    }
    
    

    /**
     * Creates new form JframeHome
     */
    public JframeHome() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuAdmin = new javax.swing.JMenu();
        MenuListCreateAdmin = new javax.swing.JMenuItem();
        MenuListAdmin = new javax.swing.JMenuItem();
        MenuUtilisateur = new javax.swing.JMenu();
        MenuCreateUtilisateur = new javax.swing.JMenuItem();
        MenuListUtilisateur = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        MenuCreateCompte = new javax.swing.JMenuItem();
        MenuListCompte = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();

        jMenu4.setText("jMenu4");

        jMenu5.setText("jMenu5");

        jMenu8.setText("jMenu8");

        jMenu1.setText("File");
        jMenuBar2.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("File");
        jMenuBar3.add(jMenu3);

        jMenu6.setText("Edit");
        jMenuBar3.add(jMenu6);

        jMenuItem1.setText("jMenuItem1");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        MenuAdmin.setText("Admin");

        MenuListCreateAdmin.setText("Create");
        MenuListCreateAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuListCreateAdminActionPerformed(evt);
            }
        });
        MenuAdmin.add(MenuListCreateAdmin);

        MenuListAdmin.setText("List");
        MenuListAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuListAdminActionPerformed(evt);
            }
        });
        MenuAdmin.add(MenuListAdmin);

        jMenuBar1.add(MenuAdmin);

        MenuUtilisateur.setText("Utilisateur");

        MenuCreateUtilisateur.setText("Create");
        MenuCreateUtilisateur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCreateUtilisateurActionPerformed(evt);
            }
        });
        MenuUtilisateur.add(MenuCreateUtilisateur);

        MenuListUtilisateur.setText("List");
        MenuListUtilisateur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuListUtilisateurActionPerformed(evt);
            }
        });
        MenuUtilisateur.add(MenuListUtilisateur);

        jMenuBar1.add(MenuUtilisateur);

        jMenu7.setText("Compte");

        MenuCreateCompte.setText("Create");
        MenuCreateCompte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCreateCompteActionPerformed(evt);
            }
        });
        jMenu7.add(MenuCreateCompte);

        MenuListCompte.setText("List");
        MenuListCompte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuListCompteActionPerformed(evt);
            }
        });
        jMenu7.add(MenuListCompte);

        jMenuBar1.add(jMenu7);

        jMenu9.setText("A propos");
        jMenuBar1.add(jMenu9);

        jMenu10.setText("Aide");
        jMenuBar1.add(jMenu10);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuListCreateAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuListCreateAdminActionPerformed
        // TODO add your handling code here:
        
        new JframeSaveAdmin("add",0,this).setVisible(true);
    }//GEN-LAST:event_MenuListCreateAdminActionPerformed

    private void MenuCreateUtilisateurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCreateUtilisateurActionPerformed
        // TODO add your handling code here:
        
        SignUpUtilisateur.setVisible(true);
    }//GEN-LAST:event_MenuCreateUtilisateurActionPerformed

    private void MenuListAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuListAdminActionPerformed
        try {
            // TODO add your handling code here:
            /*String[] columns = new String [] {
                
                "Id", "Nom", "Login"
            };
            
            Object[][] datas = new Object [][] {
                
                {"1","George","how"},
                {"2","Lionel","to"},
                {"3","Messi","test"},
                {"4","Cynthia","code"},
            };
            
            Table.setModel(new DefaultTableModel(datas, columns)); */
            
            whatMenu = "admin";
            
            List<Admin> listAdmin = controleur.routeVersListAdmin();
            
            DefaultTableModel model = new DefaultTableModel();
            
            model.addColumn("id");
            model.addColumn("Nom");
            model.addColumn("Login");
            
            for(Admin ad : listAdmin ) {
                
                model.addRow(new String[]{ad.getIdadmin() + "",ad.getNom(), ad.getLogin() }); // + "" is used to change ad.getIdadmin() to a string by concatenating it to an empty string "" which forces the conversion
            }
            
            Table.setModel(model);
            
            
        } 
        
        
        
        catch (SQLException ex) {
            Logger.getLogger(JframeHome.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Please try again later");
        }
        
        
        
    }//GEN-LAST:event_MenuListAdminActionPerformed

    private void MenuListUtilisateurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuListUtilisateurActionPerformed
        try {
            // TODO add your handling code here:
            
            List<Utilisateur> listUtilisateur = controleur.routeVersGetListUtilisateur();
            
            DefaultTableModel model = (DefaultTableModel) Table.getModel();
            
            model.addColumn("id");
            model.addColumn("login");
            model.addColumn("nom");
            model.addColumn("prenom");
            model.addColumn("datenaiss");
            model.addColumn("genre");
            
            for (Utilisateur utilisateur : listUtilisateur) {
                
                model.addRow(new Object[]{utilisateur.getIduser() + "", utilisateur.getLogin(), utilisateur.getNom(), utilisateur.getPrenom(),utilisateur.getDatenaiss(),utilisateur.getGenre() });
            }
            
            Table.setModel(model);
        } 
        
        catch (SQLException ex) {
            Logger.getLogger(JframeHome.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_MenuListUtilisateurActionPerformed

    private void MenuCreateCompteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCreateCompteActionPerformed
        // TODO add your handling code here:
        createCompte.setVisible(true);
        
        
        
    }//GEN-LAST:event_MenuCreateCompteActionPerformed

    private void MenuListCompteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuListCompteActionPerformed
        try {
            // TODO add your handling code here:
            
            List<Compte> listCompte = controleur.routeVersGetListCompte();
            
            DefaultTableModel model = (DefaultTableModel) Table.getModel();
            
            model.addColumn("idCompte");
            model.addColumn("Solde");
            model.addColumn("idUser");
            model.addColumn("idAdmin");
            
            for (Compte compte : listCompte) {
                
                model.addRow(new Object[]{compte.getIdcompte() + "", compte.getSolde(), compte.getIduser(), compte.getIdadmin() });
            }
        } 
        
        catch (SQLException ex) {
            Logger.getLogger(JframeHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_MenuListCompteActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        // TODO add your handling code here:
        
        int lineNumber = Table.getSelectedRow();
        
        TableModel model = Table.getModel();
        
        if(whatMenu.equals("admin")) {
            
            String idAdminString = model.getValueAt(lineNumber,0).toString();
            
            int idAdmin = Integer.parseInt(idAdminString);
            
            new JframeSaveAdmin("update", idAdmin, this).setVisible(true);
            
           /* JframeSaveAdmin jf = new JframeSaveAdmin("update",idAdmin,this);
            jf.setVisible(true); */
           
           
            
            
        }
    }//GEN-LAST:event_TableMouseClicked

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
            java.util.logging.Logger.getLogger(JframeHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JframeHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JframeHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JframeHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new JframeHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuAdmin;
    private javax.swing.JMenuItem MenuCreateCompte;
    private javax.swing.JMenuItem MenuCreateUtilisateur;
    private javax.swing.JMenuItem MenuListAdmin;
    private javax.swing.JMenuItem MenuListCompte;
    private javax.swing.JMenuItem MenuListCreateAdmin;
    private javax.swing.JMenuItem MenuListUtilisateur;
    private javax.swing.JMenu MenuUtilisateur;
    private javax.swing.JTable Table;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
