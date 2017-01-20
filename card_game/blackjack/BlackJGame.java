package blackjack;
import java.util.*;

import templates.*;
import behaviours.*;


public class BlackJGame{
  private BlackJDeck deck;
  private ArrayList<Player> players;
  Player player1;
  Player player2;


  public BlackJGame(String player1Name, String player2Name){
    this.player1 = new Player(player1Name);
    this.player2 = new Player(player2Name);
    this.deck = new BlackJDeck();
    this.players = new ArrayList<Player>();
  }

  public void setup(){
    players.add(player1);
    players.add(player2);

    deck.populateBlackJDeck();
    dealRound();
  }

  public void dealRound(){
    for (Player player: players) {
      player.deal(deck);
    }
  }

  public void play(){
    for (Player player: players) {
      if (player.checkHandValue() < 17)
      {
        player.deal(deck);
      }
    }

    if (player1.checkHandValue() > player2.checkHandValue() && player1.checkHandValue()<21){
      System.out.println("player1 wins");
    }

    if (player2.checkHandValue() > player1.checkHandValue() && player2.checkHandValue()<21){
      System.out.println("player2 wins");
      
    }
  }
}