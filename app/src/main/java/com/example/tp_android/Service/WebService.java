package com.example.tp_android.Service;

import android.os.AsyncTask;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.tp_android.Models.Produit;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WebService {


    public static class GetListProduitsTask extends AsyncTask<Void, ArrayList<Produit>, ArrayList<Produit>> {

        @Override
        protected ArrayList<Produit> doInBackground(Void... params) {

            ArrayList<Produit> ListProduits = new ArrayList();
            URL url = null;

            try {
                url = new URL("http://aniss.ca/REST_WebService_Produit/webresources/produit");
                HttpURLConnection client = null;

                client = (HttpURLConnection) url.openConnection();

                client.setRequestMethod("GET");

                int responsecode = client.getResponseCode();

                System.out.println("\n Sending 'GET' request to URL : " + url);
                System.out.println("response Code : " + responsecode);


                InputStreamReader myInput = new InputStreamReader(client.getInputStream());
                BufferedReader in = new BufferedReader(myInput);
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                JSONArray produits = new JSONArray(response.toString());
                JSONObject SingleProduit;
                Produit p = null;
                for (int i = 0; i < produits.length(); i++) {
                    SingleProduit = produits.getJSONObject(i);
                    p = new Produit();
                    p.setId(SingleProduit.getString("id"));
                    p.setNom(SingleProduit.getString("nom"));
                    p.setPrix(SingleProduit.getDouble("prix"));
                    p.setQuantite(SingleProduit.getInt("quantite"));


                    ListProduits.add(i, p);
                }


            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
            return ListProduits;

        }

    }


    public static class GetProduitTask extends AsyncTask<String, Produit, Produit> {

        @Override
        protected Produit doInBackground(String... params) {
            String id = params[0];
            Produit p = new Produit();
            URL url = null;

            try {

                url = new URL("http://aniss.ca/REST_WebService_Produit/webresources/produit/id/" + id);
                HttpURLConnection client = null;

                client = (HttpURLConnection) url.openConnection();

                client.setRequestMethod("GET");

                int responsecode = client.getResponseCode();

                System.out.println("\n Sending 'GET' request to URL : " + url);
                System.out.println("response Code : " + responsecode);


                InputStreamReader myInput = new InputStreamReader(client.getInputStream());
                BufferedReader in = new BufferedReader(myInput);
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                JSONObject JSONProduit = new JSONObject(response.toString());

                p.setId(JSONProduit.getString("id"));
                p.setNom(JSONProduit.getString("nom"));
                p.setPrix(JSONProduit.getDouble("prix"));
                p.setQuantite(JSONProduit.getInt("quantite"));
                p.setDescription(JSONProduit.getString("desciption"));

            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
            return p;

        }

    }

}
