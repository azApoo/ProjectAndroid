package com.example.tp_android.Android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tp_android.Models.Produit;
import com.example.tp_android.R;
import com.example.tp_android.Service.WebService;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Main2Activity_succes extends AppCompatActivity {
    TextView out7;
    ArrayList<Produit> ListProd = new ArrayList();
    String theSelectedValue;
    String[] idList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_succes);

        out7 = (TextView) findViewById(R.id.textView4);
        TableLayout med = (TableLayout) findViewById(R.id.med);

        TableRow tr1 = new TableRow(this);
        TextView theID = new TextView(this);
        theID.setText(" ID ");
        tr1.addView(theID);

        TextView theName = new TextView(this);
        theName.setText(" Nom ");
        tr1.addView(theName);

        TextView thePrice = new TextView(this);
        thePrice.setText(" Prix ");
        tr1.addView(thePrice);

        TextView theQuantite = new TextView(this);
        theQuantite.setText(" Quantite ");
        tr1.addView(theQuantite);

        med.addView(tr1);

        WebService.GetListProduitsTask task = (WebService.GetListProduitsTask) new WebService.GetListProduitsTask().execute();
        try {
            ListProd = task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (Produit p : ListProd) {

            tr1 = new TableRow(this);

            theID = new TextView(this);
            theID.setText("ID-" + p.getId());
            tr1.addView(theID);

            theName = new TextView(this);
            theName.setText(p.getNom());
            tr1.addView(theName);

            thePrice = new TextView(this);
            thePrice.setText("" + p.getPrix());
            int name = Integer.parseInt(p.getId());
            tr1.addView(thePrice);

            theQuantite = new TextView(this);
            theQuantite.setText("" + p.getQuantite());
            tr1.addView(theQuantite);

            med.addView(tr1);
            }
             idList = new String[ListProd.size()];
            for (int i = 0; i < ListProd.size(); i++) {
                idList[i] = ListProd.get(i).getId();
                System.out.println(idList[i]);
            }
        //System.out.println(idList);

        Spinner dropdown = (Spinner) findViewById(R.id.theList);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, idList);
       dropdown.setAdapter(adapter);
       theSelectedValue = dropdown.getSelectedItem().toString();
        //System.out.print("************************"+theSelectedValue);
        out7.setText("Employee List");
    }

    public void displayProduct(View myView) {

        //on va cree une instance pour le spinner et Textview
        Spinner dropdown = (Spinner)findViewById(R.id.theList);

        //on va recuperer la valeur selectionnee dans le dropdown comme String
        theSelectedValue = dropdown.getSelectedItem().toString();

        //on va recuperer la valeur selectionne dans le dropdown comme position
        // int theSelectedPosition = dropdown.getSelectedItemPosition();

        //System.out.print("************************ici"+theSelectedValue);
        Intent myIntent = new Intent(this, Main3Activity.class);
        myIntent.putExtra("ID", theSelectedValue);
        startActivity(myIntent);
    }
}

