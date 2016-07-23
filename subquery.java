package com.mta.jobphilia;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class subquery extends AppCompatActivity {
    ListView detailquery;
    String[] detailname;
    ArrayAdapter<String> aa2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subquery);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Intent obj = getIntent();
        String p1 = obj.getExtras().getString("query");
        if(p1.equalsIgnoreCase("Interview")){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    get_query1();
                }
            });
            t.start();
        }
        else if(p1.equalsIgnoreCase("Aptitude")){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    get_query2();
                }
            });
            t.start();
        }
        else if(p1.equalsIgnoreCase("Group discussion")){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    get_query3();
                }
            });
            t.start();
        }
        else if(p1.equalsIgnoreCase("Resume")){
            Intent obj2=new Intent(subquery.this,Resume.class);
            startActivity(obj2);
            finish();
        }
        else if(p1.equalsIgnoreCase("Tips")){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    get_query4();
                }
            });
            t.start();
        }
        else if(p1.equalsIgnoreCase("need help?")){
            Intent obj3=new Intent(subquery.this,help.class);
            startActivity(obj3);
            finish();
        }
    }
    public void get_query1()
    {
        httpconnection obj=new httpconnection();
        String url="http://192.168.43.225:81/swap/querydetailinterview.php";
        List<BasicNameValuePair> l1 = new ArrayList<BasicNameValuePair>();
        l1.add(new BasicNameValuePair("name", "amit"));
        final String result=obj.get_httpvalue(url, l1, getApplicationContext());


         /* *********** json parsing *************** */

        JSONArray jArray;
        try {
            jArray = new JSONArray(result);
            JSONObject json_data = null;

            final int length = jArray.length();
            detailname = new String[length];

            int j = 0;
            for (int i = 0; i < length; i++) {
                json_data = jArray.getJSONObject(i);
                detailname[i] = json_data.getString("querydetailinterview");

            }
        } catch (Exception e) {
        }

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                aa2 = new ArrayAdapter<String>(getApplicationContext(), R.layout.simple_list_item_2, detailname);
                detailquery = (ListView) findViewById(R.id.listView2);
                detailquery.setAdapter(aa2);
                detailquery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String selectedquery = detailquery.getItemAtPosition(position).toString();
                        Intent obj = new Intent(subquery.this,HR.class);
                        obj.putExtra("HRquery", selectedquery);
                        startActivity(obj);

                    }
                });

            }
        });

    }
    public void get_query2()
    {
        httpconnection obj=new httpconnection();
        String url="http://192.168.43.225:81/swap/querydetailaptitude.php";
        List<BasicNameValuePair> l1 = new ArrayList<BasicNameValuePair>();
        l1.add(new BasicNameValuePair("name", "amit"));
        final String result=obj.get_httpvalue(url, l1, getApplicationContext());


         /* *********** json parsing *************** */

        JSONArray jArray;
        try {
            jArray = new JSONArray(result);
            JSONObject json_data = null;

            final int length = jArray.length();
            detailname = new String[length];

            int j = 0;
            for (int i = 0; i < length; i++) {
                json_data = jArray.getJSONObject(i);
                detailname[i] = json_data.getString("querydetailaptitude");

            }
        } catch (Exception e) {
        }

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                aa2 = new ArrayAdapter<String>(getApplicationContext(), R.layout.simple_list_item_2, detailname);
                detailquery = (ListView) findViewById(R.id.listView2);
                detailquery.setAdapter(aa2);
                detailquery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String selectedquery = detailquery.getItemAtPosition(position).toString();
                        Intent obj = new Intent(subquery.this, aptitude.class);
                      obj.putExtra("aptitudequery", selectedquery);
                        startActivity(obj);
                    }
                });

            }
        });

    }
    public void get_query3()
    {
        httpconnection obj=new httpconnection();
        String url="http://192.168.43.225:81/swap/querydetailgroup.php";
        List<BasicNameValuePair> l1 = new ArrayList<BasicNameValuePair>();
        l1.add(new BasicNameValuePair("name", "amit"));
        final String result=obj.get_httpvalue(url, l1, getApplicationContext());


         /* *********** json parsing *************** */

        JSONArray jArray;
        try {
            jArray = new JSONArray(result);
            JSONObject json_data = null;

            final int length = jArray.length();
            detailname = new String[length];

            int j = 0;
            for (int i = 0; i < length; i++) {
                json_data = jArray.getJSONObject(i);
                detailname[i] = json_data.getString("querydetailgroup");

            }
        } catch (Exception e) {
        }

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                aa2 = new ArrayAdapter<String>(getApplicationContext(), R.layout.simple_list_item_2, detailname);
                detailquery = (ListView) findViewById(R.id.listView2);
                detailquery.setAdapter(aa2);

            }
        });

    }
    public void get_query4()
    {
        httpconnection obj=new httpconnection();
        String url="http://192.168.43.225:81/swap/querydetailtips.php";
        List<BasicNameValuePair> l1 = new ArrayList<BasicNameValuePair>();
        l1.add(new BasicNameValuePair("name", "amit"));
        final String result=obj.get_httpvalue(url, l1, getApplicationContext());


         /* *********** json parsing *************** */

        JSONArray jArray;
        try {
            jArray = new JSONArray(result);
            JSONObject json_data = null;

            final int length = jArray.length();
            detailname = new String[length];

            int j = 0;
            for (int i = 0; i < length; i++) {
                json_data = jArray.getJSONObject(i);
                detailname[i] = json_data.getString("querydetailtips");

            }
        } catch (Exception e) {
        }

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                aa2 = new ArrayAdapter<String>(getApplicationContext(), R.layout.simple_list_item_2, detailname);
                detailquery = (ListView) findViewById(R.id.listView2);
                detailquery.setAdapter(aa2);

            }
        });

    }


}
