/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.thongke;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import javax.swing.JFrame;
import java.sql.Date;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;

public class BD_DoanhThu extends javax.swing.JPanel {

    public BD_DoanhThu() {
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

        try (Connection conn = getConnection()) {
            String query = "EXEC sp_ThongKeDoanhThuTheoThang";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        dataset.addValue(rs.getDouble("TongTien"), "Tổng Doanh thu", rs.getString("ThoiGian"));
                        dataset.addValue(rs.getDouble("DoanhThuTN"), "Doanh thu thấp nhất", rs.getString("ThoiGian"));
                        dataset.addValue(rs.getDouble("DoanhThuCN"), "Doanh thu cao nhất", rs.getString("ThoiGian"));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataset;
    }

   public static DefaultCategoryDataset createDatasetLoc() {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    try (Connection conn = getConnection()) {
        int nam[] = {2023, 2024, 2025};

        // Truyền ngày, tháng, và năm cho thủ tục
        String query = "EXEC sp_LocDoanhThuTheoThang ?, ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            LocalDate ngayBD = LocalDate.of(nam[0], 1, 1); 
            LocalDate ngayKT = LocalDate.of(nam[0], 12, 31); 

            ps.setDate(1, Date.valueOf(ngayBD));
            ps.setDate(2, Date.valueOf(ngayKT));

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    dataset.addValue(rs.getDouble("TongTien"), "Tổng Doanh thu", rs.getString("ThoiGian"));
                    dataset.addValue(rs.getDouble("DoanhThuTN"), "Doanh thu thấp nhất", rs.getString("ThoiGian"));
                    dataset.addValue(rs.getDouble("DoanhThuCN"), "Doanh thu cao nhất", rs.getString("ThoiGian"));
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return dataset;
}


    public static JFreeChart createBarChart() {
        JFreeChart barChart = ChartFactory.createBarChart(
                "Biểu đồ doanh thu theo Tháng - Năm", "Tháng - Năm", "Doanh thu", createDataset(),
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

    public static JFreeChart createBarChartLoc() {
        JFreeChart barChart = ChartFactory.createBarChart(
                "Biểu đồ doanh thu theo Tháng - Năm", "Tháng - Năm", "Doanh thu", createDatasetLoc(),
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
//

//    public static void main(String[] args) {
//        createBarChart();
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
