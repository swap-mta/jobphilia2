package com.mta.jobphilia;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.view.MenuItem;
import android.transition.TransitionManager;

import java.util.Timer;
import java.util.TimerTask;

public class Interview extends AppCompatActivity {
ViewGroup buckysLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview);
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
        buckysLayout=(ViewGroup)findViewById(R.id.buckysLayout);
        buckysLayout.setOnTouchListener(
                new RelativeLayout.OnTouchListener(){
                    @Override
                public boolean onTouch(View v,MotionEvent event){
                        moveButton();
                        return true;
                    }
                }
        );
        Timer obj=new Timer();
        tt obj1=new tt();
        obj.schedule(obj1, 4000);
    }
    public void moveButton(){
        TransitionManager.beginDelayedTransition(buckysLayout);
        View buckysButton=findViewById(R.id.buckysButton);
        RelativeLayout.LayoutParams positionRules=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,RelativeLayout.TRUE);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        buckysButton.setLayoutParams(positionRules);
        ViewGroup.LayoutParams sizeRules=buckysButton.getLayoutParams();
        sizeRules.width=450;
        sizeRules.height=300;
        buckysButton.setLayoutParams(sizeRules);
    }
    class tt extends TimerTask {
        @Override
        public void run() {
            Intent obj=new Intent(Interview.this,main.class);
            startActivity(obj);
            finish();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_interview, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
