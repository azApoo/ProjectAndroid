package com.example.tp_android.Android;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tp_android.R;

public class Main2Activity_Error extends AppCompatActivity {
    TextView errorUsername,errorPassword;
    String username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2__error);
        errorUsername=(TextView) findViewById(R.id.textView2);
        Intent myNewIntent = getIntent();
        username = ((Intent) myNewIntent).getStringExtra("USERNAME");
        errorUsername.setText("Error : " + username);
    }
}
