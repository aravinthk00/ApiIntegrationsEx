package com.example.apiintegrationex.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.apiintegrationex.R;
import com.example.apiintegrationex.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.mainNavigationBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.first ) {
                    Log.d(TAG, "onNavigationItemSelected: 1");
                }else if (item.getItemId() == R.id.second ) {
                    Log.d(TAG, "onNavigationItemSelected: 2");
                }
                else if (item.getItemId() == R.id.third ) {
                    Log.d(TAG, "onNavigationItemSelected: 3");
                }
                else if (item.getItemId() == R.id.four ) {
                    Log.d(TAG, "onNavigationItemSelected: 1");
                }
                return true;
            }
        });

       // binding.naviToPhotosFrag.setOnClickListener(view -> {
//            FragmentManager fragmentManager = getSupportFragmentManager();
//            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//            PhotosFragment photosFragment = new PhotosFragment();
//            fragmentTransaction.add(binding.fragmentContainer.getId(),PhotosFragment.class,null,photosFragment.TAG);
//            fragmentTransaction.addToBackStack(photosFragment.getTag());
//            fragmentTransaction.commit();
//        });
    }
}