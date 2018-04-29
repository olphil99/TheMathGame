package com.github.olphil99.themathgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View.OnKeyListener;
import android.view.KeyEvent;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.view.MotionEvent;
import android.os.SystemClock;


public class TheGame extends AppCompatActivity {

    TextView timerTxt, question;
    EditText answer;
    RandomMathProblem problem;
    int incorrect = 0, correct = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_game);

        // initialize textViews
        timerTxt = findViewById(R.id.timerTxt);
        question = findViewById(R.id.qstn);
        answer = findViewById(R.id.answerTxt);

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

        displayQuestion();

        answer.setOnKeyListener(new OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                TextView score = findViewById(R.id.urScoreTxt);
                EditText display = findViewById(R.id.answerTxt);

                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    String entry = display.getText().toString();
                    int guess = Integer.valueOf(entry);
                    if(problem.checkAnswer(guess)) {
                        correct++;
                    } else {
                        incorrect++;
                    }

                    displayQuestion();
                    display.getText().clear();
                    score.setText("" + correct);
                    return true;
                }
                return false;
            }
        });


    }

    private void displayQuestion() {
        problem = new RandomMathProblem();
        question.setText(problem.getProblem());
    }

}
