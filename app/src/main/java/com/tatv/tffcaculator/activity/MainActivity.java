package com.tatv.tffcaculator.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.tatv.tffcaculator.R;
import com.tatv.tffcaculator.fragment.AboutUsFragment;
import com.tatv.tffcaculator.fragment.CurrencyFragment;
import com.tatv.tffcaculator.fragment.LenghtFragment;
import com.tatv.tffcaculator.fragment.StandardFragment;
import com.tatv.tffcaculator.fragment.TempFragment;
import com.tatv.tffcaculator.fragment.VolumeFragment;
import com.tatv.tffcaculator.fragment.WeightFragment;


public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawer;
    private ActionBarDrawerToggle drawerToggle;
    private Toolbar toolbar;
    private NavigationView nvDrawer;
    private FragmentManager fragmentManager;
    private StandardFragment standardFragment;
    private TempFragment tempFragment;
    private WeightFragment weightFragment;
    private CurrencyFragment currencyFragment;
    private LenghtFragment lenghtFragment;
    private VolumeFragment volumeFragment;
    private AboutUsFragment aboutUsFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        mDrawer = findViewById(R.id.drawer_layout);
        nvDrawer = findViewById(R.id.nav_view);

        View view  = nvDrawer.getHeaderView(0);

        setSupportActionBar(toolbar);
        drawerToggle = new ActionBarDrawerToggle(MainActivity.this, mDrawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        nvDrawer.setItemIconTintList(null);
        // Setup drawer view
        setupDrawerContent(nvDrawer);
        //create
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction tranControl = fragmentManager.beginTransaction();
        standardFragment = new StandardFragment();
        tranControl.replace(R.id.flContent, standardFragment);
        tranControl.commit();

    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }


    public void selectDrawerItem(MenuItem menuItem) {
        switch(menuItem.getItemId()) {
            case R.id.nav_standard:
                FragmentTransaction tranStandart = fragmentManager.beginTransaction();
                tranStandart.replace(R.id.flContent, new StandardFragment()).commit();
                menuItem.setChecked(true);
                mDrawer.closeDrawers();
                break;
            case R.id.nav_temp:
                FragmentTransaction tranTemp = fragmentManager.beginTransaction();
                tranTemp.replace(R.id.flContent, new TempFragment()).commit();
                menuItem.setChecked(true);
                mDrawer.closeDrawers();
                break;
            case R.id.nav_weight:
                FragmentTransaction tranWeight = fragmentManager.beginTransaction();
                tranWeight.replace(R.id.flContent, new WeightFragment()).commit();
                menuItem.setChecked(true);
                mDrawer.closeDrawers();
                break;
            case R.id.nav_currency:
                FragmentTransaction tranCurrency = fragmentManager.beginTransaction();
                tranCurrency.replace(R.id.flContent, new CurrencyFragment()).commit();
                menuItem.setChecked(true);
                mDrawer.closeDrawers();
                break;
            case R.id.nav_length:
                FragmentTransaction tranDashboard = fragmentManager.beginTransaction();
                tranDashboard.replace(R.id.flContent, new LenghtFragment()).commit();
                menuItem.setChecked(true);
                mDrawer.closeDrawers();
                break;
            case R.id.nav_volume:
                FragmentTransaction tranVolume = fragmentManager.beginTransaction();
                tranVolume.replace(R.id.flContent, new VolumeFragment()).commit();
                menuItem.setChecked(true);
                mDrawer.closeDrawers();
                break;
            case R.id.nav_us:
                FragmentTransaction tranAbout = fragmentManager.beginTransaction();
                tranAbout.replace(R.id.flContent, new AboutUsFragment()).commit();
                menuItem.setChecked(true);
                mDrawer.closeDrawers();
                break;
            case R.id.nav_exit:
                finish();
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}
