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
			Button button = (Button)v;
			//Toast.makeText(getApplicationContext(), button.getText(), Toast.LENGTH_SHORT).show();
		}
	};
}
