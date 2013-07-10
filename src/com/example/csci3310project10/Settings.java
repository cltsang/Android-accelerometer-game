package com.example.csci3310project10;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

public final class Settings {
	private static Settings instance = new Settings();
	SharedPreferences state = null;
	public final int numLevels = 3;
	private boolean fullScreen = true;
	private boolean mute = false;
	private int bgmVolume = 100;
	
	private int[] highscore = new int[numLevels];
    
    private Settings(){ }
        
    public static Settings getInstance(){
    	return instance;
    }
    
    public void loadStates(SharedPreferences state){
    	this.state = state;
    	fullScreen = state.getBoolean("fullScreen", true);
    	mute = state.getBoolean("mute", false);
    	for(int stage=0; stage<numLevels; stage++)
    		highscore[stage] = state.getInt("highscore"+stage, 0);
android.util.Log.i("info", "Settings.loadStates() : ending");
    }
    
    public boolean setNewHighscore(int stage, int score){
    	if(stage < 0 || stage >= numLevels)
    		return false;
    	if(highscore[stage] > score)
    		return false;
    	
    	highscore[stage] = score;
    	
		SharedPreferences.Editor editor = state.edit();
		editor.putInt("hignscore" + Integer.toString(stage), score);
		editor.commit();
    	return true;
    }
    
    public int getHighscore(int stage){
    	if(stage < 0 || stage >= numLevels)
    		return Integer.MIN_VALUE;
    	return highscore[stage];
    }

	public boolean isFullScreen() {
		return fullScreen;
	}
	public void setFullScreen(boolean fullScreen) {
		this.fullScreen = fullScreen;
		SharedPreferences.Editor editor = state.edit();
		editor.putBoolean("fullScreen", fullScreen);
		editor.commit();
	}
	
	public void setBgmVolume(int percentage){
		this.bgmVolume = percentage;
		SharedPreferences.Editor editor = state.edit();
		editor.putInt("bgmVolume", bgmVolume);
		editor.commit();
	}
	
	public int getBgmVolume(){
		return bgmVolume;
	}

	public boolean isMute() {
		return mute;
	}
	public void setMute(boolean mute) {
		this.mute = mute;
		SharedPreferences.Editor editor = state.edit();
		editor.putBoolean("mute", mute);
		editor.commit();
	}
}
