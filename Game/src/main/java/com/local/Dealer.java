package com.local;

/**
 * @author dmytro.malovichko
 */
public interface Dealer {

    void play(Deck deck);

    boolean isEnoughCards();
}
