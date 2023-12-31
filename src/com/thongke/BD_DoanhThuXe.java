/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.thongke;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;

public class BD_DoanhThuXe extends javax.swing.JPanel {

    /**
     * Creates new form KhachHang
     */
    public BD_DoanhThuXe() {
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

    public static CategoryDataset createDataset(int[] maXes) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        try (Connection conn = getConnection()) {
            for (int maXe : maXes) {
                String query = "EXEC sp_DoanhThuXe ?";
                try (PreparedStatement ps = conn.prepareStatement(query)) {
                    ps.setInt(1, maXe);
                    try (ResultSet rs = ps.executeQuery()) {
                        while (rs.next()) {
                            double doanhThu = rs.getDouble("DoanhThuXe");
                            dataset.addValue(doanhThu, "Doanh Thu - Xe " + maXe, rs.getString("ThoiGian"));
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataset;
    }

    public static JFreeChart createBarChart(CategoryDataset dataset) {
        JFreeChart barChart = ChartFactory.createBarChart(
                "Biểu đồ Doanh thu theo Mã Xe", "Tháng - Năm", "Doanh thu",
                dataset, PlotOrientation.VERTICAL, true, true, false);

        return barChart;
    }

    public static void main(String[] args) {
        int[] maXes = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // Thay đổi thành mã xe cụ thể hoặc danh sách mã xe

        CategoryDataset dataset = createDataset(maXes);
        JFreeChart barChart = createBarChart(dataset);

        // Hiển thị biểu đồ trong một cửa sổ
        JFrame frame = new JFrame();
        ChartPanel chartPanel = new ChartPanel(barChart);
        frame.add(chartPanel);
        frame.setSize(420, 260);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 337, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 286, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
//public static void main(String[] args) {
//        createPieChart();
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
