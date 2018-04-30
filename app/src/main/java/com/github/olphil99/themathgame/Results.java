package com.github.olphil99.themathgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Results extends AppCompatActivity {

    int correct = Integer.valueOf(getIntent().getStringExtra("correct"));
    int incorrect = Integer.valueOf(getIntent().getStringExtra("incorrect"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);


    }
}
