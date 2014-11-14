package com.caffeinatedgeek.strixe.scoretracker;

import java.util.*;
import android.content.*;
import android.widget.*;

public class ScoreSheet
{
	//TODO:Change to CQRS Event pattern
	private ArrayList<Integer> shots;
	
	public ScoreSheet() {
		shots = new ArrayList<Integer>();
	}
	
	public void AddShot(Integer pinMask, Integer score) {
		shots.add(pinMask);
		MainActivity.Toast("Score:" + score.toString());
	}
}
