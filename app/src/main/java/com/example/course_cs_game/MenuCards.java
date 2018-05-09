package com.example.course_cs_game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.view.Display;
import android.graphics.Point;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

//!!!!!
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.course_cs_game.CardGame.GameCards;

public class MenuCards extends AppCompatActivity implements OnClickListener {

    // Settings of the game
    public static int numOfCardPairs;
    public static int numOfCardTypes;
    public static int maxNumOfCardTypes;
    public static int timeForGame;
    public static int[] enabledCards = new int[maxNumOfCardTypes];
    public static int backId = R.drawable.back;
    public static int screenWidth;
    public static int screenHeight;

    SharedPreferences sPref;

    Button start;
    Button settings;

    // Overriding the reaction of Back button
    @Override
    public void onBackPressed() {
        // super.onBackPressed();
        super.onUserLeaveHint();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_game_menu);

        // Load saved data
        loadData();

        // Find elements
        start = findViewById(R.id.card_game_start);
        settings = findViewById(R.id.card_game_settings);

        //!!!!
       /*final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.);
        Button btnAlpha = findViewById(R.id.button5);
        btnAlpha.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                view.startAnimation(animAlpha);
            }
        });*/

       // TODO: Get rid of the button

        start.setOnClickListener(this);
        settings.setOnClickListener(this);

    }

    @Override
    protected void onDestroy() {
        saveData();
        super.onDestroy();
    }

    void saveData() {
        sPref = getSharedPreferences("preferences", MODE_PRIVATE);
        Editor ed = sPref.edit();
        ed.putInt("numOfCardPairs", numOfCardPairs);
        ed.putInt("numOfCardTypes", numOfCardTypes);
        ed.putInt("timeForGame", timeForGame);
        ed.putInt("backId", backId);
        for (int i = 0; i < maxNumOfCardTypes; i++) {
            ed.putInt("enabledCards[" + i + "]", enabledCards[i]);
        }
        ed.commit();
    }

    void loadData() {
        sPref = getSharedPreferences("preferences", MODE_PRIVATE);
        numOfCardPairs = sPref.getInt("numOfCardPairs", 8);
        numOfCardTypes = sPref.getInt("numOfCardTypes", 13);
        timeForGame = sPref.getInt("timeForGame", 100000);
        backId = sPref.getInt("backId", R.drawable.back);
        for (int i = 0; i < maxNumOfCardTypes; i++) {
            enabledCards[i] = sPref.getInt("enabledCards[" + i + "]", 1);
        }
    }

    public void onClick(View v) {

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;

        Intent intent;
        switch (v.getId()) {
            case R.id.card_game_start:
                intent = new Intent(this, GameCards.class);
                System.out.println("Log: Start the game");
                startActivity(intent);
                break;
            case R.id.card_game_settings:
                intent = new Intent(this, SettingsCards.class);
                startActivity(intent);
                break;

        }
    }
}
