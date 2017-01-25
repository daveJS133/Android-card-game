package example.codeclan.com.cardgame;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
/**
 * Created by user on 25/01/2017.
 */

public class SavedTextPreferences {

    private static final String PREF_SAVEDNAME = "savedName";


        public static void setStoredText(Context context, String text) {
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putString(PREF_SAVEDNAME, text);
            editor.apply();
        }



    public static String getStoredText(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        return sharedPreferences.getString(PREF_SAVEDNAME, null);
    }
    }

