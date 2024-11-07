package ro.pub.cs.systems.eim.Colocviul_1;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Colocviul1_1MainActivity extends AppCompatActivity {

    private EditText contentEditText;
    private Button genericButton;
    private int buttonPressCount = 0;

    private static final String BUTTON_PRESS_COUNT_KEY = "button_press_count";

    final public static int buttonIds[] = {
            R.id.north_button,
            R.id.east_button,
            R.id.west_button,
            R.id.south_button
    };

    private GenericButtonClickListener genericButtonClickListener = new GenericButtonClickListener();
    private class GenericButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            contentEditText.setText(contentEditText.getText().toString() + ", " +  ((Button)view).getText().toString());
            buttonPressCount++;
            Log.d(TAG, "Button pressed " + buttonPressCount + " times");
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colocviul1_1main);
        contentEditText = (EditText)findViewById(R.id.content_edit_text);
        if (savedInstanceState != null) {
            buttonPressCount = savedInstanceState.getInt(BUTTON_PRESS_COUNT_KEY, 0);
        }
        for (int index = 0; index < buttonIds.length; index++) {
            genericButton = (Button)findViewById(buttonIds[index]);
            genericButton.setOnClickListener(genericButtonClickListener);
        }

    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(BUTTON_PRESS_COUNT_KEY, buttonPressCount);
    }

    // Restore the button press count from the bundle
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        buttonPressCount = savedInstanceState.getInt(BUTTON_PRESS_COUNT_KEY, 0);
    }

}