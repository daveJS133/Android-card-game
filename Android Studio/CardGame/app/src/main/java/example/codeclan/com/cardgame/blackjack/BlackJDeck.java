package example.codeclan.com.cardgame.blackjack;

import java.util.ArrayList;
import java.util.Random;

import example.codeclan.com.cardgame.templates.Deck;

import example.codeclan.com.cardgame.templates.StandardCard;
import example.codeclan.com.cardgame.templates.StandardSuits;

/**
 * Created by user on 23/01/2017.
 */



public class BlackJDeck extends Deck {

    private String suiteName;
    private ArrayList<StandardCard> deck;
    private Random rand;

    StandardSuits suit;


    public BlackJDeck(){
        this.suit = suit;
        this.numOfSuits = 4;
        this.numInSuit = 13;
        this.faceCards = true;
        this.suits = new ArrayList<String>();
        this.deck = new ArrayList<StandardCard>();
        Random rand;
    }

    public void populateBlackJDeck(){
        for (StandardSuits suit:StandardSuits.values()) {
            suits.add(suit.toString());
            for(int i=0; i<numInSuit; i++){
                StandardCard card = createCard(suit, i+1);
                deck.add(card);
                System.out.println("deck: "+ card.getSuit().toString() + " " + card.getValue());
            }
        }

    }

    public StandardCard createCard(StandardSuits suit, int value){
        StandardCard card = new StandardCard(suit, value);
        return card;
    }

    public StandardCard pickUpCard(BlackJPlayer player){
        rand = new Random();
        int randomNum = rand.nextInt(numInSuit - 1 + 1) + 1;
        StandardCard newCard = deck.remove(randomNum);
        return newCard;
    }

}


