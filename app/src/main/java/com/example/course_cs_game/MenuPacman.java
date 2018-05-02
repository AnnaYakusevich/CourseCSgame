package com.example.course_cs_game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;

public class MenuPacman extends AppCompatActivity implements OnClickListener {

    Button start;
    Button settings;
    Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pacman_menu);

        // Find elements
        start = findViewById(R.id.pacman_start);
        settings = findViewById(R.id.pacman_settings);
        exit = findViewById(R.id.pacman_exit);

        start.setOnClickListener(this);
        settings.setOnClickListener(this);
        exit.setOnClickListener(this);
    }

    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.pacman_start:
                intent = new Intent(this, GamePacman.class);
                startActivity(intent);
                break;
            case R.id.pacman_settings:
                intent = new Intent(this, SettingsPacman.class);
                startActivity(intent);
                break;
            case R.id.pacman_exit:
                //intent = new Intent(this, MenuCards.class);
                //startActivity(intent);
                this.finish();
                break;
        }
    }
}
