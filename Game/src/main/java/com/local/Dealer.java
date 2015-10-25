package com.local;

/**
 * Dealer abstraction in the game.
 * Implementation must provide AI algorithm that will be used to take right decisions during the game.
 *
 * @author dmytro.malovichko
 */
public interface Dealer {

    /**
     * The dealer must draw cards until it(AI) decides that it is enough
     *
     * @param deck currently used deck
     */
    void play(Deck deck);

    /**
     * Algorithm which decides whether it makes sense to draw another card taking into account cards in the Dealer's hand
     *
     * @return true, if it makes sense to draw another card based on AI algorithm, false otherwise
     */
    boolean isEnoughCards();
}
