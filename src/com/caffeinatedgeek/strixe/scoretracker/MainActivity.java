package com.caffeinatedgeek.strixe.scoretracker;

import android.content.*;
import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.widget.Button.*;
import java.util.*;

public class MainActivity extends Activity
{
	private static Context _context;
	ScoreSheet scoreSheet;
	List<ToggleButton> pinButtons;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

		_context = getApplicationContext();
		
		//TODO: Move to global Exception Handler
		//Logger logger = new Logger();
		//logger.EmailLogCat(getApplicationContext());

		Button saveButton = (Button) findViewById(R.id.saveShotButton);
		saveButton.setOnClickListener(saveShotClickHandler);
		
		ToggleButton leftTwoPinButton = (ToggleButton) findViewById(R.id.leftTwoPinButton);
		ToggleButton leftThreePinButton = (ToggleButton) findViewById(R.id.leftThreePinButton);
		ToggleButton headPinButton = (ToggleButton) findViewById(R.id.headPinButton);
		ToggleButton rightThreePinButton = (ToggleButton) findViewById(R.id.rightThreePinButton);
		ToggleButton rightTwoPinButton = (ToggleButton) findViewById(R.id.rightTwoPinButton);

		pinButtons = new ArrayList<ToggleButton>();
		pinButtons.add(leftTwoPinButton);
		pinButtons.add(leftThreePinButton);
		pinButtons.add(headPinButton);
		pinButtons.add(rightThreePinButton);
		pinButtons.add(rightTwoPinButton);
		
		scoreSheet = new ScoreSheet();
		RerackPins();
    }
	
	public void RerackPins() {
		for(ToggleButton b: pinButtons) {
			b.setChecked(true);
		}
	}
	
	public Integer GetRackState() {
		Integer pinMask = 0;
		
		Integer i = 0;
		for(ToggleButton b: pinButtons) {
			if (!b.isChecked())
				pinMask += (int)Math.pow(2, i);
			i++;
		}
		
		return pinMask;
	}

	public Integer ConvertMaskToScore(Integer pinMask) {
		Integer score = 0;

		Integer i = 0;
		for(ToggleButton b: pinButtons) {
			Integer pos = (int)Math.pow(2, i);
			boolean isDown = (pinMask & pos) != 0;
			if (isDown)
				score += Integer.parseInt(b.getText().toString());
				
			//Toast(String.valueOf(isDown));
			i++;
		}
		
		return score;
	}

	View.OnClickListener saveShotClickHandler = new View.OnClickListener() {
		public void onClick(View v) {
			Integer pinMask = GetRackState();
			Integer score = ConvertMaskToScore(pinMask);
			
			TextView showShotValue = (TextView) findViewById(R.id.showShotValue);
			showShotValue.setText(pinMask.toString());
			
			scoreSheet.AddShot(pinMask, score);
		}
	};
	
	public static void Toast(String message) {
		Toast.makeText(_context, message, Toast.LENGTH_SHORT).show();
	}
}
