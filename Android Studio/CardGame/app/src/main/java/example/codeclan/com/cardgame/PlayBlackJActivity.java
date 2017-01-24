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
import android.widget.TextView;

import example.codeclan.com.cardgame.blackjack.BlackJGame;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class PlayBlackJActivity extends AppCompatActivity {

    BlackJGame game;
    TextView nameText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_play_black_j);


        Intent toBlackjack = getIntent();
        Bundle extras = toBlackjack.getExtras();
        String name = extras.getString("name");
        game = new BlackJGame(name);
        Log.d(getClass().toString(), "game created");
        nameText = (TextView) findViewById(R.id.name_text);
        nameText.setText(name);
    }

}