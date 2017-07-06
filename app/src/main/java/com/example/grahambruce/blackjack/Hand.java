package com.example.grahambruce.blackjack;

import java.util.ArrayList;

/**
 * Created by grahambruce on 30/06/2017.
 */

public class Hand {

    ArrayList<Card> cards;

    public Hand(){
        this.cards = new ArrayList<Card>();
    }


    public void addCard(Card card) {
        cards.add(card);
    }


    public Card showFirstCard() {
        return cards.get(0);
    }

    public ArrayList<Card> showHand(){
        return cards;
    }

    public int getHandValue(){
        int total = 0;
        for (Card card : cards){
            total += card.cardValue();
        }
        return total;
    }
}
