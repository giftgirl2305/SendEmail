package com.example.brittany.sendemail;

/**
 * Created by Brittany on 10/12/2015.
 */

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import java.util.Properties;


public class sendMail {
    private Multipart _multipart = new MimeMultipart();

    // Recipient's email ID needs to be mentioned.
    String to = "pancake2305@gmail.com";//change accordingly

    // Sender's email ID needs to be mentioned
    String from = "suavereport@gmail.com";//change accordingly
    final String username = "suavereport";//change accordingly
    final String password = "se300project";//change accordingly

    // Assuming you are sending email through relay.jangosmtp.net
    String host = "smtp.gmail.com";

    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", host);
    props.put("mail.smtp.port", "587");

    // Get the Session object.
    Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

    try {
        // Create a default MimeMessage object.
        Message message = new MimeMessage(session);

        //DataHandler handler = new DataHandler(new ByteArrayDataSource(body.getBytes(), "text/plain"));

       // message.setDataHandler(handler);

        // Set From: header field of the header.
        try {
            message.setFrom(new InternetAddress(from));
        } catch (MessagingException e1) {
            e1.printStackTrace();
        }

        // Set To: header field of the header.
        try {
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
        } catch (MessagingException e1) {
            e1.printStackTrace();
        }

        // Set Subject: header field
        try {
            message.setSubject("Testing Subject");
        } catch (MessagingException e1) {
            e1.printStackTrace();
        }

        BodyPart messageBodyPart = new MimeBodyPart();

        try {
            messageBodyPart.setText("Hello, this is the summary.");
        } catch (MessagingException e1) {
            e1.printStackTrace();
        }

        try {
            _multipart.addBodyPart(messageBodyPart);
        } catch (MessagingException e1) {
            e1.printStackTrace();
        }

        //DataSource source = new FileDataSource(Environment.getExternalStorageDirectory().getPath()+"/image.jpg");

        DataSource source = new FileDataSource("Downloads/drone.jpg");

        try {
            messageBodyPart.setDataHandler(new DataHandler(source));
        } catch (MessagingException e1) {
            e1.printStackTrace();
        }

        try {
            messageBodyPart.setFileName("download image");
        } catch (MessagingException e1) {
            e1.printStackTrace();
        }

        try {
            _multipart.addBodyPart(messageBodyPart);
        } catch (MessagingException e1) {
            e1.printStackTrace();
        }

        // Send message
        try {
            Transport.send(message);
        } catch (MessagingException e1) {
            e1.printStackTrace();
        }

        System.out.println("Sent message successfully....");

    } catch(MessagingException e1){
        e1.printStackTrace();
    }

}



