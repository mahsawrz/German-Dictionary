package com.example.dictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dictionary.Bank.BankActivity;
import com.example.dictionary.Daily.DailyActivity;
import com.example.dictionary.Doctor.MainActivity;
import com.example.dictionary.Location.LocActivity;
import com.example.dictionary.Restaurant.RestActivity;

public class expActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp);
    }

    public void drVoid(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void locVoid(View view) {
        startActivity(new Intent(this, LocActivity.class));
    }


    public void restVoid(View view) {
        startActivity(new Intent(this, RestActivity.class));
    }

    public void bankVoid(View view) {
        startActivity(new Intent(this, BankActivity.class));
    }

    public void dailyVoid(View view) {
        startActivity(new Intent(this, DailyActivity.class));
    }

}