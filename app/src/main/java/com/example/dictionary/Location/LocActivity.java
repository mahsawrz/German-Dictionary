package com.example.dictionary.Location;

import androidx.appcompat.app.AppCompatActivity;

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

public class LocActivity extends AppCompatActivity {

    TextView tContent;
    Spinner spLoc;
    MediaPlayer mp;
    Button btnPlay;
    DatabaseAccess db;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loc);
        tContent = findViewById(R.id.txtContent);
        btnPlay = findViewById(R.id.btnPlay);
        spLoc = findViewById(R.id.spLoc);
        db = DatabaseAccess.getInstance(this);

        spLoc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                c = db.getLoc(String.valueOf(position + 1));
                c.moveToFirst();
                tContent.setText(c.getString(c.getColumnIndex("content")));
                int idMedia = getResources().getIdentifier(c.getString(3), "raw", getPackageName());


                btnPlay.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        mp = MediaPlayer.create(LocActivity.this, idMedia);
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