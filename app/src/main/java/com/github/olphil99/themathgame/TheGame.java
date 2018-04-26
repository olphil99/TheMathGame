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
import android.widget.Button;
import android.widget.RelativeLayout;
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
    };
    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_game);

        // add timerTxt to theGame.xml
        timerTxt = (TextView) findViewById(R.id.timerTxt);

        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#195cc6"));
        Bitmap bg = Bitmap.createBitmap(400, 800, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bg);
        canvas.drawRect(70, 120, 330, 240, paint);
        paint.setColor(Color.parseColor("#ffffff"));
        canvas.drawRect(75, 125, 325, 235, paint);
        RelativeLayout rel = (RelativeLayout) findViewById(R.id.thePage);
        rel.setBackgroundDrawable(new BitmapDrawable(bg));


        // might have to make the start button start the timer?
        Button btn = (Button) findViewById(R.id.startBtn);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Button b = (Button) v;
//                // ...
//            }
//        });
    }
}
