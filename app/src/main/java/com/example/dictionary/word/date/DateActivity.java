package com.example.dictionary.word.date;

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
import com.example.dictionary.word.bar.BarActivity;


public class DateActivity extends AppCompatActivity {

    TextView tContent;
    ImageView picDate;
    Spinner spHava;
    DatabaseAccess db;
    Button btnPlay;
    MediaPlayer mp;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        tContent = findViewById(R.id.txtContentDate);
        picDate = findViewById(R.id.picDate);
        btnPlay = findViewById(R.id.btnPlay);
        spHava = findViewById(R.id.spDate);
        db = DatabaseAccess.getInstance(this);

        spHava.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                c = db.getDate(String.valueOf(position + 1));
                c.moveToFirst();
                tContent.setText(c.getString(c.getColumnIndex("content")));
                int idPic = getResources().getIdentifier(c.getString(3), "drawable", getPackageName());
                picDate.setImageResource(idPic);
                int idMedia = getResources().getIdentifier(c.getString(3), "raw", getPackageName());
                btnPlay.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        mp = MediaPlayer.create(DateActivity.this, idMedia);
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
