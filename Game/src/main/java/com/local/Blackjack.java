package com.local;

/**
 * @author dmytro.malovichko
 */
public interface Blackjack {

    /**
     * Start a game of Blackjack.
     *
     * @param deck the deck that will be used for the game
     * @param dealer dealer that will play with the human player
     */
    void start(Deck deck, Dealer dealer);
}
