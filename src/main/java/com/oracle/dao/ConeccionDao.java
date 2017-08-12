/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Oracle D77738
 */
public class ConeccionDao {

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    private Connection con;
    
    public void Conectar(){
        String url ="jdbc:derby://localhost:1527/BaseTest";
        String driver ="org.apache.derby.jdbc.ClientDriver";
        String userName ="root";
        String password="root";
        try {
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url, userName, password);
            System.out.println("Conexion exitosa");
        } catch (Exception ex) {
            Logger.getLogger(ConeccionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cerrar (){
        try {
            if (con != null &&!con.isClosed() ){
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
