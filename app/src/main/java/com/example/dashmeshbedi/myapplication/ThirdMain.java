package com.example.dashmeshbedi.myapplication;

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


/**
 * used for signup button on login page
 * Created by dashmeshbedi on 17/11/15.
 */
public class ThirdMain extends AppCompatActivity {

    private UserRegisterTask obj = null;

    private static TextView name;
    private static TextView email;
    private static TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_third);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        name = (EditText) findViewById(R.id.editText);
        final String namee = name.getText().toString();
        email = (EditText) findViewById(R.id.editText2);
        final String emaill = email.getText().toString();
        password = (EditText) findViewById(R.id.editText3);
        final String passwordd = password.getText().toString();
        Button RegisterButton = (Button) findViewById(R.id.button2);
        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("hello","sankalp");

                //attemptSignup();
                // Intent myIntent3 = new Intent(ThirdMain.this, ThirdMain.class);
                // LoginActivity.this.startActivity(myIntent3);
                //finish();

                obj = new UserRegisterTask(namee, emaill, passwordd);
                obj.execute((Void) null);
            }

        });

    }

    public class UserRegisterTask extends AsyncTask<Void, Void, Boolean> {
        private final String nName;
        private final String nEmail;
        private final String nPassword;

        UserRegisterTask(String name, String email, String password) {
            nName = name;
            nEmail = email;
            nPassword = password;
            Log.d("IN constructor", "BEDI");
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.
            Log.d("Background", "task");
            try {
                // Simulate network access.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return false;
            }
            // TODO: register the new account here.
            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {

            if (true) {

               // finish();
                Intent myIntent3 = new Intent(ThirdMain.this, MainActivity.class);
                ThirdMain.this.startActivity(myIntent3);
            finish();
            }
        }

    }


}
