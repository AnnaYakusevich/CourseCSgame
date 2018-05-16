package com.example.course_cs_game;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 *  Class for choosing the back image cards
 */

public class SetBack extends AppCompatActivity implements View.OnClickListener {

    SharedPreferences sPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_back);

        ImageView iv1 = findViewById(R.id.imageViewBack1);
        ImageView iv2 = findViewById(R.id.imageViewBack2);
        ImageView iv3 = findViewById(R.id.imageViewBack3);
        ImageView iv4 = findViewById(R.id.imageViewBack4);

        iv1.setOnClickListener(this);
        iv2.setOnClickListener(this);
        iv3.setOnClickListener(this);
        iv4.setOnClickListener(this);
    }

    /**
     * Method analyse which image was clicked and save new back image
     * After the click activity end its work
     *
     * @param v current view when image was clicked
     */
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageViewBack1:
                MenuCards.backId = R.drawable.back;
                saveData();
                finish();
                break;
            case R.id.imageViewBack2:
                MenuCards.backId = R.drawable.back2;
                saveData();
                finish();
                break;
            case R.id.imageViewBack3:
                MenuCards.backId = R.drawable.back3;
                saveData();
                finish();
                break;
            case R.id.imageViewBack4:
                MenuCards.backId = R.drawable.back4;
                saveData();
                finish();
                break;
        }
    }

    /**
     * Method saves data about new back image to the storage
     */
    private void saveData() {
        sPref = getSharedPreferences("preferences", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putInt("backId", MenuCards.backId);
        ed.commit();
    }
}
