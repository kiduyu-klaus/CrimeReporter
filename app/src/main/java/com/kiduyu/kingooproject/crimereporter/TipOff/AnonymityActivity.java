package com.kiduyu.kingooproject.crimereporter.TipOff;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Switch;

import com.kiduyu.kingooproject.crimereporter.R;

import java.util.Objects;

public class AnonymityActivity extends AppCompatActivity {

    Switch s1,s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anonymity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Anonymity");

        s1=findViewById(R.id.switch1);
        s2=findViewById(R.id.switch2);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.tipoff, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.tipoff_next) {
            Intent intent = new Intent(this, IncidentTypeActivity.class);
            intent.putExtra("report_anonymously", s1.isChecked());
            intent.putExtra("communicate", s1.isChecked());
            startActivity(intent);
        }
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}