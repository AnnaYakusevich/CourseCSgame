package com.example.course_cs_game.CardGame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;

import com.example.course_cs_game.R;

public class GameCards extends AppCompatActivity implements View.OnClickListener {

    public int number_of_cards = 8;
    CardModel model = new CardModel();
    Card[] card_array = new Card[number_of_cards];
    TableLayout table_layout_cards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_game);

        // Get generated cards
        card_array = model.getCards();

    // Display cards
        // Variables for help
        int number_of_rows = number_of_cards / 4;
        if (number_of_rows % 4 != 0) { number_of_rows++;}
        TableRow tableRow;
        int number_of_row = 0;
        int num = number_of_cards * 2;

        // Find TableLayout to work with it
        table_layout_cards = findViewById(R.id.table_layout_cards);
        TableRow[] tableRows = new TableRow[number_of_rows];

        while (number_of_rows != 0) {

            // Create a tableRow
            tableRow = new TableRow(this);
            //tableRow.setId(number_of_row);                        Do I need it?
            TableLayout.LayoutParams params = new TableLayout.LayoutParams(LayoutParams.MATCH_PARENT,670, 1);
            params.setMargins(5, 0, 5, 10);
            params.bottomMargin = 50;
            tableRow.setLayoutParams(params);
            tableRow.setWeightSum(1);
            tableRows[number_of_row] = tableRow;

            // Add buttons for it
            for(int i = 1; i <= 4; i++) {
                if (num == 0) {
                    break;
                }
                Button button = new Button(this);
                //TODO: Set different id to have access to buttons
                button.setId(number_of_row * 4 + 1);
                LayoutParams params1 = new TableRow.LayoutParams(0,650, 0.23f);
                button.setBackgroundResource(R.drawable.back);
                button.setText("");
                button.setLayoutParams(params1);
                tableRow.addView(button);
                if (i != 4) {
                    TextView separator = new TextView(this);
                    separator.setLayoutParams(new TableRow.LayoutParams(0, LayoutParams.MATCH_PARENT, 0.03f));
                    tableRow.addView(separator);
                }
                num--;
            }

            // Add a tableRow to the TableLayout
            table_layout_cards.addView(tableRow, params);

            number_of_rows--;
            number_of_row++;


        }

    }

    public void onClick(View v) {
        Intent intent;
    }
}
