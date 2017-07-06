package com.example.grahambruce.blackjack;


import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by grahambruce on 30/06/2017.
 */

public class Deck {

    ArrayList<Card> cards;

    public Deck(){
        cards = new ArrayList<Card>();
        populate();
    }

    public void populate(){
        for (Suit suit : Suit.values()){
            for (Rank rank : Rank.values()){
                cards.add(new Card(rank, suit));
            }
        }
    }

    public Card getCard(){
        return cards.remove(0);
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }
}
