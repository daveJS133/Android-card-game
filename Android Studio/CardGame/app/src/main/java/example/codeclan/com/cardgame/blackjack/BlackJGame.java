package example.codeclan.com.cardgame.blackjack;

import java.util.ArrayList;

import example.codeclan.com.cardgame.behaviours.Dealable;
import example.codeclan.com.cardgame.templates.Player;

/**
 * Created by user on 23/01/2017.
 */

public class BlackJGame{
    private BlackJDeck deck;
    private ArrayList<Player> players;
    public Player player1;
    public Player player2;

    public BlackJGame(String player1Name){
        this.player1 = new Player(player1Name);
        this.player2 = new Player("Dealer");
        this.deck = new BlackJDeck();
        this.players = new ArrayList<Player>();
    }

    public void setup(){
        players.add(player1);
        players.add(player2);

        deck.populateBlackJDeck();
        System.out.println("dealing starting hand");
        dealRound();
        player1.deal(deck);
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
            if (player1.getStick() == true && player2.getStick() == true){
                checkStick();
            }
            else{
                System.out.println(player.getName()+"'s turn");
                while (player.checkHandValue() < 17)
                {
                    hit(player);
                    checkBust(player);
                }

                System.out.println(player.getName() + " has " + player.getHandSize() + " cards, with a value of " + player.checkHandValue() + "sticks");
                player.setStick();
            }
        }
    }

    public void checkStick(){
        if (player1.checkHandValue() > player2.checkHandValue()){
            System.out.println(player1.getName() + " wins!");
        }
        else{
            System.out.println(player2.getName() + " wins!");
        }
        // break;
    }


    public void checkBust(Player player){
        if (player.checkHandValue() > 21){
            System.out.println(player.getName() + " is bust!");
            // break;
        }
    }

    public void hit(Player player){

        System.out.println(player.getName() + " has " + player.getHandSize() + " cards and hits");
        player.deal(deck);
        System.out.println(player.getName() + " now has " + player.getHandSize() + " cards, with a value of " + player.checkHandValue());
        System.out.println("________________________________");
    }
}