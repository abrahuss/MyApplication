package com.example.ibm_admin.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TicketDetailsSLOHoldRecycler extends AppCompatActivity {


    // Ip to connect Emulator
    private static final String url ="http://10.0.2.2:9999/KANBAN/rest/MobileServices/ticketDetailsSLOHold";


    // Ip to connect Mobile Device

   //  String url = "http://192.168.43.182:9999/KANBAN/rest/MobileServices/ticketDetailsSLOHold";

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
                userList.setAdapter(new ProgrammingAdapter(TicketDetailsSLOHoldRecycler.this, details));

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);

    }




}
