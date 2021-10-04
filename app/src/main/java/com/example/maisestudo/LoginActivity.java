package com.example.maisestudo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;

public class LoginActivity extends AppCompatActivity {
    private EditText edit_email, edit_senha;
    private Button btn_login;
    public List AdmList;
    public Users Users;
    String[] mensagens = {"Preencha todos os campos", "Credenciais Inválidas"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Users = new Users();
        AdmList = new ArrayList();
        AdmList.add("rafaeldinizsoaresreal@gmail.com");
        AdmList.add("diniz@arcom.com");
        AdmList.add("alyssom@arcom.com");
        IniciarComponentes();
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edit_email.getText().toString();
                String password = edit_senha.getText().toString();


                if (email.isEmpty() || password.isEmpty()) {
                    Snackbar snackbar = Snackbar.make(view, mensagens[0], Snackbar.LENGTH_LONG);

                    snackbar.show();
                } else {

                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {


                                    home();





                            } else {
                                Snackbar snackbar = Snackbar.make(view, mensagens[1], Snackbar.LENGTH_LONG);

                                snackbar.show();


                            }
                        }
                    });
                }
            }
        });

    }

    private void IniciarComponentes() {
        edit_email = findViewById(R.id.edit_usuario);
        edit_senha = findViewById(R.id.edit_senha);
        btn_login = findViewById(R.id.btn_login);
        Paper.init(this);


    }

    private void login() {
        String email = edit_email.getText().toString();
        String pass = edit_senha.getText().toString();


    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser useratual = FirebaseAuth.getInstance().getCurrentUser();
        if (useratual != null) {
            home();
        }
    }

    private void home() {
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        intent.putExtra("aList", (Serializable) AdmList);
        intent.putExtra("Users", (Serializable) Users);

        startActivity(intent);

        finish();
    }

    }
