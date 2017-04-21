/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uas;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Dimas
 */
public class koneksi {
     private String confTimeZone = "serverTimezone=UTC";
    private String url = "jdbc:mysql://localhost:3306/SIAK?" + confTimeZone;
    private String user = "root";
    private String password = "";

    private Connection connection;
    private Statement statement;
    private ResultSet rs;

    protected void openDb(){
        try {
            connection = (Connection) DriverManager.getConnection(url, user, password);
            statement = (Statement) connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void closeDb(){
        try {
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
}
