/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ui;


import com.form.HoaDonChiTiet;
import com.form.KhachHang;
import com.form.QuanLyHoaDon;
import com.form.ThongTinNhanVien;
import com.form.ThongTinXe;
import com.form.TrangChu;
import java.awt.Color;
import java.awt.Container;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ASUS
 */
public class Dashboard extends javax.swing.JFrame {

    private JPanel childPanel;

    Color DefauColor, ClickedColor;
    Color DefaulColor1, ClickColor1;

    public Dashboard() {
        initComponents();
        DefauColor = new Color(153, 204, 255);
        ClickedColor = new Color(240, 151, 57);

        DefaulColor1 = new Color(0, 0, 0);
        ClickColor1 = new Color(240, 151, 57);

        pnMenu1.setBackground(DefauColor);
        pnMenu2.setBackground(DefauColor);
        pnMenu3.setBackground(DefauColor);
        pnMenu4.setBackground(DefauColor);

        lblHoaDon.setForeground(DefaulColor1);
        lblKhachhang.setForeground(DefaulColor1);
        lblXe.setForeground(DefaulColor1);
        lblNhanvien.setForeground(DefaulColor1);
        lblHoaDonChiTiet.setForeground(DefaulColor1);

    }

    private void showContainer(Container content) {
        pnHome.removeAll();
        pnHome.add(content);
        pnHome.validate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        mau1 = new com.form.Mau();
        jLabel15 = new javax.swing.JLabel();
        pnTrangChu = new javax.swing.JPanel();
        pnMenuNho = new javax.swing.JPanel();
        pnMenu1 = new javax.swing.JPanel();
        lblTrangChu = new javax.swing.JLabel();
        pnMenu2 = new javax.swing.JPanel();
        lblQuanLy = new javax.swing.JLabel();
        pnMenu3 = new javax.swing.JPanel();
        lblThongKe = new javax.swing.JLabel();
        pnMenu4 = new javax.swing.JPanel();
        lblCaidat = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        pnMenu5 = new javax.swing.JPanel();
        lblDangXuat = new javax.swing.JLabel();
        lblDong = new javax.swing.JLabel();
        pnMenu = new javax.swing.JPanel();
        lblMenuname = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblMo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        pnHome = new javax.swing.JPanel();
        mau3 = new com.form.Mau();
        jLabel6 = new javax.swing.JLabel();
        pnQuanLyChung = new javax.swing.JPanel();
        mau2 = new com.form.Mau();
        lblHoaDon = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblXe = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblKhachhang = new javax.swing.JLabel();
        lblNhanvien = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        pnQuanLy = new javax.swing.JPanel();
        lblHoaDonChiTiet = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("File");
        jMenuBar3.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar3.add(jMenu6);

        mau1.setPreferredSize(new java.awt.Dimension(880, 460));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/dive-removebg-preview.png"))); // NOI18N

        javax.swing.GroupLayout mau1Layout = new javax.swing.GroupLayout(mau1);
        mau1.setLayout(mau1Layout);
        mau1Layout.setHorizontalGroup(
            mau1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mau1Layout.createSequentialGroup()
                .addGap(365, 365, 365)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(386, Short.MAX_VALUE))
        );
        mau1Layout.setVerticalGroup(
            mau1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mau1Layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(jLabel15)
                .addContainerGap(174, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnTrangChu.setMinimumSize(new java.awt.Dimension(880, 500));
        pnTrangChu.setPreferredSize(new java.awt.Dimension(880, 650));
        pnTrangChu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnMenuNho.setBackground(new java.awt.Color(153, 204, 255));
        pnMenuNho.setPreferredSize(new java.awt.Dimension(220, 650));
        pnMenuNho.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnMenu1.setBackground(new java.awt.Color(153, 204, 255));
        pnMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnMenu1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnMenu1MousePressed(evt);
            }
        });

        lblTrangChu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTrangChu.setForeground(new java.awt.Color(255, 255, 255));
        lblTrangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/home.png"))); // NOI18N
        lblTrangChu.setText(" Trang Chủ");
        lblTrangChu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTrangChuMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnMenu1Layout = new javax.swing.GroupLayout(pnMenu1);
        pnMenu1.setLayout(pnMenu1Layout);
        pnMenu1Layout.setHorizontalGroup(
            pnMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenu1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        pnMenu1Layout.setVerticalGroup(
            pnMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTrangChu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, Short.MAX_VALUE)
        );

        pnMenuNho.add(pnMenu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 220, 40));

        pnMenu2.setBackground(new java.awt.Color(153, 204, 255));
        pnMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnMenu2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnMenu2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pnMenu2MouseReleased(evt);
            }
        });

        lblQuanLy.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblQuanLy.setForeground(new java.awt.Color(255, 255, 255));
        lblQuanLy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/quanly.png"))); // NOI18N
        lblQuanLy.setText(" Quản Lý");
        lblQuanLy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuanLyMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnMenu2Layout = new javax.swing.GroupLayout(pnMenu2);
        pnMenu2.setLayout(pnMenu2Layout);
        pnMenu2Layout.setHorizontalGroup(
            pnMenu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenu2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        pnMenu2Layout.setVerticalGroup(
            pnMenu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblQuanLy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnMenuNho.add(pnMenu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 220, 40));

        pnMenu3.setBackground(new java.awt.Color(153, 204, 255));
        pnMenu3.setAutoscrolls(true);
        pnMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnMenu3MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnMenu3MousePressed(evt);
            }
        });

        lblThongKe.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblThongKe.setForeground(new java.awt.Color(255, 255, 255));
        lblThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/thongke.png"))); // NOI18N
        lblThongKe.setText("Thống Kê");
        lblThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThongKeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnMenu3Layout = new javax.swing.GroupLayout(pnMenu3);
        pnMenu3.setLayout(pnMenu3Layout);
        pnMenu3Layout.setHorizontalGroup(
            pnMenu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenu3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblThongKe)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        pnMenu3Layout.setVerticalGroup(
            pnMenu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenu3Layout.createSequentialGroup()
                .addComponent(lblThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        pnMenuNho.add(pnMenu3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 220, 40));

        pnMenu4.setBackground(new java.awt.Color(153, 204, 255));
        pnMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnMenu4MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnMenu4MousePressed(evt);
            }
        });

        lblCaidat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblCaidat.setForeground(new java.awt.Color(255, 255, 255));
        lblCaidat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/icons8-setting-40.png"))); // NOI18N
        lblCaidat.setText("Đổi Mật Khẩu");
        lblCaidat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCaidatMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnMenu4Layout = new javax.swing.GroupLayout(pnMenu4);
        pnMenu4.setLayout(pnMenu4Layout);
        pnMenu4Layout.setHorizontalGroup(
            pnMenu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMenu4Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(lblCaidat)
                .addGap(22, 22, 22))
        );
        pnMenu4Layout.setVerticalGroup(
            pnMenu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCaidat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnMenuNho.add(pnMenu4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 220, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/account.png"))); // NOI18N
        pnMenuNho.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 110, 100));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("NV001");
        pnMenuNho.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 70, -1));
        pnMenuNho.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 220, 10));

        pnMenu5.setBackground(new java.awt.Color(153, 204, 255));
        pnMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnMenu5MousePressed(evt);
            }
        });

        lblDangXuat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblDangXuat.setForeground(new java.awt.Color(255, 255, 255));
        lblDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/login.png"))); // NOI18N
        lblDangXuat.setText(" Đăng Xuất");
        lblDangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDangXuatMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnMenu5Layout = new javax.swing.GroupLayout(pnMenu5);
        pnMenu5.setLayout(pnMenu5Layout);
        pnMenu5Layout.setHorizontalGroup(
            pnMenu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenu5Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblDangXuat)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        pnMenu5Layout.setVerticalGroup(
            pnMenu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDangXuat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        pnMenuNho.add(pnMenu5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 220, 40));

        lblDong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/dong.png"))); // NOI18N
        lblDong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDongMouseClicked(evt);
            }
        });
        pnMenuNho.add(lblDong, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, 30));

        pnTrangChu.add(pnMenuNho, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 0, 650));

        pnMenu.setBackground(new java.awt.Color(51, 153, 255));
        pnMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMenuname.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblMenuname.setForeground(new java.awt.Color(255, 255, 255));
        lblMenuname.setText("Dịch Vụ Thuê Xe");
        pnMenu.add(lblMenuname, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nguyễn Văn B");
        pnMenu.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));

        lblMo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/icons8-menu-64.png"))); // NOI18N
        lblMo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMoMouseClicked(evt);
            }
        });
        pnMenu.add(lblMo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 60, 60));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/xoa.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        pnMenu.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/icons8-home-16.png"))); // NOI18N
        pnMenu.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 80, 20, 20));

        jLabel13.setText("/");
        pnMenu.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 80, 10, 20));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/icons8-find-user-male-16.png"))); // NOI18N
        pnMenu.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 80, 20, -1));

        jLabel16.setText("/");
        pnMenu.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 80, 10, 20));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/logout3.png"))); // NOI18N
        pnMenu.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 80, 30, -1));

        pnTrangChu.add(pnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 110));

        pnHome.setPreferredSize(new java.awt.Dimension(880, 540));
        pnHome.setLayout(new java.awt.BorderLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/dive-removebg-preview.png"))); // NOI18N

        javax.swing.GroupLayout mau3Layout = new javax.swing.GroupLayout(mau3);
        mau3.setLayout(mau3Layout);
        mau3Layout.setHorizontalGroup(
            mau3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mau3Layout.createSequentialGroup()
                .addGap(377, 377, 377)
                .addComponent(jLabel6)
                .addContainerGap(383, Short.MAX_VALUE))
        );
        mau3Layout.setVerticalGroup(
            mau3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mau3Layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(jLabel6)
                .addContainerGap(210, Short.MAX_VALUE))
        );

        pnHome.add(mau3, java.awt.BorderLayout.CENTER);

        pnTrangChu.add(pnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 880, 540));

        pnQuanLyChung.setPreferredSize(new java.awt.Dimension(880, 540));
        pnQuanLyChung.setLayout(new java.awt.BorderLayout());

        mau2.setPreferredSize(new java.awt.Dimension(880, 550));

        lblHoaDon.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblHoaDon.setText("Hóa Đơn");
        lblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHoaDonMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("/");

        lblXe.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblXe.setText("Sản Phẩm");
        lblXe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblXeMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("/");

        lblKhachhang.setBackground(new java.awt.Color(255, 255, 255));
        lblKhachhang.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblKhachhang.setText("Khách Hàng");
        lblKhachhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKhachhangMouseClicked(evt);
            }
        });

        lblNhanvien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNhanvien.setText("Nhân Viên");
        lblNhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNhanvienMouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/dive-removebg-preview.png"))); // NOI18N
        jLabel1.setMinimumSize(new java.awt.Dimension(60, 600));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("/");

        pnQuanLy.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnQuanLy.setOpaque(false);
        pnQuanLy.setPreferredSize(new java.awt.Dimension(880, 500));
        pnQuanLy.setLayout(new java.awt.BorderLayout());

        lblHoaDonChiTiet.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblHoaDonChiTiet.setText("Hóa Đơn Chi Tiết");
        lblHoaDonChiTiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHoaDonChiTietMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("/");

        javax.swing.GroupLayout mau2Layout = new javax.swing.GroupLayout(mau2);
        mau2.setLayout(mau2Layout);
        mau2Layout.setHorizontalGroup(
            mau2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mau2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblHoaDon)
                .addGap(28, 28, 28)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(lblHoaDonChiTiet)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(26, 26, 26)
                .addComponent(lblXe)
                .addGap(26, 26, 26)
                .addComponent(jLabel8)
                .addGap(34, 34, 34)
                .addComponent(lblKhachhang)
                .addGap(15, 15, 15)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(lblNhanvien)
                .addGap(17, 17, 17))
            .addComponent(pnQuanLy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(mau2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mau2Layout.createSequentialGroup()
                    .addContainerGap(361, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(399, Short.MAX_VALUE)))
        );
        mau2Layout.setVerticalGroup(
            mau2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mau2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(mau2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHoaDon)
                    .addComponent(jLabel7)
                    .addComponent(lblXe)
                    .addComponent(jLabel8)
                    .addComponent(lblKhachhang)
                    .addComponent(lblNhanvien)
                    .addComponent(jLabel11)
                    .addComponent(lblHoaDonChiTiet)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnQuanLy, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE))
            .addGroup(mau2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mau2Layout.createSequentialGroup()
                    .addGap(0, 76, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnQuanLyChung.add(mau2, java.awt.BorderLayout.CENTER);

        pnTrangChu.add(pnQuanLyChung, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, -1, 540));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pnMenu1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnMenu1MousePressed
        pnMenu1.setBackground(ClickedColor);
        pnMenu2.setBackground(DefauColor);
        pnMenu3.setBackground(DefauColor);
        pnMenu4.setBackground(DefauColor);

        lblMenuname.setText("Trang Chủ");
    }//GEN-LAST:event_pnMenu1MousePressed

    private void pnMenu2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnMenu2MousePressed
        pnMenu1.setBackground(DefauColor);
        pnMenu2.setBackground(ClickedColor);
        pnMenu3.setBackground(DefauColor);
        pnMenu4.setBackground(DefauColor);

        lblMenuname.setText("Quản Lý Chung ");
    }//GEN-LAST:event_pnMenu2MousePressed

    private void pnMenu3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnMenu3MousePressed
        pnMenu1.setBackground(DefauColor);
        pnMenu2.setBackground(DefauColor);
        pnMenu3.setBackground(ClickedColor);
        pnMenu4.setBackground(DefauColor);

        lblMenuname.setText("Thống Kê");
    }//GEN-LAST:event_pnMenu3MousePressed

    private void pnMenu4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnMenu4MousePressed
        pnMenu1.setBackground(DefauColor);
        pnMenu2.setBackground(DefauColor);
        pnMenu3.setBackground(DefauColor);
        pnMenu4.setBackground(ClickedColor);

        lblMenuname.setText("Đổi Mật Khẩu");
    }//GEN-LAST:event_pnMenu4MousePressed

    private void pnMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnMenu1MouseClicked

        showPanel(new TrangChu());
        lblMenuname.setText("Trang Chủ");
        closeMenu();
    }//GEN-LAST:event_pnMenu1MouseClicked

    private void showPanel(JPanel panel) {
        childPanel = panel;
        pnHome.removeAll();
        pnHome.add(childPanel);
        pnHome.validate();
    }

    private void showPane2(JPanel panel) {
        childPanel = panel;
        pnQuanLy.removeAll();
        pnQuanLy.add(childPanel);
        pnQuanLy.validate();
    }

