package example.codeclan.com.cardgame.blackjack;

import java.util.ArrayList;

import example.codeclan.com.cardgame.PlayBlackJActivity;
import example.codeclan.com.cardgame.templates.StandardCard;

/**
 * Created by user on 25/01/2017.
 */

public class BlackJPlayer {
    protected PlayBlackJActivity context;
    private ArrayList<StandardCard> hand;
    private String name;
    private Boolean stick;

    public BlackJPlayer(String name, PlayBlackJActivity _context){
        this.hand = new ArrayList<StandardCard>();
        this.name = name;
        this.stick = false;
    }

    public void setPlayerName(String newName){
        name = newName;

    }

    public BlackJPlayer getPlayer(){
        return this;
    }

    public String getName(){
        return name;
    }

    public ArrayList<StandardCard> getHand(){
        return hand;
    }

    public int getHandSize(){
        return hand.size();
    }


    public void setStick(){
        stick = true;
    }
    public Boolean getStick(){
        return stick;
    }



    public void deal(BlackJDeck deck){
        StandardCard card = deck.pickUpCard(this);
        card.setFace(Integer.toString(card.getValue())) ;
        if (card.getValue() == 11){
            card.setValue(10);
            card.setFace("J");
        }
        if (card.getValue() == 12){
            card.setValue(10);
            card.setFace("Q");
        }

        if (card.getValue() == 13){
            card.setValue(10);
            card.setFace("K");
        }

        if (card.getValue() == 1){
            card.setFace("A");
        }

        if (card.getValue() == 1 && this.checkHandValue()  < 11){
            card.setValue(11);
        }

        this.hand.add(card);
        System.out.println(this.name + " picks up the " + card.getValue() + " of "+ card.getSuit());
    }


    public int checkHandValue(){
        int total = 0;
        for (StandardCard thisCard: hand) {
            total += thisCard.getValue();
        }
        return total;
    }
}
