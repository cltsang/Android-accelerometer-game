package com.example.csci3310project10;


import android.app.Activity;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public abstract class MyActivity extends Activity{
	
	Settings settings = Settings.getInstance();
	BGMManager bgmManager = BGMManager.getInstance();
    
    @Override
    protected void onCreate(Bundle savedInstanceState){
    	super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
    }
    
    protected void updateAfterLoadingStates(){
		handleFullScreen();
    }
	
	protected void handleFullScreen(){
		if(settings.isFullScreen()){
			/*
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	                WindowManager.LayoutParams.FLAG_FULLSCREEN);
	        */
			WindowManager.LayoutParams attrs = getWindow().getAttributes();
			attrs.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
			getWindow().setAttributes(attrs);
		}
		else{
			WindowManager.LayoutParams attrs = getWindow().getAttributes();
			attrs.flags &= (~WindowManager.LayoutParams.FLAG_FULLSCREEN);
			getWindow().setAttributes(attrs); 
		}
	}
	
	protected void handleVolume(){
		bgmManager.setBgmVolume(settings.getBgmVolume());
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState){
		super.onSaveInstanceState(savedInstanceState);
	}
	
	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
	}
	
	@Override
	protected void onResume(){
		super.onResume();

		bgmManager.play();
	}
	
	@Override
	protected void onPause(){
		super.onPause();
		
		//bgmManager.stop();
	}
	
}
