/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import com.utils.JDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class ThongKeDAO {

    public static ResultSet rs = null;
    public static String DoanhThuNam_SQL = "{CALL sp_ThongKeDoanhThuTheoThang}";
    public static String LocDoanhThu_SQL = "{CALL sp_LocDoanhThuTheoThang(?,?)}";
//    public static String DoanhThuXe_SQL = "{CALL sp_"

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
}
