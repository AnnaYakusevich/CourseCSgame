package com.example.course_cs_game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class SetCards extends AppCompatActivity  implements View.OnClickListener {

    CheckBox[] checkBoxes = new CheckBox[MenuCards.maxNumOfCardTypes];
    int checkedNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_cards);

        checkBoxes[1] = findViewById(R.id.checkBox2);
        checkBoxes[1].setOnClickListener(this);
        if (checkBoxes[1].isChecked()) {
            MenuCards.enabledCards[1] = 1;
            checkedNum++;
        } else {
            MenuCards.enabledCards[1] = 0;
        }

        checkBoxes[2] = findViewById(R.id.checkBox3);
        checkBoxes[2].setOnClickListener(this);
        if (checkBoxes[2].isChecked()) {
            MenuCards.enabledCards[2] = 1;
            checkedNum++;
        } else {
            MenuCards.enabledCards[2] = 0;
        }

        checkBoxes[3] = findViewById(R.id.checkBox4);
        checkBoxes[3].setOnClickListener(this);
        if (checkBoxes[3].isChecked()) {
            MenuCards.enabledCards[3] = 1;
            checkedNum++;
        } else {
            MenuCards.enabledCards[3] = 0;
        }

        checkBoxes[4] = findViewById(R.id.checkBox5);
        checkBoxes[4].setOnClickListener(this);
        if (checkBoxes[4].isChecked()) {
            MenuCards.enabledCards[4] = 1;
            checkedNum++;
        } else {
            MenuCards.enabledCards[4] = 0;
        }

        checkBoxes[5] = findViewById(R.id.checkBox6);
        checkBoxes[5].setOnClickListener(this);
        if (checkBoxes[5].isChecked()) {
            MenuCards.enabledCards[5] = 1;
            checkedNum++;
        } else {
            MenuCards.enabledCards[5] = 0;
        }

        checkBoxes[6] = findViewById(R.id.checkBox7);
        checkBoxes[6].setOnClickListener(this);
        if (checkBoxes[6].isChecked()) {
            MenuCards.enabledCards[6] = 1;
            checkedNum++;
        } else {
            MenuCards.enabledCards[6] = 0;
        }

        checkBoxes[7] = findViewById(R.id.checkBox8);
        checkBoxes[7].setOnClickListener(this);
        if (checkBoxes[7].isChecked()) {
            MenuCards.enabledCards[7] = 1;
            checkedNum++;
        } else {
            MenuCards.enabledCards[7] = 0;
        }

        checkBoxes[8] = findViewById(R.id.checkBox9);
        checkBoxes[8].setOnClickListener(this);
        if (checkBoxes[8].isChecked()) {
            MenuCards.enabledCards[8] = 1;
            checkedNum++;
        } else {
            MenuCards.enabledCards[8] = 0;
        }

        checkBoxes[9] = findViewById(R.id.checkBox10);
        checkBoxes[9].setOnClickListener(this);
        if (checkBoxes[9].isChecked()) {
            MenuCards.enabledCards[9] = 1;
            checkedNum++;
        } else {
            MenuCards.enabledCards[9] = 0;
        }

        checkBoxes[10] = findViewById(R.id.checkBox11);
        checkBoxes[10].setOnClickListener(this);
        if (checkBoxes[10].isChecked()) {
            MenuCards.enabledCards[10] = 1;
            checkedNum++;
        } else {
            MenuCards.enabledCards[10] = 0;
        }

        checkBoxes[11] = findViewById(R.id.checkBox12);
        checkBoxes[11].setOnClickListener(this);
        if (checkBoxes[11].isChecked()) {
            MenuCards.enabledCards[11] = 1;
            checkedNum++;
        } else {
            MenuCards.enabledCards[11] = 0;
        }

        checkBoxes[12] = findViewById(R.id.checkBox13);
        checkBoxes[12].setOnClickListener(this);
        if (checkBoxes[12].isChecked()) {
            MenuCards.enabledCards[12] = 1;
            checkedNum++;
        } else {
            MenuCards.enabledCards[12] = 0;
        }

        checkBoxes[0] = findViewById(R.id.checkBox1);
        checkBoxes[0].setOnClickListener(this);
        if (checkBoxes[0].isChecked()) {
            MenuCards.enabledCards[0] = 1;
            checkedNum++;
        } else {
            MenuCards.enabledCards[0] = 0;
        }
        Button save = findViewById(R.id.save_cards);
        save.setOnClickListener(this);

        MenuCards.numOfCardTypes = checkedNum;
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save_cards:
                this.finish();
                break;
            case R.id.checkBox2:
                if (checkBoxes[1].isChecked()) {
                    MenuCards.enabledCards[1] = 1;
                    checkedNum++;
                } else {
                    MenuCards.enabledCards[1] = 0;
                    checkedNum--;
                }
                MenuCards.numOfCardTypes = checkedNum;
                System.out.println(checkedNum);
                break;
            case R.id.checkBox3:
                if (checkBoxes[2].isChecked()) {
                    MenuCards.enabledCards[2] = 1;
                    checkedNum++;
                } else {
                    MenuCards.enabledCards[2] = 0;
                    checkedNum--;
                }
                MenuCards.numOfCardTypes = checkedNum;
                System.out.println(checkedNum);
                break;
            case R.id.checkBox4:
                if (checkBoxes[3].isChecked()) {
                    MenuCards.enabledCards[3] = 1;
                    checkedNum++;
                } else {
                    MenuCards.enabledCards[3] = 0;
                    checkedNum--;
                }
                MenuCards.numOfCardTypes = checkedNum;
                System.out.println(checkedNum);
                break;
            case R.id.checkBox5:
                if (checkBoxes[4].isChecked()) {
                    MenuCards.enabledCards[4] = 1;
                    checkedNum++;
                } else {
                    MenuCards.enabledCards[4] = 0;
                    checkedNum--;
                }
                MenuCards.numOfCardTypes = checkedNum;
                System.out.println(checkedNum);
                break;
            case R.id.checkBox6:
                if (checkBoxes[5].isChecked()) {
                    MenuCards.enabledCards[5] = 1;
                    checkedNum++;
                } else {
                    MenuCards.enabledCards[5] = 0;
                    checkedNum--;
                }
                MenuCards.numOfCardTypes = checkedNum;
                System.out.println(checkedNum);
                break;
            case R.id.checkBox7:
                if (checkBoxes[6].isChecked()) {
                    MenuCards.enabledCards[6] = 1;
                    checkedNum++;
                } else {
                    MenuCards.enabledCards[6] = 0;
                    checkedNum--;
                }
                MenuCards.numOfCardTypes = checkedNum;
                System.out.println(checkedNum);
                break;
            case R.id.checkBox8:
                if (checkBoxes[7].isChecked()) {
                    MenuCards.enabledCards[7] = 1;
                    checkedNum++;
                } else {
                    MenuCards.enabledCards[7] = 0;
                    checkedNum--;
                }
                MenuCards.numOfCardTypes = checkedNum;
                System.out.println(checkedNum);
                break;
            case R.id.checkBox9:
                if (checkBoxes[8].isChecked()) {
                    MenuCards.enabledCards[8] = 1;
                    checkedNum++;
                } else {
                    MenuCards.enabledCards[8] = 0;
                    checkedNum--;
                }
                MenuCards.numOfCardTypes = checkedNum;
                System.out.println(checkedNum);
                break;
            case R.id.checkBox10:
                if (checkBoxes[9].isChecked()) {
                    MenuCards.enabledCards[9] = 1;
                    checkedNum++;
                } else {
                    MenuCards.enabledCards[9] = 0;
                    checkedNum--;
                }
                MenuCards.numOfCardTypes = checkedNum;
                System.out.println(checkedNum);
                break;
            case R.id.checkBox11:
                if (checkBoxes[10].isChecked()) {
                    MenuCards.enabledCards[10] = 1;
                    checkedNum++;
                } else {
                    MenuCards.enabledCards[10] = 0;
                    checkedNum--;
                }
                MenuCards.numOfCardTypes = checkedNum;
                System.out.println(checkedNum);
                break;
            case R.id.checkBox12:
                if (checkBoxes[11].isChecked()) {
                    MenuCards.enabledCards[11] = 1;
                    checkedNum++;
                } else {
                    MenuCards.enabledCards[11] = 0;
                    checkedNum--;
                }
                MenuCards.numOfCardTypes = checkedNum;
                System.out.println(checkedNum);
                break;
            case R.id.checkBox13:
                if (checkBoxes[12].isChecked()) {
                    MenuCards.enabledCards[12] = 1;
                    checkedNum++;
                } else {
                    MenuCards.enabledCards[12] = 0;
                    checkedNum--;
                }
                MenuCards.numOfCardTypes = checkedNum;
                System.out.println(checkedNum);
                break;
            case R.id.checkBox1:
                if (checkBoxes[0].isChecked()) {
                    MenuCards.enabledCards[0] = 1;
                    checkedNum++;
                } else {
                    MenuCards.enabledCards[0] = 0;
                    checkedNum--;
                }
                MenuCards.numOfCardTypes = checkedNum;
                System.out.println(checkedNum);
                break;
        }
    }


}
