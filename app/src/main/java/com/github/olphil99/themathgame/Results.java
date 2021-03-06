package com.github.olphil99.themathgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageView;
import android.content.Intent;
import android.app.AlertDialog;
import android.content.DialogInterface;

import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.android.volley.toolbox.StringRequest ;

import android.widget.Button;

public class Results extends AppCompatActivity {

    int correct, incorrect, numQuestions, accuracy;
    double timePer;
    String letterGrade;
    TextView correctTxt, incorrectTxt, accuracyTxt, timeTxt, gradeTxt;
    ImageView factSpot;

    private static RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        requestQueue = Volley.newRequestQueue(this);
        Button restart = findViewById(R.id.restartBtn);
        restart.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                startActivity(new Intent(Results.this, StartScreen.class));
            }
        });

        Button surprise = findViewById(R.id.surpriseBtn);
        surprise.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                getFact(correct);
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
            accuracy = Math.round(correct * 100 / numQuestions);
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

    private void getFact(final int num) {
//        try {
//            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
//                    Request.Method.GET,
//                    "http://thecatapi.com/api/images/get?format=xml&type=gif&size=small",
//                    null,
//                    new Response.Listener<org.json.JSONObject>() {
//                        @Override
//                        public void onResponse(final JSONObject response) {
//                            String gifUrl = response.toString();
//                            Log.d("URL", gifUrl);
//                        }
//                    }, new Response.ErrorListener() {
//                @Override
//                public void onErrorResponse(final VolleyError error) {
//                    Log.w("ERR", error.toString());
//                }
//            });
//            requestQueue.add(jsonObjectRequest);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try {
            StringRequest request = new StringRequest(
                    "http://numbersapi.com/" + num,
                    new Response.Listener<String>() {
                            @Override
                            public void onResponse(final String response) {
                                Log.d("RESPONSE", response);
                                AlertDialog alert = new AlertDialog.Builder(Results.this).create();
                                alert.setTitle("Fun Fact!");
                                alert.setMessage(response);
                                alert.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                                alert.show();
                            }
                        }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(final VolleyError error) {
                            Log.d("ERR", error.toString());
                        }
                    }
                    );
            requestQueue.add(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
