package example.codeclan.com.cardgame;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import example.codeclan.com.cardgame.blackjack.BlackJGame;
import example.codeclan.com.cardgame.blackjack.BlackJPlayer;
import example.codeclan.com.cardgame.templates.StandardCard;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class PlayBlackJActivity extends AppCompatActivity {

    public BlackJGame game;
    TextView nameText;
    BlackJPlayer player;
    StandardCard card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_play_black_j);


        Intent toBlackjack = getIntent();
        Bundle extras = toBlackjack.getExtras();
        String name = extras.getString("name");
        LinearLayout dealerHand = (LinearLayout) findViewById(R.id.dealer_hand);
        LinearLayout playerHand = (LinearLayout) findViewById(R.id.player_hand);
        game = new BlackJGame(name, this);
        Log.d(getClass().toString(), "game created");
        nameText = (TextView) findViewById(R.id.name_text);
        nameText.setText(name);
        game.setup();
        updateViews();
        game.play();
        updateViews();
        game.checkStick();
        if (game.player1.getStick() && game.player2.getStick()) {
            updateWinner();
        }
    }


//    may be able to add to new class all below if find syntax for activity
public void updateViews(){
    LinearLayout handView = (LinearLayout) findViewById(R.id.dealer_hand);

    game.populateHandViews(handView, game.player2);

    handView = (LinearLayout) findViewById(R.id.player_hand);

    game.populateHandViews(handView, game.player1);

}

    public void updateWinner(){
        TextView WinnerText = (TextView) findViewById(R.id.winner_text);

        WinnerText.setText(game.checkStick());

    }


}


