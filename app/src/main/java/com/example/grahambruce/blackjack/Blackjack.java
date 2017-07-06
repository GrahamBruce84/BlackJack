package com.example.grahambruce.blackjack;

import java.util.Scanner;

/**
 * Created by grahambruce on 30/06/2017.
 */

public class Blackjack {

    Deck deck;
    Dealer dealer;
    Player player;

    public Blackjack() {
        deck = new Deck();
        dealer = new Dealer(deck);
        player = new Player();
    }

    public void play() {
        for (int i = 0; i < 2; i++) {
            dealer.addCardToHand(dealer.deal());
            player.addCardToHand(dealer.deal());
        }

        Card card = dealer.showFirstCard();
        System.out.println("Dealer has " + card.prettyName());
        System.out.println();

        Hand playerHand = player.showHand();
        if (checkBlackJack(playerHand)) {
            System.out.println("Player has BlackJack");
        } else {
            playerTurn(playerHand);
        }
        Hand dealerHand = dealer.showHand();
        dealerTurn(dealerHand);
        checkForWinner(dealerHand, playerHand);
    }

    public boolean checkBlackJack(Hand hand) {
        if (hand.getHandValue() == 21) {
            return true;
        }
        return false;
    }


    public void playerTurn(Hand playerHand) {
        boolean playing = true;
        while (playing) {
            System.out.println("Player has: ");
            for (Card playerCard : playerHand.showHand()) {
                System.out.println(playerCard.prettyName());
            }
            System.out.println("Player has " + playerHand.getHandValue());
            System.out.println("\nDo you want to stick or twist?");
            Scanner sc = new Scanner(System.in);
            String answer = sc.nextLine().toUpperCase();
            if (answer.equals("TWIST")) {
                player.addCardToHand(dealer.deal());
                if (isBust(playerHand)) {
                    break;
                }
            } else {
                playing = false;
            }
        }
    }

    public boolean isBust(Hand playerHand) {
        if (playerHand.getHandValue() > 21) {
            System.out.println("Player is bust!");
            return true;
        }
        return false;
    }

    public void dealerTurn(Hand dealerHand) {
        boolean playing = true;
        while (playing) {
            if (dealerHand.getHandValue() < 17 && !isBust(dealerHand)) {
                dealer.addCardToHand(dealer.deal());
            } else {
                playing = false;
            }
        }
    }

    public String checkForWinner(Hand dealerHand, Hand playerHand) {
        if (!isBust(playerHand)) {
            if ((playerHand.getHandValue() > dealerHand.getHandValue()) || isBust(dealerHand)) {
                return "Player has won!";
            }
        } else if (!isBust(dealerHand)) {
            return "Dealer has won!";
        }
        return "Everybody's lost!";
    }
}
