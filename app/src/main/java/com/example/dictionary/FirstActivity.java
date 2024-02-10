package com.example.dictionary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    public void expVoid(View view) {

        startActivity(new Intent(this , expActivity.class));
    }

    public void exitVoid(View view) {
        onBackPressed();
    }
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("بستن برنامه");
        builder.setIcon(R.drawable.ic_baseline_exit_to_app_24);
        builder.setMessage("آیا می خواهید از برنامه خارج شوید؟");
        builder.setPositiveButton("تایید", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("لغو", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();


        //super.onBackPressed();
    }

    public void aboutVoid(View view) {
        View app_v = getLayoutInflater().inflate(R.layout.about , null);
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setView(app_v);
        AlertDialog alertDialog = builder1.create();
        alertDialog.show();
    }

    public void wordVoid(View view) {
       startActivity(new Intent(this , WordActivity.class));
    }

    public void zarbVoid(View view) {
        View v_alert = getLayoutInflater().inflate(R.layout.zarblayout, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(v_alert);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}