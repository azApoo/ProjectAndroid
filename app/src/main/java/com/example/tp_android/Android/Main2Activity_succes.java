package com.example.tp_android.Android;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tp_android.Main3Activity;
import com.example.tp_android.Models.Produit;
import com.example.tp_android.R;
import com.example.tp_android.Service.WebService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Main2Activity_succes extends AppCompatActivity {
    ArrayList<Produit> ListProd = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_succes);

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
            String[] idList = new String[ListProd.size()];
            for (int i = 0; i < ListProd.size() - 1; i++) {
                idList[i] = ListProd.get(i).getId();
            }
                //System.out.println(idList[i]);
                Spinner dropdown = (Spinner) findViewById(R.id.theList);
                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, idList);
                dropdown.setAdapter(adapter);

                //on va cree une instance pour le spinner et Textview
                //Spinner dropdown = (Spinner) findViewById(R.id.theList);



                //on va recuperer la valeur selectionnee dans le dropdown comme String
                String theSelectedValue = dropdown.getSelectedItem().toString();

                //on va recuperer la valeur selectionne dans le dropdown comme position
                int theSelectedPosition = dropdown.getSelectedItemPosition();

                Intent myIntent = new Intent(this, Main3Activity.class);
                myIntent.putExtra("ID", theSelectedValue);
                startActivity(myIntent);

            }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();



}
    //public void displayProduct(View myView) {
//        WebService.GetListProduitsTask task = (WebService.GetListProduitsTask) new WebService.GetListProduitsTask().execute();
//        try {
//            ListProd = task.get();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        String[] idList=new String[ListProd.size()];
//        for(int i=0; i<ListProd.size()-1; i++) {
//            idList[i]=ListProd.get(i).getId();
//            System.out.println(idList[i]);
//        Spinner dropdown = (Spinner) findViewById(R.id.theList);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, idList);
//        dropdown.setAdapter(adapter);
//
//        //on va cree une instance pour le spinner et Textview
//        //Spinner dropdown = (Spinner) findViewById(R.id.theList);
//        TextView myLabel = (TextView) findViewById(R.id.textView4);
//
//        //on va recuperer la valeur selectionnee dans le dropdown comme String
//        String theSelectedValue = dropdown.getSelectedItem().toString();
//
//        //on va recuperer la valeur selectionne dans le dropdown comme position
//        int theSelectedPosition = dropdown.getSelectedItemPosition();
//
//        Intent myIntent = new Intent(this, Main3Activity.class);
//        myIntent.putExtra("ID", theSelectedValue);
//        startActivity(myIntent);
//        }
//
//    }
//}

