/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.thongke;

import com.DAO.ThongKeDAO;
import com.model.ThongTinXe;
import static com.thongke.BD_DoanhThuXe.createDataset;
import static com.thongke.BD_DoanhThuXe.createBarChart;
import com.utils.XExcel;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
public class DoanhThuXe extends javax.swing.JFrame {

    ThongKeDAO tkDAO = new ThongKeDAO();
    private JPanel pnBD;
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM-yyyy");

    public DoanhThuXe() {
        initComponents();
        init();
    }

    void init() {
        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) tblXe.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tblXe.getColumnModel().getColumn(0).setCellRenderer(render);
        tblXe.getColumnModel().getColumn(1).setCellRenderer(render);
        int[] maXes = {1, 2, 3, 4, 5, 6}; // Ví dụ với một số phần tử cụ thể
        CategoryDataset dataset = createDataset(maXes);
        JPanel bieuDoPanel = panelBieuDo(dataset);
        showPanel(bieuDoPanel);
        fillTable();
    }

    private void fillTable() {
        try {
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new Object[]{"Mã Xe", "Thời Gian", "Doanh Thu"});
            List<Integer> maXeList = tkDAO.getAllMaXe();

            for (Integer maXe : maXeList) {
                List<Object[]> result = tkDAO.getDoanhThuXe(maXe);

                for (Object[] row : result) {
                    String thoiGian = "";
                    if (row[1] != null) {
                        if (row[1] instanceof Date) {
                            thoiGian = new SimpleDateFormat("MM-yyyy").format((Date) row[1]);
                        } else if (row[1] instanceof String) {
                            thoiGian = (String) row[1];
                        }
                    }

                    NumberFormat numberFormat = NumberFormat.getInstance();
                    model.addRow(new Object[]{
                        row[0],
                        thoiGian,
                        numberFormat.format(row[2]),});
                }
            }

            tblXe.setModel(model);
            // Đặt Renderer để căn chỉnh dữ liệu ở giữa
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

            for (int i = 1; i < tblXe.getColumnCount(); i++) {
                tblXe.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fillTableTK() {
        String keyword = txtTimKiem.getText().trim();

        // Kiểm tra xem có đang thực hiện tìm kiếm hay không
        boolean isSearching = !keyword.isEmpty();

        try {
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new Object[]{"Mã Xe", "Thời Gian", "Doanh Thu"});
            model.setRowCount(0);  // Clear existing rows

            // Sử dụng phương thức searchDoanhThuXe với keyword
            List<Object[]> result = isSearching ? tkDAO.searchDoanhThuXe(keyword) : Collections.emptyList();

            for (Object[] row : result) {
                String thoiGian = "";
                if (row[1] != null) {
                    thoiGian = row[1] instanceof Date
                            ? new SimpleDateFormat("MM-yyyy").format((Date) row[1])
                            : (String) row[1];
                }

                NumberFormat numberFormat = NumberFormat.getInstance();
                model.addRow(new Object[]{
                    row[0],
                    thoiGian,
                    numberFormat.format(row[2]),});
            }

            tblXe.setModel(model);

            // Đặt Renderer để căn chỉnh dữ liệu ở giữa
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

            for (int i = 1; i < tblXe.getColumnCount(); i++) {
                tblXe.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private JFreeChart barChart;

    private void showPanel(JPanel panel) {
        pnBD = panel;
        pnBieuDo.removeAll();
        pnBieuDo.add(pnBD);
        pnBieuDo.validate();
    }

    private JPanel panelBieuDo(CategoryDataset dataset) {
        if (barChart == null) {
            BD_DoanhThuXe dtx = new BD_DoanhThuXe();
            barChart = dtx.createBarChart(dataset);
        }
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(435, 285));
        return chartPanel;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        blue1 = new com.color.Blue();
        jLabel2 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblXe = new javax.swing.JTable();
        btnExcel = new javax.swing.JButton();
        pnBieuDo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 600));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/icons8-search-30.png"))); // NOI18N
        jLabel2.setText("Mã xe:");

        txtTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BẢNG THỐNG KÊ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setOpaque(false);

        tblXe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblXe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblXe);

        btnExcel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExcel.setText("XUẤT EXCEL");
        btnExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 831, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnExcel)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcel))
        );

        pnBieuDo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnBieuDo.setOpaque(false);
        pnBieuDo.setPreferredSize(new java.awt.Dimension(440, 290));
        pnBieuDo.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout blue1Layout = new javax.swing.GroupLayout(blue1);
        blue1.setLayout(blue1Layout);
        blue1Layout.setHorizontalGroup(
            blue1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(blue1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(blue1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(blue1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(blue1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnBieuDo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 25, Short.MAX_VALUE))
        );
        blue1Layout.setVerticalGroup(
            blue1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(blue1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(blue1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnBieuDo, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(blue1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(blue1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
         XExcel.writeToExcel(tblXe, "Doanh Thu Xe");
    }//GEN-LAST:event_btnExcelActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        this.fillTableTK();
    }//GEN-LAST:event_txtTimKiemKeyReleased

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
            java.util.logging.Logger.getLogger(DoanhThuXe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoanhThuXe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoanhThuXe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoanhThuXe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new DoanhThuXe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.color.Blue blue1;
    private javax.swing.JButton btnExcel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnBieuDo;
    private javax.swing.JTable tblXe;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
