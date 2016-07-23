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

public class HR extends AppCompatActivity {
    ListView detailquery1;
    String[] detailname1;
    ArrayAdapter<String> aa3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hr);
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
        String p1 = obj.getExtras().getString("HRquery");
        //String p2 = obj.getExtras().getString("softwarequery");
        if (p1.equalsIgnoreCase("HR") ){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    get_queryhr1();
                }
            });
            t.start();
        }
        else if (p1.equalsIgnoreCase("software development") ){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    get_querysoftware1();
                }
            });
            t.start();
        }
        else if (p1.equalsIgnoreCase("Engineering") ){
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
        }



    }


    public void get_queryhr1() {
        httpconnection obj = new httpconnection();
        String url = "http://192.168.43.225:81/swap/querydetailhr.php";
        List<BasicNameValuePair> l1 = new ArrayList<BasicNameValuePair>();
        l1.add(new BasicNameValuePair("name", "amit"));
        final String result = obj.get_httpvalue(url, l1, getApplicationContext());


         /* *********** json parsing *************** */

        JSONArray jArray;
        try {
            jArray = new JSONArray(result);
            JSONObject json_data = null;

            final int length = jArray.length();
            detailname1 = new String[length];

            int j = 0;
            for (int i = 0; i < length; i++) {
                json_data = jArray.getJSONObject(i);
                detailname1[i] = json_data.getString("querydetailhr");

            }
        } catch (Exception e) {
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                aa3 = new ArrayAdapter<String>(getApplicationContext(), R.layout.simple_list_item_2, detailname1);
                detailquery1 = (ListView) findViewById(R.id.listView3);
                detailquery1.setAdapter(aa3);
                detailquery1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String selectedquery = detailquery1.getItemAtPosition(position).toString();
                        Intent obj = new Intent(HR.this, questions.class);
                        obj.putExtra("questionquery", selectedquery);
                        startActivity(obj);

                    }
                });
            }
        });
    }
    public void get_querysoftware1() {
        httpconnection obj = new httpconnection();
        String url = "http://192.168.43.225:81/swap/querydetailsoftware.php";
        List<BasicNameValuePair> l1 = new ArrayList<BasicNameValuePair>();
        l1.add(new BasicNameValuePair("name", "amit"));
        final String result = obj.get_httpvalue(url, l1, getApplicationContext());


         /* *********** json parsing *************** */

        JSONArray jArray;
        try {
            jArray = new JSONArray(result);
            JSONObject json_data = null;

            final int length = jArray.length();
            detailname1 = new String[length];

            int j = 0;
            for (int i = 0; i < length; i++) {
                json_data = jArray.getJSONObject(i);
                detailname1[i] = json_data.getString("querydetailsoftware");

            }
        } catch (Exception e) {
        }

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                aa3 = new ArrayAdapter<String>(getApplicationContext(), R.layout.simple_list_item_2, detailname1);
                detailquery1 = (ListView) findViewById(R.id.listView3);
                detailquery1.setAdapter(aa3);
                detailquery1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String selectedquery = detailquery1.getItemAtPosition(position).toString();
                        Intent obj = new Intent(HR.this, questions.class);
                        obj.putExtra("questionquery", selectedquery);
                        startActivity(obj);
                    }
                });

            }
        });
    }
    public void get_queryengineering1() {
        httpconnection obj = new httpconnection();
        String url = "http://192.168.43.225:81/swap/querydetailengineering.php";
        List<BasicNameValuePair> l1 = new ArrayList<BasicNameValuePair>();
        l1.add(new BasicNameValuePair("name", "amit"));
        final String result = obj.get_httpvalue(url, l1, getApplicationContext());


         /* *********** json parsing *************** */

        JSONArray jArray;
        try {
            jArray = new JSONArray(result);
            JSONObject json_data = null;

            final int length = jArray.length();
            detailname1 = new String[length];

            int j = 0;
            for (int i = 0; i < length; i++) {
                json_data = jArray.getJSONObject(i);
                detailname1[i] = json_data.getString("querydetailengineering");
            }
        } catch (Exception e) {
        }

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                aa3 = new ArrayAdapter<String>(getApplicationContext(), R.layout.simple_list_item_2, detailname1);
                detailquery1 = (ListView) findViewById(R.id.listView3);
                detailquery1.setAdapter(aa3);
                detailquery1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String selectedquery = detailquery1.getItemAtPosition(position).toString();
                        Intent obj = new Intent(HR.this, questions.class);
                        obj.putExtra("questionquery", selectedquery);
                        startActivity(obj);
                    }
                });

            }
        });

    }
    public void get_querymbaentrance1() {
        httpconnection obj = new httpconnection();
        String url = "http://192.168.43.225:81/swap/querydetailmbaentrance.php";
        List<BasicNameValuePair> l1 = new ArrayList<BasicNameValuePair>();
        l1.add(new BasicNameValuePair("name", "amit"));
        final String result = obj.get_httpvalue(url, l1, getApplicationContext());


         /* *********** json parsing *************** */

        JSONArray jArray;
        try {
            jArray = new JSONArray(result);
            JSONObject json_data = null;

            final int length = jArray.length();
            detailname1 = new String[length];

            int j = 0;
            for (int i = 0; i < length; i++) {
                json_data = jArray.getJSONObject(i);
                detailname1[i] = json_data.getString("querydetailmbaentrance");

            }
        } catch (Exception e) {
        }

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                aa3 = new ArrayAdapter<String>(getApplicationContext(), R.layout.simple_list_item_2, detailname1);
                detailquery1 = (ListView) findViewById(R.id.listView3);
                detailquery1.setAdapter(aa3);
                detailquery1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String selectedquery = detailquery1.getItemAtPosition(position).toString();
                        Intent obj = new Intent(HR.this, questions.class);
                        obj.putExtra("questionquery", selectedquery);
                        startActivity(obj);
                    }
                });

            }
        });
    }
    public void get_querymbaplacement1() {
        httpconnection obj = new httpconnection();
        String url = "http://192.168.43.225:81/swap/querydetailmbaplacement.php";
        List<BasicNameValuePair> l1 = new ArrayList<BasicNameValuePair>();
        l1.add(new BasicNameValuePair("name", "amit"));
        final String result = obj.get_httpvalue(url, l1, getApplicationContext());


         /* *********** json parsing *************** */

        JSONArray jArray;
        try {
            jArray = new JSONArray(result);
            JSONObject json_data = null;

            final int length = jArray.length();
            detailname1 = new String[length];

            int j = 0;
            for (int i = 0; i < length; i++) {
                json_data = jArray.getJSONObject(i);
                detailname1[i] = json_data.getString("querydetailmbaplacement");

            }
        } catch (Exception e) {
        }

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                aa3 = new ArrayAdapter<String>(getApplicationContext(), R.layout.simple_list_item_2, detailname1);
                detailquery1 = (ListView) findViewById(R.id.listView3);
                detailquery1.setAdapter(aa3);
                detailquery1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String selectedquery = detailquery1.getItemAtPosition(position).toString();
                        Intent obj = new Intent(HR.this, questions.class);
                        obj.putExtra("questionquery", selectedquery);
                        startActivity(obj);
                    }
                });

            }
        });
    }
    public void get_querycompany1() {
        httpconnection obj = new httpconnection();
        String url = "http://192.168.43.225:81/swap/querydetailcompany.php";
        List<BasicNameValuePair> l1 = new ArrayList<BasicNameValuePair>();
        l1.add(new BasicNameValuePair("name", "amit"));
        final String result = obj.get_httpvalue(url, l1, getApplicationContext());


         /* *********** json parsing *************** */

        JSONArray jArray;
        try {
            jArray = new JSONArray(result);
            JSONObject json_data = null;

            final int length = jArray.length();
            detailname1 = new String[length];

            int j = 0;
            for (int i = 0; i < length; i++) {
                json_data = jArray.getJSONObject(i);
                detailname1[i] = json_data.getString("querydetailcompany");

            }
        } catch (Exception e) {
        }

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                aa3 = new ArrayAdapter<String>(getApplicationContext(), R.layout.simple_list_item_2, detailname1);
                detailquery1 = (ListView) findViewById(R.id.listView3);
                detailquery1.setAdapter(aa3);
                detailquery1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String selectedquery = detailquery1.getItemAtPosition(position).toString();
                        Intent obj = new Intent(HR.this, questions.class);
                        obj.putExtra("questionquery", selectedquery);
                        startActivity(obj);
                    }
                });

            }
        });
    }


}
