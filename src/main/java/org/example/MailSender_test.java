package org.example;

import javax.mail.*;
import javax.mail.internet.*;

import java.util.Properties;

public class MailSender_test {
    public static void main(String[] args) {

        String from = "munirov22072000@gmail.com";
        String to = "munirov22072000@gmail.com";
        String host = "smtp.gmail.com";
        String smtpPort = "465";

        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", smtpPort);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(
                properties,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, "ceaojwizlxezfcyb");
                    }
                }
        );
        session.setDebug(true);
        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom( new InternetAddress(from));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            msg.setSubject("Актуальный курс валют");
            msg.setText("Hi");
            Transport.send(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }

        }
    }