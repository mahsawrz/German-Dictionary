package com.example.dictionary.word.mode;

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


public class ModeActivity extends AppCompatActivity {

    TextView tContent;
    ImageView picMode;
    Spinner spMode;
    DatabaseAccess db;
    Cursor c;
    MediaPlayer mp;
    Button btnPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode);
        tContent = findViewById(R.id.txtContentMode);
        picMode = findViewById(R.id.picMode);
        spMode = findViewById(R.id.spMode);
        btnPlay = findViewById(R.id.btnPlay);
        db = DatabaseAccess.getInstance(this);

        spMode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                c = db.getMode(String.valueOf(position + 2));
                c.moveToFirst();
                tContent.setText(c.getString(c.getColumnIndex("content")));
                int idPic = getResources().getIdentifier(c.getString(3), "drawable", getPackageName());
                picMode.setImageResource(idPic);
                int idMedia = getResources().getIdentifier(c.getString(3), "raw", getPackageName());
                btnPlay.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        mp = MediaPlayer.create(ModeActivity.this, idMedia);
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
