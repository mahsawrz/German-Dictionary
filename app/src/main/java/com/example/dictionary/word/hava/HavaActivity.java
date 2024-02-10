package com.example.dictionary.word.hava;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.dictionary.R;
import com.example.dictionary.word.date.DateActivity;


public class HavaActivity extends AppCompatActivity {

    TextView tContent;
    ImageView picHava;
    Spinner spHava;
    Button btnPlay;
    MediaPlayer mp;
    DatabaseAccess db;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hava);
        tContent = findViewById(R.id.txtContentHava);
        picHava = findViewById(R.id.picHava);
        spHava = findViewById(R.id.spHava);
        btnPlay = findViewById(R.id.btnPlay);
        db = DatabaseAccess.getInstance(this);

        spHava.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                c = db.getHava(String.valueOf(position + 1));
                c.moveToFirst();
                tContent.setText(c.getString(c.getColumnIndex("content")));
                int idPic = getResources().getIdentifier(c.getString(3), "drawable", getPackageName());
                picHava.setImageResource(idPic);
                int idMedia = getResources().getIdentifier(c.getString(3), "raw", getPackageName());
                btnPlay.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        mp = MediaPlayer.create(HavaActivity.this, idMedia);
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
