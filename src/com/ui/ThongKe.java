/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.ui;

import com.thongke.DoanhThuNam;
import com.thongke.DoanhThuHoaDon;
import com.thongke.DoanhThuXe;
import com.utils.XManager;
import java.awt.Color;
import java.awt.Container;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThongKe extends javax.swing.JDialog {

 
    Color DefaultColor, ClickedColor;

    public ThongKe(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        DefaultColor = new Color(255, 255, 255);
        ClickedColor = new Color(255, 0, 0);
        lblKhachHang.setForeground(DefaultColor);
        lblHoaDon.setForeground(DefaultColor);
        lblDoanhThu.setForeground(DefaultColor);
        if(!XManager.isManager()){
            lblDoanhThu.remove(this);
        }
    }

    private void show(Container content) {
        pnHomeTK.removeAll();
        pnHomeTK.add(content);
        pnHomeTK.validate();
    }
    int width = 880;
    int height = 90;

    void openMenu() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < width; i++) {
                    pnMenu.setSize(width, height);

                }

            }
        }).start();
    }

    void closeMenu() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = width; i > 0; i--) {
                    pnMenu.setSize(i, height);

                }

            }
        }).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnHomeTK = new javax.swing.JPanel();
        mau1 = new com.form.Mau();
        pnMenu = new javax.swing.JPanel();
        green1 = new com.color.Green();
        lblHoaDon = new javax.swing.JLabel();
        lblDoanhThu = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        lblKhachHang = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnHomeTK.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnHomeTK.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout mau1Layout = new javax.swing.GroupLayout(mau1);
        mau1.setLayout(mau1Layout);
        mau1Layout.setHorizontalGroup(
            mau1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 896, Short.MAX_VALUE)
        );
        mau1Layout.setVerticalGroup(
            mau1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 536, Short.MAX_VALUE)
        );

        pnHomeTK.add(mau1, java.awt.BorderLayout.CENTER);

        pnMenu.setPreferredSize(new java.awt.Dimension(880, 90));
        pnMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        green1.setPreferredSize(new java.awt.Dimension(880, 70));

        lblHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        lblHoaDon.setText("HÓA ĐƠN");
        lblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHoaDonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblHoaDonMousePressed(evt);
            }
        });

        lblDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDoanhThu.setForeground(new java.awt.Color(255, 255, 255));
        lblDoanhThu.setText("DOANH THU");
        lblDoanhThu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDoanhThuMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblDoanhThuMousePressed(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));

        lblKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        lblKhachHang.setText("KHÁCH HÀNG");
        lblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKhachHangMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblKhachHangMousePressed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout green1Layout = new javax.swing.GroupLayout(green1);
        green1.setLayout(green1Layout);
        green1Layout.setHorizontalGroup(
            green1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(green1Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(green1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblKhachHang)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(204, 204, 204)
                .addGroup(green1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(green1Layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(green1Layout.createSequentialGroup()
                        .addComponent(lblHoaDon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDoanhThu)))
                .addGap(69, 69, 69))
        );
        green1Layout.setVerticalGroup(
            green1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, green1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(green1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(green1Layout.createSequentialGroup()
                        .addGroup(green1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblKhachHang, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(green1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblHoaDon)
                                .addComponent(lblDoanhThu)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(green1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(green1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))
        );

        pnMenu.add(green1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnHomeTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnHomeTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKhachHangMouseClicked
        show(new DoanhThuXe().getContentPane());
    }//GEN-LAST:event_lblKhachHangMouseClicked

    private void lblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoaDonMouseClicked
        show(new DoanhThuHoaDon().getContentPane());
    }//GEN-LAST:event_lblHoaDonMouseClicked

    private void lblDoanhThuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDoanhThuMouseClicked
        show(new DoanhThuNam().getContentPane());
    }//GEN-LAST:event_lblDoanhThuMouseClicked

    private void lblKhachHangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKhachHangMousePressed
        lblKhachHang.setForeground(ClickedColor);
        lblHoaDon.setForeground(DefaultColor);
        lblDoanhThu.setForeground(DefaultColor);
    }//GEN-LAST:event_lblKhachHangMousePressed

    private void lblHoaDonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoaDonMousePressed
        lblKhachHang.setForeground(DefaultColor);
        lblHoaDon.setForeground(ClickedColor);
        lblDoanhThu.setForeground(DefaultColor);
    }//GEN-LAST:event_lblHoaDonMousePressed

    private void lblDoanhThuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDoanhThuMousePressed
        lblKhachHang.setForeground(DefaultColor);
        lblHoaDon.setForeground(DefaultColor);
        lblDoanhThu.setForeground(ClickedColor);
    }//GEN-LAST:event_lblDoanhThuMousePressed

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
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ThongKe dialog = new ThongKe(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.color.Green green1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblDoanhThu;
    private javax.swing.JLabel lblHoaDon;
    private javax.swing.JLabel lblKhachHang;
    private com.form.Mau mau1;
    private javax.swing.JPanel pnHomeTK;
    private javax.swing.JPanel pnMenu;
    // End of variables declaration//GEN-END:variables
}
