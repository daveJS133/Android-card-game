
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import org.mockito.*;
import static org.mockito.Mockito.*;
import blackjack.*;
import behaviours.*;
import templates.*;




public class BlackJGameTest{
 BlackJGame game;
 Dealable spyPlayer;


@Mock
BlackJDeck spyDeck = Mockito.mock(BlackJDeck.class);

 @Before 
 public void before(){

  // game.setup();
  // game.dealRound();
  // spyPlayer = Mockito.spy(Player);
 }

 // @Test

//  public void testCanCreateGame(){
//   BlackJGame game = new BlackJGame("jim", "bob");
//   assertEquals(game.getClass(), BlackJGame.class);
// }

// @Test
// public void testCanCreatePlayer(){
//   Player player1 = new Player("Dave");
//   assertEquals("Dave", player1.getPlayer().getName());
// }

// @Test
// public void testCanSetUp(){
//   BlackJGame game = new BlackJGame("jim", "bob");
//   game.setup();
//   assertEquals(2, game.player1.getPlayer().getHandSize());
// }

@Test
public void testPlay(){
game = new BlackJGame("Dave", "Dealer");
  game.setup();
  game.play();
}

}