package com.example.dashmeshbedi.myapplication;

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

import java.util.ArrayList;
import java.util.HashMap;

public class Fixtures extends AppCompatActivity {

    //Button btnJSONRequest;
    TextView tvResult;
    ListView list;
    ArrayList<HashMap<String, String>> list1 = new ArrayList<HashMap<String, String>>();
    String url="http://api.football-data.org/alpha/soccerseasons/398/fixtures";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixtures);
      //  list1 = new ArrayList<HashMap<String, String>>();
        //tvResult = (TextView)findViewById(R.id.tvResult);
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
                    //tvResult.setText("Response: " + response.toString());
                    String textResult = "";
                    //JSONObject arr2;
                    String date,matchday,home,hgoals,away,agoals;
                    try {
                        JSONArray arrProducts = response.getJSONArray("fixtures");
                        for(int i=0; i<arrProducts.length(); i++){
                            JSONObject productItem = (JSONObject)arrProducts.get(i);
                            date =" Date : "+  productItem.getString("date") + " ";
                            matchday ="Matchday : " + productItem.getString("matchday") + " ";
                            JSONObject productItem2 = productItem.getJSONObject("result");
                            home =  productItem.getString("homeTeamName") + " ";
                            hgoals=productItem2.getString("goalsHomeTeam") + " ";
                            away =  productItem.getString("awayTeamName") + " ";
                            agoals =productItem2.getString("goalsAwayTeam") + " ";

                            // textResult +=  productItem.getString("result") + "\n";
                            // arr2 =  productItem.getJSONObject("result") + "\n";
                           // textResult+=productItem
                            HashMap<String, String> map = new HashMap<String, String>();
                            //int mday;
                            ///mday = Integer.parseInt(matchday);

                                map.put("date", date);
                                map.put("matchday", matchday);
                                map.put("homeTeamName", home);
                                map.put("goalsHomeTeam", hgoals);
                                map.put("awayTeamName", away);
                                map.put("goalsAwayTeam", agoals);

                                list1.add(map);
                                list = (ListView) findViewById(R.id.list3);

                                ListAdapter adapter = new SimpleAdapter(Fixtures.this, list1,
                                        R.layout.listview3,
                                        new String[]{"date", "matchday", "homeTeamName", "goalsHomeTeam", "awayTeamName", "goalsAwayTeam"},
                                        new int[]{R.id.dt, R.id.md, R.id.ht, R.id.hg, R.id.at, R.id.ag});

                                list.setAdapter(adapter);




                               // continue;



                        }
                        //tvResult.setText(textResult);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    if(error != null) Log.e("Fixtures", error.getMessage());

                }
            });


}
