package com.example.ibm_admin.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TableLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import static com.example.ibm_admin.myapplication.R.id.table_details;
import static com.example.ibm_admin.myapplication.R.id.userList;

public class TicketDetailsRecycler extends AppCompatActivity {

    public boolean table_flg = false;

    // Ip to connect Emulator
   private static final String url ="http://10.0.2.2:9999/KANBAN/rest/MobileServices/ticketDetails";


    // Ip to connect Mobile Device

   // String url = "http://192.168.43.182:9999/KANBAN/rest/MobileServices/ticketDetails";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_details_recycler);
        final RecyclerView userList = findViewById(R.id.userList);
        userList.setLayoutManager(new LinearLayoutManager(this));


        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.d("code", response);
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                TicketDetail[] details = gson.fromJson(response, TicketDetail[].class);
                userList.setAdapter(new ProgrammingAdapter(TicketDetailsRecycler.this, details));

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);



        /*Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    public void collapseTable(View view){

        TableLayout table = findViewById(table_details);
        TableLayout table1 = findViewById(table_details);
        table.setColumnCollapsed(4, table_flg);
        table.setColumnCollapsed(3,table_flg);

        table1.setColumnCollapsed(4, table_flg);
        table1.setColumnCollapsed(3,table_flg);
        if (table_flg){
            table_flg = false;
        }
        else {
            table_flg = true;
        }
    }



}
