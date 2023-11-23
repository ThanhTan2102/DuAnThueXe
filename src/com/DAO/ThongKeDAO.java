/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import com.model.ThongTinXe;
import com.utils.JDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class ThongKeDAO {

    public static ResultSet rs = null;
    public static String DoanhThuNam_SQL = "{CALL sp_ThongKeDoanhThuTheoThang}";
    public static String LocDoanhThu_SQL = "{CALL sp_LocDoanhThuTheoThang(?,?)}";
    public static String DoanhThuXe_SQL = "{CALL sp_DoanhThuXe(?)} ";
    public static String DoanhThuHoaDon_SQL = "{CALL sp_ThongKeHoaDon}";
    public static String LocDoanhThuHD_SQL = "{CALL sp_LocDoanhThuHoaDon(?,?)}";

    private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            rs = JDBC.query(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Object[]> getDoanhThuNam() {
        String[] cols = {"ThoiGian", "DoanhThuTN", "DoanhThuCN", "TongTien"};
        return this.getListOfArray(DoanhThuNam_SQL, cols);
    }

    public List<Object[]> getLocDoanhThu(LocalDate ngayBD, LocalDate ngayKT) {
        String[] cols = {"ThoiGian", "DoanhThuTN", "DoanhThuCN", "TongTien"};
        return this.getListOfArray(LocDoanhThu_SQL, cols, ngayBD, ngayKT);
    }

    public List<Object[]> getLocDoanhThuHD(LocalDate ngayBD, LocalDate ngayKT) {
        String[] cols = {"ThoiGian", "SoLuongHD", "TongTien"};
        return this.getListOfArray(LocDoanhThuHD_SQL, cols, ngayBD, ngayKT);
    }

    public List<Object[]> getDoanhThuXe(Integer maXe) {
        String[] cols = {"MaXe", "ThoiGian", "DoanhThuXe"};
        return this.getListOfArray(DoanhThuXe_SQL, cols, maXe);
    }

    public List<Object[]> getDoanhThuHoaDon() {
        String[] cols = {"ThoiGian", "SoLuongHD", "DoanhThu"};
        return this.getListOfArray(DoanhThuHoaDon_SQL, cols);
    }

    public List<Integer> getAllMaXe() {
        List<Integer> maXeList = new ArrayList<>();
        try (Connection conn = JDBC.getConnection()) {
            String query = "SELECT MaXe FROM ThongTinXe";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        int maXe = rs.getInt("MaXe");
                        maXeList.add(maXe);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maXeList;
    }

    public List<Object[]> searchDoanhThuXe(String keyword) {
        List<Object[]> result = new ArrayList<>();

        try {
            String sql = "{CALL sp_TimKiemXe(?)}";

            try (PreparedStatement stmt = JDBC.getStmt(sql, keyword); ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    // Đọc dữ liệu từ ResultSet và kiểm tra nếu phù hợp với keyword
                    String maXe = rs.getString("MaXe");
                    String thoiGian = rs.getString("ThoiGian");
                    double doanhThuXe = rs.getDouble("DoanhThuXe");

                    // Kiểm tra nếu dữ liệu phù hợp với keyword
                    if (maXe.contains(keyword) || thoiGian.contains(keyword)) {
                        Object[] row = new Object[]{maXe, thoiGian, doanhThuXe};
                        result.add(row);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
