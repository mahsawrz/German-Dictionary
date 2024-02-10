package com.example.dictionary.word.bar;

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

import com.example.dictionary.Bank.BankActivity;
import com.example.dictionary.R;

public class BarActivity extends AppCompatActivity {

    TextView tContent;
    ImageView picBar;
    Button btnPlay;
    MediaPlayer mp;
    Spinner spBar;
    DatabaseAccess db;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar);
        tContent = findViewById(R.id.txtContentBar);
        picBar = findViewById(R.id.picBar);
        spBar = findViewById(R.id.spBar);
        btnPlay = findViewById(R.id.btnPlay);
        db = DatabaseAccess.getInstance(this);

        spBar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                c = db.getBar(String.valueOf(position + 1));
                c.moveToFirst();
                tContent.setText(c.getString(c.getColumnIndex("content")));
                int idPic = getResources().getIdentifier(c.getString(3), "drawable", getPackageName());
                int idMedia = getResources().getIdentifier(c.getString(3), "raw", getPackageName());
                picBar.setImageResource(idPic);
                btnPlay.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        mp = MediaPlayer.create(BarActivity.this, idMedia);
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
