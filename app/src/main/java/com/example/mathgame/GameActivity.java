package com.example.mathgame;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.Random;

public class GameActivity extends AppCompatActivity {
    static String OPERATION_SYMBOL = "";
    static int CHECK_PAGE = 0, MIN_VALUE = 5, MAX_VALUE = 20, LEVEL = 1, MIN_VALUE_DEV = 5, MAX_VALUE_DEV = 15;
    CountDownTimer cTimer = null, stopt_timer = null;
    Random random;
    TextView timer, score, level, question;
    Button answer1, answer2, answer3, answer4;
    ScrollView scrollView;
    int number1, number2, sum, answer_1, answer_2, answer_3, answer_4, number_of_times, old_number_of_times, score_level;

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.answer1:
                    checkAnswer(answer_1, answer1);
                    break;
                case R.id.answer2:
                    checkAnswer(answer_2, answer2);
                    break;
                case R.id.answer3:
                    checkAnswer(answer_3, answer3);
                    break;
                case R.id.answer4:
                    checkAnswer(answer_4, answer4);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //deceleration the Views
        decleration();

        //set color of timer
        setColor();

        //start timer
        startTimer(16000, 1000);

        //get Random numbers for question
        randomNumbers();

        //get random value for answer
        randomValue();

        //get random answers
        getAnswer();

        //show question and answers in TextViews
        showText();

