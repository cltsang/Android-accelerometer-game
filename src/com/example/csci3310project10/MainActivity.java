package com.example.csci3310project10;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends MyActivity {

	ImageButton playBtn, highScoreBtn, settingsBtn;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        android.widget.Toast.makeText(getApplicationContext(), "Welcome!!", android.widget.Toast.LENGTH_SHORT).show();

        // restore app states
        SharedPreferences preferences = getSharedPreferences("MyData", 0);
        settings.loadStates(preferences);
        updateAfterLoadingStates();

        // set the button actions
		
		playBtn = (ImageButton) findViewById(R.id.play_btn);
		highScoreBtn = (ImageButton) findViewById(R.id.highscore_btn);
		settingsBtn = (ImageButton) findViewById(R.id.settings_btn);

		playBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), LevelSelector.class);
				startActivity(i);
			}
		});
		
		highScoreBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), HighScoreActivity.class);
				startActivity(i);
			}
		});
		
		settingsBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), SettingActivity.class);
				startActivity(i);
			}
		});
    }
    
    @Override
    public void onResume(){
    	bgmManager.setBGM(this, R.raw.main);
    	android.util.Log.i("info", "MainActivity.onResume() : trying to load BGM");
    	android.util.Log.i("info", "MainActivity.onResume() : BGMManager = " + bgmManager);
		super.onResume();
    }

	@Override
	protected void onDestroy(){
		super.onDestroy();
		
		bgmManager.dispose();
	}
}