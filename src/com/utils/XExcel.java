/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;

public class XExcel {

    public static void main(String[] args) {
        writeToExcel(tblDoanhThu, "DoanhThuTheoThang");
        writeToExcel(tblHoaDon, "DoanhThuTheoHoaDon");
        writeToExcel(tblXe, "DoanhThuXe");
    }

    public static void writeToExcel(JTable table, String title) {
        XSSFWorkbook wb = null;
        FileOutputStream fos = null;
        try {
            wb = new XSSFWorkbook();
            XSSFSheet sheet = wb.createSheet(title); // Sử dụng tên sheet được truyền vào

            JFileChooser fc = new JFileChooser("D:\\");
            fc.setDialogTitle("Lưu thành...");
            FileNameExtensionFilter fnef = new FileNameExtensionFilter("Tệp tin", "xls", "xlsx", "xlsm");
            fc.setFileFilter(fnef);
            int chooser = fc.showSaveDialog(null);
            if (chooser == JFileChooser.APPROVE_OPTION) {
                TableModel tm = table.getModel();
                TableColumnModel tcm = table.getTableHeader().getColumnModel();
                XSSFRow rowtitle = sheet.createRow((short) 0);
                for (int i = 0; i < tcm.getColumnCount(); i++) {
                    // Thiết lập font cho tiêu đề cột
                    XSSFFont font = wb.createFont();
                    font.setFontHeightInPoints((short) 12);
                    font.setColor(IndexedColors.RED.getIndex());
                    font.setBold(true);
                    // Thiết lập kiểu cho tiêu đề cột
                    XSSFCellStyle cs = wb.createCellStyle();
                    cs.setAlignment(HorizontalAlignment.CENTER);
                    cs.setVerticalAlignment(VerticalAlignment.CENTER);
                    cs.setFont(font);
                    // Tạo ô tiêu đề cột
                    XSSFCell cell = rowtitle.createCell((short) i);
                    cell.setCellValue(tcm.getColumn(i).getHeaderValue().toString());
                    cell.setCellStyle(cs);
                }
                for (int i = 0; i < tm.getRowCount(); i++) {
                    XSSFFont font1 = wb.createFont();
                    // Thiết lập font cho dữ liệu cột
                    font1.setFontHeightInPoints((short) 10);
                    // Thiết lập kiểu cho dữ liệu cột
                    XSSFCellStyle cs1 = wb.createCellStyle();
                    cs1.setFont(font1);
                    XSSFRow row = sheet.createRow((short) i + 1);
                    for (int j = 0; j < tm.getColumnCount(); j++) {
                        // Tạo ô dữ liệu cột
                        XSSFCell cell = row.createCell((short) j);
                        cell.setCellValue(Objects.toString(tm.getValueAt(i, j), ""));
                        cell.setCellStyle(cs1);
                        // Thiết lập cột vừa vừa
                        for (int k = 0; k < row.getLastCellNum(); k++) {
                            wb.getSheetAt(0).autoSizeColumn(k);
                        }
                    }
                }
                fos = new FileOutputStream(fc.getSelectedFile() + ".xlsx");
                wb.write(fos);
                XDialog.alert(null, "Xuất dữ liệu thành công!");
                fos.close();
            }
        } catch (HeadlessException | IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (wb != null) {
                    wb.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static JTable tblDoanhThu; // Giả sử bạn có một JTable có tên là tblDoanhThu
    private static JTable tblHoaDon; // Giả sử bạn có một JTable khác có tên là tblSoLuongDon
    private static JTable tblXe;
}
