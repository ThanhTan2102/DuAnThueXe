/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.thongke;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.renderer.category.BarRenderer;

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

    public static CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        try (Connection conn = getConnection()) {
            String query = "{CALL sp_ThongKeHoaDon}";
            try (PreparedStatement ps = conn.prepareCall(query)) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        String thoiGian = rs.getString("ThoiGian");
                        int soLuongHD = rs.getInt("SoLuongHD");
                        int doanhThu = rs.getInt("DoanhThu");

                        dataset.addValue(soLuongHD, "Số Lượng", thoiGian);
                        dataset.addValue(doanhThu, "Doanh Thu", thoiGian);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataset;
    }

    public static JFreeChart taoBieuDoDuongHaiTruc(CategoryDataset dataset) {
        JFreeChart bieuDoDuongHaiTruc = ChartFactory.createLineChart(
                "Biểu đồ Thống kê Hóa Đơn", "Thời Gian", "Số liệu",
                dataset, PlotOrientation.VERTICAL, true, true, false);

        CategoryPlot plot = bieuDoDuongHaiTruc.getCategoryPlot();
        CategoryAxis trucX = plot.getDomainAxis();
        trucX.setCategoryLabelPositions(CategoryLabelPositions.UP_45);

        NumberAxis trucY1 = new NumberAxis("Số Lượng");
        trucY1.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        trucY1.setRange(1, 100); // Thiết lập phạm vi cho trục y bên trái
        trucY1.setTickUnit(new NumberTickUnit(5)); // Thiết lập đơn vị chia cho trục y bên trái
        plot.setRangeAxis(0, trucY1);

        LineAndShapeRenderer rendererDuong1 = new LineAndShapeRenderer();
        plot.setRenderer(0, rendererDuong1);
        plot.mapDatasetToRangeAxis(0, 0);

        NumberAxis trucY2 = new NumberAxis("Doanh Thu");
        plot.setRangeAxis(1, trucY2);
        plot.setRangeAxisLocation(1, AxisLocation.BOTTOM_OR_RIGHT);

        LineAndShapeRenderer rendererDuong2 = new LineAndShapeRenderer();
        plot.setDataset(1, plot.getDataset(0)); // Sử dụng cùng bộ dữ liệu cho loại đồ thị đường
        plot.setRenderer(1, rendererDuong2);
        plot.mapDatasetToRangeAxis(1, 1);

        return bieuDoDuongHaiTruc;
    }

    public static void main(String[] args) {
        CategoryDataset dataset = createDataset();
        JFreeChart dualAxisLineChart = taoBieuDoDuongHaiTruc(dataset);

        // Display the chart in a JFrame
        JFrame frame = new JFrame();
        ChartPanel chartPanel = new ChartPanel(dualAxisLineChart);
        frame.add(chartPanel);
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
