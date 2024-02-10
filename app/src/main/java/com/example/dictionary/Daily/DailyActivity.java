package com.example.dictionary.Daily;

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


public class DailyActivity extends AppCompatActivity {

    TextView tContent;
    MediaPlayer mp;
    Button btnPlay;
    Spinner spDaily;
    DatabaseAccess db;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);
        tContent = findViewById(R.id.txtContentDaily);
        btnPlay = findViewById(R.id.btnPlay);
        spDaily = findViewById(R.id.spDaily);
        db = DatabaseAccess.getInstance(this);

        spDaily.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                c = db.getDaily(String.valueOf(position + 1));
                c.moveToFirst();
                tContent.setText(c.getString(c.getColumnIndex("content")));
                int idMedia = getResources().getIdentifier(c.getString(3), "raw", getPackageName());


                btnPlay.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        mp = MediaPlayer.create(DailyActivity.this, idMedia);
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