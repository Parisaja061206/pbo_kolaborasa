/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kolaborasa.model;

/**
 *
 * @author Sadid
 */
public class Ide {
    private int id;
    private String judul;
    private String deskripsi;
    private String pathGambar;
    private String pencipta;
    private String status;

    // Constructor
   public Ide(int id, String judul, String deskripsi, String pathGambar, String pencipta, String status) {
    this.id = id;
    this.judul = judul;
    this.deskripsi = deskripsi;
    this.pathGambar = pathGambar;
    this.pencipta = pencipta;
    this.status = status;
}

    public Ide(String judul, String deskripsi, String pathGambar) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.pathGambar = pathGambar;
    }

    // Getter dan Setter
    public int getId() { return id; }
    public String getJudul() { return judul; }
    public String getDeskripsi() { return deskripsi; }
    public String getPathGambar() { return pathGambar; }
    public String getPencipta() { return pencipta; }
    public String getStatus() { return status; }

    public void setId(int id) {
    this.id = id;
    }
}
