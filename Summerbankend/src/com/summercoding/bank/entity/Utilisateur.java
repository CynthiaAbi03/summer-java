/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.summercoding.bank.entity;
import com.summercoding.bank.utils.Jdbc;
//import java.sql.Date;
import java.time.LocalDate;
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
public class Utilisateur {
    
    int iduser;
    String login;
    String nom;
    String prenom;
    String password;
    LocalDate datenaiss;
    String genre;
    int idadmin;
    

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDatenaiss() {
        return datenaiss;
    }

    public void setDatenaiss(LocalDate datenaiss) {
        this.datenaiss = datenaiss;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(int idadmin) {
        this.idadmin = idadmin;
    }
    
    
    
    public void save(String login, String nom, String prenom, String password, LocalDate datenaiss, String genre, int idadmin) throws SQLException{
    
            
            String command2 = "INSERT INTO `utilisateur` ( `login`, `nom`, `prenom`, `password`,`datenaiss`,`genre`,`idadmin`) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
                    
                    PreparedStatement addstmt =
                        Jdbc.getConnexion().prepareStatement(command2);
            
                    addstmt.setObject(1,login);
                    addstmt.setObject(2,nom);
                    addstmt.setObject(3,prenom);
                    addstmt.setObject(4,password);
                    addstmt.setObject(5,datenaiss);
                    addstmt.setObject(6,genre);
                    addstmt.setObject( 7,idadmin);
                    
                    addstmt.execute();     
    }
    
    public void update(int iduser, String login, String nom, String prenom, String password, LocalDate datenaiss, String genre, int idadmin) throws SQLException{
        
        
            String command = "UPDATE `utilisateur` SET `login` = ?, `nom` = ? ,`prenom` = ?, `password` = ?, `datenaiss` = ?, `genre` = ?,`idadmin` = ? WHERE `utilisateur`.`iduser` = ?";

            
            PreparedStatement addstmt = // PreparedStatement is an interface provided by JDBC
                                        // It represents a precompiled SQL statement that can be executed multiple times with different parameter values
                    
                    Jdbc.getConnexion().prepareStatement(command); //prepared statement object
            
           
            addstmt.setObject(1,login);
            addstmt.setObject(2,nom);
            addstmt.setObject(3,prenom);
            addstmt.setObject(4,password);
            addstmt.setObject(5, datenaiss);
            addstmt.setObject(6,genre);
            addstmt.setObject(7, idadmin);
             addstmt.setObject(8,iduser);
          

            addstmt.execute(); // to execute the prepared statement
            
    }
    
    public void delete(int iduser ) throws SQLException{
        
        
            String command = "DELETE FROM `utilisateur` WHERE `utilisateur`.`iduser` = ?";
            
            PreparedStatement addstmt = // PreparedStatement is an interface provided by JDBC
                                        // It represents a precompiled SQL statement that can be executed multiple times with different parameter values
                    
                    Jdbc.getConnexion().prepareStatement(command); //prepared statement object
            
            addstmt.setObject(1,iduser);
            
            addstmt.execute(); // to execute the prepared statement
            
    }
    
    public Utilisateur getOne(int iduser) throws SQLException {
        // get all the admin details by entrying the idamin.
        String cmd = "SELECT * FROM `utilisateur` WHERE iduser = ?";
        
        PreparedStatement stmt
                = Jdbc.getConnexion().prepareStatement(cmd);
        
        stmt.setObject(1, iduser);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()) {
            return new Utilisateur (rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDate(6).toLocalDate(),rs.getString(7),rs.getInt(8));
        }
        return null;
    }
    
    public Utilisateur getByLoginAndPassWord(String login, String password) throws SQLException {
        
        String cmd = "SELECT * FROM `utilisateur` WHERE login= ? and password = ? ";
        
        PreparedStatement stmt
                = Jdbc.getConnexion().prepareStatement(cmd);
        
        stmt.setObject(1, login);
        stmt.setObject(2, password);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()) {
            return new Utilisateur (rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDate(6).toLocalDate(),rs.getString(7),rs.getInt(8));
        }
        return null;
    }
    
    public List<Utilisateur> getAllUtilisateur() throws SQLException {  //automatically returns a list of all the userss  with their details
        
        String cmd = "SELECT * FROM `utilisateur`";
        
        PreparedStatement stmt
                = Jdbc.getConnexion().prepareStatement(cmd);
        
        ResultSet rs = stmt.executeQuery();
        
        List<Utilisateur> listUtilisateur = new ArrayList<>();
        
        
        while(rs.next()) {
            listUtilisateur.add(new Utilisateur (rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDate(6).toLocalDate(),rs.getString(7),rs.getInt(8)));
        }
        return listUtilisateur;
    }

    public Utilisateur() { // default constructor
    }

    public Utilisateur(int iduser, String login,String nom, String prenom, String password, LocalDate datenaiss, String genre, int idadmin) {
        this.iduser = iduser;
        this.login = login;
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.datenaiss = datenaiss;
        this.genre = genre;
        this.idadmin = idadmin;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "iduser=" + iduser + ", login=" + login + ", nom=" + nom + ", prenom=" + prenom + ", password=" + password + ", datenaiss=" + datenaiss + ", genre=" + genre + ", idadmin=" + idadmin + '}';
    }

    
    
    
    
    public static void main(String arg[]){
        
        try {
            Utilisateur utilisateur = new Utilisateur();
            
            //utilisateur.save("kiuy","moneoooy11","you","jkk",Date.valueOf("2023-06-17"),"feminine",9);
            
            //utilisateur.update(3,"jjfdj", "Jesus", "babes", "hello",LocalDate.of(2023,05,15), "masculin", 6);
            
            String result = utilisateur.getOne(1).toString();
            
            //String result = utilisateur.getByLoginAndPassWord("ooo", "hippo").toString();
            
            //String result = utilisateur.getAllUtilisateur().toString();
            
            System.out.println(result);
            
            
            
            
        }
        catch (SQLException ex) {
            Logger.getLogger(Utilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
