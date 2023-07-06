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
public class Admin {
    
    
    int idadmin;
    
    String login;
    
    String password;
    
    String nom;

    public int getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(int idadmin) {
        this.idadmin = idadmin;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
    
    public void save(String login, String password, String nom) throws SQLException{
        
        
            String command = "INSERT INTO `admin` ( `login`, `password`, `nom`) VALUES ( ?, ?, ?)";
            
            PreparedStatement addstmt = // PreparedStatement is an interface provided by JDBC
                                        // It represents a precompiled SQL statement that can be executed multiple times with different parameter values
                    
                    Jdbc.getConnexion().prepareStatement(command); //prepared statement object
            
            addstmt.setObject(1,login);
            addstmt.setObject(2,password);
            addstmt.setObject(3,nom);
            addstmt.execute(); // to execute the prepared statement
            
    }
    // save and update methods modify the database
    
    public void update( int idadmin, String login, String password, String nom) throws SQLException{
        
        
            String command = "UPDATE `admin` SET `login` = ?, `password` = ?, `nom` = ? WHERE `admin`.`idadmin` = ?";
            
            PreparedStatement addstmt = // PreparedStatement is an interface provided by JDBC
                                        // It represents a precompiled SQL statement that can be executed multiple times with different parameter values
                    
                    Jdbc.getConnexion().prepareStatement(command); //prepared statement object
            
            addstmt.setObject(1,login);
            addstmt.setObject(2,password);
            addstmt.setObject(3,nom);
            addstmt.setObject(4,idadmin);
          
            addstmt.execute(); // to execute the prepared statement
            
    }
    
    public void delete(int idadmin ) throws SQLException{
        
        
            String command = "DELETE FROM `admin` WHERE `admin`.`idadmin` = ?";
            
            PreparedStatement addstmt = // PreparedStatement is an interface provided by JDBC
                                        // It represents a precompiled SQL statement that can be executed multiple times with different parameter values
                    
                    Jdbc.getConnexion().prepareStatement(command); //prepared statement object
            
            addstmt.setObject(1,idadmin);
            
            addstmt.execute(); // to execute the prepared statement
            
    }

    
    public Admin getOne(int idadmin) throws SQLException {
        // get all the admin details by entrying the idamin.
        String cmd = "SELECT * FROM `admin` WHERE idadmin = ?";
        
        PreparedStatement stmt
                = Jdbc.getConnexion().prepareStatement(cmd); // prepares the SQL statement for execution with the database
        
        stmt.setObject(1, idadmin); //sets the value of the parameter at index 1 denoted by ? in the sql query
                                                  // to the provided adminn value.
        ResultSet rs = stmt.executeQuery(); // rs represents the result obtained by the database.
        
        while(rs.next()) {
            return new Admin (rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4));
        } // in the while loop a new admin object is created using the values retrieved from the() which 
          //represents a single Admin record in the database. the return statement returns this record if the idadmin is found
          //calls constructor
        return null; 
    }   // if the id admin is not found, the method returns null.
    
    
    public Admin getByLoginAndPassWord(String login, String password) throws SQLException {
        
        String cmd = "SELECT * FROM `admin` WHERE login= ? and password = ? ";
        
        PreparedStatement stmt
                = Jdbc.getConnexion().prepareStatement(cmd);
        
        stmt.setObject(1, login);
        stmt.setObject(2, password);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()) { // an iteration of each row of the result set done by rs.next()..
            return new Admin (rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4));
        }
        return null;
    }
    
    
    public List<Admin> getAllAdmin() throws SQLException {  //automatically returns a list of all the adminss  with their details
        
        String cmd = "SELECT * FROM `admin`";
        
        PreparedStatement stmt
                = Jdbc.getConnexion().prepareStatement(cmd);
        
        ResultSet rs = stmt.executeQuery();
        
        List<Admin> listAdmin = new ArrayList<>();
        
        
        while(rs.next()) { // an iteration of each row of the result set done by rs.next()..
            listAdmin.add(new Admin (rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4)));
        }   // a new admin object is created and added to the listAdmin
        return listAdmin;
    }
    
    
    public Admin() {
    }

    public Admin(int idadmin, String login, String password, String nom) {
        this.idadmin = idadmin;
        this.login = login;
        this.password = password;
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Admin{" + "idadmin=" + idadmin + ", login=" + login + ", password=" + password + ", nom=" + nom + '}';
    }
    
    
    public static void main(String arg[]){
        
        
        try {
            Admin admin = new Admin();
            //admin.save("annoyed","tbh", "ighien");
            //String result = admin.getOne(9).toString();
            
            //String result = admin.getAllAdmin().toString();
            
            //String result = admin.getByLoginAndPassWord("cyn", "messi").toString();
            
            admin.update(7, "testing", "again","tired");
            
            //admin.delete(1);
            
            
            
            
            
            //System.out.println(result);
            
            
        } 
        catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        
    }
}
