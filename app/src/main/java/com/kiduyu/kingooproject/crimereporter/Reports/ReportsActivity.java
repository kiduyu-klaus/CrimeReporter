package com.kiduyu.kingooproject.crimereporter.Reports;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import com.kiduyu.kingooproject.crimereporter.Adapters.ReportsAdapter;
import com.kiduyu.kingooproject.crimereporter.Models.Reports;
import com.kiduyu.kingooproject.crimereporter.R;

import java.io.IOException;

public class ReportsActivity extends AppCompatActivity {
    private ReportsAdapter reportsAdapter;
    private ArrayList<Reports> reportsArrayList= new ArrayList<>();
    ProgressDialog progressDialog;
    RecyclerView recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Crime Rate Reports ");

         recycler= findViewById(R.id.recyclerview_complete_series);
        reportsAdapter= new ReportsAdapter(this,reportsArrayList);
        recycler.setAdapter(reportsAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        recycler.setLayoutManager(layoutManager);
        recycler.setFocusable(false);
        Content content = new Content();
        content.execute();
    }


    private class Content extends AsyncTask<Void,Void,Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showProgressDialog();
            //bindAudioService();

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);


            progressDialog.cancel();
           reportsAdapter.notifyDataSetChanged();

        }

        @Override
        protected Void doInBackground(Void... voids) {


            try {
                String rooturl = "http://www.nationalpolice.go.ke/crime-statistics.html";

                String url = rooturl;

                Document doc = Jsoup.connect(url).get();

                Elements data = doc.getElementsByClass("pd-filebox");

                int size = data.size();
                Log.d("items", "all_pdfs" + size);

                for (int i = 0; i < size; i++) {
                    String name = data
                            .select("div.pd-filenamebox")
                            .select("div.pd-filename")
                            .select("div.pd-document16")
                            .select("div.pd-float")
                            .select("a")
                            .eq(i)
                            .text();
                    String reporturl = data
                            .select("div.pd-filenamebox")
                            .select("div.pd-filename")
                            .select("div.pd-document16")
                            .select("div.pd-float")
                            .select("a")
                            .eq(i)
                            .attr("href");
                    String actualurl= "http://www.nationalpolice.go.ke/crime-statistics.html"+reporturl;
                    Log.d("TAG", "filename: "+actualurl);
                    // String name = getArguments().getString("name");
                    reportsArrayList.add(new Reports(name,"Pdf","1.6mbs","",actualurl));


                    //mObjects.add(new Audio(detailtitle+" part: "+i,audiourl));
                   // Log.d("items", "Image url: " + coverurl+" Image url part: " + i);

                }



            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }
    }

    public void showProgressDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.setCanceledOnTouchOutside(false);
        Objects.requireNonNull(progressDialog.getWindow()).setBackgroundDrawableResource(android.R.color.transparent);
        Runnable progressRunnable = new Runnable() {

            @Override
            public void run() {
                int confirmation=0;
                if (confirmation != 1) {
                    progressDialog.cancel();
                    //Toast.makeText(MainActivity.this, "Internet slow/not available", Toast.LENGTH_SHORT).show();
                }
            }
        };
        Handler pdCanceller = new Handler();
        pdCanceller.postDelayed(progressRunnable, 8000);
    }
}