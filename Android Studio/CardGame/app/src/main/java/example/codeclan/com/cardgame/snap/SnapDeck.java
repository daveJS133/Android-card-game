package example.codeclan.com.cardgame.snap;

import java.util.ArrayList;
import java.util.Random;

import example.codeclan.com.cardgame.templates.Deck;
import example.codeclan.com.cardgame.templates.NoveltyCard;
import example.codeclan.com.cardgame.templates.NoveltySuits;


/**
 * Created by user on 25/01/2017.
 */

public class SnapDeck extends Deck {

    private String suiteName;
    private ArrayList<NoveltyCard> deck;
    private Random rand;

    NoveltySuits suit;


    public SnapDeck(){
        this.suit = suit;
        this.numOfSuits = 5;
        this.numInSuit = 4;
        this.faceCards = true;
        this.suits = new ArrayList<String>();
        this.deck = new ArrayList<NoveltyCard>();

    }

    public void populateNoveltyDeck(){
        for (NoveltySuits suit:NoveltySuits.values()) {
            suits.add(suit.toString());
            for(int i=0; i<numInSuit; i++){
                NoveltyCard card = createCard(suit);
                deck.add(card);
            }
        }
    }

    public NoveltyCard createCard(NoveltySuits suit){
        NoveltyCard card = new NoveltyCard(suit);
        return card;
    }

    public NoveltyCard pickUpCard(SnapPlayer player){
        rand = new Random();
        int randomNum = rand.nextInt(numInSuit - 1 + 1) + 1;
        NoveltyCard newCard = deck.remove(randomNum);
        return newCard;
    }



}



