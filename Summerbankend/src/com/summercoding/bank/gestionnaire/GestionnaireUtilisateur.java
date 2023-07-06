/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.summercoding.bank.gestionnaire;

import com.summercoding.bank.entity.Utilisateur;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author cynthiaabi
 */
public class GestionnaireUtilisateur {
    
    Utilisateur utilisateur = new Utilisateur ();
    
    
    
    public Utilisateur loginUtilisateur (String login, String password) throws SQLException{
        
        return utilisateur.getByLoginAndPassWord(login, password);
    }
    
    
    
    public void saveUtilisateur (String login, String nom, String prenom, String password, LocalDate datenaiss, String genre, int idadmin) throws SQLException {
        
        utilisateur.save(login, nom, prenom, password, datenaiss, genre, idadmin);
        
        
    }
    
    public List<Utilisateur> getAllUtilisateurList() throws SQLException {
        
        return utilisateur.getAllUtilisateur();
    }
}
