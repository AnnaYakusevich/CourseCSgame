package com.example.course_cs_game;

import android.os.Handler;
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

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


import com.example.course_cs_game.CardGame.GameCards;

public class MenuCards extends AppCompatActivity implements OnClickListener {

    // Settings of the game used in different classes
    public static int numOfCardPairs;
    public static int numOfCardTypes;
    public static int maxNumOfCardTypes = 13;
    public static int timeForGame;
    public static int[] enabledCards = new int[maxNumOfCardTypes];
    public static int numOfCardsInRow;
    public static int backId = R.drawable.back;

    public static int screenWidth;
    public static int screenHeight;

    SharedPreferences sPref;

    Button start;
    Button settings;

    Animation anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_game_menu);

        // Load saved data
        loadData();

        // Find elements
        start = findViewById(R.id.card_game_start);
        settings = findViewById(R.id.card_game_settings);

        start.setOnClickListener(this);
        settings.setOnClickListener(this);

        anim = AnimationUtils.loadAnimation(this, R.anim.start);
    }

    @Override
    protected void onDestroy() {
        saveData();
        super.onDestroy();
    }

    /**
     * This method react on user clicks:
     * open new activity - game or settings
     * It also defines the size of display to adapt program
     * to different screen sizes
     *
     * @param v current view when object was clicked
     */
    public void onClick(View v) {

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;

        final Intent intent;

        Handler handler = new Handler();
        Runnable r;

        switch (v.getId()) {
            case R.id.card_game_start:
                intent = new Intent(this, GameCards.class);
                r = new Runnable() {
                    public void run() {
                        startActivity(intent);
                    }
                };
                start.startAnimation(anim);
                handler.postDelayed(r, 400);
                break;
            case R.id.card_game_settings:
                intent = new Intent(this, SettingsCards.class);
                r = new Runnable() {
                    public void run() {
                        startActivity(intent);
                    }
                };
                settings.startAnimation(anim);
                handler.postDelayed(r, 400);
                break;
        }
    }

    /**
     * This method save new settings of the game to the storage
     */
    void saveData() {
        sPref = getSharedPreferences("preferences", MODE_PRIVATE);
        Editor ed = sPref.edit();
        ed.clear();
        ed.putInt("numOfCardPairs", numOfCardPairs);
        ed.putInt("numOfCardTypes", numOfCardTypes);
        ed.putInt("timeForGame", timeForGame);
        ed.putInt("backId", backId);
        ed.putInt("numOfCardsInRow", numOfCardsInRow);
        for (int i = 0; i < maxNumOfCardTypes; i++) {
            ed.putInt("enabledCards[" + i + "]", enabledCards[i]);
        }
        ed.commit();
    }

    /**
     * This method load settings of the game from the storage
     * Needed if user made some changes and then decided to reset
     * them to the previous state
     */
    void loadData() {
        sPref = getSharedPreferences("preferences", MODE_PRIVATE);
        numOfCardPairs = sPref.getInt("numOfCardPairs", 8);
        numOfCardTypes = sPref.getInt("numOfCardTypes", 13);
        timeForGame = sPref.getInt("timeForGame", 100000);
        backId = sPref.getInt("backId", R.drawable.back);
        numOfCardsInRow = sPref.getInt("numOfCardsInRow", 5);
        for (int i = 0; i < maxNumOfCardTypes; i++) {
            enabledCards[i] = sPref.getInt("enabledCards[" + i + "]", 1);
        }
    }

}
