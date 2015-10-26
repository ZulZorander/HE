package com.local.blackjack;

import com.local.Card;
import com.local.Rank;
import com.local.Suit;

/**
 * @author dmytro.malovichko
 */
public class DefaultCard implements Card {

    private final Suit suit;

    private final Rank rank;

    public DefaultCard(final Suit suit, final Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public Rank getRank() {
        return rank;
    }

    @Override
    public Suit getSuit() {
        return suit;
    }

    @Override
    public int getPoints() {
        return rank.getPoints();
    }

    @Override
    public String toString() {
        return String.format("%s %s; ", getRank(), getSuit());
    }
}
