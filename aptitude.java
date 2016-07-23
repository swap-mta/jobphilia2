package com.mta.jobphilia;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class aptitude extends AppCompatActivity {

    String p1,t1;
    String id="v1";
    String b11,b12,b13,b14,tt;
    Button bu1,bu2,bu3,bu4,bu6,bu7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aptitude);
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
        bu1=(Button)findViewById(R.id.button);
        bu2=(Button)findViewById(R.id.button3);
        bu3=(Button)findViewById(R.id.button4);
        bu4=(Button)findViewById(R.id.button5);
        bu6=(Button)findViewById(R.id.button6);
        bu7=(Button)findViewById(R.id.button7);
        Intent obj = getIntent();
        p1 = obj.getExtras().getString("aptitudequery");

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                get_queryfr1();
            }
        });
        t.start();
        bu7.setOnClickListener(new View.OnClickListener(){
          @Override
        public void onClick(View view){
              Toast.makeText(getApplicationContext(),"next question please",Toast.LENGTH_LONG).show();
              //code to change and increment string by 1
           id="v"+(Integer.parseInt(id.substring(1,id.length()))+1);
              Thread t = new Thread(new Runnable() {
                  @Override
                  public void run() {
                      get_queryfr1();
                  }
              });
              t.start();
          }
        });
    }
    public void get_queryfr1() {
        httpconnection obj = new httpconnection();
        String url = "http://192.168.43.225:81/swap/catagory1.php";
        List<BasicNameValuePair> nvps = new ArrayList<BasicNameValuePair>();
        nvps.add(new BasicNameValuePair("catagory", p1));
        nvps.add(new BasicNameValuePair("id",id));


        final String result = obj.get_httpvalue(url, nvps, getApplicationContext());


         /* *********** json parsing *************** */

        JSONArray jArray;
        try {
            jArray = new JSONArray(result);
            JSONObject json_data = null;

            final int length = jArray.length();

            int j = 0;

                json_data = jArray.getJSONObject(j);
                tt = json_data.getString("textview");
                b11 = json_data.getString("b1");
            b12 = json_data.getString("b2");
            b13 = json_data.getString("b3");
            b14 = json_data.getString("b4");

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    bu6.setText(tt);
                    bu1.setText(b11);
                    bu2.setText(b12);
                    bu3.setText(b13);
                    bu4.setText(b14);

                }
            });

        } catch (Exception e) {
        }
    }
}
