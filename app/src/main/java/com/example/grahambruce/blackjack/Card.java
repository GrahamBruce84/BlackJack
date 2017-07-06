package com.example.grahambruce.blackjack;

/**
 * Created by grahambruce on 30/06/2017.
 */

public class Card {

    Rank rank;
    Suit suit;

    public Card(Rank valueOfCard, Suit suitOfCard){
        this.rank = valueOfCard;
        this.suit = suitOfCard;
    }

    public int cardValue(){
        return this.rank.getValue();
    }

    public String prettyName(){
        return this.rank + " of " + this.suit;
    }
}
