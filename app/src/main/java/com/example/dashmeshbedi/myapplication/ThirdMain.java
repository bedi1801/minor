package com.example.dashmeshbedi.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


/**
 * used for signup button on login page
 * Created by dashmeshbedi on 17/11/15.
 */
public class ThirdMain extends AppCompatActivity {

   // private UserRegisterTask obj = null;

    TextView name;
    TextView email;
    TextView password;
    TextView dob;
    TextView mobile;
    TextView ques;
    TextView ans;
    ConnectionClass connectionClass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_third);
        connectionClass = new ConnectionClass();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        name = (EditText) findViewById(R.id.name);

        email = (EditText) findViewById(R.id.email);

        password = (EditText) findViewById(R.id.password);

        dob = (EditText) findViewById(R.id.dob);

        mobile = (EditText) findViewById(R.id.mobile);

        ques = (EditText) findViewById(R.id.ques);

        ans = (EditText) findViewById(R.id.ans);

        Button RegisterButton = (Button) findViewById(R.id.button2);
        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Log.d("hello","sankalp");

                //attemptSignup();
                 Intent myIntent3 = new Intent(ThirdMain.this, LoginActivity.class);
                 startActivity(myIntent3);
                //finish();

               // obj = new UserRegisterTask(namee, emaill, passwordd,mobilee,quess,anss,dobb);
                UserRegisterTask obj = new UserRegisterTask();
                obj.execute("");

            }

        });

    }

    class UserRegisterTask extends AsyncTask<String, String, String> {

        Boolean isSuccess = false;
        String z = "";

        String namee = name.getText().toString();
         String emaill = email.getText().toString();
         String passwordd = password.getText().toString();
         String dobb = dob.getText().toString();
         String mobilee = mobile.getText().toString();
         String quess = ques.getText().toString();
         String anss = ans.getText().toString();

      /*  UserRegisterTask() {

            Log.d("Name", namee);

            Log.d("IN constructor", "BEDI");
        }
*/

        Connection con = connectionClass.CONN();


        @Override
        protected void onPreExecute() {
            ProgressDialog pDialog;
            pDialog = new ProgressDialog(ThirdMain.this);
            pDialog.setMessage("Going to Login Page  ...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        Log.d("ad","asd");
        }

        @Override
        protected String doInBackground(String... params) {

            if (namee.trim().equals("") || passwordd.trim().equals("") || emaill.trim().equals("") || dobb.trim().equals("") || quess.trim().equals("") || anss.trim().equals("")) {
            //   z = "Please enter User Id and Password";
            Log.d("Enter username ","and id ");
            }

            else{
                try {
                    Log.d("try", "try");


                    if (con == null) {
                        z = "Error in connection with SQL server";
                        Log.d("Error connection", z);
                    } else {
                        Log.d("TRY", "query not work");
                        String query = "insert into User_Detail (Email_Id,Name,Password,Mobile_no,Security_question,Security_answer,Date_of_birth) values ('" + emaill + "','" + namee + "','" + passwordd + "','" + mobilee + "','" + quess + "','" + anss + "','" + dobb + "' )";
                        PreparedStatement preparedStatement = con.prepareStatement(query);
                        preparedStatement.executeUpdate();

                       // Statement stmt = con.createStatement();
                       // ResultSet rs = stmt.executeQuery(query);

                        z = "Added Successfully";
                        isSuccess = true;
                        Log.d("query true ", "true");
                    }
                }
                catch (Exception ex) {
                    Log.d("ecevvt", "er");
                    isSuccess = false;
                    z = "Exceptions";
                }
            }
            return z;
            //return true;
        }


        @Override
        protected void onPostExecute(String s) {

            Log.d("post", z);
        }

    }


}
