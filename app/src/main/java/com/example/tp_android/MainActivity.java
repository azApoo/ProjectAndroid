package com.example.tp_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void nexPage(View maVue){

        //instanciation de la zone de saisie
        EditText inUser = (EditText) findViewById(R.id.editText);
        EditText inPw = (EditText) findViewById(R.id.editText2);

        String sUser = inUser.getText().toString();
        String sPw = inPw.getText().toString();
        String pw_accepted = "Abcd1234;";

        //Intent selon la validation
            Intent myIntent_Extra;
            Intent myIntent_Error = new Intent(this,Main2Activity_Error .class);
            Intent myIntent_Succes = new Intent(this,Main2Activity_succes.class);
        //la validation du pw
            // 1) la taille de 8 caractères
                    if(sPw.length()< 8){
                       myIntent_Extra = myIntent_Error;

                    }else if(!sPw.equals(pw_accepted)){
                        myIntent_Extra = myIntent_Error;
                    }
                    else{
                        myIntent_Extra = myIntent_Succes;
                    }


        startActivity(myIntent_Extra);

    }

}
