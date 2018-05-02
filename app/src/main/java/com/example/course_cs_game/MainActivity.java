package com.example.course_cs_game;

//import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    Button card_game;
    Button pacman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find elements
        card_game = findViewById(R.id.but_card_game);
        pacman = findViewById(R.id.but_pacman);

        card_game.setOnClickListener(this);
        pacman.setOnClickListener(this);
    }

    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.but_card_game:
                intent = new Intent(this, MenuCards.class);
                startActivity(intent);
                break;
            case R.id.but_pacman:
                intent = new Intent(this, MenuPacman.class);
                startActivity(intent);
                break;
        }
    }

}
