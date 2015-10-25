package com.local;

/**
 * @author dmytro.malovichko
 */
public interface Deck {

    /**
     * Shuffle this deck of cards
     */
    void shuffle();

    /**
     * Draw next card from the deck's top
     *
     * @return next card in the deck
     */
    Card drawCard();

}
