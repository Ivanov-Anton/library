package ru.javabegin.training.web.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;
/**
* Doc
*
*/
public class Database {

    private static Connection conn;    
    private static DataSource ds;

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return conn;
    }
    private static final String PASS = "root";
    private static final String USER = "root";
    private static final String URL = "jdbc:mysql://localhost:3300/library";
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
}
