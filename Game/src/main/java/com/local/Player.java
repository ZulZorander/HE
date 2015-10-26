package com.local;

import com.local.blackjack.exception.GameOverException;

import java.util.List;
import java.util.Set;

/**
 * @author dmytro.malovichko
 */
public interface Player {

    /**
     * Game decision making logic
     *
     * @param deck currently used deck
     * @return true, if player is still playing, false otherwise
     */
    boolean play(Deck deck) throws GameOverException;

    /**
     * Get cards in player's hand
     *
     * @return cards in player's hand
     */
    List<Card> getCardsInHand();

    /**
     * Get current amount of player's points
     *
     * @return current amount of player's points
     */
    int getPointsInHand();
}
