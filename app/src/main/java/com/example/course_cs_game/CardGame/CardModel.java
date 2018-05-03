package com.example.course_cs_game.CardGame;

import java.util.Random;

public class CardModel {

    public int number_of_cards = 8;
    public static Random rand = new Random();

    public Card[] getCards() {

        // Declare the array for generated cards
        Card[] generated_cards_array = new Card[2 * number_of_cards];

        // Randomly generate pairs of cards
        for (int i = 0; i < number_of_cards; i++) {

            // Get a random number
            int random_number = rand.nextInt(13) + 1;

            // Log the number
            System.out.println(random_number);

            // First card object
            Card card_one = new Card();
            card_one.image_name = "card" + random_number;
            generated_cards_array[2*i] = card_one;

            // Second card object
            Card card_two = new Card();
            card_one.image_name = "card" + random_number;
            generated_cards_array[2*i + 1] = card_two;

            // TODO: Make pairs of cards different

        }

        // TODO: Randomize the array

        // Return the array
        return generated_cards_array;
    }
}
