package com.example.dashmeshbedi.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MyDetails extends AppCompatActivity {
    public String userid2;
    String email1,name1,dob1,mobile1,ques1,ans1,dream1,coins1,lock1,ponitsweek1,pointslead1;
    private ListView listView;
    ConnectionClass connectionClass;
    private TextView name , ema;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        userid2 = extras.getString("Name");
        setContentView(R.layout.activity_my_details);
        listView = (ListView) findViewById(R.id.listView1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        connectionClass = new ConnectionClass();
        name = (TextView) findViewById(R.id.name);
        ema = (TextView) findViewById(R.id.email);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Log.d("name", userid2);

        Details details = new Details();
        details.execute("");


    }

    public class Details extends AsyncTask<String,String,String>
    {
        String z = "";
        Boolean isSuccess = false;
        //String name = name.getText().toString();
        //String email = email.getText().toString();
        @Override
        protected void onPreExecute() {

        }
        @Override
        protected void onPostExecute(String r) {
            Toast.makeText(MyDetails.this,r,Toast.LENGTH_SHORT).show();
            if(isSuccess) {

                Log.d("on post execute email", email1);
               // TextView ema = (TextView) findViewById(R.id.email);
               // ema.setText(email1);
            finish();
            }
        }
        @Override
        protected String doInBackground(String... params) {

                try {
                    Connection con = connectionClass.CONN();
                    if (con == null) {
                        z = "Error in connection with SQL server";
                    } else {
                        String query = "select * from User_Detail where Name='" + userid2 +"'" ;
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(query);
                        while(rs.next()) {

                            email1 = rs.getString("Email_Id");
                            name1 = rs.getString("Name");
                            mobile1 = rs.getString("Mobile_no");
                            ques1 = rs.getString("Security_question");
                            ans1 = rs.getString("Security_answer");
                            dob1 = rs.getString("Date_of_birth");
                            dream1 = rs.getString("Dream_Team");
                            ponitsweek1 = rs.getString("Points_Week");
                            pointslead1 = rs.getString("Points_LeaderBoard");
                            lock1 = rs.getString("Lock_Status");
                            coins1 = rs.getString("Coins");
                            Log.d("email1",email1);
                            Log.d("Coins",coins1);
                            isSuccess = true;
                        }

                        this.publishProgress(email1);
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
            Log.d("On progress Update before text view ",email1);
            TextView ema = (TextView) findViewById(R.id.email);
            Log.d("On progress Update after text view ",email1);
           // ema.setText(values[0]);

        }



        }
    }











