package com.local;

/**
 * Dealer abstraction in the game.
 * Implementation must provide AI algorithm that will be used to take right decisions during the game.
 *
 * @author dmytro.malovichko
 */
public interface Dealer extends Player {

    /**
     * Reset dealer state
     */
    void gameOver();

}
