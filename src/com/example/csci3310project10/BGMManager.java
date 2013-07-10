package com.example.csci3310project10;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;

public final class BGMManager {
	private static BGMManager instance = new BGMManager();
	private AudioManager audioManager;
    private int bgmFileID;
    private MediaPlayer player;
    
    private BGMManager(){}
    
    public static BGMManager getInstance(){
    	return instance;
    }
    
    public void setBGM(Context context, int bgmFileID){
    	if(this.bgmFileID == bgmFileID && playing()){
android.util.Log.i("info", "BGMManager.setBGM() : return false");
    		return;
    	}
    	dispose();
    	this.bgmFileID = bgmFileID;
		player = MediaPlayer.create(context, bgmFileID);
		audioManager = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
android.util.Log.i("info", "BGMManager.setBGM() : bgm loaded");
    }
    
    public void setBgmVolume(int percentage){
    	int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
    	audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, (int)(maxVolume*percentage*0.01), AudioManager.FLAG_VIBRATE);
    }
    
    public boolean dispose(){
    	if(player == null)
    		return false;
    	stop();
    	//player.release();
    	player = null;
    	return true;
    }
    
    public boolean playerExists(){
    	return player != null;
    }
    
    public boolean playing(){
    	if(player == null)
    		return false;
    	return player.isLooping() || player.isPlaying();
    }
    
    public boolean play(){
    	if(player == null)
    		return false;
    	if(playing())
    		return false;
    	player.start();
    	player.setLooping(true);
    	return true;
    }
    
    public boolean stop(){
    	if(player == null)
    		return false;
    	if(!playing())
    		return false;
    	
    	player.stop();
    	return true;
    }
}
