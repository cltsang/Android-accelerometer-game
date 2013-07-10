package com.example.csci3310project10;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;

public class SettingActivity extends MyActivity {
	SeekBar volumeLevelSeekBar;
	CheckBox fullScreenCheckBox;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
		
		volumeLevelSeekBar = (SeekBar)findViewById(R.id.settings_volumeLevel);
		fullScreenCheckBox = (CheckBox)findViewById(R.id.settings_fullscreen_checkbox);
		
		volumeLevelSeekBar.setMax(100);
		volumeLevelSeekBar.setProgress(settings.getBgmVolume());
		volumeLevelSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
				settings.setBgmVolume(progress);
				handleVolume();
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {				
			}
		});
		
		fullScreenCheckBox.setChecked(settings.isFullScreen());
		fullScreenCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				settings.setFullScreen(isChecked);
				handleFullScreen();
			}
		});
	}
}
