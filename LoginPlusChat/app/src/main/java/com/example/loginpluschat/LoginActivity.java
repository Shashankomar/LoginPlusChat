package com.example.loginpluschat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        setListeners();
    }

    private void setListeners() {
        btnLogin.setOnClickListener(view -> {
            if (Objects.equals(etUsername.getText().toString(), "Edunomics") && Objects.equals(etPassword.getText().toString(), "edu1234")) {
                Toast.makeText(LoginActivity.this, "You have Authenticated Successfully", Toast.LENGTH_LONG).show();
                redirectToHome();
            } else {
                Toast.makeText(LoginActivity.this, "Authentication Failed", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void redirectToHome() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    /*
    method of initialization of views
     */
    private void initView() {
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
    }
}
