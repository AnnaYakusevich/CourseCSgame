package com.example.course_cs_game;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.widget.SeekBar;
import android.widget.TextView;


public class SettingsCards extends AppCompatActivity implements OnClickListener, SeekBar.OnSeekBarChangeListener {


    private TextView mTextView;
    private TextView mTextView2;
    private SeekBar seekBar;
    private SeekBar seekBar2;
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_game_settings);

        seekBar = findViewById(R.id.seekBar);
        seekBar.setProgress(MenuCards.numOfCardPairs);
        seekBar.setMax(32);
        seekBar.setOnSeekBarChangeListener(this);

        seekBar2 = findViewById(R.id.seekBar2);
        seekBar2.setProgress(0);
        seekBar2.setMax(300000);
        seekBar2.setProgress(MenuCards.timeForGame);
        seekBar2.setOnSeekBarChangeListener(this);

        mTextView = findViewById(R.id.textView);
        text = "Количество карт: " + MenuCards.numOfCardPairs * 2;
        mTextView.setText(text);

        mTextView2 = findViewById(R.id.textView2);
        text = "Время на решение (секунды): " + MenuCards.timeForGame;
        mTextView2.setText(text);

        Button cards;
        Button back;
        Button save;
        Button basicSettings;

        cards = findViewById(R.id.button2);
        back = findViewById(R.id.button);
        save = findViewById(R.id.button3);
        basicSettings = findViewById(R.id.button4);

        cards.setOnClickListener(this);
        back.setOnClickListener(this);
        save.setOnClickListener(this);
        basicSettings.setOnClickListener(this);

    }
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (seekBar.getId() == R.id.seekBar) {
            text = "Количество карт: " + progress*2;
            mTextView.setText(text);
        }
        else {
            text = "Время на решение (секунды): " + progress / 1000;
            mTextView2.setText(text);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        if (seekBar.getId() == R.id.seekBar) {
            MenuCards.numOfCardPairs = seekBar.getProgress();
        }
        else {
            MenuCards.timeForGame = seekBar.getProgress();
        }
    }


    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.button:
                intent = new Intent(this, SetBack.class);
                startActivity(intent);
                break;
            case R.id.button2:
                intent = new Intent(this, SetCards.class);
                startActivity(intent);
                break;
            case R.id.button3:
                finish();
                break;
            case R.id.button4:
                modeMenu();
                break;
        }
    }


    //TODO: Check levels
    private void modeMenu() {
        final CharSequence[] items = {"Легкий","Средний","Сложный"};//имена методов Ваших в списке
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                String text;
                if (item == 0) { // Легкий
                    text = "Количество карт: 16";
                    mTextView.setText(text);
                    seekBar.setProgress(8);
                    text = "Время на решение (секунды): 300";
                    mTextView2.setText(text);
                    seekBar2.setProgress(300000);
                    MenuCards.timeForGame = 300000;
                    MenuCards.numOfCardPairs = 8;
                    MenuCards.numOfCardTypes = MenuCards.maxNumOfCardTypes;
                }
                if (item == 1) { // Средний
                    text = "Количество карт: 20";
                    mTextView.setText(text);
                    seekBar.setProgress(10);
                    text = "Время на решение (секунды): 200";
                    mTextView2.setText(text);
                    seekBar2.setProgress(200000);
                    MenuCards.timeForGame = 200000;
                    MenuCards.numOfCardPairs = 10;
                    MenuCards.numOfCardTypes = MenuCards.maxNumOfCardTypes;
                }
                if (item == 2) { // Сложный
                    text = "Количество карт: 24";
                    mTextView.setText(text);
                    seekBar.setProgress(12);
                    text = "Время на решение (секунды): 100";
                    mTextView2.setText(text);
                    seekBar2.setProgress(100000);
                    MenuCards.timeForGame = 100000;
                    MenuCards.numOfCardPairs = 12;
                    MenuCards.numOfCardTypes = MenuCards.maxNumOfCardTypes;
                }
            }
        });
        AlertDialog alert = builder.create();
        alert.show();

    }

}
