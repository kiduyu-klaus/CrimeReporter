package com.kiduyu.kingooproject.crimereporter.GeneralInfo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.kiduyu.kingooproject.crimereporter.DashboardActivity;
import com.kiduyu.kingooproject.crimereporter.R;

import java.util.Objects;

public class GeneralInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_info);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setTitle("General Information");
    }

    public void WhatisACrime(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("What is A Crime");
        alertDialogBuilder.setMessage(getString(R.string.what_is_a_crime));


        alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(GeneralInfoActivity.this, "Closed", Toast.LENGTH_LONG).show();
            }
        });
        alertDialogBuilder.show();
    }

    public void CrimeTypes(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Crime Types");
        alertDialogBuilder.setMessage(getString(R.string.types_of_crimes_1)+getString(R.string.types_of_crimes_2)+
                getString(R.string.types_of_crimes_3)+getString(R.string.types_of_crimes_4)+getString(R.string.types_of_crimes_5));


        alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(GeneralInfoActivity.this, "Closed", Toast.LENGTH_LONG).show();
            }
        });
        alertDialogBuilder.show();

    }
}