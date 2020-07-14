package com.robertormzg.petagram.pojo;


import android.util.Log;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import static android.content.ContentValues.TAG;

public class Email {

    private static final String SMTP_HOST_NAME = "smtp.gmail.com";
    private static final String SMTP_AUTH_USER = "petagram@gmail.com";
    private static final String SMTP_AUTH_PWD  = "Password";

    private static Message message;

    public static void sendEmail(String to, String subject, String msg){

        String from = "petagram@gmail.com";

        final String username = SMTP_AUTH_USER;
        final String password = SMTP_AUTH_PWD;

        String host = SMTP_HOST_NAME;

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");


        Session session = Session.getInstance(
            props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

        try {

            message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
            message.setSubject(subject);

            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(msg, "text/html");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            message.setContent(multipart);

            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        Transport.send(message);
                        Log.d(TAG, "Mensaje enviado");
                    } catch (Exception e) {
                        System.out.println("Exception: "+ e.getMessage());
                        e.printStackTrace();
                    }
                }
            });

            thread.start();

        } catch (Exception e) {
            System.out.println("Exception: "+ e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
