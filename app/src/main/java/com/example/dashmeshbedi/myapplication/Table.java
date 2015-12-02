package com.example.dashmeshbedi.myapplication;

import android.app.DownloadManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
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

import java.util.ArrayList;
import java.util.HashMap;

public class Table extends AppCompatActivity {


    Button btnJSONRequest;
   // TextView tvResult;
    //String url="http://api.football-data.org/alpha/soccerseasons/398/teams";
    String url="http://api.football-data.org/alpha/soccerseasons/398/leagueTable";
    ListView list;
    ArrayList<HashMap<String, String>> list1 = new ArrayList<HashMap<String, String>>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);


     //   tvResult = (TextView)findViewById(R.id.tvResult);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        VolleyHelper.getInstance(getApplicationContext()).addToRequestQueue(jsObjRequest);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
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

    final JsonObjectRequest jsObjRequest = new JsonObjectRequest
            (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject response) {
       //             tvResult.setText("Response: " + response.toString());
                    String textResult = "";
                    String pos,tname
                            ,points,win
                            ,loss
                            ,draw
                            ,pgames;
                    try {
                        JSONArray arrProducts = response.getJSONArray("standing");
                        for(int i=0; i<arrProducts.length(); i++){
                            JSONObject productItem = (JSONObject)arrProducts.get(i);
                            pos= productItem.getString("position") + " ";
                            tname=  productItem.getString("teamName") + " ";
                            points ="Points:" +  productItem.getString("points") + "\n";
                            pgames= "Games Played:" + productItem.getString("playedGames") + " ";
                            win="Wins:" + productItem.getString("wins") + " ";
                            draw="Draws:" + productItem.getString("draws") + " ";
                            loss="Losses:" + productItem.getString("losses") + " ";

                            HashMap<String, String> map = new HashMap<String, String>();

                            map.put("position", pos);
                            map.put("teamName", tname);
                            map.put("points", points);
                            map.put("playedGames", pgames);
                            map.put("wins", win);
                            map.put("draws", draw);
                            map.put("losses", loss);


                            list1.add(map);
                            list = (ListView) findViewById(R.id.list4);

                            ListAdapter adapter = new SimpleAdapter(Table.this, list1,
                                    R.layout.listview4,
                                    new String[]{"position","teamName","points","playedGames","wins","draws","losses"},
                                    new int[]{R.id.po, R.id.tn, R.id.pt,R.id.pg,R.id.wi,R.id.dr,R.id.lo});

                            list.setAdapter(adapter);
                        }
                      //  tvResult.setText(textResult);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    if(error != null) Log.e("MainActi", error.getMessage());

                }
            });

}
