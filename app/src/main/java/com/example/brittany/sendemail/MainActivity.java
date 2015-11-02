package com.example.brittany.sendemail;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.os.Bundle;

import java.util.Properties;

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


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mailSend(View v)

    {
        Multipart _multipart = new MimeMultipart();

        // Recipient's email ID needs to be mentioned.
        String to = "pancake2305@gmail.com";//change accordingly

        // Sender's email ID needs to be mentioned
        String from = "pancake2305@gmail.com";//change accordingly
        final String username = "pancake2305";//change accordingly
        final String password = "killer2305";//change accordingly

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
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


            _multipart.addBodyPart(messageBodyPart);

            message.setContent(_multipart);

            // Send message
            Transport.send(message);


        } catch (MessagingException e1) {
            e1.printStackTrace();
        }
    }
}








   /* public void onCancelButtonTapped(View view){
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    public void onSendButtonTapped(View view){
        Toast.makeText(getApplicationContext(), "Sending message...", Toast.LENGTH_SHORT).show();
        sendMail();
        Toast.makeText(getApplicationContext(), "Message sent", Toast.LENGTH_SHORT).show();

    }*/




