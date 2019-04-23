package com.example.ibm_admin.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter=5;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        /*BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);*/

        Name =(EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.tvInfo);
        Login =(Button)findViewById(R.id.etLogin);

        Info.setText("Number of Attempts remiining : 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validate(Name.getText().toString(), Password.getText().toString());
            }
        });

    }

    private void validate (String userName, String userPassword){
        if ((userName.equals("Admin")) && (userPassword.equals("1234"))){

            Intent intent = new Intent(MainActivity.this, KanbanUI.class);
            startActivity(intent);
        }else{
            counter--;
            Info.setText("Number of attempts remaining : " + String.valueOf(counter));


            if (counter == 0){
                Login.setEnabled(false);
            }
        }

    }

}
