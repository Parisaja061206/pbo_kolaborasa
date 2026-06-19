package com.mycompany.kolaborasa.controller;

import com.mycompany.kolaborasa.model.Ide;
import com.mycompany.kolaborasa.model.IdeDAO;
import com.mycompany.kolaborasa.view.InputIdeView;
import com.mycompany.kolaborasa.view.ListIdeView;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 *
 * @author Sadid
 */
public class IdeController {
    private final IdeDAO dao = new IdeDAO();

    // Logika untuk menyimpan ide baru
    public void simpanIde(InputIdeView view) {
        String judul = view.getTxtJudul().getText();
        String deskripsi = view.getTxtDeskripsi().getText();
        String pathAbsolut = view.getPathGambarTerpilih();

        if(judul.isEmpty() || deskripsi.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Judul dan Deskripsi tidak boleh kosong!");
            return;
        }

        Ide ideBaru = new Ide(judul, deskripsi, pathAbsolut);
        if(dao.insertIde(ideBaru)) {
            JOptionPane.showMessageDialog(view, "Ide Berhasil Disimpan!");
            view.clearForm();
        } else {
            JOptionPane.showMessageDialog(view, "Gagal Menyimpan Ide.");
        }
    }

    // Logika untuk menampilkan data ke JTable di ListIdeView
    public void tampilkanDataKeTabel(ListIdeView view) {
        System.out.println("Controller: Mencoba mengambil model tabel...");
        DefaultTableModel model = (DefaultTableModel) view.getTabelIde().getModel();
        
        model.setRowCount(0); // Reset tabel

        System.out.println("Controller: Meminta data dari DAO...");
        List<Ide> listIde = dao.getAllIde();
        
        System.out.println("Controller: Jumlah data yang didapat dari DB = " + listIde.size());

        for (Ide ide : listIde) {
            Object[] row = {
                ide.getId(), 
                ide.getJudul(), 
                ide.getDeskripsi(), 
                ide.getPathGambar()
            };
            model.addRow(row);
        }
        
        System.out.println("Controller: Selesai memasukkan data ke tabel GUI.");
    }
    
    // Menampilkan data ke JTable khusus yang ada di Dashboard
    public void loadDataDashboard(javax.swing.JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        List<Ide> list = dao.getAllIde();

        for (Ide ide : list) {
            Object[] row = {
                ide.getId(),
                ide.getJudul(),
                "Umar",              // dummy pencipta
                "Sedang Progress"    // dummy status
            };
            model.addRow(row);
        }
    }
    
    // Logika Update Data
    public void updateIde(String idStr, String judul, String deskripsi) {
        if (idStr.isEmpty() || judul.isEmpty() || deskripsi.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua data harus diisi!");
            return;
        }

        try {
            int id = Integer.parseInt(idStr);
            Ide ideUpdate = new Ide(judul, deskripsi, null);
            ideUpdate.setId(id);

            if (dao.updateIde(ideUpdate)) {
                JOptionPane.showMessageDialog(null, "Data Ide berhasil diperbarui!");
            } else {
                JOptionPane.showMessageDialog(null, "Gagal memperbarui data.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID tidak valid!");
        }
    }

    // Logika Delete Data
    public void deleteIde(String idStr) {
        if (idStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Pilih data yang ingin dihapus terlebih dahulu!");
            return;
        }

        try {
            int id = Integer.parseInt(idStr);
            if (dao.deleteIde(id)) {
                JOptionPane.showMessageDialog(null, "Data Ide berhasil dihapus!");
            } else {
                JOptionPane.showMessageDialog(null, "Gagal menghapus data.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID tidak valid!");
        }
    }
    
    // Mengambil total jumlah ide dari database untuk angka pada Card
    public int getJumlahIde() {
        return dao.getAllIde().size();
    }

    public void cariDataDashboard(JTable jTable1, String keyword) {
        // Bisa diisi logika pencarian jika diperlukan nanti
    }
}