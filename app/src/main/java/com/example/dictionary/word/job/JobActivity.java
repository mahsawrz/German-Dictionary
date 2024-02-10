package com.example.dictionary.word.job;

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


public class JobActivity extends AppCompatActivity {

    TextView tContent;
    ImageView picJob;
    Spinner spJob;
    DatabaseAccess db;
    Button btnPlay;
    MediaPlayer mp;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);
        tContent = findViewById(R.id.txtContentJob);
        btnPlay = findViewById(R.id.btnPlay);
        picJob = findViewById(R.id.picJob);
        spJob = findViewById(R.id.spJob);
        db = DatabaseAccess.getInstance(this);

        spJob.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                c = db.getJob(String.valueOf(position + 1));
                c.moveToFirst();
                tContent.setText(c.getString(c.getColumnIndex("content")));
                int idPic = getResources().getIdentifier(c.getString(3), "drawable", getPackageName());
                picJob.setImageResource(idPic);
                int idMedia = getResources().getIdentifier(c.getString(3), "raw", getPackageName());
                btnPlay.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        mp = MediaPlayer.create(JobActivity.this, idMedia);
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
