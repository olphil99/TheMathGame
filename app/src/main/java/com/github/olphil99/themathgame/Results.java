package com.github.olphil99.themathgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Button;

public class Results extends AppCompatActivity {

    int correct, incorrect, numQuestions, accuracy;
    double timePer;
    String letterGrade;
    TextView correctTxt, incorrectTxt, accuracyTxt, timeTxt, gradeTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Button restart = findViewById(R.id.restartBtn);
        restart.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                startActivity(new Intent(Results.this, StartScreen.class));
            }
        });

        // receive data
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        correctTxt = findViewById(R.id.correct);
        incorrectTxt = findViewById(R.id.incorrect);
        accuracyTxt = findViewById(R.id.accuracy);
        timeTxt = findViewById(R.id.timeP);
        gradeTxt = findViewById(R.id.grade);

        // calculate numbers
        correct = extras.getInt("correct");
        incorrect = extras.getInt("incorrect");
        numQuestions = correct + incorrect;

        if (numQuestions != 0) {
            accuracy = (int) Math.round(correct * 100 / numQuestions);
            timePer = 60 / numQuestions;
            timePer = Math.round(timePer * 100.0) / 100.0;
        }

        // display numbers
        correctTxt.setText("" + correct);
        incorrectTxt.setText("" + incorrect);
        accuracyTxt.setText("" + accuracy + "%");
        timeTxt.setText("" + timePer + "s");

        if (accuracy >= 90) {
            letterGrade = "A";
        } else if (accuracy >= 80) {
            letterGrade = "B";
        } else if (accuracy >= 70) {
            letterGrade = "C";
        } else if (accuracy >= 60) {
            letterGrade = "D";
        } else {
            letterGrade = "F";
        }

        gradeTxt.setText(letterGrade);

    }
}
