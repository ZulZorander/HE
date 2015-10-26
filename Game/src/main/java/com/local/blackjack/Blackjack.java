package com.local.blackjack;

import com.local.*;
import com.local.blackjack.exception.GameOverException;

/**
 * @author dmytro.malovichko
 */
public class Blackjack implements Game {

    @Override
    public void start() {
        Deck deck = new FrenchDeck();
        Dealer dealer = new DefaultDealer();
        Dealer player = new DefaultDealer();

        try {
            System.out.println("----------NEW-GAME----------");
            deck.shuffle();
            boolean isDealerPlaying = true;
            boolean isPlayerPlaying = true;
            while (isDealerPlaying || isPlayerPlaying) {
                isPlayerPlaying = player.play(deck);
                isDealerPlaying = dealer.play(deck);
            }
            processResults(dealer, player);
        } catch (GameOverException e) {
            System.out.println(e.getMessage());
            processResults(dealer, player);
        }
    }

    private void outputCards(Player player) {
        for (Card card : player.getCardsInHand()) {
            System.out.print(card);
        }
        System.out.println();
        System.out.printf("%s points", player.getPointsInHand());
        System.out.println();
    }

    private void processResults(Dealer dealer, Player player) {
        final int playerPoints = player.getPointsInHand();
        System.out.print("Player cards: ");
        outputCards(player);
        System.out.print("Dealer cards: ");
        outputCards(dealer);
        final int dealerPoints = dealer.getPointsInHand();
        if ((playerPoints <= 21 && playerPoints > dealerPoints && dealerPoints <= 21) || (playerPoints <= 21 && dealerPoints > 21)) {
            System.out.println("Player has won!");
        } else if ((dealerPoints == playerPoints && playerPoints <= 21) || (dealerPoints > 21 && playerPoints > 21)) {
            System.out.println("Draw!");
        } else if (playerPoints > 21 || dealerPoints > playerPoints) {
            System.out.println("Player has lost!");
        }
    }
}
