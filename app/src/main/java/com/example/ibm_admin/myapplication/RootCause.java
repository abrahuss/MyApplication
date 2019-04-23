package com.example.ibm_admin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RootCause extends AppCompatActivity {

    private Button Home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root_cause);

        Home = (Button)findViewById(R.id.btnHomeRC);
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RootCause.this, KanbanUI.class);
                startActivity(intent);

            }
        });
    }
}
