/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.summercoding.bank.gestionnaire;

import com.summercoding.bank.entity.Admin;
import java.sql.SQLException;
import java.util.List;



/**
 *
 * @author cynthiaabi
 */
// the gestionnaire package holds the the use cases or cas d'utilisation of the entities
//to implement a cas d'utilisation the gestionnaire can combien many methods of the entities. it is the logic metier
//it implements all the use cases of the admin 

public class GestionnaireAdmin {
    
    private Admin admin = new Admin();
    
    
    
    public Admin login(String login, String password) throws SQLException {
        
        return admin.getByLoginAndPassWord(login, password);  //  control + spacebar after admin.
        
    }
    
    
    
    public void saveAdmin(String login, String password, String nom) throws SQLException {
    
        admin.save(login, password, nom);
    
    }
    
    
    
    public List<Admin> GetAllAdminList() throws SQLException {
        
        return admin.getAllAdmin();
        
    }
    
    public Admin GetOneAdmin (int idadmin) throws SQLException {
        
        return admin.getOne(idadmin);
    }
    
    public void updateAdmin (int idadmin,String login,String password,String nom) throws SQLException {
        
        admin.update(idadmin, login, password, nom);
        
    }
            
            
}
