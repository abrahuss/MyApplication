package com.example.ibm_admin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Statistics extends AppCompatActivity {

    private Button Home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        Home = (Button)findViewById(R.id.btnHome);

        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Statistics.this, KanbanUI.class);
                startActivity(intent1);
            }
        });
    }
}
