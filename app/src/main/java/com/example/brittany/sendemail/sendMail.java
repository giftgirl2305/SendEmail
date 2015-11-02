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

    public void mailSend()

    {
        Multipart _multipart = new MimeMultipart();

        // Recipient's email ID needs to be mentioned.
        String to = "pancake2305@gmail.com";//change accordingly

        // Sender's email ID needs to be mentioned
        String from = "suavereport@gmail.com";//change accordingly
        final String username = "suavereport";//change accordingly
        final String password = "se300project";//change accordingly

        // Assuming you are sending email through relay.jangosmtp.net
        String mailhost = "smtp.gmail.com";

        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", mailhost);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.quitwait", "false");

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

                message.setFrom(new InternetAddress(from));


            // Set To: header field of the header.

                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(to));


            // Set Subject: header field

                message.setSubject("Testing Subject");


            BodyPart messageBodyPart = new MimeBodyPart();


                messageBodyPart.setText("Hello, this is the summary.");



                _multipart.addBodyPart(messageBodyPart);


            //DataSource source = new FileDataSource(Environment.getExternalStorageDirectory().getPath()+"/image.jpg");

            DataSource source = new FileDataSource("drone.jpg");


                messageBodyPart.setDataHandler(new DataHandler(source));



                messageBodyPart.setFileName("download image");

            //this is a comment i am adding for no reason

                _multipart.addBodyPart(messageBodyPart);

            // Send message

                Transport.send(message);


            System.out.println("Sent message successfully....");

        } catch (MessagingException e1) {
            e1.printStackTrace();
        }
    }
}



