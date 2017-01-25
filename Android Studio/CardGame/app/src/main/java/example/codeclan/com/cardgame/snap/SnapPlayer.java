package example.codeclan.com.cardgame.snap;

import java.util.ArrayList;

import example.codeclan.com.cardgame.templates.NoveltyCard;


/**
 * Created by user on 25/01/2017.
 */

public class SnapPlayer {


        private ArrayList<NoveltyCard> hand;
        private String name;


        public SnapPlayer(String name){
            this.hand = new ArrayList<NoveltyCard>();
            this.name = name;

        }

        public void setPlayerName(String newName){
            name = newName;

        }

        public SnapPlayer getPlayer(){
            return this;
        }

        public String getName(){
            return name;
        }

        public ArrayList<NoveltyCard> getHand(){
            return hand;
        }

        public int getHandSize(){
            return hand.size();
        }



        public void deal(SnapDeck deck){
            NoveltyCard card = deck.pickUpCard(this);
            this.hand.add(card);
            System.out.println(this.name + " picks up " + card.getSuit());
        }
    }


