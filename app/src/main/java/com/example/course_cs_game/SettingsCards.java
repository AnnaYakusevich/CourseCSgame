package com.example.course_cs_game;

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
    private Button cards;
    private Button back;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_game_settings);

        final SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setProgress(8);
        seekBar.setMax(32);
        //seekBar.setMin(4);
        seekBar.setOnSeekBarChangeListener(this);


        mTextView = findViewById(R.id.textView);
        mTextView.setText("Количество карт: 16");

        cards = findViewById(R.id.button2);
        back = findViewById(R.id.button);
        save = findViewById(R.id.button3);

        cards.setOnClickListener(this);
        back.setOnClickListener(this);
        save.setOnClickListener(this);

    }
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        mTextView.setText("Количество карт: " + progress*2);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        MenuCards.numOfCardPairs = seekBar.getProgress();
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
        }


    }
}
