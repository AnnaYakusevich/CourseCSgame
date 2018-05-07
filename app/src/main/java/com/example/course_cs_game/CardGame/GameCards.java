package com.example.course_cs_game.CardGame;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.os.Handler;
import android.app.AlertDialog;
import android.content.DialogInterface;

import com.example.course_cs_game.MenuCards;
import com.example.course_cs_game.R;

public class GameCards extends AppCompatActivity implements View.OnClickListener {

    private long timeRemaining = MenuCards.timeForGame;
    private CardModel model = new CardModel();
    private Card[] arrayOfCards;
    private Button[] buttons = new Button[MenuCards.numOfCardPairs * 2];
    private int firstFlipped = -1;
    private CountDownTimerPausable timer;

    private enum SoundEffect {
        flip, shuffle, match, nomatch, won, lost
    }

    // Overriding the reaction of Back button
    @Override
    public void onBackPressed() {
        // super.onBackPressed();
        super.onUserLeaveHint();
    }

    // Overriding basic methods of activity state
    @Override
    protected void onStop() {
        super.onStop();
        timer.pause();
    }

    @Override
    protected void onPause() {
        super.onPause();
        timer.pause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        timer.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        timer.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_game);
        playSound(SoundEffect.shuffle);

        // Get generated cards
        arrayOfCards = model.getCards();
        displayCards();

