/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uas;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.sun.corba.se.spi.orbutil.fsm.Input;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dimas
 */
public class UAS {

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

public static void bukatbl_mhs(){
        openDb();
        String sql = "Select * from tbl_mhs";
        try {
            ps = (PreparedStatement) connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            if(!rs.isBeforeFirst()){
                System.out.println("Kosong\n");
                return;
            }
            while (rs.next()){
                System.out.print("Nim: " + rs.getString("nim"));
                System.out.print(" \t| Nama: " + rs.getString("Nama"));
                System.out.println("\t| Lahir:  " + rs.getString("Lahir"));
                System.out.println("\t| Alamat:  " + rs.getString("Alamat"));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        closeDb();
    }


public static void bukatbl_matkul(){
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
                System.out.print("Kode Matkul: " + rs.getString("kode_mk"));
                System.out.print(" \t| Nama Matkul: " + rs.getString("Nama_mk"));
                System.out.println("\t| SKS:  " + rs.getString("SKS"));
                
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        closeDb();
    }
public static void bukatbl_nilai(){
        openDb();
        String sql = "Select * from tbl_nilai";
        try {
            ps = (PreparedStatement) connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            if(!rs.isBeforeFirst()){
                System.out.println("Kosong\n");
                return;
            }
            while (rs.next()){
                System.out.print("Nim: " + rs.getString("nim"));
                System.out.print(" \t| kode_mk: " + rs.getString("kode_mk"));
                System.out.println("\t| Nilai:  " + rs.getString("Nilai"));
                
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        closeDb();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        
        bukatbl_mhs();
        bukatbl_matkul();
        bukatbl_nilai();
        
    } 
    }



    