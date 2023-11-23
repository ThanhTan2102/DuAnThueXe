/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.thongke;

import com.DAO.ThongKeDAO;
import static com.utils.JDBC.conn;
import com.utils.XDate;
import com.utils.XExcel;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

/**
 *
 * @author ASUS
 */
public class DoanhThuNam extends javax.swing.JFrame {

    ThongKeDAO tkDAO = new ThongKeDAO();
    private JPanel pnBD;
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM-yyyy");

    public DoanhThuNam() {
        initComponents();
//        ChartFramee.setVisible(true);
        init();
    }

    private void init() {
        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) tblDoanhThu.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tblDoanhThu.getColumnModel().getColumn(0).setCellRenderer(render);
        tblDoanhThu.getColumnModel().getColumn(1).setCellRenderer(render);
        tblDoanhThu.getColumnModel().getColumn(2).setCellRenderer(render);
        tblDoanhThu.getColumnModel().getColumn(3).setCellRenderer(render);
        showPanel(panelBieuDo());
        fillTable();
    }

    private void fillTable() {
        try {
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new Object[]{"Thời Gian", "Doanh Thu TN", "Doanh Thu CN", "Tổng Doanh Thu"});

            List<Object[]> result = tkDAO.getDoanhThuNam();

            for (Object[] row : result) {
                String thoiGian = "";
                if (row[0] != null) {
                    if (row[0] instanceof Date) {
                        thoiGian = new SimpleDateFormat("MM-yyyy").format((Date) row[0]);
                    } else if (row[0] instanceof String) {
                        thoiGian = (String) row[0];
                    }
                }

                NumberFormat numberFormat = NumberFormat.getInstance();
                model.addRow(new Object[]{
                    thoiGian,
                    numberFormat.format(row[1]),
                    numberFormat.format(row[2]),
                    numberFormat.format(row[3])
                });
            }

            tblDoanhThu.setModel(model);
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
            for (int i = 0; i < tblDoanhThu.getColumnCount(); i++) {
                tblDoanhThu.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fillTableLoc() {
        if (startDate.getDate() == null) {
            lblLoi.setText("Ngày bắt đầu không được để trống !");
            lblLoi1.setText(" ");
            return;
        } else if (endDate.getDate() == null) {
            lblLoi.setText(" ");
            lblLoi1.setText("Ngày kết thúc không được để trống !");
        } else if (startDate.getDate().after(endDate.getDate())) {
            lblLoi.setText("Ngày bắt đầu phải trước ngày kết thúc !");
            lblLoi1.setText(" ");
            return;  // You should return here to avoid further execution if startDate is after endDate
        } else {
            try {
                DefaultTableModel model = (DefaultTableModel) tblDoanhThu.getModel();
                model.setColumnIdentifiers(new Object[]{"Thời Gian", "Doanh Thu TN", "Doanh Thu CN", "Tổng Doanh Thu"});
                model.setRowCount(0);

                LocalDate ngayBD = startDate.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate ngayKT = endDate.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                List<Object[]> list = tkDAO.getLocDoanhThu(ngayBD, ngayKT);

                for (Object[] row : list) {
                    NumberFormat numberFormat = NumberFormat.getInstance();
                    model.addRow(new Object[]{
                        row[0],
                        numberFormat.format(row[1]),
                        numberFormat.format(row[2]),
                        numberFormat.format(row[3])
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();

            }
            lblLoi.setText(" ");
            lblLoi1.setText(" ");
        }
    }

    private JFreeChart barChart;

    private void showPanel(JPanel panel) {
        pnBD = panel;
        pnBieuDo.removeAll();
        pnBieuDo.add(pnBD);
        pnBieuDo.validate();
    }

    private JPanel panelBieuDo() {
        if (barChart == null) {
            BD_DoanhThu bddt = new BD_DoanhThu();
            barChart = bddt.createBarChart();
        }
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(440, 260));
        return chartPanel;
    }

//    private JPanel panelBieuDoLoc() {
//        if (barChart == null) {
//            BD_DoanhThu bddt1 = new BD_DoanhThu();
//            barChart = bddt1.createBarChartLoc();
//        }
//        ChartPanel chartPanel = new ChartPanel(barChart);
//        chartPanel.setPreferredSize(new java.awt.Dimension(440, 260));
//        return chartPanel;
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        blue2 = new com.color.Blue();
        jLabel2 = new javax.swing.JLabel();
        pnBang = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDoanhThu = new javax.swing.JTable();
        btnXuat = new javax.swing.JButton();
        endDate = new com.toedter.calendar.JDateChooser();
        startDate = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        btnThongKe = new javax.swing.JButton();
        pnBieuDo = new javax.swing.JPanel();
        lblLoi = new javax.swing.JLabel();
        lblLoi1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 600));

        blue2.setOpaque(false);
        blue2.setPreferredSize(new java.awt.Dimension(880, 500));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Thời gian:");

        pnBang.setBackground(new java.awt.Color(255, 255, 255));
        pnBang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BẢNG THỐNG KÊ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        pnBang.setOpaque(false);

        tblDoanhThu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblDoanhThu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Thời gian", "Doanh thu TN", "Doanh thu CN", "Tổng doanh thu"
            }
        ));
        tblDoanhThu.setColumnSelectionAllowed(true);
        tblDoanhThu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tblDoanhThu);
        tblDoanhThu.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        btnXuat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXuat.setText("XUẤT EXCEL");
        btnXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBangLayout = new javax.swing.GroupLayout(pnBang);
        pnBang.setLayout(pnBangLayout);
        pnBangLayout.setHorizontalGroup(
            pnBangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBangLayout.createSequentialGroup()
                .addGroup(pnBangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBangLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnXuat)))
                .addContainerGap())
        );
        pnBangLayout.setVerticalGroup(
            pnBangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBangLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXuat)
                .addContainerGap())
        );

        endDate.setDateFormatString("MM-yyyy");
        endDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        startDate.setDateFormatString("MM-yyyy");
        startDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        startDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                startDateKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("~");

        btnThongKe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThongKe.setText("THỐNG KÊ");
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        pnBieuDo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnBieuDo.setOpaque(false);
        pnBieuDo.setLayout(new java.awt.BorderLayout());

        lblLoi.setForeground(new java.awt.Color(255, 0, 0));
        lblLoi.setText(" ");
        lblLoi.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblLoi1.setForeground(new java.awt.Color(255, 0, 0));
        lblLoi1.setText(" ");
        lblLoi1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout blue2Layout = new javax.swing.GroupLayout(blue2);
        blue2.setLayout(blue2Layout);
        blue2Layout.setHorizontalGroup(
            blue2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(blue2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(blue2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(blue2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(pnBang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnBieuDo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(blue2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(blue2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(blue2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lblLoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(blue2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(blue2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lblLoi1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnThongKe)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        blue2Layout.setVerticalGroup(
            blue2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(blue2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(blue2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(endDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(startDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(blue2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLoi)
                    .addComponent(lblLoi1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnBang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnBieuDo, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(blue2, javax.swing.GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(blue2, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        fillTableLoc();
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void startDateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_startDateKeyReleased
        if (startDate.getDate() == null) {
            lblLoi.setText("Không để trống");
        }
    }//GEN-LAST:event_startDateKeyReleased

    private void btnXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatActionPerformed
        XExcel.writeToExcel(tblDoanhThu, "Doanh Thu");
    }//GEN-LAST:event_btnXuatActionPerformed

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
            java.util.logging.Logger.getLogger(DoanhThuNam.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoanhThuNam.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoanhThuNam.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoanhThuNam.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoanhThuNam().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.color.Blue blue2;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JButton btnXuat;
    private com.toedter.calendar.JDateChooser endDate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLoi;
    private javax.swing.JLabel lblLoi1;
    private javax.swing.JPanel pnBang;
    private javax.swing.JPanel pnBieuDo;
    private com.toedter.calendar.JDateChooser startDate;
    private javax.swing.JTable tblDoanhThu;
    // End of variables declaration//GEN-END:variables
}
