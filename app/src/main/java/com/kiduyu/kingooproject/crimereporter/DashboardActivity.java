package com.kiduyu.kingooproject.crimereporter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.kiduyu.kingooproject.crimereporter.GeneralInfo.GeneralInfoActivity;
import com.kiduyu.kingooproject.crimereporter.Messages.MessagesActivity;
import com.kiduyu.kingooproject.crimereporter.Reports.ReportsActivity;
import com.kiduyu.kingooproject.crimereporter.StatusBar.StatusBar;
import com.kiduyu.kingooproject.crimereporter.TipOff.AnonymityActivity;

import java.util.Objects;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        //StatusBar.changeStatusBarColor(this);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Crime Reporter System (Kenya)");

    }

    public void Tipoff(View view) {
        startActivity(new Intent(this, AnonymityActivity.class));
    }

    public void Message(View view) {
        startActivity(new Intent(this, MessagesActivity.class));
    }

    public void Callcrimedesk(View view) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Crime Reporter is not for emergencies");
        alertDialogBuilder.setMessage("In case of emergencies please call 999 for assistance");
        alertDialogBuilder.setPositiveButton("Call",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        CallPolice();


                    }
                });

        alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(DashboardActivity.this, "Call Cancelled", Toast.LENGTH_LONG).show();
            }
        });
        alertDialogBuilder.show();

    }

    private void CallPolice() {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);

        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    Integer.parseInt("123"));
        } else {
            startActivity(new Intent(Intent.ACTION_CALL).setData(Uri.parse("tel:112")));
        }
    }


    public void GeneralInfo(View view) {
        startActivity(new Intent(this, GeneralInfoActivity.class));
    }

    public void PeopleOfInterest(View view) {
    }

    public void Station(View view) {
    }

    public void CrimeRates(View view) {
        startActivity(new Intent(this, ReportsActivity.class));
    }

    public void SocialMedia(View view) {
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {

            case 123:
                if ((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    CallPolice();
                } else {
                    Log.d("TAG", "Call Permission Not Granted");
                }
                break;

            default:
                break;
        }
    }
}
