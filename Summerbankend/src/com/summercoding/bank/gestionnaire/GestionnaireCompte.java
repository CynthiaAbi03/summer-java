/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.summercoding.bank.gestionnaire;

import com.summercoding.bank.entity.Compte;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author cynthiaabi
 */
public class GestionnaireCompte {
    
    Compte compte = new Compte();
    
    public Compte loginCompte (double solde, int iduser) throws SQLException {
        
        return compte.getBySoldeAndIduser(solde, iduser);
    }
    
    public void saveCompte (double solde, int iduser, int idadmin) throws SQLException {
        
        compte.save(solde, iduser, idadmin);
    }
    
    public List<Compte> getAllCompteListe () throws SQLException {
        
        return compte.getAllCompte();
    }
    
    public List<Compte> getCompteByIdUserList (int iduser) throws SQLException {
        
        return compte.getComptebyIdUser(iduser);
    } 
    
    public void updateCompte (int idcompte, double solde, int iduser, int idadmin) throws SQLException {
        
        compte.update(idcompte, solde, iduser, idadmin);
    }
    
    public Compte getOneCompte (int idcompte) throws SQLException {
        
        return compte.getOne(idcompte);
    }
    
    public void deleteCompte(int iduser) throws SQLException {
        
        compte.delete(iduser);
    }
}
