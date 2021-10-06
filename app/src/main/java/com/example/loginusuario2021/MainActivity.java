package com.example.loginusuario2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_EMAIL1 = "perucho.ronito.MainActivity.email";
    public static final String EXTRA_PASSWORD1 = "perucho.ronito.M;ainActivity.password";
    EditText edt_email = null;
    EditText edt_password = null;
    String usuarioSecreto = "ronito@gmail.com";
    String claveSecreta = "1234";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_email = (EditText) findViewById(R.id.edt_email);
        edt_password = (EditText) findViewById(R.id.edt_password);
    }

    public void entrar(View view) {
        //Button b = (Button) view;
        //b.setText("prueba");
        String email = String.valueOf(edt_email.getText());
        String password = String.valueOf(edt_password.getText());
        boolean validarOK = validar(email, password);
        if(validarOK)
        {
            Intent intent = new Intent(this, HomeActivity.class);
            intent.putExtra(EXTRA_EMAIL1, email);
            intent.putExtra(EXTRA_PASSWORD1, password);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, " Error en el E-mail o en el Password ", Toast.LENGTH_LONG).show();
        }
    }

    private boolean validar(String email, String password) {
        if(email.isEmpty())
        {
            edt_email.setError(" Debes poner un E-mail ");
            return false;
        }
        if(password.isEmpty())
        {
            edt_password.setError(" Debes escribir un Password ");
            return false;
        }
        if(email.equalsIgnoreCase(usuarioSecreto) && password.equals(claveSecreta))
        {
            return true;
        }

        return false;
    }
}