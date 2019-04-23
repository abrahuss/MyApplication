package com.example.ibm_admin.myapplication;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

public class KanbanUI extends AppCompatActivity {

    private Button GetStats;
    private Button GetVKB;
    private Button GetRCS;
    private Button GetGraph;
    private ImageView Title;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kanban_ui);



        GetStats=(Button)findViewById(R.id.buttonStatistics);
        GetVKB=(Button)findViewById(R.id.buttonVKB);
        GetRCS=(Button)findViewById(R.id.buttonRCS);
        GetGraph=(Button)findViewById(R.id.buttonGraph);
       // Title=(ImageView) findViewById(R.id.ivTitle);
        Resources res = getResources();
        Drawable drawable = ResourcesCompat.getDrawable(res, R.drawable.titlelogo, null);

        GetStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KanbanUI.this, Statistics.class);
                startActivity(intent);
            }
        });

        GetVKB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(KanbanUI.this, KanbanVirtual.class);
                startActivity(intent1);
            }
        });
       // GetVKB.setOnLongClickListener();

        GetRCS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(KanbanUI.this, RootCause.class);
                startActivity(intent3);
                 }
        });


        Spinner spinner = (Spinner) findViewById(R.id.spinnerItem);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Owner_Group, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);



    }
}
