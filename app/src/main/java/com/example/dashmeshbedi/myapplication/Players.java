package com.example.dashmeshbedi.myapplication;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dashmeshbedi.myapplication.JSONParser;
import com.example.dashmeshbedi.myapplication.MainActivity;
import com.example.dashmeshbedi.myapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Players extends AppCompatActivity {

    ListView list;
    TextView id;
    TextView name;
    TextView position;
    Button Btngetdata;
    ArrayList<HashMap<String, String>> list1 = new ArrayList<HashMap<String, String>>();
    String url;
    String dreamteamid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        if(extras == null) {
            url= null;
        } else {
            url= extras.getString("url");
        }
        setContentView(R.layout.activity_players);
        list1 = new ArrayList<HashMap<String, String>>();
        //Btngetdata = (Button)findViewById(R.id.getdata);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        new JSONParse().execute();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    //String url = "http://api.football-data.org/alpha/teams/66/players";


    //JSONParser jsonParser = new JSONParser();
    //JSONObject object = jsonParser.getJSONFromUrl(url);

    // String content=object.getString("json key");


    // System.out.println("*****JARRAY*****" + jArray.length());


    // String content=object.getString("players");
    private static final String TAG_PLAYERS = "players";
    private static final String TAG_ID = "id";
    private static final String TAG_NAME = "name";
    private static final String TAG_POSITION = "position";
    private static final String TAG_JERSEYNO = "jerseyNumber";
    private static final String TAG_DOB = "dateOfBirth";
    private static final String TAG_NATIONALITY = "nationality";
    private static final String TAG_CONTRACT = "contractUntil";
    private static final String TAG_MARKETVALUE = "marketValue";
    JSONArray user = null;

    TextView uid;
    TextView name1;
    TextView pos1;

    private class JSONParse extends AsyncTask<String, String, JSONObject> {
        private ProgressDialog pDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//            uid = (TextView) findViewById(R.id.is);
 //           name1 = (TextView) findViewById(R.id.name);
 //           pos1 = (TextView) findViewById(R.id.position);
            pDialog = new ProgressDialog(Players.this);
            pDialog.setMessage("Getting Data ...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();

        }

        @Override
        protected JSONObject doInBackground(String... args) {
            JSONParser jParser = new JSONParser();

            // Getting JSON from URL
            JSONObject json = jParser.getJSONFromUrl(url);
            return json;
        }

        @Override
        protected void onPostExecute(JSONObject json) {
            pDialog.dismiss();

            try {
                // Getting JSON Array
                user = json.getJSONArray(TAG_PLAYERS);
                //JSONObject c = user.getJSONObject(0);
                for (int i = 0; i < user.length(); i++) {
                    JSONObject c = user.getJSONObject(i);
                    String id = c.getString(TAG_ID);
                    String name = c.getString(TAG_NAME);
                    String pos = c.getString(TAG_POSITION);
                    // items.add(name);
                    Log.d(name, "Output");
                    HashMap<String, String> map = new HashMap<String, String>();

                    map.put(TAG_ID, id);
                    map.put(TAG_NAME, name);
                    map.put(TAG_POSITION, pos);
                    list1.add(map);
                    list = (ListView) findViewById(R.id.list2);

                    ListAdapter adapter = new SimpleAdapter(Players.this, list1,
                            R.layout.listview2,
                            new String[]{TAG_ID, TAG_NAME, TAG_POSITION}, new int[]{
                            R.id.is, R.id.name, R.id.position});

                    list.setAdapter(adapter);
                    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view,
                                                int position, long id) {

                            Toast.makeText(Players.this, "You Clicked at " + list1.get(+position).get("id"), Toast.LENGTH_SHORT).show();
                            //dreamteamid+=list1.get(+position).get("id")+ "_";
                            //Log.d("dreamteamid", dreamteamid);
                        }
                    });
                    //Storing  JSON item in a Variable
                    //String id = c.getString(TAG_ID);
                    //String name = c.getString(TAG_NAME);
                    //String pos = c.getString(TAG_POSITION);
                    //Set JSON Data in TextView

                    //uid.setText(id);
                    //name1.setText(name);
                    //pos1.setText(pos);

                }
            }catch (JSONException e) {
                e.printStackTrace();
            }

    //        Log.d("dreamteamid", dreamteamid);

        }

    }
}