package com.caffeinatedgeek.strixe.scoretracker;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.widget.Button.*;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

		//TODO: Move to global Exception Handler
		//Logger logger = new Logger();
		//logger.EmailLogCat(getApplicationContext());
		
		Button leftTwoPinButton = (Button) findViewById(R.id.leftTwoPinButton);
		Button leftThreePinButton = (Button) findViewById(R.id.leftThreePinButton);
		Button headPinButton = (Button) findViewById(R.id.headPinButton);
		Button rightThreePinButton = (Button) findViewById(R.id.rightThreePinButton);
		Button rightTwoPinButton = (Button) findViewById(R.id.rightTwoPinButton);

		leftTwoPinButton.setOnClickListener(pinClickHandler);
		leftThreePinButton.setOnClickListener(pinClickHandler);
		headPinButton.setOnClickListener(pinClickHandler);
		rightThreePinButton.setOnClickListener(pinClickHandler);
		rightTwoPinButton.setOnClickListener(pinClickHandler);
    }
	
	View.OnClickListener pinClickHandler = new View.OnClickListener() {
		public void onClick(View v) {
			ToggleButton button = (ToggleButton)v;
			CharSequence txt = button.getText();
			boolean isStanding = button.isChecked();
			String message = txt.toString()
				+ (isStanding ? " up" : " down");
			Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
		}
	};
}
