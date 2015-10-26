package com.local.blackjack;

import com.local.Card;
import com.local.Dealer;
import com.local.Deck;
import com.local.Rank;
import com.local.blackjack.exception.EmptyDeckException;
import com.local.blackjack.exception.GameOverException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dmytro.malovichko
 */
public class DefaultDealer implements Dealer {

    private final List<Card> hand = new ArrayList<Card>();

    /**
     * Store points separately so that we don't iterate over the list on each draw card operation
     */
    private int points = 0;

    /**
     * Soft hands means that a dealer has an Ace, which can have 1 or 11 points
     */
    private boolean isSoftHand;

    private static final int RISK_THRESHOLD = 17;

    private static final int SOFT_HAND_RISK_THRESHOLD = 19;

    private static final int OVERFLOW_THRESHOLD = 21;

    @Override
    public boolean play(Deck deck) throws GameOverException {
        if(!isEnoughCards()) {
            final Card card = drawCard(deck);
            hand.add(card);
            checkSoftHand(card);
            countPoints(card);
            checkOverflow();
            return true;
        }

        return false;
    }

    @Override
    public void gameOver() {
        hand.clear();
        isSoftHand = false;
        points = 0;
    }

    private Card drawCard(Deck deck) throws GameOverException {
        try {
            return deck.drawCard();
        } catch (EmptyDeckException e) {
            throw new GameOverException("There is no cards in the deck");
        }
    }

    private void checkOverflow() throws GameOverException {
        if (points > OVERFLOW_THRESHOLD) {
            throw new GameOverException("Dealer has more then 21 points");
        }
    }

    private void checkSoftHand(Card card) {
        isSoftHand = isSoftHand || Rank.ACE.equals(card.getRank());
    }

    private void countPoints(Card card) {
        points += card.getPoints();
    }

    /**
     * Simple Blackjack dealer algorithm
     * Ace is 1 point by default
     */
    private boolean isEnoughCards() {
        if (isSoftHand) {
            // dealer has an Ace, which means that he can risk one more card if he has less then certain "risk threshold" points
            return points >= RISK_THRESHOLD || (points + 10) >= SOFT_HAND_RISK_THRESHOLD;
        } else {
            return points >= RISK_THRESHOLD;
        }
    }

    @Override
    public List<Card> getCardsInHand() {
        return hand;
    }

    @Override
    public int getPointsInHand() {
        return isSoftHand && ((points + 10) <= OVERFLOW_THRESHOLD) ? (points + 10) : points;
    }
}
