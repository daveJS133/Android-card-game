package templates;

import java.util.*;
import blackjack.*;
import behaviours.*;




public class StandardCard {
  private int value;
  StandardSuits suit;

   public StandardCard(StandardSuits suit, int value){
    this.value = value;
    this.suit = suit;
  }

  public StandardSuits getSuit(){
    return this.suit;
  }

  public int getValue(){
    return this.value;
  }

 
}