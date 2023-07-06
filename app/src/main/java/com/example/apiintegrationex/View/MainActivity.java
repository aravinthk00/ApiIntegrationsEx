package com.example.apiintegrationex.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import com.example.apiintegrationex.R;
import com.example.apiintegrationex.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.naviToPhotosFrag.setOnClickListener(view -> {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            PhotosFragment photosFragment = new PhotosFragment();
            fragmentTransaction.add(binding.fragmentContainer.getId(),PhotosFragment.class,null,photosFragment.TAG);
            fragmentTransaction.addToBackStack(photosFragment.getTag());
            fragmentTransaction.commit();
        });
    }
}