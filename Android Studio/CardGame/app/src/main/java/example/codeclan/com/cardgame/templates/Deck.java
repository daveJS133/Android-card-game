package example.codeclan.com.cardgame.templates;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by user on 23/01/2017.
 */

public abstract class Deck{
    public int numOfSuits;
    public int numInSuit;
    public ArrayList<String> suits;
    public boolean faceCards;
    public ArrayList<? extends Deck> deck;



}
