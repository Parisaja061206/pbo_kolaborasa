/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kolaborasa.model;

import com.mycompany.kolaborasa.config.Koneksi;
import java.sql.*;

/**
 *
 * @author harir
 */
public class UserDAO {

    public User login(String email, String password) {
        String sql = "SELECT * FROM users WHERE email=? AND password=?";
        try (Connection conn = Koneksi.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getString("nama"), rs.getString("email"), rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getUserByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email=?";
        try (Connection conn = Koneksi.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getString("nama"), rs.getString("email"), rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateProfile(User user) {
        // Pastikan nama kolom (nama, password, email) SAMA dengan di database
        String sql = "UPDATE users SET nama = ?, password = ? WHERE email = ?";
        try (Connection conn = com.mycompany.kolaborasa.config.Koneksi.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user.getNama());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
