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

    public static DefaultCategoryDataset createDataset(int selectedMonth, int selectedYear) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        try (Connection conn = getConnection()) {
            String query = "EXEC sp_DoanhThuTheoHoaDon ?, ?";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setInt(1, selectedMonth);
                ps.setInt(2, selectedYear);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        while (rs.next()) {
                            dataset.addValue(rs.getDouble("DoanhThu"), "Tổng Doanh thu", String.format("%02d/%04d", selectedMonth, selectedYear));
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataset;
    }

    public static JFreeChart createBarChart(int selectedMonth, int selectedYear) {
        JFreeChart barChart = ChartFactory.createBarChart(
                "Biểu đồ doanh thu theo Tháng - Năm", "Tháng - Năm", "Hóa đơn",
                createDataset(selectedMonth, selectedYear), PlotOrientation.VERTICAL, true, true, false);

        JFrame frame = new JFrame();
        ChartPanel chartPanel = new ChartPanel(barChart);
        frame.add(chartPanel);
        frame.setSize(420, 260);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setVisible(true);

        return barChart;
    }

    public static void main(String[] args) {
//        int selectedMonth = [1,2,3,4,5,6,7,8,9,11,12]; // Replace with the desired month
        int selectedYear = 2023; // Replace with the desired year
//        createBarChart(selectedMonth, selectedYear);
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
