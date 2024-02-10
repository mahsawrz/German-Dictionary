package com.example.dictionary.word.organ;

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

public class OrganActivity extends AppCompatActivity {
    TextView tContent;
    ImageView picOrgan;
    Spinner spOrgan;
    DatabaseAccess db;
    MediaPlayer mp;
    Button btnPlay;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organ);
        tContent = findViewById(R.id.txtContent);
        picOrgan = findViewById(R.id.pic);
        btnPlay = findViewById(R.id.btnPlay);
        spOrgan = findViewById(R.id.spOrgan);
        db = DatabaseAccess.getInstance(this);

        spOrgan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                c = db.getOrgan(String.valueOf(position + 1));
                c.moveToFirst();
                tContent.setText(c.getString(c.getColumnIndex("content")));
                int idPic = getResources().getIdentifier(c.getString(3), "drawable", getPackageName());
                picOrgan.setImageResource(idPic);
                int idMedia = getResources().getIdentifier(c.getString(3), "raw", getPackageName());
                btnPlay.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        mp = MediaPlayer.create(OrganActivity.this, idMedia);
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
