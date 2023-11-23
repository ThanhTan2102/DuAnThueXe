/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.thongke;

import com.DAO.ThongKeDAO;
import static com.thongke.BD_HoaDon.taoBieuDoDuongHaiTruc;
import static com.thongke.BD_HoaDon.createDataset;
import com.utils.XExcel;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;

/**
 *
 * @author ASUS
 */
public class DoanhThuHoaDon extends javax.swing.JFrame {

    ThongKeDAO tkDAO = new ThongKeDAO();
    private JPanel pnBD;

    public DoanhThuHoaDon() {
        initComponents();
        init();
    }

    void init() {
        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) tblHoaDon.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tblHoaDon.getColumnModel().getColumn(0).setCellRenderer(render);
        tblHoaDon.getColumnModel().getColumn(1).setCellRenderer(render);
        tblHoaDon.getColumnModel().getColumn(2).setCellRenderer(render);
        CategoryDataset dataset = createDataset();
//        pnBD1 = new JPanel(); // Tạo JPanel pnBD
//        pnBD1.add(panelBieuDo()); // Thêm biểu đồ vào pnBD
//        add(pnBD1); // Thêm pnBD vào JFrame
//        showPanel(new BD_HoaDon());
        JPanel bieuDoPanel = panelBieuDo(dataset);
        showPanel(panelBieuDo(dataset));
        fillTable();
    }

    private void fillTable() {
        try {
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new Object[]{"Thời Gian", "Số Lượng", "Doanh Thu"});

            List<Object[]> result = tkDAO.getDoanhThuHoaDon();

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
                    numberFormat.format(row[2]),});
            }

            tblHoaDon.setModel(model);
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
            for (int i = 0; i < tblHoaDon.getColumnCount(); i++) {
                tblHoaDon.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
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
            return;
        } else if(startDate.getDate().after(endDate.getDate())){
            lblLoi.setText("Ngày bắt đầu phải trước ngày kết thúc !");
            lblLoi1.setText(" ");
            return;
        }else {
            try {
                DefaultTableModel model = (DefaultTableModel) tblHoaDon.getModel();
                model.setColumnIdentifiers(new Object[]{"Thời Gian", "Số Lượng", "Doanh Thu"});
                model.setRowCount(0);

                LocalDate ngayBD = startDate.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate ngayKT = endDate.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                List<Object[]> list = tkDAO.getLocDoanhThuHD(ngayBD, ngayKT);

                for (Object[] row : list) {
                    NumberFormat numberFormat = NumberFormat.getInstance();
                    model.addRow(new Object[]{
                        row[0],
                        numberFormat.format(row[1]),
                        numberFormat.format(row[2])
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();

            }
            lblLoi.setText(" ");
            lblLoi1.setText(" ");
        }
    }

    private JFreeChart lineChart;

    private JPanel panelBieuDo(CategoryDataset dataset) {
        if (lineChart == null) {
            lineChart = taoBieuDoDuongHaiTruc(dataset);  // Truyền dataset vào phương thức
        }
        ChartPanel chartPanel = new ChartPanel(lineChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(842, 400));

        return chartPanel;
    }

    private void showPanel(JPanel panel) {
        pnBD = panel;
        pnBieuDo.removeAll();
        pnBieuDo.add(pnBD);
        pnBieuDo.validate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        blue1 = new com.color.Blue();
        jLabel2 = new javax.swing.JLabel();
        startDate = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        endDate = new com.toedter.calendar.JDateChooser();
        btnThongKe = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        btnXuat = new javax.swing.JButton();
        pnBieuDo = new javax.swing.JPanel();
        lblLoi = new javax.swing.JLabel();
        lblLoi1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 600));

        blue1.setPreferredSize(new java.awt.Dimension(880, 500));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Thời gian:");

        startDate.setDateFormatString("MM-yyyy");
        startDate.setPreferredSize(new java.awt.Dimension(88, 27));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("~");

        endDate.setDateFormatString("MM-yyyy");
        endDate.setPreferredSize(new java.awt.Dimension(88, 27));

        btnThongKe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThongKe.setText("THỐNG KÊ");
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BẢNG THỐNG KÊ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setOpaque(false);

        tblHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(tblHoaDon);

        btnXuat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXuat.setText("XUẤT EXCEL");
        btnXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnXuat)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXuat)
                .addGap(0, 0, 0))
        );

        pnBieuDo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnBieuDo.setOpaque(false);
        pnBieuDo.setPreferredSize(new java.awt.Dimension(440, 290));
        pnBieuDo.setLayout(new java.awt.BorderLayout());

        lblLoi.setForeground(new java.awt.Color(255, 0, 51));
        lblLoi.setText(" ");

        lblLoi1.setForeground(new java.awt.Color(255, 0, 51));
        lblLoi1.setText(" ");

        javax.swing.GroupLayout blue1Layout = new javax.swing.GroupLayout(blue1);
        blue1.setLayout(blue1Layout);
        blue1Layout.setHorizontalGroup(
            blue1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(blue1Layout.createSequentialGroup()
                .addGroup(blue1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(blue1Layout.createSequentialGroup()
                        .addGroup(blue1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(blue1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, blue1Layout.createSequentialGroup()
                                .addGap(155, 155, 155)
                                .addComponent(lblLoi, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(blue1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(blue1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lblLoi1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnThongKe))
                    .addGroup(blue1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(blue1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnBieuDo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        blue1Layout.setVerticalGroup(
            blue1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(blue1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(blue1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(blue1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(endDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(startDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(blue1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLoi)
                    .addComponent(lblLoi1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnBieuDo, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        startDate.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(blue1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(blue1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        fillTableLoc();
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void btnXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatActionPerformed
        XExcel.writeToExcel(tblHoaDon, "Hóa Đơn");
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
            java.util.logging.Logger.getLogger(DoanhThuHoaDon.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoanhThuHoaDon.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoanhThuHoaDon.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoanhThuHoaDon.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoanhThuHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.color.Blue blue1;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JButton btnXuat;
    private com.toedter.calendar.JDateChooser endDate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLoi;
    private javax.swing.JLabel lblLoi1;
    private javax.swing.JPanel pnBieuDo;
    private com.toedter.calendar.JDateChooser startDate;
    private javax.swing.JTable tblHoaDon;
    // End of variables declaration//GEN-END:variables
}
