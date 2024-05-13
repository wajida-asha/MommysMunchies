package com.example.mommysmunchies.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mommysmunchies.MainActivity;
import com.example.mommysmunchies.R;
import com.google.firebase.auth.FirebaseAuth;


@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        firebaseAuth = FirebaseAuth.getInstance();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (firebaseAuth.getCurrentUser() != null) {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                } else {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    finish();
                }


            }
        }, 3000);
            }


    }
