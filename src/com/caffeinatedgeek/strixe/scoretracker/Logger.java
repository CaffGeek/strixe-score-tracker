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
	public File ExtractLogToFileAndWeb(Context context){
        //set a file
        Date datum = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.ITALY);
        String fullName = df.format(datum)+"appLog.log";
        File file = new File (Environment.getExternalStorageDirectory(), fullName);

        //clears a file
        if(file.exists()){
            file.delete();
        }

        //write log to file
        int pid = android.os.Process.myPid();
        try {
            String command = String.format("logcat -d -v threadtime *:*");        
            java.lang.Process process = Runtime.getRuntime().exec(command);

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder result = new StringBuilder();
            String currentLine = null;

            while ((currentLine = reader.readLine()) != null) {
				if (currentLine != null && currentLine.contains(String.valueOf(pid))) {
					result.append(currentLine);
					result.append("\n");
				}
            }

            FileWriter out = new FileWriter(file);
            out.write(result.toString());
            out.close();

            //Runtime.getRuntime().exec("logcat -d -v time -f "+file.getAbsolutePath());
        } catch (IOException e) {
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }


        //clear the log
        try {
            Runtime.getRuntime().exec("logcat -c");
        } catch (IOException e) {
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }

        return file;
    }
}
