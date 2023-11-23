package com.DAO;

import com.model.NhanVien;
import com.ui.Email;
import com.utils.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.activation.DataContentHandler;

public class QuenMKDAO {

    public static ResultSet rs = null;
    public static final String SELECT_EMAIL_SQL = "SELECT * FROM NhanVien WHERE Email = ?";
    public static final String UPDATE_PASSWORD_SQL = "UPDATE NhanVien SET MatKhau = ? WHERE Email = ?";
    public static final String SELECT_BY_ID_SQL = "SELECT * FROM NhanVien WHERE MaNV = ?";
    public String newPass = getRandomString(6);

    private String getRandomString(int n) {
        String txt = "0123456789";
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            Random rd = new Random();
            sb.append(txt.charAt(rd.nextInt(txt.length())));
            n--;
        }
        return sb.toString();
    }

    private String createMessage(String hoTen, String taiKhoan) {
        return "<div style='background-color:cyan;padding:15px;border-radius:10px;margin:0 auto;width:70%;line-height:25px;'>"
                + "Xin chào <b>" + hoTen + "</b>,<br/>"
                + "Chúng tôi muốn thông báo rằng mật khẩu trên ứng dụng <b>DriveNow</b> của bạn đã được đặt lại."
                + "<br/><br/>"
                + "Tên tài khoản: " + taiKhoan + "<br/>"
                + "Mật khẩu mới của bạn là: <b>" + newPass + "</b><br/>"
                + "Vui lòng truy cập vào tài khoản và thay đổi mật khẩu ngay!"
                + "<br/><br/>"
                + "Nếu bạn gặp sự cố, vui lòng liên hệ với bộ phận hỗ trợ qua email: "
                + "<a href='mailto:phanthanhtan2102@gmail.com'>phanthanhtan2102@gmail.com</a><br/>"
                + "Vui lòng không trả lời email này bằng mật khẩu của bạn. "
                + "Chúng tôi sẽ không bao giờ yêu cầu mật khẩu của bạn và "
                + "chúng tôi đặc biệt không khuyến khích bạn chia sẻ mật khẩu với bất kỳ ai.</div>";
    }

    public void updatePassword(String key) {
        JDBC.update(UPDATE_PASSWORD_SQL, newPass, key);
    }

    public void sendEmail(String email) {
        try {
            // Thiết lập tài khoản email mặc định
            final String from = "phanthanhthaothotnot@gmail.com";
            final String password = "pdnt hkda scic epbk";

            // Cấu hình thuộc tính máy chủ
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");

            // Tạo phiên bản mới của authenticator
            Session ss = Session.getDefaultInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, password);
                }
            });

            rs = JDBC.query(SELECT_EMAIL_SQL, email);
            try {
                while (rs.next()) {
                    // Tạo tin nhắn email mới
                    MimeMessage msg = new MimeMessage(ss);
                    msg.setFrom(new InternetAddress(from));
                    msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(rs.getString("Email")));

                    // Đặt chủ đề
                    String subject = "Mật khẩu của bạn đã được đặt lại";
                    String body = createMessage(rs.getString("TenNV"), rs.getString("MaNV"));
                    msg.setSubject(subject, "utf-8");
                    msg.setContent(body, "text/html;charset=utf-8");

                    // Gửi email
                    Transport.send(msg);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException | MessagingException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

//    @Override
//    public NhanVien selectById(String key) {
//        List<NhanVien> list = selectBySql(SELECT_BY_ID_SQL, key);
//        return list.size() > 0 ? list.get(0) : null;
//    }
}
