/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.summercoding.bank.controleur;

import com.summercoding.bank.entity.Admin;
import com.summercoding.bank.entity.Compte;
import com.summercoding.bank.entity.Utilisateur;
import com.summercoding.bank.gestionnaire.GestionnaireAdmin;
import com.summercoding.bank.gestionnaire.GestionnaireCompte;
import com.summercoding.bank.gestionnaire.GestionnaireUtilisateur;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

//the controleur holds the route to each gestionnaire method because the client communicates directly only with the controleur
//that is if the client wants to login , the controleur has the route to the login and then calls the needed gestionnaire that holds the method

/**
 *
 * @author cynthiaabi
 */
public class Controleur {
    
    GestionnaireAdmin getGestionnaireAdmin = new GestionnaireAdmin();
    
    GestionnaireUtilisateur getGestionnaireUtilisateur = new GestionnaireUtilisateur();
    
    GestionnaireCompte getGestionnaireCompte = new GestionnaireCompte();
    
    
    
    public Admin routeVersLogin (String login, String password) throws SQLException{
        
        return getGestionnaireAdmin.login(login, password);
    }
    
    public void routeVersSave (String login, String password, String nom) throws SQLException{
        
        getGestionnaireAdmin.saveAdmin(login, password, nom);
    }
    
    public List<Admin> routeVersListAdmin() throws SQLException {
        
        return getGestionnaireAdmin.GetAllAdminList();
        
    } 
    
    public Admin routeVersGetOne (int idadmin) throws SQLException {
        
        return getGestionnaireAdmin.GetOneAdmin(idadmin);
    }
    
    public void routeVersUpdate (int idadmin, String login, String password, String nom) throws SQLException {
        
        getGestionnaireAdmin.updateAdmin(idadmin, login, password, nom);
    }
    
    public void routeVersDeleteAdmin (int idadmin) throws SQLException {
        
        getGestionnaireAdmin.deleteAdmin(idadmin);
    }
    
    
    
    public Utilisateur routeVersUtilisateurLogin (String login, String password) throws SQLException{
        
        return getGestionnaireUtilisateur.loginUtilisateur(login, password);
    }
    
    public void saveUtilisateur (String login, String nom, String prenom, String password, LocalDate datenaiss, String genre, int idadmin) throws SQLException {
        
           getGestionnaireUtilisateur.saveUtilisateur(login, nom, prenom, password, datenaiss, genre, idadmin);
        
    }
        
    public List<Utilisateur> routeVersGetListUtilisateur () throws SQLException {
        
        return getGestionnaireUtilisateur.getAllUtilisateurList();
    }
    
    public void routeVersUpdateUtilisateur(int iduser, String login, String nom, String prenom, String password, LocalDate datenaiss, String genre, int idadmin) throws SQLException{
        
        getGestionnaireUtilisateur.updateUtilisateur(iduser, login, nom, prenom, password, datenaiss, genre, idadmin);
    }
    
    public Utilisateur routeVersGetOneUtilisateur (int iduser) throws SQLException {
        
        return getGestionnaireUtilisateur.getOneUtilisateur(iduser);
    }
    
    public void routeVersDeleteUtilisateur (int iduser) throws SQLException {
        
        getGestionnaireUtilisateur.deleteUtilisateur(iduser);
    }
    
    
    
    
    
    
    public Compte routeVersLoginCompte (double solde, int iduser) throws SQLException {
        
        return getGestionnaireCompte.loginCompte(solde, iduser);
    }
    
    public void routeVersSaveCompte (double solde, int iduser, int idadmin) throws SQLException {
        
        getGestionnaireCompte.saveCompte(solde, iduser, idadmin);
    }
    
    public List<Compte> routeVersGetListCompte () throws SQLException {
        
        return getGestionnaireCompte.getAllCompteListe();
    }
    
    public void routeVersUpdateCompte (int idcompte, double solde, int iduser, int idadmin) throws SQLException {
        
        getGestionnaireCompte.updateCompte(idcompte, solde, iduser, idadmin);
    }
    
    public Compte routeVersGetOneCompte (int idcompte) throws SQLException {
        
        return getGestionnaireCompte.getOneCompte(idcompte);
    }
    
    public void routeVersDeleteCompte(int idcompte) throws SQLException {
        
        getGestionnaireCompte.deleteCompte(idcompte);
    }
    
    public List<Compte> routeVersGetComptebyIdUser (int iduser) throws SQLException {
        
        return getGestionnaireCompte.getCompteByIdUserList(iduser);
        
    }
    
}
