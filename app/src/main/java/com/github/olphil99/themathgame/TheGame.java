package com.github.olphil99.themathgame;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TheGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_game);

        new CountDownTimer(60000, 1000) {
            public void onTick(long msUntilFinished) {
                //timerTxt.setText(msUntilFinished / 1000 + " s");
            }

            public void onFinish() {
                //display alert saying game is over
            }
        }.start();
    }
}
