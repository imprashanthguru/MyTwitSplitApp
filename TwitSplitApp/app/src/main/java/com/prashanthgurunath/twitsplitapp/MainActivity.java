package com.prashanthgurunath.twitsplitapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView zaloraWebsiteNavHeaderTexxtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, new ChatFragment());
        fragmentTransaction.commit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home_id) {

            ChatFragment chatFragment=new ChatFragment();
            getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.enter_anim,R.anim.exit_anim,R.anim.pop_enter,R.anim.pop_exit)
                    .replace(R.id.content_frame,chatFragment)
            .addToBackStack(null)
                    .commit();


        } else if (id == R.id.nav_about_id) {

            AboutFragment aboutFragment=new AboutFragment();
            getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.enter_anim,R.anim.exit_anim,R.anim.pop_enter,R.anim.pop_exit)
                    .replace(R.id.content_frame,aboutFragment)
                    .addToBackStack(null)
                    .commit();

        } else if (id == R.id.nav_featured_brands_id) {

            FeaturedBrandFragment featuredBrandFragment=new FeaturedBrandFragment();
            getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.enter_anim,R.anim.exit_anim,R.anim.pop_enter,R.anim.pop_exit)
                    .replace(R.id.content_frame,featuredBrandFragment)
                    .addToBackStack(null)
                    .commit();


        } else if (id == R.id.nav_contact_us_id) {

            ContactUsFragment contactUsFragment=new ContactUsFragment();
            getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.enter_anim,R.anim.exit_anim,R.anim.pop_enter,R.anim.pop_exit)
                    .replace(R.id.content_frame,contactUsFragment)
                    .addToBackStack(null)
                    .commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onWebsiteNavHeaderclick(View view) {
        zaloraWebsiteNavHeaderTexxtView=findViewById(R.id.zalora_website_nav_page_text_view_id);


        // to open the webpage on clicking the website link in the nav header

        zaloraWebsiteNavHeaderTexxtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.view_onclick_anim));

                Intent openBrowserIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(getResources().getString(R.string.zalora_website_link)));
                startActivity(openBrowserIntent);
            }
        });

    }
}
