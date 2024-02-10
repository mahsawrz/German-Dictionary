package com.example.dictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dictionary.word.bar.BarActivity;
import com.example.dictionary.word.date.DateActivity;
import com.example.dictionary.word.hava.HavaActivity;
import com.example.dictionary.word.job.JobActivity;
import com.example.dictionary.word.mode.ModeActivity;
import com.example.dictionary.word.organ.OrganActivity;

public class WordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);
    }

    public void organVoid(View view) {
        startActivity(new Intent(this , OrganActivity.class));
    }

    public void jobVoid(View view) {
        startActivity(new Intent(this , JobActivity.class));
    }

    public void modeVoid(View view) {
        startActivity(new Intent(this , ModeActivity.class));
    }

    public void barVoid(View view) {
        startActivity(new Intent(this , BarActivity.class));
    }

    public void havaVoid(View view) {
        startActivity(new Intent(this , HavaActivity.class));
    }

    public void dateVoid(View view) {
        startActivity(new Intent(this , DateActivity.class));
    }
}