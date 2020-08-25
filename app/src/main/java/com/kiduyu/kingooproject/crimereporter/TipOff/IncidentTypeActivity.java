package com.kiduyu.kingooproject.crimereporter.TipOff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.kiduyu.kingooproject.crimereporter.R;

import java.util.Objects;

public class IncidentTypeActivity extends AppCompatActivity {

    boolean report,communicate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incident_type);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Type Of Incident");

        report =getIntent().getExtras().getBoolean("report_anonymously");
        communicate=getIntent().getExtras().getBoolean("communicate");





    }

    public void Corruption(View view) {
        Intent intent = new Intent(this, ReportActivity.class);
        intent.putExtra("Type", "Corruption");
        intent.putExtra("report", report);
        intent.putExtra("communicate", communicate);
        startActivity(intent);
    }

    public void DrugRelated(View view) {
        Intent intent = new Intent(this, ReportActivity.class);
        intent.putExtra("Type", "Drug Related");
        intent.putExtra("report", report);
        intent.putExtra("communicate", communicate);
        startActivity(intent);
    }

    public void Other(View view) {
        Intent intent = new Intent(this, ReportActivity.class);
        intent.putExtra("Type", "Others");
        intent.putExtra("report", report);
        intent.putExtra("communicate", communicate);
        startActivity(intent);
    }

    public void Missing(View view) {
        Intent intent = new Intent(this, ReportActivity.class);
        intent.putExtra("Type", "Missing Persons");
        intent.putExtra("report", report);
        intent.putExtra("communicate", communicate);
        startActivity(intent);
    }

    public void Wanted(View view) {
        Intent intent = new Intent(this, ReportActivity.class);
        intent.putExtra("Type", "Wanted Persons");
        intent.putExtra("report", report);
        intent.putExtra("communicate", communicate);
        startActivity(intent);
    }

    public void Theft(View view) {
        Intent intent = new Intent(this, ReportActivity.class);
        intent.putExtra("Type", "Theft");
        intent.putExtra("report", report);
        intent.putExtra("communicate", communicate);
        startActivity(intent);
    }

    public void Sexual(View view) {
        Intent intent = new Intent(this, ReportActivity.class);
        intent.putExtra("Type", "Sexual Assault");
        intent.putExtra("report", report);
        intent.putExtra("communicate", communicate);
        startActivity(intent);
    }

    public void Abuse(View view) {
        Intent intent = new Intent(this, ReportActivity.class);
        intent.putExtra("Type", "Abuse Of Any Kind");
        intent.putExtra("report", report);
        intent.putExtra("communicate", communicate);
        startActivity(intent);
    }

    public void Murder(View view) {
        Intent intent = new Intent(this, ReportActivity.class);
        intent.putExtra("Type", "Murder");
        intent.putExtra("report", report);
        intent.putExtra("communicate", communicate);
        startActivity(intent);
    }

    public void Fraud(View view) {
        Intent intent = new Intent(this, ReportActivity.class);
        intent.putExtra("Type", "Fraund");
        intent.putExtra("report", report);
        intent.putExtra("communicate", communicate);
        startActivity(intent);
    }
}