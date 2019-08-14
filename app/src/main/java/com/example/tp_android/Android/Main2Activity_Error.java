package com.example.tp_android.Android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tp_android.R;

public class Main2Activity_Error extends AppCompatActivity {
    TextView errorUsername;
    String username,password;
    Intent myIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2__error);
        errorUsername=(TextView) findViewById(R.id.textView2);
        Intent myNewIntent = getIntent();
        username = ((Intent) myNewIntent).getStringExtra("USERNAME");
        password = ((Intent) myNewIntent).getStringExtra("PASSWORD");
        errorUsername.setText("The username " + username + " and Password "+password+" is not a valid combination.");
    }

    public void loginBack(View myView){
            myIntent = new Intent(this,MainActivity.class);
            startActivity(myIntent);
        }
}
