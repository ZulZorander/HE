package com.local;

/**
 * @author dmytro.malovichko
 */
public interface Card {

    String getRank();

    String getSuit();

    /**
     * Get amount of points that this card represents
     *
     * @return amount of points that this card represents
     */
    int getPoints();
}
