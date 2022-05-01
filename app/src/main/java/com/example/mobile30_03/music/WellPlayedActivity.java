package com.example.mobile30_03.music;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.mobile30_03.R;
import com.example.mobile30_03.databinding.ActivityWellPlayedBinding;

public class WellPlayedActivity extends AppCompatActivity {
    private ActivityWellPlayedBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWellPlayedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.navHost);
        NavigationUI.setupWithNavController(binding.bottomBarWP, navHostFragment.getNavController());
    }
}