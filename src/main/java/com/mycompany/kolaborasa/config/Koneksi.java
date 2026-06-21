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
    try {
        if (koneksi == null || koneksi.isClosed()) {
            String url = "jdbc:mysql://localhost:3306/kolaborasa_pbo";
            String user = "root";
            String password = "";
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            koneksi = DriverManager.getConnection(url, user, password);
            System.out.println("Koneksi ke Database Berhasil!");
        }
    } catch (SQLException e) {
        System.out.println("Koneksi ke Database Gagal! Error: " + e.getMessage());
    }
    return koneksi;
}
}
