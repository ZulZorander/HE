package com.local;

/**
 * @author dmytro.malovichko
 */
public enum Rank {
    TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10), ACE(1);

    int points;

    Rank(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }
}
