package com.example.course_cs_game.CardGame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
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
    private ImageView[] buttons = new ImageView[MenuCards.numOfCardPairs * 2];
    private int firstFlipped = -1;
    private CountDownTimerPausable timer;

    /**
     * Overriding basic methods of activity state
     */
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

        startGame();

    }

    /**
     * Start the game, create the timer
     */
    private void startGame() {
        // Get generated cards
        arrayOfCards = model.getCards();

        displayCards();

        // Create timer and display it
        final TextView timeText = findViewById(R.id.time_remaining);
        int timeForGame = MenuCards.timeForGame;
        timer = new CountDownTimerPausable(timeForGame, 10) {

            public void onTick(long millisUntilFinished) {
                timeRemaining = millisUntilFinished;
                String time = "Time remaining: " + timeRemaining / 1000 + ".";
                if (timeRemaining % 1000 / 10 < 10) {
                    time += "0" + timeRemaining % 1000 / 10 + " s";
                }
                else {
                    time += timeRemaining % 1000 / 10 + " s";
                }
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

    /**
     * In this method all buttons are created and added to the screen
     */
    private void displayCards() {

        // Find TableLayout to work with it
        TableLayout tableLayout = findViewById(R.id.table_layout_cards);
        tableLayout.removeAllViewsInLayout();

        int currentNumberOfRow = 0;
        int numOfCards = MenuCards.numOfCardPairs * 2;

        while (numOfCards >= 1) {

            // Create a tableRow
            TableRow tableRow = new TableRow(this);
            TableLayout.LayoutParams params = new TableLayout.LayoutParams(0, LayoutParams.WRAP_CONTENT, 1);
            params.setMargins(5, 5, 5, 0);
            params.bottomMargin = 20;
            tableRow.setLayoutParams(params);
            tableRow.setWeightSum(1);

            // Add buttons to TableRow (max four in each line)
            for (int i = 1; i <= MenuCards.numOfCardsInRow; i++) {

                // If all cards already exist, end adding
                if (numOfCards == 0) { break; }

                // Create a button object with default parameters
                ImageView button = new ImageView(this);
                button.setId(currentNumberOfRow * MenuCards.numOfCardsInRow + i - 1);
                LayoutParams params1 = new TableRow.LayoutParams(0, (int) ((MenuCards.screenWidth
                        / 2.7) * (4.0 / MenuCards.numOfCardsInRow)), 22f / (25 * MenuCards.numOfCardsInRow - 3));
                button.setScaleType(ImageView.ScaleType.FIT_XY);
                button.setImageResource(MenuCards.backId);
                button.setLayoutParams(params1);

                // Add button to the array of all buttons and to the TableRow
                buttons[currentNumberOfRow * MenuCards.numOfCardsInRow + i - 1] = button;
                buttons[currentNumberOfRow * MenuCards.numOfCardsInRow + i - 1].setOnClickListener(this);
                tableRow.addView(buttons[currentNumberOfRow * MenuCards.numOfCardsInRow + i - 1]);
                // Add to TableRow additional TextView to separate buttons from each other
                if (i != MenuCards.numOfCardsInRow) {
                    TextView separator = new TextView(this);
                    separator.setLayoutParams(new TableRow.LayoutParams(0, LayoutParams.WRAP_CONTENT,
                            3f / (25 * MenuCards.numOfCardsInRow - 3)));
                    tableRow.addView(separator);
                }
                numOfCards--;
            }

            // Add TableRow to TableLayout
            tableLayout.addView(tableRow, params);
            currentNumberOfRow++;
        }
    }

    /**
     * Analyze a click and set reaction on click
     *
     * @param v current view when object was clicked
     */
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

    /**
     * Show the picture of the card if clicked
     *
     * @param i - id if the clicked card
     */
    private void flip(int i) {
        switch (arrayOfCards[i].getImageNum()) {
            case 1:
                buttons[i].setImageResource(R.drawable.card1);
                break;
            case 2:
                buttons[i].setImageResource(R.drawable.card2);
                break;
            case 3:
                buttons[i].setImageResource(R.drawable.card3);
                break;
            case 4:
                buttons[i].setImageResource(R.drawable.card4);
                break;
            case 5:
                buttons[i].setImageResource(R.drawable.card5);
                break;
            case 6:
                buttons[i].setImageResource(R.drawable.card6);
                break;
            case 7:
                buttons[i].setImageResource(R.drawable.card7);
                break;
            case 8:
                buttons[i].setImageResource(R.drawable.card8);
                break;
            case 9:
                buttons[i].setImageResource(R.drawable.card9);
                break;
            case 10:
                buttons[i].setImageResource(R.drawable.card10);
                break;
            case 11:
                buttons[i].setImageResource(R.drawable.card11);
                break;
            case 12:
                buttons[i].setImageResource(R.drawable.card12);
                break;
            case 13:
                buttons[i].setImageResource(R.drawable.card13);
                break;
        }
        arrayOfCards[i].setFlipped(true);
    }

    /**
     * Show the back of the card if clicked twice
     *
     * @param i - id if the clicked card
     */
    private void flipBack(int i) {
        buttons[i].setImageResource(MenuCards.backId);
        arrayOfCards[i].setFlipped(false);
    }

    /**
     * Makes card invisible (called if two card matches)
     *
     * @param i - id if the card
     */
    public void remove(int i) {
        buttons[i].setVisibility(View.INVISIBLE);
    }

    /**
     * Checks whether two flipped cards are the same or not
     *
     * @param second_flipped - id if the card that was second clicked
     */
    public void checkForMatches(int second_flipped) {

        if (arrayOfCards[firstFlipped].getImageNum() == arrayOfCards[second_flipped].getImageNum()) {

            // If cards match
            arrayOfCards[firstFlipped].setMatched(true);
            arrayOfCards[second_flipped].setMatched(true);

            remove(firstFlipped);
            remove(second_flipped);

            // Check if all cards are matched
            checkGameEnded();
        }
        else {

            // Cards are different
            flipBack(firstFlipped);
            flipBack(second_flipped);
        }

    }

    /**
     * Determine whether game ended or not
     * Called when
     */
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
            message = "Вы готовы к сессии!";

        }
        else {
            // If yes, check if there's any time left
            if (timeRemaining > 0) {
                return;
            }
            title = "Игра окончена!";
            message = "Удачи на пересдаче!";
        }

        // Show won/lost message
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title)
                .setMessage(message)
                .setIcon(R.mipmap.icon)
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
                                startGame();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    /**
     * This method destroys the current activity and return user to the main menu
     */
    public void end_of_game() {
        finish();
    }

}
