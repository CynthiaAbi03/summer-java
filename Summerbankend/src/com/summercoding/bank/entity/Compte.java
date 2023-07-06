/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.summercoding.bank.entity;


import com.summercoding.bank.utils.Jdbc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cynthiaabi
 */
public class Compte {
    int idcompte;
    
    double solde;
    
    int iduser;
    
    int idadmin;

    public int getIdcompte() {
        return idcompte;
    }

    public void setIdcompte(int idcompte) {
        this.idcompte = idcompte;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(int idadmin) {
        this.idadmin = idadmin;
    }
    
    
    public void save (double solde, int iduser, int idadmin) throws SQLException{
        
     
           String command1 = "INSERT INTO `compte` ( `solde`, `iduser`, `idadmin`) VALUES ( ?, ?, ?)";
           
           PreparedStatement addstmt =
                    Jdbc.getConnexion().prepareStatement(command1);
            
            addstmt.setObject(1,solde);
            addstmt.setObject(2,iduser);
            addstmt.setObject(3,idadmin);
            addstmt.execute();
          
    }
    
    public void update(int idcompte, double solde, int iduser, int idadmin) throws SQLException{
        
        
            String command = "UPDATE `compte` SET `solde` = ?, `iduser` = ?, `idadmin` = ? WHERE `compte`.`idcompte` = ?";
            
            PreparedStatement addstmt = // PreparedStatement is an interface provided by JDBC
                                        // It represents a precompiled SQL statement that can be executed multiple times with different parameter values
                    
                    Jdbc.getConnexion().prepareStatement(command); //prepared statement object
            
            
            addstmt.setObject(1,solde);
            addstmt.setObject(2,iduser);
            addstmt.setObject(3,idadmin);
            addstmt.setObject(4,idcompte);
          
            addstmt.execute(); // to execute the prepared statement
            
    }
    
    public void delete(int idcompte) throws SQLException{
        
        
            String command = "DELETE FROM `compte` WHERE `compte`.`idcompte` = ?";
            
            PreparedStatement addstmt = // PreparedStatement is an interface provided by JDBC
                                        // It represents a precompiled SQL statement that can be executed multiple times with different parameter values
                    
                    Jdbc.getConnexion().prepareStatement(command); //prepared statement object
            
            addstmt.setObject(1,idcompte);
            
            addstmt.execute(); // to execute the prepared statement
            
    }
    
    
    
    public Compte() {
    }

    public Compte(int idcompte, double solde, int iduser, int idadmin) {
        this.idcompte = idcompte;
        this.solde = solde;
        this.iduser = iduser;
        this.idadmin = idadmin;
    }
    
    public Compte getOne(int idcompte) throws SQLException {
        // get all the admin details by entrying the idamin.
        String cmd = "SELECT * FROM `compte` WHERE idcompte = ?";
        
        PreparedStatement stmt
                = Jdbc.getConnexion().prepareStatement(cmd); // prepares the SQL statement for execution with the database
        
        stmt.setObject(1, idcompte); //sets the value of the parameter at index 1 denoted by ? in the sql query
                                                  // to the provided adminn value.
        ResultSet rs = stmt.executeQuery(); // rs represents the result obtained by the database.
        
        while(rs.next()) {
            return new Compte (rs.getInt(1), rs.getDouble(2),rs.getInt(3),rs.getInt(4));
        } // in the while loop a new admin object is created using the values retrieved from the() which 
          //represents a single Admin record in the database. the return statement returns this record if the idadmin is found
        return null; 
    }   // if the id admin is not found, the method returns null.
    
    public Compte getBySoldeAndIduser(Double solde, int iduser) throws SQLException {
        
        String cmd = "SELECT * FROM `compte` WHERE solde= ? and iduser = ? ";
        
        PreparedStatement stmt
                = Jdbc.getConnexion().prepareStatement(cmd);
        
        stmt.setObject(1, solde);
        stmt.setObject(2, iduser);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()) {
            return new Compte (rs.getInt(1), rs.getDouble(2),rs.getInt(3),rs.getInt(4));
        }
        return null;
    }
    
    public List<Compte> getAllCompte() throws SQLException {  //automatically returns a list of all the adminss  with their details
        
        String cmd = "SELECT * FROM `compte`";
        
        PreparedStatement stmt
                = Jdbc.getConnexion().prepareStatement(cmd);
        
        ResultSet rs = stmt.executeQuery();
        
        List<Compte> listCompte = new ArrayList<>();
        
        
        while(rs.next()) { // an iteration of each row of the result set done by rs.next()..
            listCompte.add(new Compte (rs.getInt(1), rs.getDouble(2),rs.getInt(3),rs.getInt(4)));
        }   // a new admin object is created and added to the listAdmin
        return listCompte;
    }

    @Override
    public String toString() {
        return "Compte{" + "idcompte=" + idcompte + ", solde=" + solde + ", iduser=" + iduser + ", idadmin=" + idadmin + '}';
    }
    
    
    
    
    
    
    
    public static void main(String arg[]) {
        
        try {
            Compte compte = new Compte();
            //compte.save(55000.77,3,10);
            
            compte.update(1,900080.8,8,2);
            
            //String result = compte.getOne(3).toString();
            
            //String result = compte.getAllCompte().toString();
            
            //String result = compte.getBySoldeAndIduser(55000.77, 3).toString();
            
            //System.out.println(result);
            
            
        } 
        
        catch (SQLException ex) {
            Logger.getLogger(Compte.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        
    
    }
    
    
    
}
