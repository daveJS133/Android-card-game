package templates;
import java.util.*;

import templates.*;
import behaviours.*;
import blackjack.*;


public class Player implements Dealable{
  private ArrayList<StandardCard> hand;
  private String name;

  public Player(String name){
    this.hand = new ArrayList<StandardCard>();
    this.name = name;
  }

  public void setPlayerName(String newName){
    name = newName;

  }

  public Player getPlayer(){
    return this;
  }

  public String getName(){
    return name;
  }

  public int getHandSize(){
    return hand.size();
  }


  public void deal(BlackJDeck deck){
    StandardCard card = deck.pickUpCard(this);
    if (card.getValue() > 10){
      card.setValue(10);
    }
    this.hand.add(card);
    System.out.println(this.name + " picks up the " + card.getValue() + " of "+ card.suit);
  }

  public int checkHandValue(){
    int total = 0;
    for (StandardCard thisCard: hand) {
        total += thisCard.getValue();
    }
    return total;
  }
}