//    private boolean isPnHomeVisible = false;
//    private boolean isPnMenuNhoVisible = true;
//
//    public void DongMo() {
//        if (pnHome.isVisible()) {
//            showPanel(pnMenu);
//            isPnHomeVisible = false;
//        } else {
//            showPanel(pnHome);
//            isPnHomeVisible = true;
//        }
//        pnMenuNho.setVisible(isPnHomeVisible);
//    }
    int width1 = 220;
    int height1 = 650;

    void openMenu() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < width1; i++) {
                    pnMenuNho.setSize(i, height1);

                    try {
                        //mở từ từ
                        Thread.sleep(2);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }

    void closeMenu() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = width1; i > 0; i--) {
                    pnMenuNho.setSize(i, height1);

                    try {
                        //mở từ từ
                        Thread.sleep(2);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }

    private void lblMoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMoMouseClicked
        openMenu();

    }//GEN-LAST:event_lblMoMouseClicked

    private void pnMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnMenu2MouseClicked
        showPanel(pnQuanLyChung);
        lblMenuname.setText("Quản Lý Chung");
        closeMenu();
    }//GEN-LAST:event_pnMenu2MouseClicked

    private void pnMenu5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnMenu5MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_pnMenu5MousePressed

    private void lblDangXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangXuatMouseClicked

    }//GEN-LAST:event_lblDangXuatMouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void lblDongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDongMouseClicked
        closeMenu();
    }//GEN-LAST:event_lblDongMouseClicked

    private void lblTrangChuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTrangChuMouseClicked
        showPanel(new TrangChu());
        lblMenuname.setText("Trang Chủ");
        closeMenu();
    }//GEN-LAST:event_lblTrangChuMouseClicked

    private void lblQuanLyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLyMouseClicked
        showPanel(pnQuanLyChung);
        lblMenuname.setText("Quản Lý Chung");
        closeMenu();
    }//GEN-LAST:event_lblQuanLyMouseClicked

    private void lblThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThongKeMouseClicked
        showContainer(new ThongKe(this, rootPaneCheckingEnabled).getContentPane());
        lblMenuname.setText("Thống Kê");
        closeMenu();
    }//GEN-LAST:event_lblThongKeMouseClicked

    private void lblCaidatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaidatMouseClicked
        showContainer(new ThayDoiPassJDialog(this, rootPaneCheckingEnabled).getContentPane());
        lblMenuname.setText("Thay Đổi Mật Khẩu");
        closeMenu();
    }//GEN-LAST:event_lblCaidatMouseClicked

    private void pnMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnMenu3MouseClicked
        showContainer(new ThongKe(this, rootPaneCheckingEnabled).getContentPane());
        lblMenuname.setText("Thống Kê");
        closeMenu();
    }//GEN-LAST:event_pnMenu3MouseClicked

    private void pnMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnMenu4MouseClicked
        showContainer(new ThayDoiPassJDialog(this, rootPaneCheckingEnabled).getContentPane());
        lblMenuname.setText("Thay Đổi Mật Khẩu");
        closeMenu();
    }//GEN-LAST:event_pnMenu4MouseClicked

    private void pnMenu2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnMenu2MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_pnMenu2MouseReleased

    private void lblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoaDonMouseClicked
        showPane2(new QuanLyHoaDon());
        lblMenuname.setText("Quản Lý hóa Đơn");
        lblHoaDon.setForeground(ClickColor1);
        lblKhachhang.setForeground(DefaulColor1);
        lblXe.setForeground(DefaulColor1);
        lblHoaDonChiTiet.setForeground(DefaulColor1);
        lblNhanvien.setForeground(DefaulColor1);
    }//GEN-LAST:event_lblHoaDonMouseClicked

    private void lblXeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblXeMouseClicked
        showPane2(new ThongTinXe());
        lblMenuname.setText("Quản Lý Xe");
        lblHoaDon.setForeground(DefaulColor1);
        lblKhachhang.setForeground(DefaulColor1);
        lblXe.setForeground(ClickColor1);
       lblHoaDonChiTiet.setForeground(DefaulColor1);
        lblNhanvien.setForeground(DefaulColor1);

    }//GEN-LAST:event_lblXeMouseClicked

    private void lblKhachhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKhachhangMouseClicked
        showPane2(new KhachHang());
        lblMenuname.setText("Quản Lý Khách Hàng");
        lblHoaDon.setForeground(DefaulColor1);
        lblKhachhang.setForeground(ClickColor1);
        lblXe.setForeground(DefaulColor1);
        lblHoaDonChiTiet.setForeground(DefaulColor1);
        lblNhanvien.setForeground(DefaulColor1);
    }//GEN-LAST:event_lblKhachhangMouseClicked

    private void lblNhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNhanvienMouseClicked
        showPane2(new ThongTinNhanVien());
        lblMenuname.setText("Quản Lý Nhân Viên");
        lblHoaDon.setForeground(DefaulColor1);
        lblHoaDonChiTiet.setForeground(DefaulColor1);
        lblKhachhang.setForeground(DefaulColor1);
        lblXe.setForeground(DefaulColor1);
        lblNhanvien.setForeground(ClickColor1);
    }//GEN-LAST:event_lblNhanvienMouseClicked

    private void lblHoaDonChiTietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoaDonChiTietMouseClicked
         showPane2(new HoaDonChiTiet());
        lblMenuname.setText("Quản Lý Hóa Đơn Chi Tiết");
        lblHoaDon.setForeground(DefaulColor1);
        lblKhachhang.setForeground(DefaulColor1);
        lblXe.setForeground(DefaulColor1);
        lblHoaDonChiTiet.setForeground(ClickColor1);
        lblNhanvien.setForeground(DefaulColor1);
    }//GEN-LAST:event_lblHoaDonChiTietMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCaidat;
    private javax.swing.JLabel lblDangXuat;
    private javax.swing.JLabel lblDong;
    private javax.swing.JLabel lblHoaDon;
    private javax.swing.JLabel lblHoaDonChiTiet;
    private javax.swing.JLabel lblKhachhang;
    private javax.swing.JLabel lblMenuname;
    private javax.swing.JLabel lblMo;
    private javax.swing.JLabel lblNhanvien;
    private javax.swing.JLabel lblQuanLy;
    private javax.swing.JLabel lblThongKe;
    private javax.swing.JLabel lblTrangChu;
    private javax.swing.JLabel lblXe;
    private com.form.Mau mau1;
    private com.form.Mau mau2;
    private com.form.Mau mau3;
    private javax.swing.JPanel pnHome;
    private javax.swing.JPanel pnMenu;
    private javax.swing.JPanel pnMenu1;
    private javax.swing.JPanel pnMenu2;
    private javax.swing.JPanel pnMenu3;
    private javax.swing.JPanel pnMenu4;
    private javax.swing.JPanel pnMenu5;
    private javax.swing.JPanel pnMenuNho;
    private javax.swing.JPanel pnQuanLy;
    private javax.swing.JPanel pnQuanLyChung;
    private javax.swing.JPanel pnTrangChu;
    // End of variables declaration//GEN-END:variables
}
