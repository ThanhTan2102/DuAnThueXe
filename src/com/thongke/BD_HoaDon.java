/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.thongke;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;

public class BD_HoaDon extends javax.swing.JPanel {

    /**
     * Creates new form BD_HoaDon
     */
    public BD_HoaDon() {
        initComponents();
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            String user = "sa";
            String pass = "123456";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String durl = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyThueXe;encrypt=true;trustServerCertificate=true;";
            conn = DriverManager.getConnection(durl, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        try {
            Connection conn = getConnection();

            for (int thang = 1; thang <= 12; thang++) {
                // Truyền tháng cho thủ tục
                String query = "EXEC sp_ThongKeHoaDonThang ?";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, thang);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    dataset.addValue(rs.getInt("SoLuongHoaDon"), "Tháng " + thang, rs.getString("MaNhanVien"));
                }
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataset;
    }

    public static JFreeChart createBarChart() {
        JFreeChart barChart = ChartFactory.createBarChart(
                "Biểu đồ thống kê hóa đơn theo tháng", "Tháng", "Số lượng hóa đơn", createDataset(),
                PlotOrientation.VERTICAL, true, true, false);

        JFrame frame = new JFrame();
        ChartPanel chartPanel = new ChartPanel(barChart);
        frame.add(chartPanel);
        frame.setSize(420, 260);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
//        frame.setVisible(true);

        return barChart;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

//    public static void main(String[] args) {
//        createBarChart();
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
