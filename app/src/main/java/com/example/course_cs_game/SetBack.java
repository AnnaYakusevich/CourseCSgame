package com.example.course_cs_game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SetBack extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_back);

        ImageView iv1 = findViewById(R.id.imageViewBack1);
        ImageView iv2 = findViewById(R.id.imageViewBack2);

        iv1.setOnClickListener(this);
        iv2.setOnClickListener(this);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageViewBack1:
                MenuCards.backId = R.drawable.back;
                finish();
                break;
            case R.id.imageViewBack2:
                MenuCards.backId = R.drawable.back2;
                finish();
                break;
        }
    }
}
