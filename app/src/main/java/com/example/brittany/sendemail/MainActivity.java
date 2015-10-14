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




public class MainActivity extends AppCompatActivity {




    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }





    public void runEmail(View v){


        new Thread(new Runnable() {

            public void run() {

                try {

                    sendMail sender = new sendMail();

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }
            }
        }).start();
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




