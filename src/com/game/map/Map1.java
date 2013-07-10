package com.game.map;

import org.jbox2d.dynamics.World;

import com.game.object.GameObject;
import com.game.object.Wall;

import android.R.integer;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.Window;

public class Map1 extends GameMap{
	private GameObject gameObjectArray[];
	private int numOfObject;

	public Map1(World world){
		numOfObject = 1;
		gameObjectArray = new GameObject[numOfObject];
		
		gameObjectArray[0] = new Wall(10, 400, 400, 430, world);
	}
	
	public void draw(Canvas canvas, Resources resources){
		Paint paint = new Paint();
		
		// BackGround
		canvas.drawColor(Color.BLACK);
		
		try{
			for(int i=0; i<1; i++){
				gameObjectArray[i].draw(canvas, resources);
			}
		}catch (Exception e) {
			Log.d("Draw", "Draw world object exception:" + e.toString());
		}
	}
}
