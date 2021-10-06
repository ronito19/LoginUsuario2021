package com.example.loginusuario2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    TextView txt_email = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        txt_email = (TextView) findViewById(R.id.txt_email);
        Intent intent = getIntent();
        if(intent != null)
        {
            String email = intent.getStringExtra(MainActivity.EXTRA_EMAIL1);
            String password = intent.getStringExtra(MainActivity.EXTRA_PASSWORD1);
            txt_email.setText(email);
            Toast.makeText(this, " BUENOS DIAS " + email, Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this, " DEBES LOGUEARTE ", Toast.LENGTH_LONG).show();
            finish();
        }
    }
}