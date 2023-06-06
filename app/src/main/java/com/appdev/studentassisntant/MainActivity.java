package com.appdev.studentassisntant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawer;
    private NavigationView nvDrawer;
    private Boolean drawerOpen = false;
    private ImageButton drawerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nvDrawer = findViewById(R.id.actualDrawer);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        mDrawer = findViewById(R.id.drawerLayout);
        drawerButton = findViewById(R.id.drawerButton);
        drawerButton.setOnClickListener(v -> {
            if (drawerOpen) {
                mDrawer.closeDrawer(Gravity.LEFT);
            } else {
                mDrawer.openDrawer(Gravity.LEFT);
            }
        });
        setupDrawerContent(nvDrawer);
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, new dashBoard()).commit();
    }

    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        FragmentManager fragmentManager = getSupportFragmentManager();

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        mDrawer.closeDrawers();
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
            menuItem -> {
                selectDrawerItem(menuItem);
                return true;
            });
    }
}