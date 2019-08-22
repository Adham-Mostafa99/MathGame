package com.example.mathgame;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {
    //Declare timer
    CountDownTimer cTimer = null;
    TextView timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        timer = (TextView) findViewById(R.id.timerText);
        startTimer();
    }


    //start timer function
    void startTimer() {
        cTimer = new CountDownTimer(31000, 1000) {
            public void onTick(long l) {
                timer.setText(String.valueOf(l/1000));
            }

            public void onFinish() {
                timer.setText("finished");
                timer.setTextSize(16);
                cancelTimer();
            }
        };
        cTimer.start();
    }


    //cancel timer
    void cancelTimer() {
        if (cTimer != null)
            cTimer.cancel();
    }
}
