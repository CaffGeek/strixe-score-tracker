package com.caffeinatedgeek.strixe.scoretracker;

import android.content.*;
import android.widget.*;

public class ScoreSheet
{
	private Context _context;
	private Integer[] shots;
	
	public ScoreSheet(Context context) {
		_context = context;
		shots = new Integer[30];
	}
	
	public void AddShot(Integer pinMask) {
		shots[0] = pinMask;
		Toast.makeText(_context, "PinMask:" + pinMask.toString(), Toast.LENGTH_SHORT).show();
	}
	
	public Integer ConvertMaskToScore(Integer pinMask) {
		
		return 15;
	}
}
