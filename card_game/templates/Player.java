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

  public String getPlayerName(){
    return name;
  }


  public void deal(BlackJDeck deck){
    StandardCard card = deck.pickUpCard(this);
    this.hand.add(card);
  }

  public int checkHandValue(){
    int total = 0;
    for (StandardCard thisCard: hand) {
        total += thisCard.getValue();
    }
    return total;
  }
}