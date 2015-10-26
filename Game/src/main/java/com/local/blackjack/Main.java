package com.local.blackjack;

/**
 * @author dmytro.malovichko
 */
public class Main {

    public static void main(String[] args) {
        final Blackjack blackjack = new Blackjack();

        // play a game of blackjack 5 times just to see it work
        for (int i = 0; i < 5; i++) {
            blackjack.start();
        }
    }
}
