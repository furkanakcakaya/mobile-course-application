package com.example.mobile30_03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();
    private int loginAttempts = 0;

    Button btn_login;
    TextView tv_login_error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppUsers.populateUsers();
        EditText et_username = findViewById(R.id.et_username);
        EditText et_password = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);
        tv_login_error = findViewById(R.id.tv_login_error);
        Button btn_signup = findViewById(R.id.btn_signup);

        btn_signup.setOnClickListener(view -> registerClicked());

        btn_login.setOnClickListener(view -> loginClicked(et_username.getText().toString(), et_password.getText().toString()));
    }

    private void registerClicked() {
        Log.d(LOG_TAG, "Register clicked!");
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    private void loginClicked(String username, String password) {
        Log.d(LOG_TAG, "Login clicked!");
        if (loginAttempts++ >= 2){
            btn_login.setVisibility(View.GONE);
            tv_login_error.setVisibility(View.VISIBLE);
        }
        int login = AppUsers.tryToLogin(username,password);
        System.out.println(login);
        if (login > 0){
            Intent intent = new Intent(this, HomeActivity.class);
            intent.putExtra("userId",  login);
            intent.putExtra("type",  "Giriş");
            startActivity(intent);
            finish();
        }else{
            Toast.makeText(this, R.string.login_failed, Toast.LENGTH_SHORT).show();
        }

    }
}

