package com.example.course_cs_game.CardGame;

import com.example.course_cs_game.MenuCards;

import java.util.Random;

public class CardModel {

    private Random rand = new Random();

    // Prepare array for work
    private int[] numberOfCardsForEachType = new int[MenuCards.numOfCardTypes];
    private void makeArrayOfZeros() {
        for(int j = 0; j < 13; j++) {
            numberOfCardsForEachType[j] = 0;
        }
    }

    // The array for generated cards
    private Card[] generatedCardsArray = new Card[2 * MenuCards.numOfCardPairs];

    // Make and return an array of cards for game
    protected Card[] getCards() {

        makeArrayOfZeros();

        // Randomly generate numOfCardPairs pairs of cards
        int i = 0;
        while (i < MenuCards.numOfCardPairs) {

            int randomNumber = rand.nextInt(13);

            // Making sure that cards are different
            int maxNumOfOneTypeCards = MenuCards.numOfCardPairs / 13;
            if (MenuCards.numOfCardPairs % 13 != 0) {
                maxNumOfOneTypeCards++;
            }
            if (numberOfCardsForEachType[randomNumber] < maxNumOfOneTypeCards) {

                // First card object
                Card card = new Card();
                card.setImageNum(randomNumber + 1);
                generatedCardsArray[2 * i] = card;

                // Second card object
                card = new Card();
                card.setImageNum(randomNumber + 1);
                generatedCardsArray[2 * i + 1] = card;

                numberOfCardsForEachType[randomNumber]++;
                i++;
            }
        }

        randomizeArray();

        return generatedCardsArray;
    }

    // Change the order of cards to make the game interesting
    private void randomizeArray() {
        Card temp;
        for(int i = 0; i < MenuCards.numOfCardPairs * 2; i++) {
            int random_number = rand.nextInt(MenuCards.numOfCardPairs * 2);
            temp = generatedCardsArray[i];
            generatedCardsArray[i] = generatedCardsArray[random_number];
            generatedCardsArray[random_number] = temp;
        }
    }

}
