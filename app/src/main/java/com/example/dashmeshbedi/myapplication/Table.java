package com.example.dashmeshbedi.myapplication;

import android.app.DownloadManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Table extends AppCompatActivity {


    Button btnJSONRequest;
    TextView tvResult;
    //String url="http://api.football-data.org/alpha/soccerseasons/398/teams";
    String url="http://api.football-data.org/alpha/soccerseasons/398/leagueTable";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);


        tvResult = (TextView)findViewById(R.id.tvResult);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        VolleyHelper.getInstance(getApplicationContext()).addToRequestQueue(jsObjRequest);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    final JsonObjectRequest jsObjRequest = new JsonObjectRequest
            (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject response) {
                    tvResult.setText("Response: " + response.toString());
                    String textResult = "";
                    try {
                        JSONArray arrProducts = response.getJSONArray("standing");
                        for(int i=0; i<arrProducts.length(); i++){
                            JSONObject productItem = (JSONObject)arrProducts.get(i);
                            textResult += productItem.getString("position") + " ";
                            textResult += productItem.getString("teamName") + " ";
                            textResult +=  productItem.getString("points") + "\n";
                        }
                        tvResult.setText(textResult);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    if(error != null) Log.e("MainActivity", error.getMessage());

                }
            });

}
