package com.mycompany.kolaborasa.model;

import com.mycompany.kolaborasa.config.Koneksi;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sadid
 */
public class IdeDAO {
    
    // Fungsi untuk simpan ke DB
    public boolean insertIde(Ide ide) {
        String sql = "INSERT INTO ide (judul, deskripsi, path_gambar) VALUES (?, ?, ?)";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, ide.getJudul());
            ps.setString(2, ide.getDeskripsi());
            ps.setString(3, ide.getPathGambar());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Fungsi untuk ambil semua data dari DB
    public List<Ide> getAllIde() {
        List<Ide> list = new ArrayList<>();
        String sql = "SELECT * FROM ide";
        try (Connection conn = Koneksi.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Ide(
                    rs.getInt("id"),
                    rs.getString("judul"),
                    rs.getString("deskripsi"),
                    rs.getString("path_gambar"),
                    "Umar",              
                    "Sedang Progress"    
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Fungsi untuk mengupdate data di DB
    public boolean updateIde(Ide ide) {
        String sql = "UPDATE ide SET judul = ?, deskripsi = ? WHERE id = ?";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, ide.getJudul());
            ps.setString(2, ide.getDeskripsi());
            ps.setInt(3, ide.getId());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Fungsi untuk menghapus data di DB
    public boolean deleteIde(int id) {
        String sql = "DELETE FROM ide WHERE id = ?";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}