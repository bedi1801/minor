package com.example.dashmeshbedi.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Allteams extends AppCompatActivity {

    ListView list;
    //TextView id;
    //TextView name;

    //TextView position;
    private static final String TAG_NAME = "name";
    private static final String TAG_CODE = "code";
    ArrayList<HashMap<String, String>> list1 = new ArrayList<HashMap<String, String>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allteams);
        list1 = new ArrayList<HashMap<String, String>>();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //new JSONParse().execute();


        //String url = "http://api.football-data.org/alpha/soccerseasons/398/teams";

        //private static final String TAG_TEAMS = "teams";
      //  private static final String TAG_NAME = "name";
       // private static final String TAG_CODE = "code";
        //private static final String TAG_JERSEYNO = "jerseyNumber";
        //private static final String TAG_DOB = "dateOfBirth";
        //private static final String TAG_NATIONALITY = "nationality";
        //private static final String TAG_CONTRACT = "contractUntil";
        //private static final String TAG_MARKETVALUE = "marketValue";
        //JSONArray user = null;

        //TextView uid;


        TextView name1;
        TextView pos1;

        String[] teams={"Manchester United", "Manchester City","Liverpool","West Brom","Stroke City","West Ham","Arsenal","Southampton","Newcastle United","Swansea City","Chelsea","Crystal Palace ","Norwich City","Sunderland","Leicester City","Watford City","Bournmouth","Everton","Aston Villa","Tottenham Hotspurs"};
        //String[] posi={"ManU","","ad"};
       // HashMap<String, String> map = new HashMap<String, String>();
        String name;
        //String pos;

      for (int i=0;i<20;i++) {
          HashMap<String, String> map = new HashMap<String, String>();
          //name=teams[i];
          //pos=posi[i];
          map.put(TAG_NAME, teams[i]);
          //map.put(TAG_CODE, posi[i]);
          list1.add(map);
          list = (ListView) findViewById(R.id.list);

          ListAdapter adapter = new SimpleAdapter(Allteams.this, list1,
                  R.layout.listview,
                  new String[]{TAG_NAME}, new int[]{R.id.name});

          list.setAdapter(adapter);
          list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

              @Override
              public void onItemClick(AdapterView<?> parent, View view,
                                      int position, long id) {
                  Toast.makeText(Allteams.this, "You Clicked at " + list1.get(+position).get("name"), Toast.LENGTH_SHORT).show();
                    //Log.isLoggable("on click", position);
                        Log.d("asd","as" + position);
String url;
                  switch(position)
                  {
                     case 0:url="http://api.football-data.org/alpha/teams/66/players";
                      // case 0:url="http://api.football-data.org/alpha/soccerseasons/398/teams";

                      Log.d("Case0", "MANU");

                          Intent intent1=new Intent(Allteams.this,Players.class);
                          intent1.putExtra("url", url);
                          startActivity(intent1);
                          break;

                      case 1:url="http://api.football-data.org/alpha/teams/65/players";
                          Log.d("Case1","MANC");

                          Intent intent2=new Intent(Allteams.this,Players.class);
                          intent2.putExtra("url", url);
                          startActivity(intent2);
                          break;

                      case 2:url="http://api.football-data.org/alpha/teams/64/players";
                          Log.d("Case2","LIVERPOOL");

                          Intent intent3=new Intent(Allteams.this,Players.class);
                          intent3.putExtra("url", url);
                          startActivity(intent3);
                          break;

                      case 3:url="http://api.football-data.org/alpha/teams/74/players";
                          Log.d("Case2","WEST BROM");

                          Intent intent4=new Intent(Allteams.this,Players.class);
                          intent4.putExtra("url", url);
                          startActivity(intent4);
                          break;

                      case 4:url="http://api.football-data.org/alpha/teams/70/players";
                          Log.d("Case2","STROKE CITY");

                          Intent intent5=new Intent(Allteams.this,Players.class);
                          intent5.putExtra("url", url);
                          startActivity(intent5);
                          break;


                      case 5:url="http://api.football-data.org/alpha/teams/563/players";
                          Log.d("Case2","WEST HAM");

                          Intent intent6=new Intent(Allteams.this,Players.class);
                          intent6.putExtra("url", url);
                          startActivity(intent6);
                          break;

                      case 6:url="http://api.football-data.org/alpha/teams/57/players";
                          Log.d("Case2","ARSENAL");

                          Intent intent7=new Intent(Allteams.this,Players.class);
                          intent7.putExtra("url", url);
                          startActivity(intent7);
                          break;

                      case 7:url="http://api.football-data.org/alpha/teams/340/players";
                          Log.d("Case2","SOUTHAMPTON");

                          Intent intent8=new Intent(Allteams.this,Players.class);
                          intent8.putExtra("url", url);
                          startActivity(intent8);
                          break;

                      case 8:url="http://api.football-data.org/alpha/teams/67/players";
                          Log.d("Case2","NEWCASTLE");

                          Intent intent9=new Intent(Allteams.this,Players.class);
                          intent9.putExtra("url", url);
                          startActivity(intent9);
                          break;
                      case 9:url="http://api.football-data.org/alpha/teams/72/players";
                          Log.d("Case2","SWANSEA");

                          Intent intent10=new Intent(Allteams.this,Players.class);
                          intent10.putExtra("url", url);
                          startActivity(intent10);
                          break;
                      case 10:url="http://api.football-data.org/alpha/teams/61/players";
                          Log.d("Case2","CHELSEA");

                          Intent intent11=new Intent(Allteams.this,Players.class);
                          intent11.putExtra("url", url);
                          startActivity(intent11);
                          break;
                      case 11:url="http://api.football-data.org/alpha/teams/354/players";
                          Log.d("Case2","CRYSTAL PALACE");

                          Intent intent12=new Intent(Allteams.this,Players.class);
                          intent12.putExtra("url", url);
                          startActivity(intent12);
                          break;
                      case 12:url="http://api.football-data.org/alpha/teams/68/players";
                          Log.d("Case2","NORWICH CITY");

                          Intent intent13=new Intent(Allteams.this,Players.class);
                          intent13.putExtra("url", url);
                          startActivity(intent13);
                          break;
                      case 13:url="http://api.football-data.org/alpha/teams/71/players";
                          Log.d("Case2","SUNDERLAND");

                          Intent intent14=new Intent(Allteams.this,Players.class);
                          intent14.putExtra("url", url);
                          startActivity(intent14);
                          break;
                      case 14:url="http://api.football-data.org/alpha/teams/338/players";
                          Log.d("Case2","LEICESTER CITY");

                          Intent intent15=new Intent(Allteams.this,Players.class);
                          intent15.putExtra("url", url);
                          startActivity(intent15);
                          break;
                      case 15:url="http://api.football-data.org/alpha/teams/346/players";
                          Log.d("Case2","WATFORD CITY");

                          Intent intent16=new Intent(Allteams.this,Players.class);
                          intent16.putExtra("url", url);
                          startActivity(intent16);
                          break;
                      case 16:url="http://api.football-data.org/alpha/teams/1044/players";
                          Log.d("Case2","BOURNMOUTH");

                          Intent intent17 =new Intent(Allteams.this,Players.class);
                          intent17.putExtra("url", url);
                          startActivity(intent17);
                          break;
                      case 17:url="http://api.football-data.org/alpha/teams/62/players";
                          Log.d("Case2","EVERTON");

                          Intent intent18=new Intent(Allteams.this,Players.class);
                          intent18.putExtra("url", url);
                          startActivity(intent18);
                          break;
                      case 18:url="http://api.football-data.org/alpha/teams/58/players";
                          Log.d("Case2","ASTON VILLA");

                          Intent intent19=new Intent(Allteams.this,Players.class);
                          intent19.putExtra("url", url);
                          startActivity(intent19);
                          break;
                      case 19:url="http://api.football-data.org/alpha/teams/73/players";
                          Log.d("Case2","TOTTENHAM HOTSPURS");

                          Intent intent20=new Intent(Allteams.this,Players.class);
                          intent20.putExtra("url", url);
                          startActivity(intent20);
                          break;


                  }





              }
          });
      }

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


