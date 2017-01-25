package example.codeclan.com.cardgame.blackjack;

import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import example.codeclan.com.cardgame.PlayBlackJActivity;
import example.codeclan.com.cardgame.templates.StandardCard;

/**
 * Created by user on 23/01/2017.
 */

public class BlackJGame {

    protected PlayBlackJActivity context;
    private BlackJDeck deck;
    private ArrayList<BlackJPlayer> players;
    public BlackJPlayer player1;
    public BlackJPlayer player2;


    public BlackJGame(String player1Name, PlayBlackJActivity _context) {
        context = _context;
        this.player1 = new BlackJPlayer(player1Name, context);
        this.player2 = new BlackJPlayer("Dealer", context);
        this.deck = new BlackJDeck();
        this.players = new ArrayList<BlackJPlayer>();
    }

    public void setup() {
        players.add(player1);
        players.add(player2);

        deck.populateBlackJDeck();
        System.out.println("dealing starting hand");
        dealRound();
        player1.deal(deck);
        System.out.println("setup over");
        checkStick();

    }

    public void dealRound() {

        for (BlackJPlayer player : players) {
            System.out.println(player.getName() + " has " + player.getHandSize() + " cards");
            player.deal(deck);
            System.out.println(player.getName() + " now has " + player.getHandSize() + " cards, with a value of " + player.checkHandValue());
            System.out.println("________________________________");
        }
    }

    public void play() {

        for (BlackJPlayer player : players) {
            while (!checkBust(player1) && !checkBust(player2)) {
                while (!player.getStick()) {
                    context.setChecker(player.getName() + "'s turn");
//                while (player == player1){
//                  context.onHitButtonPressed{
//                hit(player)
//                checkBust(player);
//            }
//                System.out.println(player.getName() + " has " + player.getHandSize() + " cards, with a value of " + player.checkHandValue() + " & sticks");
//                player.setStick();

//            }
//                else{
                    while (player.checkHandValue() < 17) {
                        hit(player);
                        player.checkHandValue();
                    }

                    if (player.checkHandValue() == 21) {
                        context.setChecker(player.getName() + " wins");
                        context.updateWinner();

                    } else if (checkBust(player)) {
                        context.setChecker(player.getName() + " is bust!");
                        context.updateWinner();
                    } else {
                        player.setStick();
                    }
                }

            }
            if (player1.getStick() && player2.getStick()) {
                if (player1.checkHandValue() > player2.checkHandValue()) {
                    context.setChecker("Player 1 wins");
                    context.updateWinner();
                } else {
                    context.setChecker("Player 2 wins");
                    context.updateWinner();
                }
            }
        }
    }



    public String checkStick() {
        if (player1.getStick() && player2.getStick()) {
            if (player1.checkHandValue() > player2.checkHandValue()) {
                return (player1.getName() + " wins!");
            } else {
                return (player2.getName() + " wins!");
            }
        } else {
            return "Playing";
        }

    }


    public Boolean checkBust(BlackJPlayer player) {
        if (player.checkHandValue() > 21) {
            return true;
            // break;
             }
            else{
            return false;
        }
    }


    public void hit(BlackJPlayer player) {

        System.out.println(player.getName() + " has " + player.getHandSize() + " cards and hits");
        player.deal(deck);
        System.out.println(player.getName() + " now has " + player.getHandSize() + " cards, with a value of " + player.checkHandValue());
        System.out.println("________________________________");
    }

    public ArrayList getPlayers() {
        return players;
    }


    public void populateHandViews(LinearLayout handView, BlackJPlayer player) {
        handView.removeAllViews();
        for (StandardCard card : player.getHand()) {
            TextView cardView = new TextView(context);
            String val = card.getFace();
            String message = val + " " + card.getSuit();
            cardView.setText(message);
            handView.addView(cardView);
        }
    }

}
