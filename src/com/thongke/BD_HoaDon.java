/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.thongke;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
//import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
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

    public static CategoryDataset createDataset(int nam) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        try (Connection conn = getConnection()) {
            // Thay đổi truy vấn để lấy dữ liệu cho tất cả các tháng trong năm
            String query = "EXEC sp_ThongKeHoaDon ?, ?";
            for (int thang = 1; thang <= 12; thang++) {
                try (PreparedStatement ps = conn.prepareStatement(query)) {
                    ps.setInt(1, thang);
                    ps.setInt(2, nam);
                    try (ResultSet rs = ps.executeQuery()) {
                        while (rs.next()) {
                            int soLuongHoaDon = rs.getInt("SoLuongHoaDon");
                            double doanhThu = rs.getDouble("DoanhThu");

                            // Thêm dữ liệu vào dataset
                            dataset.addValue(soLuongHoaDon, "Số Lượng Hóa Đơn", String.valueOf(thang));
                            dataset.addValue(doanhThu, "Doanh Thu", String.valueOf(thang));
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataset;
    }

    public static JFreeChart createLineChart(CategoryDataset dataset) {
        JFreeChart lineChart = ChartFactory.createLineChart(
                "Biểu đồ Thống kê Hóa Đơn", "Tháng", "Số liệu",
                dataset, PlotOrientation.VERTICAL, true, true, false);

        // Tùy chỉnh trục x để hiển thị các tháng
        CategoryPlot plot = (CategoryPlot) lineChart.getPlot();
        CategoryAxis xAxis = plot.getDomainAxis();
        xAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);

        // Tùy chỉnh biểu đồ
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        // Hiển thị điểm trên đường
        LineAndShapeRenderer renderer = new LineAndShapeRenderer();
        plot.setRenderer(renderer);
        renderer.setSeriesShapesVisible(0, true);

        return lineChart;
    }

    public static void main(String[] args) {
        int nam = 2023; // Thay đổi theo năm mong muốn

        CategoryDataset dataset = createDataset(nam);
        JFreeChart lineChart = createLineChart(dataset);

        // Hiển thị biểu đồ trong một cửa sổ
        JFrame frame = new JFrame();
        ChartPanel chartPanel = new ChartPanel(lineChart);
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