        // Create timer and display it
        final TextView timeText = findViewById(R.id.time_remaining);
        timer = new CountDownTimerPausable(MenuCards.timeForGame, 1000) {

            public void onTick(long millisUntilFinished) {
                timeRemaining = millisUntilFinished;
                String time = "Time remaining: " + timeRemaining / 1000 + "" + timeRemaining % 1000 / 10 + " s";
                timeText.setText(time);
            }

            public void onFinish() {
                timeRemaining = 0;
                String time = "Time remaining: " + timeRemaining + " s";
                timeText.setText(time);
                checkGameEnded();
            }
        };
        timer.start();
    }

    private void displayCards() {

        // Find TableLayout to work with it
        TableLayout tableLayout = findViewById(R.id.table_layout_cards);

        int currentNumberOfRow = 0;
        int numOfCards = MenuCards.numOfCardPairs * 2;

        while (numOfCards >= 1) {

            // Create a tableRow
            TableRow tableRow = new TableRow(this);
            TableLayout.LayoutParams params = new TableLayout.LayoutParams(LayoutParams.MATCH_PARENT, 670, 1);
            params.setMargins(5, 0, 5, 10);
            params.bottomMargin = 50;
            tableRow.setLayoutParams(params);
            tableRow.setWeightSum(1);

            // Add buttons to TableRow (max four in each line)
            for (int i = 1; i <= 4; i++) {

                // If all cards already exist, end adding
                if (numOfCards == 0) { break; }

                // Create a button object with default parameters
                Button button = new Button(this);
                button.setId(currentNumberOfRow * 4 + i - 1);
                LayoutParams params1 = new TableRow.LayoutParams(0, 650, 0.22f);
                button.setBackgroundResource(R.drawable.back);
                button.setText("");
                button.setLayoutParams(params1);

                // Add button to the array of all buttons and to the TableRow
                buttons[currentNumberOfRow * 4 + i - 1] = button;
                buttons[currentNumberOfRow * 4 + i - 1].setOnClickListener(this);
                tableRow.addView(buttons[numOfCards * 4 + i - 1]);

                // Add to TableRow additional TextView to separate buttons from each other
                if (i != 4) {
                    TextView separator = new TextView(this);
                    separator.setLayoutParams(new TableRow.LayoutParams(0, LayoutParams.MATCH_PARENT, 0.03f));
                    tableRow.addView(separator);
                }
                numOfCards--;
            }

            // Add TableRow to TableLayout
            tableLayout.addView(tableRow, params);
            currentNumberOfRow++;
        }
    }

    // Analyze a click and set reaction on click
    public void onClick(View v) {

        // User can't select any cards when the time ended
        if (timeRemaining == 0) { return; }

        final int clickedId = v.getId();

        // Flip the card in required way
        if ((!arrayOfCards[clickedId].getFlipped()) && (!arrayOfCards[clickedId].getMatched())) {

            // Determine if it's the first card of the second card that's flipped over
            if (firstFlipped < 0) {
                flip(clickedId);
                firstFlipped = clickedId;
            } else {
                // It's the second card
                flip(clickedId);

                // Wait for some time to display both flipped cards and analyze them
                Handler handler = new Handler();
                Runnable r = new Runnable() {
                    public void run() {
                        checkForMatches(clickedId);
                        firstFlipped = -1;
                    }
                };
                handler.postDelayed(r, 300);
            }
        }
        else {
            flipBack(clickedId);
            if (firstFlipped == clickedId) { firstFlipped = -1; }
        }
    }

    // TODO: Set animation
    // Methods for working with buttons
    private void flip(int i) {
        switch (arrayOfCards[i].getImageNum()) {
            case 1:
                buttons[i].setBackgroundResource(R.drawable.card1);
                break;
            case 2:
                buttons[i].setBackgroundResource(R.drawable.card2);
                break;
            case 3:
                buttons[i].setBackgroundResource(R.drawable.card3);
                break;
            case 4:
                buttons[i].setBackgroundResource(R.drawable.card4);
                break;
            case 5:
                buttons[i].setBackgroundResource(R.drawable.card5);
                break;
            case 6:
                buttons[i].setBackgroundResource(R.drawable.card6);
                break;
            case 7:
                buttons[i].setBackgroundResource(R.drawable.card7);
                break;
            case 8:
                buttons[i].setBackgroundResource(R.drawable.card8);
                break;
            case 9:
                buttons[i].setBackgroundResource(R.drawable.card9);
                break;
            case 10:
                buttons[i].setBackgroundResource(R.drawable.card10);
                break;
            case 11:
                buttons[i].setBackgroundResource(R.drawable.card11);
                break;
            case 12:
                buttons[i].setBackgroundResource(R.drawable.card12);
                break;
            case 13:
                buttons[i].setBackgroundResource(R.drawable.card13);
                break;
        }
        arrayOfCards[i].setFlipped(true);
        playSound(SoundEffect.flip);
    }
    private void flipBack(int i) {
        buttons[i].setBackgroundResource(R.drawable.back);
        arrayOfCards[i].setFlipped(false);
        playSound(SoundEffect.flip);
    }
    public void remove(int i) {
        buttons[i].setVisibility(View.INVISIBLE);
    }

    // Game logic methods
    public void checkForMatches(int second_flipped) {

        if (arrayOfCards[firstFlipped].getImageNum() == arrayOfCards[second_flipped].getImageNum()) {

            // If cards match
            arrayOfCards[firstFlipped].setMatched(true);
            arrayOfCards[second_flipped].setMatched(true);

            remove(firstFlipped);
            remove(second_flipped);

            playSound(SoundEffect.match);
        }
        else {

            // Cards are different
            flipBack(firstFlipped);
            flipBack(second_flipped);
            playSound(SoundEffect.nomatch);
        }

        // Check if all cards are matched
        checkGameEnded();
    }

    // Determine whether game ended or not
    public void checkGameEnded() {

        // Messaging variables
        String title;
        String message;

        // Determine if there any cards unmatched
        Boolean is_won = true;
        for (int i = 0; i < MenuCards.numOfCardPairs * 2; i++) {
            if (!arrayOfCards[i].getMatched()) {
                is_won = false;
                break;
            }
        }

        // If not, then user won
        if (is_won) {
            if (timeRemaining > 0) {
                timer.cancel();
            }

            title = "Поздравляем!";
            message = "Вы выиграли!";
            playSound(SoundEffect.won);

        }
        else {
            // If yes, check if there's any time left
            if (timeRemaining > 0) {
                return;
            }
            title = "Игра окончена!";
            message = "Вы проиграли!";
            playSound(SoundEffect.lost);
        }

        // Show won/lost message
        // TODO: Change the style
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title)
                .setMessage(message)
                .setIcon(R.drawable.icon)
                .setCancelable(false)
                .setNegativeButton("Закрыть",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        })
                .setNeutralButton("Главное меню",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                end_of_game();
                            }
                        })
                .setPositiveButton("Новая игра",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                new_game();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    // Go to the main menu
    public void end_of_game() {
        Intent intent = new Intent(this, MenuCards.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    // Start new game
    public void new_game() {
        Intent intent = new Intent(this, GameCards.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }




    // TODO: Check sounds when activity changes/stops/resumes/etc
    // TODO: Change sounds
    // Methods for sounds
    public void playSound(SoundEffect effect) {

        int sound_id;

        switch (effect) {
            case won:
                sound_id = R.raw.lion_roar;
                break;
            case flip:
                sound_id = R.raw.sparrow_mail;
                break;
            case lost:
                sound_id = R.raw.lion_roar;
                break;
            case match:
                sound_id = R.raw.short_kitten_meow;
                break;
            case nomatch:
                sound_id = R.raw.short_kitten_meow;
                break;
            case shuffle:
                sound_id = R.raw.sparrow_mail;
                break;
            default:
                return;
        }

        MediaPlayer ring = MediaPlayer.create(this, sound_id);
        ring.start();

    }

}
