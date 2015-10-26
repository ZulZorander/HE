package com.local.blackjack;

import com.local.Card;
import com.local.Deck;
import com.local.Rank;
import com.local.Suit;
import com.local.blackjack.exception.EmptyDeckException;

import java.util.*;

/**
 * @author dmytro.malovichko
 */
public class FrenchDeck implements Deck {

    public static final int DECK_SIZE = 52;

    private Stack<Card> deck = new Stack<Card>();

    public FrenchDeck() {
        initDeck();
    }

    @Override
    public void shuffle() {
        if(deck.size() != DECK_SIZE) {
            // populate deck in case it is not full
            initDeck();
        }
        final Random random = new Random();
        for(int i = 0; i < DECK_SIZE; i++ ) {
            // swap random card with current card
            deck.set(i, deck.set(random.nextInt(DECK_SIZE), deck.get(i)));
        }
    }

    @Override
    public Card drawCard() throws EmptyDeckException {
        try {
            return deck.pop();
        } catch (EmptyStackException e) {
            throw new EmptyDeckException(e);
        }
    }

    private void initDeck() {
        deck.clear();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.push(new DefaultCard(suit, rank));
            }
        }
    }
}
