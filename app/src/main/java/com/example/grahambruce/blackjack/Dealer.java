package com.example.grahambruce.blackjack;

/**
 * Created by grahambruce on 30/06/2017.
 */

public class Dealer {
    Deck deck;
    Hand hand;

    public Dealer(Deck newDeck){
        this.deck = newDeck;
        this.hand = new Hand();
        shuffle();
    }

    public void shuffle(){
        this.deck.shuffle();
    }

    public Card deal(){
        return deck.getCard();
    }

    public void addCardToHand(Card card){
        hand.addCard(card);
    }

    public Card showFirstCard(){
        return hand.showFirstCard();
    }

    public Hand showHand(){
        return hand;
    }

}
