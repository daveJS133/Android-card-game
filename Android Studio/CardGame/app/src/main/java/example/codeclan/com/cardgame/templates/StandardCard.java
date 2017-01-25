package example.codeclan.com.cardgame.templates;

/**
 * Created by user on 23/01/2017.
 */

public class StandardCard {
    private int value;
    StandardSuits suit;
    String face = "";

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

    public void setValue(int val){
        this.value = val;
    }

    public void setFace(String newFace){
        face = newFace;
    }

    public String getFace(){
        return face;
    }



}
