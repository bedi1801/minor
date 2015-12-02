package com.example.dashmeshbedi.myapplication;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class DreamTeam extends AppCompatActivity {
      String userid2;
    ListView list;
    ArrayList<HashMap<String, String>> list1 = new ArrayList<HashMap<String, String>>();
    ConnectionClass connectionClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dream_team);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle extras = getIntent().getExtras();
        userid2 = extras.getString("Name");

        connectionClass = new ConnectionClass();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        showTeam show = new showTeam();
        show.execute("");

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                //this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public class showTeam extends AsyncTask<String,String,String>
    {

        String emailid2;
        String gk,lcb,lb,lwm,rb,rcb,rwm,rst,lst,cam,cdm;

        String z = "";
        Boolean isSuccess = false;
        //String name = name.getText().toString();
        //String email = email.getText().toString();
        @Override
        protected void onPreExecute() {

        }
        @Override
        protected void onPostExecute(String r) {
            Toast.makeText(DreamTeam.this, r, Toast.LENGTH_SHORT).show();
            if(isSuccess) {


                HashMap<String, String> map = new HashMap<String, String>();

                map.put("GK", gk);
                map.put("RB", rb);
                map.put("RCB", rcb);
                map.put("LCB", lcb);
                map.put("LB", lb);
                map.put("CDM", cdm);
                map.put("LWM", lwm);
                map.put("RWM", rwm);
                map.put("CAM", cam);
                map.put("LST", lst);
                map.put("RST", rst);

                list1.add(map);
                list = (ListView) findViewById(R.id.list5);

                ListAdapter adapter = new SimpleAdapter(DreamTeam.this, list1,
                        R.layout.listview5,
                        new String[]{"GK","RB","RCB","LCB","LB","CDM","RWM","LWM","CAM","RST","LST"},
                        new int[]{R.id.gk, R.id.rb, R.id.rcb,R.id.lcb,R.id.lb,R.id.cdm,R.id.rwm,R.id.lwm,R.id.cam,R.id.rst,R.id.lst});

                list.setAdapter(adapter);

            }
        }
        @Override
        protected String doInBackground(String... params) {
            //String emailid2;
            Log.d("SHowteam class", "DO in background");
            try {
                Connection con = connectionClass.CONN();
                if (con == null) {

                    z = "Error in connection with SQL server";
                } else {
                    Log.d("userid2 in else",userid2);

                    String query = "select Email_Id from User_Detail where Name='" + userid2 +"'" ;
                    Statement stmt2 = con.createStatement();
                    ResultSet rs2 = stmt2.executeQuery(query);
                    Log.d("RS rs2","query");

                    while(rs2.next()) {

                        emailid2 = rs2.getString("Email_Id");

                    }
                    Log.d("Emaild is ",emailid2);

                    String query2 = "select * from DreamTeam where Email_Id='" + emailid2 +"'" ;
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(query2);
                    Log.d("After query2","RS");
                    while(rs.next()) {


                        gk=rs.getString("GK");
                        rb=rs.getString("RB");
                        rcb=rs.getString("RCB");
                        lcb=rs.getString("LCB");
                        lb=rs.getString("LB");
                        cdm=rs.getString("CDM");
                        rwm=rs.getString("RWM");
                        lwm=rs.getString("LWM");
                        cam=rs.getString("CAM");
                        rst=rs.getString("RS");
                        lst=rs.getString("LS");

                        Log.d("gk",gk);


                        isSuccess = true;
                    }

                    this.publishProgress(emailid2);
                }
            }
            catch (Exception ex)
            {
                isSuccess = false;
                z = "Exceptions";
            }

            return "Done";
        }
        @Override
        protected void onProgressUpdate(String... values)
        {
            super.onProgressUpdate(values);

            /*Log.d("On progress Update before text view ",email1);
            TextView ema = (TextView) findViewById(R.id.email);
            Log.d("On progress Update after text view ",email1);
            ema.setText(values[0]);
            */
        }



    }










}
