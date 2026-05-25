package com.example.applogin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class activity_registrar extends AppCompatActivity {

    EditText edNome, edUser, edPass1, edPass2;
    Button btSalvar;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        db = new DBHelper(this);

        edNome = findViewById(R.id.edNome);
        edUser = findViewById(R.id.edUser);
        edPass1 = findViewById(R.id.edPass1);
        edPass2 = findViewById(R.id.edPass2);

        btSalvar = findViewById(R.id.btSalvar);

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = edUser.getText().toString();
                String pass1 = edPass1.getText().toString();
                String pass2 = edPass2.getText().toString();

                if(username.equals("")){

                    Toast.makeText(activity_registrar.this,
                            "Digite o usuário",
                            Toast.LENGTH_SHORT).show();

                } else if(pass1.equals("") || pass2.equals("")){

                    Toast.makeText(activity_registrar.this,
                            "Digite a senha",
                            Toast.LENGTH_SHORT).show();

                } else if(!pass1.equals(pass2)){

                    Toast.makeText(activity_registrar.this,
                            "As senhas não coincidem",
                            Toast.LENGTH_SHORT).show();

                } else {

                    long resultado = db.criarUtilizador(username, pass1);

                    if(resultado > 0){

                        Toast.makeText(activity_registrar.this,
                                "Cadastro realizado!",
                                Toast.LENGTH_SHORT).show();

                    } else {

                        Toast.makeText(activity_registrar.this,
                                "Erro ao cadastrar",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}