package com.game.map;

import org.jbox2d.dynamics.World;

import com.game.object.GameObject;
import com.game.object.Wall;

import android.R.integer;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.Window;

public class Map4 extends GameMap{
	private GameObject gameObjectArray[];
	private int numOfObject;
 
	public Map4(World world){
		numOfObject = 17;
		gameObjectArray = new GameObject[numOfObject];
        //boundary   
		gameObjectArray[0] = new Wall(140-100, 200, 150-100, 1250, world);
		gameObjectArray[1] = new Wall(840-100, 200, 850-100, 1250, world);
		gameObjectArray[2] = new Wall(140-100, 200, 850-100, 210, world);
		gameObjectArray[3] = new Wall(140-100, 1240, 850-100, 1250, world);
		//inner
		gameObjectArray[4] = new Wall(300, 200, 310, 400, world);
		gameObjectArray[5] = new Wall(680, 200, 690, 550, world);
		gameObjectArray[6] = new Wall(200, 400, 310, 410, world);
		gameObjectArray[7] = new Wall(370, 450, 600, 460, world);
		gameObjectArray[8] = new Wall(200, 500, 210, 700, world);
		gameObjectArray[9] = new Wall(470, 600, 670, 610, world);
	    gameObjectArray[10] = new Wall(200, 700, 500, 710, world);
		gameObjectArray[11] = new Wall(500, 700, 510, 900, world);
		gameObjectArray[12] = new Wall(600, 600, 610, 1100, world);
		gameObjectArray[13] = new Wall(470, 1100, 680, 1110, world);
		gameObjectArray[14] = new Wall(320, 900, 510, 910, world);
		gameObjectArray[15] = new Wall(320, 750, 330, 1250, world);
		gameObjectArray[16] = new Wall(100, 800, 250, 810, world);
	}
	
	public void draw(Canvas canvas, Resources resources){
		Paint paint = new Paint();
		
		// BackGround
		canvas.drawColor(Color.BLACK);
		
		try{
			for(int i=0; i<gameObjectArray.length; i++){
				gameObjectArray[i].draw(canvas, resources);
			}
		}catch (Exception e) {
			Log.d("Draw", "Draw world object exception:" + e.toString());
		}
	}
}
