package com.example.tp_android.Android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.tp_android.Models.Produit;
import com.example.tp_android.R;
import com.example.tp_android.Service.WebService;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Main3Activity extends AppCompatActivity {
    Produit prd = new Produit();
    TextView out1, out2, out3, out4, out5, out6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        out1 = (TextView) findViewById(R.id.textView5);
        out2 = (TextView) findViewById(R.id.textView6);
        out3 = (TextView) findViewById(R.id.textView7);
        out4 = (TextView) findViewById(R.id.textView8);
        out5 = (TextView) findViewById(R.id.textView9);
        out6 = (TextView) findViewById(R.id.textView10);

        Intent monIntent = getIntent();
        String receivedId = monIntent.getStringExtra("ID");

        WebService.GetProduitTask task2= (WebService.GetProduitTask) new WebService.GetProduitTask().execute(receivedId);
        try {
            prd = task2.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        out1.setText("PRODUITS DETAILS");
        out2.setText(prd.getId());
        out3.setText(prd.getNom());
        out4.setText(""+ prd.getPrix());
        out5.setText(""+prd.getQuantite());
        out6.setText(prd.getDescription().substring(0,50));

        }
    public void loginBack(View myView){
        Intent  myIntent = new Intent(this,MainActivity.class);
        startActivity(myIntent);
        }
    }


