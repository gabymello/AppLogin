package com.example.applogin;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class activity_login extends AppCompatActivity {

    EditText edLogin, edPass;
    Button btLogin;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DBHelper(this);

        edLogin = findViewById(R.id.edLogin);
        edPass = findViewById(R.id.edPass);
        btLogin = findViewById(R.id.btLogin);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = edLogin.getText().toString();
                String password = edPass.getText().toString();

                if(username.equals("")){

                    Toast.makeText(activity_login.this,
                            "Digite o usuário",
                            Toast.LENGTH_SHORT).show();

                } else if(password.equals("")){

                    Toast.makeText(activity_login.this,
                            "Digite a senha",
                            Toast.LENGTH_SHORT).show();

                } else {

                    String resultado = db.validarLogin(username,password);

                    if(resultado.equals("OK")){

                        Toast.makeText(activity_login.this,
                                "Login realizado!",
                                Toast.LENGTH_SHORT).show();

                    } else {

                        Toast.makeText(activity_login.this,
                                "Usuário ou senha incorretos",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}