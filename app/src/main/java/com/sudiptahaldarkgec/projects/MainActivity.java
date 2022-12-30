package com.sudiptahaldarkgec.projects;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    RecyclerView recyclerView;
    CustomAdapter customAdapter;
    String []titles;

    private long pressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.mainToolBarId);
        drawerLayout = findViewById(R.id.drawerLayId);
        navigationView = findViewById(R.id.NavigationViewId);

        recyclerView = findViewById(R.id.mainRecycleViewId);


        toolbar.setTitle("ALL IN ONE");
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.firstId) {
                    Toast.makeText(MainActivity.this, "touch on first", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.shareAppId2) {
                    Toast.makeText(MainActivity.this, "touch on share", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "touched", Toast.LENGTH_SHORT).show();
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });



        titles = new String[]{
                "Vibrator",
                "Brightness Control",
                "Torch",
                "Phone Details",
                "Call or save number",
                "Try more"



        };

        customAdapter = new CustomAdapter(this, titles);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(customAdapter);


    }

    @Override
    public void onBackPressed() {


        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            if (pressedTime + 1500 > System.currentTimeMillis()) {
                super.onBackPressed();
                finish();
            } else {
                Toast.makeText(getBaseContext(), "PRESS BACK AGAIN TO EXIT", Toast.LENGTH_SHORT).show();
            }
            pressedTime = System.currentTimeMillis();

        }


    }
}