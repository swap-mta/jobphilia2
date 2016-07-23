package com.mta.jobphilia;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class questions extends AppCompatActivity {
    ListView detailquery2;
    String[] detailname2;
    String catagory;
    ArrayAdapter<String> aa4;
    String p1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
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
        p1 = obj.getExtras().getString("questionquery");

        //String p2 = obj.getExtras().getString("softwarequery");
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    get_queryfr1();
                }
            });
            t.start();


       /* else if (p1.equalsIgnoreCase("Engineering") ){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    get_queryengineering1();
                }
            });
            t.start();
        }
        else if (p1.equalsIgnoreCase("MBA Entrance") ){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    get_querymbaentrance1();
                }
            });
            t.start();
        }
        else if (p1.equalsIgnoreCase("MBA placement") ){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    get_querymbaplacement1();
                }
            });
            t.start();
        }
        else if (p1.equalsIgnoreCase("Company wise") ){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    get_querycompany1();
                }
            });
            t.start();
        }*/

    }

    public void get_queryfr1() {
        httpconnection obj = new httpconnection();
        String url = "http://192.168.43.225:81/swap/catagory.php";
        List<BasicNameValuePair>nvps=new ArrayList<BasicNameValuePair>();
        nvps.add(new BasicNameValuePair("catagory",p1));

        final String result = obj.get_httpvalue(url, nvps, getApplicationContext());


         /* *********** json parsing *************** */

        JSONArray jArray;
        try {
            jArray = new JSONArray(result);
            JSONObject json_data = null;

            final int length = jArray.length();
            detailname2 = new String[length];

            int j = 0;
            for (int i = 0; i < length; i++) {
                json_data = jArray.getJSONObject(i);
                detailname2[i] = json_data.getString("detail");

            }
        } catch (Exception e) {
        }

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                aa4 = new ArrayAdapter<String>(getApplicationContext(), R.layout.simple_list_item_2, detailname2);
                detailquery2 = (ListView) findViewById(R.id.listView4);
                detailquery2.setAdapter(aa4);

            }
        });
    }
    public void get_queryexp1() {
        httpconnection obj = new httpconnection();
        String url = "http://192.168.43.225:81/swap/exper.php";
        List<BasicNameValuePair> l1 = new ArrayList<BasicNameValuePair>();
        l1.add(new BasicNameValuePair("name", "amit"));
        final String result = obj.get_httpvalue(url, l1, getApplicationContext());


         /* *********** json parsing *************** */

        JSONArray jArray;
        try {
            jArray = new JSONArray(result);
            JSONObject json_data = null;

            final int length = jArray.length();
            detailname2 = new String[length];

            int j = 0;
            for (int i = 0; i < length; i++) {
                json_data = jArray.getJSONObject(i);
                detailname2[i] = json_data.getString("exper");

            }
        } catch (Exception e) {
        }

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                aa4 = new ArrayAdapter<String>(getApplicationContext(), R.layout.simple_list_item_2, detailname2);
                detailquery2 = (ListView) findViewById(R.id.listView4);
                detailquery2.setAdapter(aa4);

            }
        });
    }
}