package com.example.csci3310project10;

import java.util.ArrayList;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HighScoreActivity extends MyActivity {
	ArrayAdapter<String> scoreAdapter;
	ArrayList<String> highscores = new ArrayList<String>();
	
	@Override
	public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
		setContentView(R.layout.highscore);
		
		for(int i=0; i<settings.numLevels; i++){
			highscores.add("Stage " + i + "  :  " + settings.getHighscore(i));
		}
		scoreAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,highscores);
		ListView listView = (ListView)findViewById(R.id.highscore_ListView);
		listView.setAdapter(scoreAdapter);
	}
}
