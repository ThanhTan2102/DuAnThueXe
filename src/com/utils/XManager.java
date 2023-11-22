/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utils;

import com.model.NhanVien;

/**
 *
 * @author ASUS
 */
public class XManager {

    public static NhanVien user = null;

    public static void clear() {
        XManager.user = null;
    }

    public static boolean Login() {
        return XManager.user != null;
    }

    public static boolean isManager() {
        return XManager.Login() && user.isVaiTro();
    }
}
