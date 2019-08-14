package com.example.tp_android.Android;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tp_android.Models.Produit;
import com.example.tp_android.R;
import com.example.tp_android.Service.WebService;
import com.example.tp_android.Utilitaire.Verification;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    EditText inUser,inPw;
    Intent myIntent;
    ArrayList<Produit> list=new ArrayList();
    Produit prd=new Produit();
    //String username="abcd2019", password="Abcd1234;";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        WebService.GetListProduitsTask task= (WebService.GetListProduitsTask) new  WebService.GetListProduitsTask().execute();
//        WebService.GetProduitTask task2= (WebService.GetProduitTask) new WebService.GetProduitTask().execute("32");
//        try {
//            list=  task.get();
//            prd=task2.get();
//            System.out.println(list);
//            System.out.println(prd);
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
    public void login(View myView){

        System.out.println("List egal= "+list);
        System.out.println("Produit = "+prd);
        //instanciation de la zone de saisie
        inUser = (EditText) findViewById(R.id.editText);
        inPw = (EditText) findViewById(R.id.editText2);


        String sUser = inUser.getText().toString();
        String sPw = inPw.getText().toString();
        System.out.println("sUser ---" +sUser);
        System.out.println("sPw ---" +sPw);

        if(Verification.validerUsername(sUser)&&Verification.validerPassword(sPw)&&
           Verification.verifierUserPwd(sUser,sPw)){
            myIntent = new Intent(this,Main2Activity_succes.class);
            startActivity(myIntent);
        }
        else {
            myIntent = new Intent(this,Main2Activity_Error.class);
            myIntent.putExtra("USERNAME", sUser);
            myIntent.putExtra("PASSWORD", sPw);
            startActivity(myIntent);
        }
    }
}
