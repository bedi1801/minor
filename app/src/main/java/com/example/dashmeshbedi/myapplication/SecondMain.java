package com.example.dashmeshbedi.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.logging.Logger;

public class SecondMain extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public String userid1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        userid1 = extras.getString("Name");

        setContentView(R.layout.activity_second_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.d("name",userid1);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
          //  super.onBackPressed();
            Toast.makeText(SecondMain.this, "Back button disabled \n Please logout !!!!!!", Toast.LENGTH_SHORT).show();

            //moveTaskToBack(true);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.second_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.mydetails) {

            Intent inten=new Intent(SecondMain.this,MyDetails.class);
            inten.putExtra("Name",userid1);
            startActivity(inten);

        } else if (id == R.id.mydreamteam) {

        } else if (id == R.id.checkpoint) {

        }else if (id == R.id.teams) {
            startActivity(new Intent(SecondMain.this, Allteams.class));

        }

        else if (id == R.id.fixtures) {
            startActivity(new Intent(SecondMain.this, Fixtures.class));

        }
        else if (id == R.id.leaguet) {
            startActivity(new Intent(SecondMain.this, Table.class));

        }
        else if (id == R.id.news) {
            startActivity(new Intent(SecondMain.this, NewsFeed.class));

        }
        else if (id == R.id.rules) {
            startActivity(new Intent(SecondMain.this, Rules.class));

        }
        else if (id == R.id.about) {
            startActivity(new Intent(SecondMain.this, AboutUs.class));

        }
        else if (id == R.id.logout) {
            startActivity(new Intent(SecondMain.this,MainActivity.class));
            Toast.makeText(SecondMain.this, "logout successful!!!!!!", Toast.LENGTH_SHORT).show();


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
