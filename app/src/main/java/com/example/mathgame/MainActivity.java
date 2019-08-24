package com.example.mathgame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
import java.util.logging.Level;

public class MainActivity extends AppCompatActivity {

    Button plus, sub, multi, dev, rand;

    View.OnClickListener to_levels = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.plusButton:
                    ViewAdapter.POSITION = 0;
                    moveToLevels(ViewAdapter.class);
                    GameActivity.OPERATION_SYMBOL = " + ";
                    GameActivity.CHECK_PAGE = 1;
                    break;
                case R.id.subButton:
                    ViewAdapter.POSITION = 1;
                    moveToLevels(ViewAdapter.class);
                    GameActivity.OPERATION_SYMBOL = " - ";
                    GameActivity.CHECK_PAGE = 2;
                    break;
                case R.id.multiButton:
                    ViewAdapter.POSITION = 2;
                    moveToLevels(ViewAdapter.class);
                    GameActivity.OPERATION_SYMBOL = " * ";
                    GameActivity.CHECK_PAGE = 3;
                    break;
                case R.id.devButton:
                    ViewAdapter.POSITION = 3;
                    moveToLevels(ViewAdapter.class);
                    GameActivity.OPERATION_SYMBOL = " / ";
                    GameActivity.CHECK_PAGE = 4;
                    break;
                case R.id.randomButton:
                    randomButton(randomNumber(),randomLevel());
                    moveToLevels(GameActivity.class);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        defineButtons();
        setButtons();
    }


    public void defineButtons() {
        plus = (Button) findViewById(R.id.plusButton);
        sub = (Button) findViewById(R.id.subButton);
        multi = (Button) findViewById(R.id.multiButton);
        dev = (Button) findViewById(R.id.devButton);
        rand = (Button) findViewById(R.id.randomButton);
    }

    public void setButtons() {
        plus.setOnClickListener(to_levels);
        sub.setOnClickListener(to_levels);
        multi.setOnClickListener(to_levels);
        dev.setOnClickListener(to_levels);
        rand.setOnClickListener(to_levels);
    }

    public void moveToLevels(Class cls) {
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), cls);
        startActivity(intent);
    }

    public int randomNumber() {
        Random random = new Random();
        return random.nextInt(4);
    }

    public int randomLevel() {
        Random random = new Random();
        return random.nextInt(10)+1;
    }
    public void randomButton(int random,int level){
        GameActivity.LEVEL=level;
        switch (random){
            case 0:
                ViewAdapter.POSITION = 0;
                GameActivity.OPERATION_SYMBOL = " + ";
                GameActivity.CHECK_PAGE = 1;
                break;
            case 1:
                ViewAdapter.POSITION = 1;
                GameActivity.OPERATION_SYMBOL = " - ";
                GameActivity.CHECK_PAGE = 2;
                break;
            case 2:
                ViewAdapter.POSITION = 2;
                GameActivity.OPERATION_SYMBOL = " * ";
                GameActivity.CHECK_PAGE = 3;
                break;
            case 3:
                ViewAdapter.POSITION = 3;
                GameActivity.OPERATION_SYMBOL = " / ";
                GameActivity.CHECK_PAGE = 4;
                break;
        }
    }
}
