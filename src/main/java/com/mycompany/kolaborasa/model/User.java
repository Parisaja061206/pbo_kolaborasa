/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kolaborasa.model;

/**
 *
 * @author harir
 */
public class User {
 private String nama;
    private String email;
    private String password;

    public User(String nama, String email, String password) {
        this.nama = nama;
        this.email = email;
        this.password = password;
    }

    // Getters
    public String getNama() { return nama; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
}