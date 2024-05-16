package com.example.mommysmunchies.Activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.mommysmunchies.R;
import com.example.mommysmunchies.databinding.ActivityMainBinding;
import com.example.mommysmunchies.databinding.NavDrawerLayoutBinding;
import com.example.mommysmunchies.databinding.ToolbarLayoutBinding;
import com.google.firebase.auth.FirebaseAuth;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    private NavDrawerLayoutBinding navDrawerLayoutBinding;
    private ActivityMainBinding activityMainBinding;
    private ToolbarLayoutBinding toolbarLayoutBinding;
    private FirebaseAuth firebaseAuth;
    private CircleImageView imgHeader;
    private TextView txtName, txtEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        navDrawerLayoutBinding = NavDrawerLayoutBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(navDrawerLayoutBinding.getRoot());

        activityMainBinding = navDrawerLayoutBinding.mainActivity;
        toolbarLayoutBinding = activityMainBinding.toolbar;

        setSupportActionBar(toolbarLayoutBinding.toolbar);

        firebaseAuth = FirebaseAuth.getInstance();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                navDrawerLayoutBinding.navDrawer,
                toolbarLayoutBinding.toolbar,
                R.string.open_navigation_drawer,
                R.string.close_navigation_drawer
        );
        navDrawerLayoutBinding.navDrawer.addDrawerListener(toggle);
        toggle.syncState();
        NavController navController = Navigation.findNavController(this, R.id.fragmentContainer);
        NavigationUI.setupWithNavController(
                navDrawerLayoutBinding.navigationView,
                navController
        );

    }
}