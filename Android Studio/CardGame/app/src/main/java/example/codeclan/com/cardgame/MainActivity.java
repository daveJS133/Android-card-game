package example.codeclan.com.cardgame;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import example.codeclan.com.cardgame.blackjack.BlackJGame;

import static android.R.attr.button;
import static android.R.attr.name;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class MainActivity extends AppCompatActivity {

    Button blackjack_button;
    Intent toBlackjack;
    EditText nameEditText;
    Button submitName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

    }



    public void onBlackjackButtonPressed(View blackjack_button) {
        toBlackjack = new Intent(MainActivity.this, PlayBlackJActivity.class);
            toBlackjack.putExtra("name", nameEditText.getText().toString());
            startActivity(toBlackjack);
    }

    public void onSubmitNameButtonPressed(View submitName) {

        nameEditText = (EditText)findViewById(R.id.name_text);
        if (nameEditText.getText().toString().trim().isEmpty()) {
    Toast toast = Toast.makeText(this, "Please enter a valid name", Toast.LENGTH_SHORT);
            TextView popToast = (TextView) toast.getView().findViewById(R.id.fullscreen_content);
            if(popToast != null) popToast.setGravity(Gravity.CENTER);
            toast.show();

        } else {
            String stringToSave = nameEditText.getText().toString();
            Context context = nameEditText.getContext();
            SavedTextPreferences.setStoredText(context,stringToSave);

            findViewById(R.id.blackjack_button).setVisibility(View.VISIBLE);
        }
    }



}
