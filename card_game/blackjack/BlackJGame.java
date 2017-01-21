package blackjack;
import java.util.*;

import templates.*;
import behaviours.*;


public class BlackJGame{
  private BlackJDeck deck;
  private ArrayList<Player> players;
  public Player player1;
  public Player player2;

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
    System.out.println("dealing starting hand");
    dealRound();
    dealRound();
    System.out.println("setup over");
  }

  public void dealRound(){

    for (Player player: players) {
      System.out.println(player.getName() + " has " + player.getHandSize() + " cards");

      player.deal(deck);
      System.out.println(player.getName() + " now has " + player.getHandSize() + " cards, with a value of " + player.checkHandValue());
      System.out.println("________________________________");
    }
  }

  public void play(){
    for (Player player: players) {
      if (player1.getStick = true && player2.getStick = true){
        checkStick(player);
      }
      else{
        System.out.println(player.getName()+"'s turn");
        if (player.checkHandValue() < 17)
        {
          hit(player);
          checkBust(player);
        }
        else{
          System.out.println(player.getName() + " has " + player.getHandSize() + " cards, with a value of " + player.checkHandValue() + "sticks");
          player.setStick = true;

        }
      }
    }
  }

  public void checkStick(Player player){
    if (player.checkHandValue() > 21){
      System.out.println(player.getName() + " is bust!");
      break
    }
  }

  public void checkBust(Player player){
    if (player.checkHandValue() > 21){
      System.out.println(player.getName() + " is bust!");
      break;
    }
  }

  public void hit(Player player){

    System.out.println(player.getName() + " has " + player.getHandSize() + " cards and hits");
    player.deal(deck);
    System.out.println(player.getName() + " now has " + player.getHandSize() + " cards, with a value of " + player.checkHandValue());
    System.out.println("________________________________");
  }
}