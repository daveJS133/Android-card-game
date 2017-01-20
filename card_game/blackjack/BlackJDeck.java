package blackjack;
import java.util.*;
import templates.*;
import behaviours.*;




public class BlackJDeck extends Deck{

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
    Random rand = new Random();
  }

  public void populateBlackJDeck(){
    for (StandardSuits suit:StandardSuits.values()) { 
      suits.add(suit.toString()); 
      for(int i=0; i<numInSuit; i++){
        StandardCard card = createCard(suit, i+1);
        deck.add(card);
      }
    }
  }

  public StandardCard createCard(StandardSuits suit, int value){
    StandardCard card = new StandardCard(suit, value);
    return card;
  }

  public StandardCard pickUpCard(Player player){
    int randomNum = rand.nextInt(numInSuit + 1) + 0;
    StandardCard newCard = deck.remove(randomNum);
    return newCard;
  }

}


