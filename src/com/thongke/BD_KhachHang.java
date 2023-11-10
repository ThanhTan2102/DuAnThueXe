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
import javax.swing.JLabel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public class BD_KhachHang extends javax.swing.JPanel {

    /**
     * Creates new form KhachHang
     */
    public BD_KhachHang() {
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

    public static DefaultPieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();

        try {
            Connection conn = getConnection();

            // Query khách hàng có hóa đơn
            String queryCoHD = "EXEC sp_ThongKeKhachHangCoHD";
            PreparedStatement ps1 = conn.prepareStatement(queryCoHD);
            ResultSet rs1 = ps1.executeQuery();
            int countCoHD = 0;
            while (rs1.next()) {
                countCoHD++;
            }

            // Query khách hàng không có hóa đơn
            String queryKHD = "EXEC sp_ThongKeKhachHangKHD";
            PreparedStatement ps2 = conn.prepareStatement(queryKHD);
            ResultSet rs2 = ps2.executeQuery();
            int countKHD = 0;
            while (rs2.next()) {
                countKHD++;
            }

            dataset.setValue("Có hóa đơn", countCoHD);
            dataset.setValue("Không có hóa đơn", countKHD);

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataset;
    }

    public static JFreeChart createPieChart() {
        JFreeChart pieChart = ChartFactory.createPieChart(
                "Biểu đồ khách hàng có hóa đơn và không có hóa đơn", createDataset(), true, true, false);

        PiePlot plot = (PiePlot) pieChart.getPlot();

        JFrame frame = new JFrame();
        ChartPanel chartPanel = new ChartPanel(pieChart);
        frame.add(chartPanel);
        frame.setSize(560, 367);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
//        frame.setVisible(true);

        return pieChart;
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
