package com.example.dictionary.Bank;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


import com.example.dictionary.Doctor.MainActivity;
import com.example.dictionary.R;
import com.example.dictionary.word.bar.BarActivity;

public class BankActivity extends AppCompatActivity {

    TextView tContent;
    Spinner spBank;
    MediaPlayer mp;
    Button btnPlay;
    DatabaseAccess db;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank);
        tContent = findViewById(R.id.txtContentBank);
        spBank = findViewById(R.id.spbank);
        db = DatabaseAccess.getInstance(this);
        btnPlay = findViewById(R.id.btnPlay);

        spBank.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                c = db.getBank(String.valueOf(position + 1));
                c.moveToFirst();
                tContent.setText(c.getString(c.getColumnIndex("content")));
                int idMedia = getResources().getIdentifier(c.getString(3), "raw", getPackageName());


                btnPlay.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        mp = MediaPlayer.create(BankActivity.this, idMedia);
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