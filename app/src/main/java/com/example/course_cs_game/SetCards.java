package com.example.course_cs_game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.content.SharedPreferences;

/**
 * This class defines the work of activity. It allows user
 * to choose which types of cards he/she wants to play with
 */

public class SetCards extends AppCompatActivity  implements View.OnClickListener {

    CheckBox[] checkBoxes = new CheckBox[MenuCards.maxNumOfCardTypes];

    SharedPreferences sPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_cards);

        checkBoxes[1] = findViewById(R.id.checkBox2);
        checkBoxes[1].setOnClickListener(this);
        if (MenuCards.enabledCards[1] == 1) {
            checkBoxes[1].setChecked(true);
        } else {
            checkBoxes[1].setChecked(false);
        }

        checkBoxes[2] = findViewById(R.id.checkBox3);
        checkBoxes[2].setOnClickListener(this);
        if (MenuCards.enabledCards[2] == 1) {
            checkBoxes[2].setChecked(true);
        } else {
            checkBoxes[2].setChecked(false);
        }

        checkBoxes[3] = findViewById(R.id.checkBox4);
        checkBoxes[3].setOnClickListener(this);
        if (MenuCards.enabledCards[3] == 1) {
            checkBoxes[3].setChecked(true);
        } else {
            checkBoxes[3].setChecked(false);
        }

        checkBoxes[4] = findViewById(R.id.checkBox5);
        checkBoxes[4].setOnClickListener(this);
        if (MenuCards.enabledCards[4] == 1) {
            checkBoxes[4].setChecked(true);
        } else {
            checkBoxes[4].setChecked(false);
        }

        checkBoxes[5] = findViewById(R.id.checkBox6);
        checkBoxes[5].setOnClickListener(this);
        if (MenuCards.enabledCards[5] == 1) {
            checkBoxes[5].setChecked(true);
        } else {
            checkBoxes[5].setChecked(false);
        }

        checkBoxes[6] = findViewById(R.id.checkBox7);
        checkBoxes[6].setOnClickListener(this);
        if (MenuCards.enabledCards[6] == 1) {
            checkBoxes[6].setChecked(true);
        } else {
            checkBoxes[6].setChecked(false);
        }

        checkBoxes[7] = findViewById(R.id.checkBox8);
        checkBoxes[7].setOnClickListener(this);
        if (MenuCards.enabledCards[7] == 1) {
            checkBoxes[7].setChecked(true);
        } else {
            checkBoxes[7].setChecked(false);
        }

        checkBoxes[8] = findViewById(R.id.checkBox9);
        checkBoxes[8].setOnClickListener(this);
        if (MenuCards.enabledCards[8] == 1) {
            checkBoxes[8].setChecked(true);
        } else {
            checkBoxes[8].setChecked(false);
        }

        checkBoxes[9] = findViewById(R.id.checkBox10);
        checkBoxes[9].setOnClickListener(this);
        if (MenuCards.enabledCards[9] == 1) {
            checkBoxes[9].setChecked(true);
        } else {
            checkBoxes[9].setChecked(false);
        }

        checkBoxes[10] = findViewById(R.id.checkBox11);
        checkBoxes[10].setOnClickListener(this);
        if (MenuCards.enabledCards[10] == 1) {
            checkBoxes[10].setChecked(true);
        } else {
            checkBoxes[10].setChecked(false);
        }

        checkBoxes[11] = findViewById(R.id.checkBox12);
        checkBoxes[11].setOnClickListener(this);
        if (MenuCards.enabledCards[11] == 1) {
            checkBoxes[11].setChecked(true);
        } else {
            checkBoxes[11].setChecked(false);
        }

        checkBoxes[12] = findViewById(R.id.checkBox13);
        checkBoxes[12].setOnClickListener(this);
        if (MenuCards.enabledCards[12] == 1) {
            checkBoxes[12].setChecked(true);
        } else {
            checkBoxes[12].setChecked(false);
        }

        checkBoxes[0] = findViewById(R.id.checkBox1);
        checkBoxes[0].setOnClickListener(this);
        if (MenuCards.enabledCards[0] == 1) {
            checkBoxes[0].setChecked(true);
        } else {
            checkBoxes[0].setChecked(false);
        }

        Button save = findViewById(R.id.save_cards);
        save.setOnClickListener(this);

        Button cancel = findViewById(R.id.cancel_cards);
        cancel.setOnClickListener(this);

    }

    /**
     * This method react on user clicks:
     * sets new settings or finishes editing with
     * properties user wants for the game
     *
     * @param v current view when object was clicked
     */
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save_cards:
                saveData();
                this.finish();
                break;
            case R.id.cancel_cards:
                loadData();
                this.finish();
                break;
            case R.id.checkBox2:
                if (checkBoxes[1].isChecked()) {
                    MenuCards.enabledCards[1] = 1;
                    MenuCards.numOfCardTypes++;
                } else {
                    MenuCards.enabledCards[1] = 0;
                    MenuCards.numOfCardTypes--;
                }
                break;
            case R.id.checkBox3:
                if (checkBoxes[2].isChecked()) {
                    MenuCards.enabledCards[2] = 1;
                    MenuCards.numOfCardTypes++;
                } else {
                    MenuCards.enabledCards[2] = 0;
                    MenuCards.numOfCardTypes--;
                }
                break;
            case R.id.checkBox4:
                if (checkBoxes[3].isChecked()) {
                    MenuCards.enabledCards[3] = 1;
                    MenuCards.numOfCardTypes++;
                } else {
                    MenuCards.enabledCards[3] = 0;
                    MenuCards.numOfCardTypes--;
                }
                break;
            case R.id.checkBox5:
                if (checkBoxes[4].isChecked()) {
                    MenuCards.enabledCards[4] = 1;
                    MenuCards.numOfCardTypes++;
                } else {
                    MenuCards.enabledCards[4] = 0;
                    MenuCards.numOfCardTypes--;
                }
                break;
            case R.id.checkBox6:
                if (checkBoxes[5].isChecked()) {
                    MenuCards.enabledCards[5] = 1;
                    MenuCards.numOfCardTypes++;
                } else {
                    MenuCards.enabledCards[5] = 0;
                    MenuCards.numOfCardTypes--;
                }
                break;
            case R.id.checkBox7:
                if (checkBoxes[6].isChecked()) {
                    MenuCards.enabledCards[6] = 1;
                    MenuCards.numOfCardTypes++;
                } else {
                    MenuCards.enabledCards[6] = 0;
                    MenuCards.numOfCardTypes--;
                }
                break;
            case R.id.checkBox8:
                if (checkBoxes[7].isChecked()) {
                    MenuCards.enabledCards[7] = 1;
                    MenuCards.numOfCardTypes++;
                } else {
                    MenuCards.enabledCards[7] = 0;
                    MenuCards.numOfCardTypes--;
                }
                break;
            case R.id.checkBox9:
                if (checkBoxes[8].isChecked()) {
                    MenuCards.enabledCards[8] = 1;
                    MenuCards.numOfCardTypes++;
                } else {
                    MenuCards.enabledCards[8] = 0;
                    MenuCards.numOfCardTypes--;
                }
                break;
            case R.id.checkBox10:
                if (checkBoxes[9].isChecked()) {
                    MenuCards.enabledCards[9] = 1;
                    MenuCards.numOfCardTypes++;
                } else {
                    MenuCards.enabledCards[9] = 0;
                    MenuCards.numOfCardTypes--;
                }
                break;
            case R.id.checkBox11:
                if (checkBoxes[10].isChecked()) {
                    MenuCards.enabledCards[10] = 1;
                    MenuCards.numOfCardTypes++;
                } else {
                    MenuCards.enabledCards[10] = 0;
                    MenuCards.numOfCardTypes--;
                }
                break;
            case R.id.checkBox12:
                if (checkBoxes[11].isChecked()) {
                    MenuCards.enabledCards[11] = 1;
                    MenuCards.numOfCardTypes++;
                } else {
                    MenuCards.enabledCards[11] = 0;
                    MenuCards.numOfCardTypes--;
                }
                break;
            case R.id.checkBox13:
                if (checkBoxes[12].isChecked()) {
                    MenuCards.enabledCards[12] = 1;
                    MenuCards.numOfCardTypes++;
                } else {
                    MenuCards.enabledCards[12] = 0;
                    MenuCards.numOfCardTypes--;
                }
                break;
            case R.id.checkBox1:
                if (checkBoxes[0].isChecked()) {
                    MenuCards.enabledCards[0] = 1;
                    MenuCards.numOfCardTypes++;
                } else {
                    MenuCards.enabledCards[0] = 0;
                    MenuCards.numOfCardTypes--;
                }
                break;
        }
    }

    /**
     * This method save new settings of the game to the storage
     */
    void saveData() {
        sPref = getSharedPreferences("preferences", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putInt("numOfCardTypes", MenuCards.numOfCardTypes);
        for (int i = 0; i < MenuCards.maxNumOfCardTypes; i++) {
            ed.putInt("enabledCards[" + i + "]", MenuCards.enabledCards[i]);
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
        MenuCards.numOfCardTypes = sPref.getInt("numOfCardTypes", 13);
        for (int i = 0; i < MenuCards.maxNumOfCardTypes; i++) {
            MenuCards.enabledCards[i] = sPref.getInt("enabledCards[" + i + "]", 1);
        }
    }

}
