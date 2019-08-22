package com.example.mathgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button plus, sub, multi, dev, rand;

    View.OnClickListener to_levels = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.plusButton:
                    ViewAdapter.POSITION=0;
                    moveToLevels(ViewAdapter.class);
                    break;
                case R.id.subButton:
                    ViewAdapter.POSITION=1;
                    moveToLevels(ViewAdapter.class);
                    break;
                case R.id.multiButton:
                    ViewAdapter.POSITION=2;
                    moveToLevels(ViewAdapter.class);
                    break;
                case R.id.devButton:
                    ViewAdapter.POSITION=3;
                    moveToLevels(ViewAdapter.class);
                    break;
//                case R.id.randomButton:
//                    moveToLevels();
//                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
}
