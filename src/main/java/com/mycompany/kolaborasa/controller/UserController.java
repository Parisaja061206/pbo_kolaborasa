/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kolaborasa.controller;

import com.mycompany.kolaborasa.model.*;
import com.mycompany.kolaborasa.view.*;
import javax.swing.JOptionPane;

/**
 *
 * @author harir
 */
public class UserController {

    private UserDAO dao = new UserDAO();

    public boolean prosesUpdate(String nama, String email, String pass) {
        User user = new User(nama, email, pass);
        return dao.updateProfile(user);
    }
}