/*
    private class JSONParse extends AsyncTask<String, String, JSONObject> {
        private ProgressDialog pDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //uid = (TextView) findViewById(R.id.is);
            name1 = (TextView) findViewById(R.id.name);
            pos1 = (TextView) findViewById(R.id.position);
            pDialog = new ProgressDialog(Allteams.this);
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
                user = json.getJSONArray(TAG_TEAMS);
                //JSONObject c = user.getJSONObject(0);
                //ArrayList<String> items = new ArrayList<String>();
                for (int i = 0; i < user.length(); i++) {
                    JSONObject c = user.getJSONObject(i);
                    //String id = c.getString(TAG_id);
                    String name = c.getString(TAG_NAME);
                    String pos = c.getString(TAG_CODE);
                    // items.add(name);
                   // Log.d(name, "Output");
                    HashMap<String, String> map = new HashMap<String, String>();

                    //map.put(TAG_ID, id);
                    map.put(TAG_NAME, name);
                    map.put(TAG_CODE, pos);
                    list1.add(map);
                    list = (ListView) findViewById(R.id.list);

                    ListAdapter adapter = new SimpleAdapter(Allteams.this, list1,
                            R.layout.listview,
                            new String[]{TAG_NAME, TAG_CODE}, new int[]{R.id.name, R.id.position});

                    list.setAdapter(adapter);
                    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view,
                                                int position, long id) {
                            Toast.makeText(Allteams.this, "You Clicked at " + list1.get(+position).get("name"), Toast.LENGTH_SHORT).show();

                        }
                    });

                }
            }catch (JSONException e) {
                e.printStackTrace();
            }



        }
    }
 */

}