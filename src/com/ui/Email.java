/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ui;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.DataContentHandler;

public class Email {
    // email: phanthanhthaothotnot@gmail.com
    //pass: pdnt hkda scic epbk

    public static void main(String[] args) {
        final String from = "phanthanhthaothotnot@gmail.com";
        final String password = "pdnt hkda scic epbk";
        

        //Propertices: khai báo các thuộc tính
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "smtp.gmail.com"); //TLS 587 SSL 465
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        //Tạo Authenticator
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        };
        //Phiên làm việc
        Session session = Session.getInstance(props, auth);
        
        
        //Gửi email
        final String to = "phanthanhtan2102@gmail.com";
        
        //Tạo một tin nhắn
        MimeMessage msg = new MimeMessage(session);
        try {
            msg.addHeader("Content-type", "text/HTML;charset=UTF-8");//kiểu nội dung
            msg.setFrom(from); //Người gửi
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to,false));//Người nhận
            msg.setSubject("Demo gửi email");//Tiêu đề
            msg.setSentDate(new Date()); //quy định ngày gửi
//            msg.setReplyTo(InternetAddress.parse(from,false));//quy định phản hồi
            msg.setText("Đây là nội dung","UTF-8");//Nội dung
            Transport.send(msg); //Gửi email
        } catch (MessagingException ex) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
