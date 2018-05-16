package com.example.course_cs_game.CardGame;

/**
 * This class represents the model of a single card
 * and contains its main properties: current state
 * and the number of image of the card
 */

public class Card {

    private int imageNum = 0;
    private Boolean isFlipped = false;
    private Boolean isMatched = false;

    public void setImageNum(int imageNum) {
        this.imageNum = imageNum;
    }

    public int getImageNum() {
        return imageNum;
    }

    public Boolean getFlipped() {
        return isFlipped;
    }

    public void setFlipped(Boolean flipped) {
        isFlipped = flipped;
    }

    public void setMatched(Boolean matched) {
        isMatched = matched;
    }

    public Boolean getMatched() {
        return isMatched;
    }
}
