package com.example.ibm_admin.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class KanbanVirtual extends AppCompatActivity {

    private TextView mTextViewCreated;
    private TextView mTextViewTransferred;
    private TextView mTextViewAssigned;
    private TextView mTextViewSlo;
    private TextView mTextViewResolved;
    private TextView mTextViewClosed;
    private TextView mTextViewBlocker;
    private TextView mTextViewSev;


    private Button HomeKV;
    private RequestQueue mQueue;

    String transfer, create, assign, sloHold, resolve, close, blocker, sev;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kanban_virtual);

        mTextViewCreated = findViewById(R.id.text_view_created);
        mTextViewTransferred = findViewById(R.id.text_view_transferred);
        mTextViewAssigned = findViewById(R.id.text_view_assigned);
        mTextViewSlo = findViewById(R.id.text_view_slo);
        mTextViewResolved = findViewById(R.id.text_view_resolved);
        mTextViewClosed = findViewById(R.id.text_view_closed);
        mTextViewBlocker = findViewById(R.id.text_view_blocker);
        mTextViewSev = findViewById(R.id.text_view_sev);

        HomeKV =(Button) findViewById(R.id.btnHomeKV);
        Button buttonParse;
        buttonParse = (Button) findViewById(R.id.button_fetch);




        mQueue = Volley.newRequestQueue(this);

        buttonParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonParse();
            }
        });



        /*Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        HomeKV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKV = new Intent(KanbanVirtual.this, KanbanUI.class);
                startActivity(intentKV);
            }
        });


        mTextViewAssigned.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTR = new Intent(KanbanVirtual.this, TicketDetailsRecycler.class);
                startActivity(intentTR);
            }
        });

        mTextViewCreated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KanbanVirtual.this, TicketDetailsCreatedRecycler.class);
                startActivity(intent);
            }
        });


        mTextViewTransferred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KanbanVirtual.this, TicketDetailsTransferredRecycler.class);
                startActivity(intent);
            }
        });

        mTextViewSlo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KanbanVirtual.this, TicketDetailsSLOHoldRecycler.class);
                startActivity(intent);
            }
        });

        mTextViewBlocker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KanbanVirtual.this, TicketDetailsBlockersRecycler.class);
                startActivity(intent);
            }
        });

    }


    private void jsonParse(){



        // Mobile IP network
    // String url = "http://192.168.43.182:9999/KANBAN/rest/MobileServices/tickets";


        //For connecting Emulator using below ip
      String url = "http://10.0.2.2:9999/KANBAN/rest/MobileServices/tickets";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        // mTextViewCreated.setText(response.toString());
                        try {
                            create = response.getString("Created");
                            transfer = response.getString("Transferred");
                            assign = response.getString("Assigned");
                            sloHold =  response.getString("SloHold");
                            resolve = response.getString("Resolved");
                            close = response.getString("Closed");
                            blocker = response.getString("Blockers");
                            sev = response.getString("Sev 1");

                            mTextViewCreated.setText(create);
                            mTextViewTransferred.setText(transfer);
                            mTextViewAssigned.setText(assign);
                            mTextViewSlo.setText(sloHold);
                            mTextViewResolved.setText(resolve);
                            mTextViewClosed.setText(close);
                            mTextViewBlocker.setText(blocker);
                            mTextViewSev.setText(sev);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                           /* mTextViewCreated.setText(response.getInt("Created"));
                            mTextViewAssigned.setText(response.getInt("Assigned"));
                            mTextViewTransferred.setText(response.getInt("Transferred"));
                            mTextViewSlo.setText(response.getInt("SloHold"));
                            mTextViewResolved.setText(response.getInt("Resolved"));*/


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                error.printStackTrace();
            }
        });

        mQueue.add(request);
    }

}
