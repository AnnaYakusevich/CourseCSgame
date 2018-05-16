package com.example.course_cs_game.CardGame;

import com.example.course_cs_game.MenuCards;
import java.util.Random;

public class CardModel {

    private Random rand = new Random();

    /**
     * In this method array of cards for game is made
     *
     * @return generatedCardsArray
     */
    protected Card[] getCards() {

        // The array for generated cards
        Card[] generatedCardsArray = new Card[2 * MenuCards.numOfCardPairs];

        int[] numberOfCardsForEachType = new int[MenuCards.numOfCardTypes];
        for(int j = 0; j < MenuCards.numOfCardTypes; j++) {
            numberOfCardsForEachType[j] = 0;
        }

        // Randomly generate numOfCardPairs pairs of cards
        int i = 0;
        int maxNumOfOneTypeCards = MenuCards.numOfCardPairs / MenuCards.numOfCardTypes;
        if (MenuCards.numOfCardPairs % MenuCards.numOfCardTypes != 0) {
            maxNumOfOneTypeCards++;
        }
        while (i < MenuCards.numOfCardPairs) {

            int randomNumber = rand.nextInt(MenuCards.numOfCardTypes);
            if (MenuCards.enabledCards[randomNumber] == 0) continue;
            System.out.println("Log: Pairs of cards " + randomNumber);

            // Make sure that cards are different
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

        randomizeArray(generatedCardsArray);

        return generatedCardsArray;
    }

    /**
     * This method changes the order of cards in array to make the game interesting
     *
     * @param generatedCardsArray array to randomize
     */
    private void randomizeArray(Card[] generatedCardsArray) {
        Card temp;
        for(int i = 0; i < MenuCards.numOfCardPairs * 2; i++) {
            int random_number = rand.nextInt(MenuCards.numOfCardPairs * 2);
            temp = generatedCardsArray[i];
            generatedCardsArray[i] = generatedCardsArray[random_number];
            generatedCardsArray[random_number] = temp;
        }
    }

}
