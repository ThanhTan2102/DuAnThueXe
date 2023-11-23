/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

/**
 *
 * @author ASUS
 */
public class ThongTinXe {

    private Integer maXe;
    private String tenXe;
    private Integer soLuong;
    private String hinh;
    private String maNV;
    private String maLoai;

    public Integer getMaXe() {
        return maXe;
    }

    public void setMaXe(Integer maXe) {
        this.maXe = maXe;
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public ThongTinXe(Integer maXe, String tenXe, Integer soLuong, String hinh, String maNV, String maLoai) {
        this.maXe = maXe;
        this.tenXe = tenXe;
        this.soLuong = soLuong;
        this.hinh = hinh;
        this.maNV = maNV;
        this.maLoai = maLoai;
    }

    public ThongTinXe() {
    }
}
