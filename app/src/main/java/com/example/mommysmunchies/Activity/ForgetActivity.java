package com.example.mommysmunchies.Activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mommysmunchies.R;
import com.example.mommysmunchies.databinding.ActivityForgetBinding;

public class ForgetActivity extends AppCompatActivity {
    private ActivityForgetBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityForgetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnBack.setOnClickListener(view -> {
            onBackPressed();
        });
    }
}