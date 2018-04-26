package com.github.olphil99.themathgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TheGame extends AppCompatActivity {

    TextView timerTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_game);

        // initialize timerTxt
        timerTxt = (TextView) findViewById(R.id.timerTxt);

        // Declare score variables
        int incorrect = 0, correct = 0;

        // Rectangle boarder around question
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#195cc6"));
        Bitmap bg = Bitmap.createBitmap(400, 800, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bg);
        canvas.drawRect(70, 120, 330, 240, paint);
        paint.setColor(Color.parseColor("#ffffff"));
        canvas.drawRect(75, 125, 325, 235, paint);
        RelativeLayout rel = (RelativeLayout) findViewById(R.id.thePage);
        rel.setBackgroundDrawable(new BitmapDrawable(bg));

        // Start timer
        CountDownTimer timer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long msFin) {
                timerTxt.setText(msFin / 1000 + " s");
            }

            @Override
            public void onFinish() {
                timerTxt.setText("!");
                // replace with *open score*
            }
        }.start();

    }
}