        //set Buttons Click
        buttonClick();

    }


    //start timer function
    private void startTimer(int full_time, int min_time) {
        cTimer = new CountDownTimer(full_time, min_time) {
            public void onTick(long l) {
                timer.setText(String.valueOf(l / 1000));
            }

            public void onFinish() {
                timer.setText("Game Over");
                timer.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.wrongAnswer));
                timer.setTextSize(24);
                answer1.setClickable(false);
                answer2.setClickable(false);
                answer3.setClickable(false);
                answer4.setClickable(false);
                cancelTimer(cTimer);
            }
        };
        cTimer.start();
    }


    //cancel timer
    private void cancelTimer(CountDownTimer countDownTimer) {
        if (countDownTimer != null)
            countDownTimer.cancel();
    }

    //deceleration the Views
    private void decleration() {
        timer = findViewById(R.id.timerText);
        question = findViewById(R.id.question);
        score = findViewById(R.id.score);
        level = findViewById(R.id.level);
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);
        scrollView = (ScrollView) findViewById(R.id.back_ground);
    }

    //get Random numbers for question
    private void randomNumbers() {
        number1 = 0;
        number2 = 0;
        random = new Random();
        while (number1 <= number2) {
            if (CHECK_PAGE == 2) {
                number1 = random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
                number2 = random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
                while (number1 - number2 < 10) {
                    number1 = random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
                    number2 = random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
                }


            } else if (CHECK_PAGE == 4) {
                Log.v("GameActivity", "gone");
                number1 = random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
                number2 = random.nextInt(MAX_VALUE_DEV - MIN_VALUE_DEV + 1) + MIN_VALUE_DEV;

                while ((((float) number1 / (float) number2)) % 1 != 0) {
                    Log.v("GameActivity", "number1  " + number1 + "   " + "number2  " + number2);
                    number1 = random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
                    number2 = random.nextInt(MAX_VALUE_DEV - MIN_VALUE_DEV + 1) + MIN_VALUE_DEV;
                }


            } else {
                number1 = random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
                number2 = random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
            }
        }

        //make 4 random numbers to answer's places
        number_of_times = random.nextInt(4);

        if (CHECK_PAGE == 1)
            sum = number1 + number2;
        else if (CHECK_PAGE == 2)
            sum = number1 - number2;

        else if (CHECK_PAGE == 3)
            sum = number1 * number2;

        else if (CHECK_PAGE == 4)
            sum = number1 / number2;

    }

    //get random answers
    private void getAnswer() {
        switch (number_of_times) {
            case 0:
                setRandomValues(randomValue()[0], randomValue()[1], randomValue()[2], randomValue()[3]);
                break;
            case 1:
                setRandomValues(randomValue()[1], randomValue()[0], randomValue()[2], randomValue()[3]);
                break;
            case 2:
                setRandomValues(randomValue()[1], randomValue()[2], randomValue()[0], randomValue()[3]);
                break;
            case 3:
                setRandomValues(randomValue()[1], randomValue()[2], randomValue()[3], randomValue()[0]);
                break;
        }
    }

    //get random value for answer
    private int[] randomValue() {
        int[] random_num = new int[4];
        random_num[0] = sum;
        while (random_num[0] == random_num[1] || random_num[0] == random_num[2] ||
                random_num[0] == random_num[3] || random_num[1] == random_num[2] || random_num[1]
                == random_num[3] || random_num[2] == random_num[3]) {
            random_num[1] = random.nextInt(sum + 15 - sum - 1 + 1) + sum - 1;
            random_num[2] = random.nextInt(sum + 15 - sum - 1 + 1) + sum - 1;
            random_num[3] = random.nextInt(sum + 15 - sum - 1 + 1) + sum - 1;
        }
        return random_num;
    }

    //show question and answers in TextViews
    private void showText() {
        question.setText(number1 + OPERATION_SYMBOL + number2);
        answer1.setText(String.valueOf(answer_1));
        answer2.setText(String.valueOf(answer_2));
        answer3.setText(String.valueOf(answer_3));
        answer4.setText(String.valueOf(answer_4));
        level.setText(String.valueOf(LEVEL));
        score.setText(score_level + " / 100");
    }

    //put random values to answers
    private void setRandomValues(int num1, int num2, int num3, int num4) {
        answer_1 = num1;
        answer_2 = num2;
        answer_3 = num3;
        answer_4 = num4;
    }

    //set color of timer
    private void setColor() {

        switch (CHECK_PAGE) {
            case 1:
                scrollView.setBackgroundColor(ContextCompat.getColor(this, R.color.plusScrolBackground));
                timer.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.timer_show_plus));
                checkColor(R.drawable.answer_button_plus);
                break;
            case 2:
                scrollView.setBackgroundColor(ContextCompat.getColor(this, R.color.subScrollBackground));
                timer.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.timer_show_sub));
                checkColor(R.drawable.answer_button_sub);
                break;
            case 3:
                scrollView.setBackgroundColor(ContextCompat.getColor(this, R.color.multiScrollBackground));
                timer.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.timer_show_multi));
                checkColor(R.drawable.answer_button_multi);
                break;
            case 4:
                scrollView.setBackgroundColor(ContextCompat.getColor(this,R.color.devScrollBackground));
                timer.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.timer_show_dev));
                checkColor(R.drawable.answer_button_dev);
                break;
        }
    }

    //check if the answer is correct or not
    private void checkAnswer(int answer, Button answer_button) {
        if (answer == sum) {
            cTimer.cancel();
            score_level += 10;
            score.setText(score_level + " / 100");
            answer_button.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.answer_button_true));
            stopTime();
        } else {
            score_level -= 5;
            score.setText(score_level + " / 100");
            answer_button.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.answer_button_false));
            answer_button.setClickable(false);
        }
    }

    //set Buttons Click
    private void buttonClick() {
        answer1.setOnClickListener(onClickListener);
        answer2.setOnClickListener(onClickListener);
        answer3.setOnClickListener(onClickListener);
        answer4.setOnClickListener(onClickListener);
    }

    private void moveToNextLevel() {
        if (LEVEL < 10) {
            //increase level
            LEVEL++;

            //to increase level's difficulty
            increaseDifficulty();

            //restart Timer
            cTimer.start();

            //get Random numbers for question
            randomNumbers();

            //get random value for answer
            randomValue();

            //get random answers
            getAnswer();

            //show question and answers in TextViews
            showText();

            //restore the button clickable
            restoreClicable();
        } else {
            if(score_level<0){
                timer.setText("VERY BAD");
                timer.setTextSize(30);
                timer.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.wrongAnswer));
            }
            else if(score_level>=0&&score_level<50){
                timer.setText("BAD");
                timer.setTextSize(30);
                timer.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.wrongAnswer));
            }
            else if(score_level>=50&&score_level<75){
                timer.setText("GOOD");
                timer.setTextSize(30);
                timer.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.rightAnswer));
            }
            else if(score_level>=75&&score_level<90){
                timer.setText("VERY GOOD");
                timer.setTextSize(30);
                timer.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.rightAnswer));
            }

            else if(score_level>=90&&score_level<=100){
                timer.setText("Excellent");
                timer.setTextSize(30);
                timer.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.rightAnswer));
            }
            answer1.setClickable(false);
            answer2.setClickable(false);
            answer3.setClickable(false);
            answer4.setClickable(false);
            cancelTimer(cTimer);
            cancelTimer(stopt_timer);
        }
    }

    //release button color
    private void releaseColor() {

        switch (CHECK_PAGE) {
            case 1:
                scrollView.setBackgroundColor(ContextCompat.getColor(this, R.color.plusScrolBackground));
                checkColor(R.drawable.answer_button_plus);
                break;
            case 2:
                scrollView.setBackgroundColor(ContextCompat.getColor(this, R.color.subScrollBackground));
                checkColor(R.drawable.answer_button_sub);
                break;
            case 3:
                scrollView.setBackgroundColor(ContextCompat.getColor(this, R.color.multiScrollBackground));
                checkColor(R.drawable.answer_button_multi);
                break;
            case 4:
                scrollView.setBackgroundColor(ContextCompat.getColor(this, R.color.devScrollBackground));
                checkColor(R.drawable.answer_button_dev);
                break;
        }

    }

    //check page for color button
    private void checkColor(int drawable) {
        answer1.setBackgroundDrawable(ContextCompat.getDrawable(this, drawable));
        answer2.setBackgroundDrawable(ContextCompat.getDrawable(this, drawable));
        answer3.setBackgroundDrawable(ContextCompat.getDrawable(this, drawable));
        answer4.setBackgroundDrawable(ContextCompat.getDrawable(this, drawable));
    }

    //restore the button clickable
    private void restoreClicable() {
        answer1.setClickable(true);
        answer2.setClickable(true);
        answer3.setClickable(true);
        answer4.setClickable(true);
    }

    //to stop app for 2 sec and resume
    private void stopTime() {
        stopt_timer = new CountDownTimer(500, 1000) {

            @Override
            public void onTick(long l) {
                answer1.setClickable(false);
                answer2.setClickable(false);
                answer3.setClickable(false);
                answer4.setClickable(false);
            }

            @Override
            public void onFinish() {
                moveToNextLevel();
                //release button color
                releaseColor();
                cancelTimer(stopt_timer);
            }
        };
        stopt_timer.start();
    }

    //to increase level's difficulty
    private void increaseDifficulty() {
        switch (CHECK_PAGE) {
            case 1:
                checkLevel(10, 30, 30, 50, 50, 70,
                        70, 90, 90, 110, 110, 130,
                        130, 150, 150, 170, 170, 190,
                        190, 250);
                break;
            case 2:
                checkLevel(10, 30, 20, 50, 30, 80,
                        50, 110, 90, 140, 120, 170,
                        150, 200, 180, 230, 200, 260,
                        260, 300);
                break;
            case 3:
                checkLevel(10, 20, 20, 30, 30, 40,
                        40, 50, 50, 60, 60, 70,
                        70, 80, 80, 90, 90, 100,
                        100, 110);
                break;
            case 4:

                checkLevel(20, 40, 30, 50, 50, 70,
                        70, 90, 90, 110, 110, 130,
                        130, 150, 150, 170, 170, 190,
                        190, 250);
                break;
        }
    }

    //set levels information
    private void setLevelInfo(int min, int max) {
        MIN_VALUE = min;
        MAX_VALUE = max;
    }

    //to check LEVELS
    private void checkLevel(int minlev1, int maxlev1, int minlev2, int maxlev2, int minlev3, int maxlev3,
                            int minlev4, int maxlev4, int minlev5, int maxlev5, int minlev6, int maxlev6,
                            int minlev7, int maxlev7, int minlev8, int maxlev8, int minlev9, int maxlev9,
                            int minlev10, int maxlev10) {
        switch (LEVEL) {
            case 1:
                setMax(2, 10);
                setLevelInfo(minlev1, maxlev1);
                break;
            case 2:
                setMax(3, 10);
                setLevelInfo(minlev2, maxlev2);
                break;
            case 3:
                setMax(5, 20);
                setLevelInfo(minlev3, maxlev3);
                break;
            case 4:
                setMax(7, 30);
                setLevelInfo(minlev4, maxlev4);
                break;
            case 5:
                setMax(9, 40);
                setLevelInfo(minlev5, maxlev5);
                break;
            case 6:
                setMax(11, 50);
                setLevelInfo(minlev6, maxlev6);
                break;
            case 7:
                setMax(13, 60);
                setLevelInfo(minlev7, maxlev7);
                break;
            case 8:
                setMax(15, 70);
                setLevelInfo(minlev8, maxlev8);
                break;
            case 9:
                setMax(17, 80);
                setLevelInfo(minlev9, maxlev9);
                break;
            case 10:
                setMax(19, 90);
                setLevelInfo(minlev10, maxlev10);
                break;
        }
    }


    //set maxNum and minNum
    private void setMax(int min_value, int max_value) {
        MIN_VALUE_DEV = min_value;
        MAX_VALUE_DEV = max_value;
    }
}
