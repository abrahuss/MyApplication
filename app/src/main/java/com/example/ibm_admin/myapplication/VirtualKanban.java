package com.example.ibm_admin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class VirtualKanban extends AppCompatActivity {

    private Button Home1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_virtual_kanban);


        Home1 = (Button)findViewById(R.id.btnHome2);

       // Resources res= getResources();
     /*   Resources res1= getResources();
        Resources res2= getResources();
        Resources res3= getResources();
        Resources res4= getResources();*/


        ImageView imageTitleview = (ImageView) findViewById(R.id.ivTitle4);
        ImageView imageNewCre = (ImageView) findViewById(R.id.ivNew);
        ImageView imageWallTi = (ImageView) findViewById(R.id.ivWallTi);
        ImageView imageWorking = (ImageView) findViewById(R.id.ivWorking);
        ImageView imageDone = (ImageView) findViewById(R.id.ivDone);



/*
        Drawable drawable=ResourcesCompat.getDrawable(res, R.drawable.done, null);
        Drawable drawable1=ResourcesCompat.getDrawable(res, R.drawable.newcre, null);
        Drawable drawable2= ResourcesCompat.getDrawable(res, R.drawable.wallti, null);
        Drawable drawable3= ResourcesCompat.getDrawable(res, R.drawable.working, null);
        Drawable drawable4 = ResourcesCompat.getDrawable(res, R.drawable.titlelogo, null);*/



        Home1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(VirtualKanban.this, KanbanUI.class);
                startActivity(intent2);
            }
        });
}
    }

