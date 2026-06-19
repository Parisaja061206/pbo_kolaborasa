/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kolaborasa.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Sadid
 */
public class Koneksi {
    // Variabel untuk menyimpan status koneksi
    private static Connection koneksi;

    // Method yang akan dipanggil oleh Model (DAO) untuk mengambil koneksi
    public static Connection getConnection() {
        // Jika belum ada koneksi yang terbuka, maka buat koneksi baru
        if (koneksi == null) {
            try {
                // 1. Alamat URL Database Anda (Driver : host : port / nama_database)
                String url = "jdbc:mysql://localhost:3306/kolaborasa_pbo"; 
                
                // 2. Username default MySQL (jika menggunakan XAMPP biasanya "root")
                String user = "root"; 
                
                // 3. Password default MySQL (jika menggunakan XAMPP biasanya kosong "")
                String password = ""; 
                
                // Mendaftarkan Driver MySQL JDBC ke sistem Java
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                
                // Membuka koneksi menggunakan data di atas
                koneksi = DriverManager.getConnection(url, user, password);
                
                System.out.println("Koneksi ke Database Berhasil!");
            } catch (SQLException e) {
                System.out.println("Koneksi ke Database Gagal! Error: " + e.getMessage());
            }
        }
        return koneksi;
    }
}
