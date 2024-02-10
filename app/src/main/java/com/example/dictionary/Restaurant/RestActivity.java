package com.example.dictionary.Restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


import com.example.dictionary.Bank.BankActivity;
import com.example.dictionary.R;

public class RestActivity extends AppCompatActivity {

    TextView tContent;
    MediaPlayer mp;
    Button btnPlay;
    Spinner spRest;
    DatabaseAccess db;
    Cursor c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest);
        tContent = findViewById(R.id.txtContentRest);
        spRest = findViewById(R.id.spRest);
        btnPlay = findViewById(R.id.btnPlay);
        db = DatabaseAccess.getInstance(this);

        spRest.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                c = db.getRest(String.valueOf(position + 1));
                c.moveToFirst();
                tContent.setText(c.getString(c.getColumnIndex("content")));
                int idMedia = getResources().getIdentifier(c.getString(3), "raw", getPackageName());
                btnPlay.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        mp = MediaPlayer.create(RestActivity.this, idMedia);
                        mp.start();

                    }

                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}