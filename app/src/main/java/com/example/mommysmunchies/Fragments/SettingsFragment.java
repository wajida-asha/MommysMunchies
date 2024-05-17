package com.example.mommysmunchies.Fragments;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mommysmunchies.Constant.AllConstant;
import com.example.mommysmunchies.Permissions.AppPermissions;
import com.example.mommysmunchies.R;
import com.example.mommysmunchies.Utility.LoadingDialog;
import com.example.mommysmunchies.databinding.FragmentSettingsBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class SettingsFragment extends Fragment {

    private FragmentSettingsBinding binding;
    private FirebaseAuth firebaseAuth;
    private LoadingDialog loadingDialog;
    private AppPermissions appPermissions;
    private Uri imageUri;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        firebaseAuth = FirebaseAuth.getInstance();
        loadingDialog = new LoadingDialog(getActivity());


        return binding.getRoot();
    }

    private void pickImage() {

        CropImage.activity()
                .setCropShape(CropImageView.CropShape.OVAL)
                .start(requireContext(), this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).setTitle("Settings");
        binding.txtEmail.setText(Objects.requireNonNull(firebaseAuth.getCurrentUser()).getEmail());
        binding.txtUsername.setText(firebaseAuth.getCurrentUser().getDisplayName());

        Glide.with(requireContext()).load(firebaseAuth.getCurrentUser().getPhotoUrl()).into(binding.imgProfile);

        if (firebaseAuth.getCurrentUser().isEmailVerified()) {
            binding.txtEEmail.setVisibility(View.GONE);
        } else {
            binding.txtEEmail.setVisibility(View.VISIBLE);
        }

        binding.txtEEmail.setOnClickListener(verify -> {
            firebaseAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(getContext(), "Mail sent verify the email", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), "" + task.getException(), Toast.LENGTH_SHORT).show();
                        Log.d("TAG", "onComplete: profile email " + task.getException());
                    }
                }
            });
        });


    }



    }
