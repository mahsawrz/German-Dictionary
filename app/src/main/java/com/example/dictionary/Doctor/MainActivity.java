package com.example.dictionary.Doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.dictionary.R;

public class MainActivity extends AppCompatActivity {

    TextView tContent;
    Spinner spDr;
    MediaPlayer mp;
    Button btnPlay;
    DatabaseAccess db;
    Cursor c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tContent = findViewById(R.id.txtContentDr);
        spDr = findViewById(R.id.spDr);
        btnPlay = findViewById(R.id.btnPlay);
        db = DatabaseAccess.getInstance(this);


        spDr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                c = db.getDr(String.valueOf(position + 1));
                c.moveToFirst();
                tContent.setText(c.getString(c.getColumnIndex("content")));
                int idMedia = getResources().getIdentifier(c.getString(3), "raw", getPackageName());

               
                btnPlay.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        mp = MediaPlayer.create(MainActivity.this, idMedia);
                        mp.start();

                    }

                });



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public void keyWordRestVoid(View view) {
    }


}