package com.example.course_cs_game;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.widget.SeekBar;
import android.widget.TextView;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/**
 * This class defines the work of activity. It allows user
 * to change game settings. User can change the back of the cards,
 * types of images he/she wants to play with, time for game,
 * number of cards and number of cards in row. User can also use
 * choose basic levels defined by developers
 */


public class SettingsCards extends AppCompatActivity implements OnClickListener, SeekBar.OnSeekBarChangeListener {


    private TextView mTextView;
    private TextView mTextView2;
    private TextView mTextView3;
    private SeekBar seekBar;
    private SeekBar seekBar2;

    Button cards;
    Button back;
    Button save;
    Button basicSettings;
    Button cancel;


    SharedPreferences sPref;

    Animation anim;
    Animation animBig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_game_settings);

        seekBar = findViewById(R.id.seekBar);
        seekBar.setProgress(MenuCards.numOfCardPairs);
        seekBar.setMax(32);
        seekBar.setOnSeekBarChangeListener(this);

        SeekBar seekBar3 = findViewById(R.id.seekBar3);
        seekBar3.setProgress(MenuCards.numOfCardsInRow - 3);
        seekBar3.setMax(3);
        seekBar3.setOnSeekBarChangeListener(this);

        seekBar2 = findViewById(R.id.seekBar2);
        seekBar2.setProgress(0);
        seekBar2.setMax(300000);
        seekBar2.setProgress(MenuCards.timeForGame);
        seekBar2.setOnSeekBarChangeListener(this);

        String text;
        mTextView = findViewById(R.id.textView);
        text = "Количество карт: " + MenuCards.numOfCardPairs * 2;
        mTextView.setText(text);

        mTextView2 = findViewById(R.id.textView2);
        text = "Время на решение (секунды): " + (MenuCards.timeForGame / 1000);
        mTextView2.setText(text);

        mTextView3 = findViewById(R.id.textView3);
        text = "Количество карт в строке: " + MenuCards.numOfCardsInRow;
        mTextView3.setText(text);

        cards = findViewById(R.id.button2);
        back = findViewById(R.id.button);
        save = findViewById(R.id.button3);
        basicSettings = findViewById(R.id.button4);
        cancel = findViewById(R.id.button6);

        cards.setOnClickListener(this);
        back.setOnClickListener(this);
        save.setOnClickListener(this);
        basicSettings.setOnClickListener(this);
        cancel.setOnClickListener(this);

        anim = AnimationUtils.loadAnimation(this, R.anim.tinkle);
        animBig = AnimationUtils.loadAnimation(this, R.anim.tinklebig);

    }

    /**
     * Methods for analysing the state of seek bars and react on their changes
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        String text;
        switch (seekBar.getId()) {
            case R.id.seekBar:
                text = "Количество карт: " + progress * 2;
                mTextView.setText(text);
                break;
            case R.id.seekBar2:
                text = "Время на решение (секунды): " + progress / 1000;
                mTextView2.setText(text);
                break;
            case R.id.seekBar3:
                text = "Количество карт в строке: " + (progress + 3);
                mTextView3.setText(text);
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        switch (seekBar.getId()) {
            case R.id.seekBar:
                MenuCards.numOfCardPairs = seekBar.getProgress();
                break;
            case R.id.seekBar2:
                MenuCards.timeForGame = seekBar.getProgress();
                break;
            case R.id.seekBar3:
                MenuCards.numOfCardsInRow = seekBar.getProgress() + 3;
                break;
        }
    }

    /**
     * This method react on user clicks: display animation,
     * open new settings activities or finishes editing with
     * properties user wants for the game
     *
     * @param v current view when object was clicked
     */
    public void onClick(View v) {
        final Intent intent;
        Handler handler = new Handler();
        Runnable r;
        switch (v.getId()) {
            case R.id.button:
                intent = new Intent(this, SetBack.class);
                r = new Runnable() {
                    public void run() {
                        startActivity(intent);
                    }
                };
                back.startAnimation(anim);
                handler.postDelayed(r, 50);
                break;
            case R.id.button2:
                intent = new Intent(this, SetCards.class);
                r = new Runnable() {
                    public void run() {
                        startActivity(intent);
                    }
                };
                cards.startAnimation(anim);
                handler.postDelayed(r, 50);
                break;
            case R.id.button3:
                saveData();
                r = new Runnable() {
                    public void run() {
                        finish();
                    }
                };
                save.startAnimation(animBig);
                handler.postDelayed(r, 50);
                break;
            case R.id.button4:
                r = new Runnable() {
                    public void run() {
                        modeMenu();
                    }
                };
                basicSettings.startAnimation(anim);
                handler.postDelayed(r, 50);
                break;
            case R.id.button6:
                loadData();
                r = new Runnable() {
                    public void run() {
                        finish();
                    }
                };
                cancel.startAnimation(anim);
                handler.postDelayed(r, 50);
                break;
        }
    }


    /**
     *  This method allows user to choose basic level designed by developers
     *  Opens new Dialog with three levels: easy, hard and medium
     *  After choosing it sets all seekBars' progresses and appropriate text
     */
    private void modeMenu() {
        final CharSequence[] items = {"Легкий","Средний","Сложный"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                String text;
                if (item == 0) {
                    // Easy level
                    text = "Количество карт: 10";
                    mTextView.setText(text);
                    seekBar.setProgress(5);
                    text = "Время на решение (секунды): 100";
                    mTextView2.setText(text);
                    seekBar2.setProgress(100000);

                    MenuCards.timeForGame = 100000;
                    MenuCards.numOfCardPairs = 5;
                    MenuCards.numOfCardTypes = MenuCards.maxNumOfCardTypes;
                }
                if (item == 1) {
                    // Middle level
                    text = "Количество карт: 12";
                    mTextView.setText(text);
                    seekBar.setProgress(6);
                    text = "Время на решение (секунды): 60";
                    mTextView2.setText(text);
                    seekBar2.setProgress(60000);

                    MenuCards.timeForGame = 60000;
                    MenuCards.numOfCardPairs = 6;
                    MenuCards.numOfCardTypes = MenuCards.maxNumOfCardTypes;
                }
                if (item == 2) {
                    // Hard level
                    text = "Количество карт: 20";
                    mTextView.setText(text);
                    seekBar.setProgress(10);
                    text = "Время на решение (секунды): 100";
                    mTextView2.setText(text);
                    seekBar2.setProgress(100000);

                    MenuCards.timeForGame = 100000;
                    MenuCards.numOfCardPairs = 10;
                    MenuCards.numOfCardTypes = MenuCards.maxNumOfCardTypes;
                }
            }
        });
        AlertDialog alert = builder.create();
        alert.show();

    }

    /**
     * This method save new settings of the game to the storage
     */
    void saveData() {
        sPref = getSharedPreferences("preferences", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putInt("numOfCardPairs", MenuCards.numOfCardPairs);
        ed.putInt("timeForGame", MenuCards.timeForGame);
        ed.putInt("backId", MenuCards.backId);
        ed.putInt("numOfCardsInRow", MenuCards.numOfCardsInRow);
        ed.commit();
    }

    /**
     * This method load settings of the game from the storage
     * Needed if user made some changes and then decided to reset
     * them to the previous state
     */
    void loadData() {
        sPref = getSharedPreferences("preferences", MODE_PRIVATE);
        MenuCards.numOfCardPairs = sPref.getInt("numOfCardPairs", 8);
        MenuCards.timeForGame = sPref.getInt("timeForGame", 100000);
        MenuCards.backId = sPref.getInt("backId", R.drawable.back);
        MenuCards.numOfCardsInRow = sPref.getInt("numOfCardsInRow", 5);
    }

}
