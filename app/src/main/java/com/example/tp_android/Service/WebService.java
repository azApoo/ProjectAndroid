package com.example.tp_android.Service;

import com.example.tp_android.Models.Produit;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class WebService {

    public static List<Produit> getList() {

        List<Produit> ListProduits = null;


        URL url = null;

        try {
            url = new URL("http://localhost:52092/wsREST_simple/webresources/produit");
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

            System.out.println(response.toString());

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

            }
            ListProduits.add(p);

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        System.out.println(ListProduits);
        return ListProduits;

    }


    public Produit getProduit(String id) {
        Produit p = new Produit();

        URL url = null;

        try {
            url = new URL("http://localhost:52092/wsREST_simple/webresources/produit/id/"+id);
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

            System.out.println(response.toString());

            JSONObject JSONProduit = new JSONObject(response.toString());

            p.setId(JSONProduit.getString("id"));
            p.setNom(JSONProduit.getString("nom"));
            p.setPrix(JSONProduit.getDouble("prix"));
            p.setQuantite(JSONProduit.getInt("quantite"));

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        System.out.println(p);
        return p;


    }


}
