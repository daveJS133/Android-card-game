package example.codeclan.com.cardgame;

import org.junit.*;
import static org.junit.Assert.*;

import example.codeclan.com.cardgame.behaviours.Dealable;
import example.codeclan.com.cardgame.blackjack.BlackJDeck;
import example.codeclan.com.cardgame.blackjack.BlackJGame;
import example.codeclan.com.cardgame.blackjack.BlackJPlayer;

/**
 * Created by user on 25/01/2017.
 */

public class TestBlackJGame {

    BlackJGame game;
    Dealable spyPlayer;


//    @Mock
//    BlackJDeck spyDeck = Mockito.mock(BlackJDeck.class);

    @Before
    public void before(){

        game = new BlackJGame("Dave");
        game.setup();
        // game.dealRound();
        // spyPlayer = Mockito.spy(BlackJPlayer);
    }

    // @Test

//  public void testCanCreateGame(){
//   BlackJGame game = new BlackJGame("jim");
//   assertEquals(game.getClass(), BlackJGame.class);
// }

 @Test
 public void testCanCreatePlayer(){
   BlackJPlayer player1 = new BlackJPlayer("Dave");
   assertEquals("Dave", player1.getPlayer().getName());
 }

 @Test
 public void testCanSetUp(){

   assertEquals(2, game.player1.getPlayer().getHandSize());
 }

//    @Test
//    public void testPlay(){
//
//        game.play();
//      assertEquals();
//    }

}