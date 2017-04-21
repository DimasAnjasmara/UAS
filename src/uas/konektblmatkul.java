/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uas;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Dimas
 */
public class konektblmatkul {
    private static String confTimeZone = "serverTimezone=UTC";

    //sesuaikan nama database dengan database milik anda
    private static String url = "jdbc:mysql://localhost:3306/SIAK?" + confTimeZone;
    private static String user = "root";
    private static String password = "";//kalau pakai password, isi di sini

    private static Connection connection;
    private static Statement statement;
    private static ResultSet result;
    private static PreparedStatement ps;


    private static void openDb(){
        try {
            connection = (Connection) DriverManager.getConnection(url, user, password);
            statement = (Statement) connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void closeDb(){
        try {
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void insertBatch(int num){
        PreparedStatement statement;
        String sql = "INSERT into tbl_matkul(kode_mk, nama_mk, SKS) VALUES (?,?,?)";
        openDb();
        try {
            statement = (PreparedStatement) connection.prepareStatement(sql);
            for(int i=0;i<num;i++){
                statement.setString(1, "kd_mk" + i);
                statement.setString(2, "nama_mk" + i);
                statement.setString(3, "SKS" + i);
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeDb();

    }

   

    public static void selectAllData(){
        openDb();
        String sql = "Select * from tbl_matkul";
        try {
            ps = (PreparedStatement) connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            if(!rs.isBeforeFirst()){
                System.out.println("Kosong\n");
                return;
            }
            while (rs.next()){
                System.out.print("kode Matkul: " + rs.getString("kd_mk"));
                System.out.print(" \t| Nama Matkul: " + rs.getString("Nama_mk"));
                System.out.println("\t| Sks:  " + rs.getString("Sks"));
                
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        closeDb();
    
}
    public static void main(String[] args){

        int num = 10;
        System.out.println("Query Pakai batch sebanyak " + num + " kali.");
        insertBatch(num);

        selectAllData();

        
       
    }
}
