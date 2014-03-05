package com.caffeinatedgeek.strixe.scoretracker;

import android.app.*;
import java.io.*;
import java.util.*;
import java.text.*;
import android.os.*;
import android.widget.*;
import android.content.*;

public class Logger
{
    public void EmailLogCat(Context context){
        String result = getLog(context);

		Intent i = new Intent(Intent.ACTION_SEND);
		i.setType("message/rfc822");
		i.putExtra(Intent.EXTRA_EMAIL, new String[] {"gibble+strixe@gmail.com"}); //TODO: Change email address
		i.putExtra(Intent.EXTRA_SUBJECT, "BUG: StriXe Score Tracker");
		i.putExtra(Intent.EXTRA_TEXT, result);
		
		try {
			Intent intent = Intent.createChooser(i, "Send mail...");
			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(intent);
		} catch (android.content.ActivityNotFoundException ex) {
		    Toast.makeText(context, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
		}

        //clear the log
        try {
            Runtime.getRuntime().exec("logcat -c");
        } catch (IOException e) {
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
    
    private String getLog(Context context) {
        StringBuilder result = new StringBuilder();
		int pid = android.os.Process.myPid();

		try {
			String command = String.format("logcat -d -v threadtime *:*");        
			java.lang.Process process = Runtime.getRuntime().exec(command);
		
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String currentLine = null;
		
			while ((currentLine = reader.readLine()) != null) {
				if (currentLine != null && currentLine.contains(String.valueOf(pid))) {
					result.append(currentLine);
					result.append("\n");
				}
			}	
		} catch (IOException e) {
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }
		
		return result.toString();
    }
}
