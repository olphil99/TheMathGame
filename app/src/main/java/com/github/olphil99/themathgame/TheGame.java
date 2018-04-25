package com.github.olphil99.themathgame;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TheGame extends AppCompatActivity {

    TextView timerTxt;
    long startTime = 0;

    Handler timerHandler = new Handler();
    Runnable timerRun = new Runnable() {
        @Override
        public void run() {
            long ms = System.currentTimeMillis() - startTime;
            int sec = (int) (ms / 1000);
            sec = sec % 60;

            timerTxt.setText(sec + " s");

            timerHandler.postDelayed(this, 500);
        }
    };;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_game);

        // add timerTxt to theGame.xml
        //timerTxt = (TextView) findViewById(R.id.timerTxt);

        // might have to make the start button start the timer?
        Button btn = (Button) findViewById(R.id.startBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                // ...
            }
        });
    }
}
