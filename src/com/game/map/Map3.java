package com.game.map;

import org.jbox2d.dynamics.World;

import com.game.object.*;

import android.R.integer;
import android.R.layout;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.Window;

public class Map3 extends GameMap{
	private GameObject gameObjectArray[];
	private int numOfObject;
 
	public Map3(World world){
		numOfObject = 11;
		gameObjectArray = new GameObject[numOfObject];
        // boundary wall  
		gameObjectArray[0] = new Wall(140-100, 200, 150-100, 1250, world);
		gameObjectArray[1] = new Wall(840-100, 200, 850-100, 1250, world);
		gameObjectArray[2] = new Wall(140-100, 200, 850-100, 210, world);
		gameObjectArray[3] = new Wall(140-100, 1240, 850-100, 1250, world);
		
		// inner wall
		gameObjectArray[4] = new Wall(330, 200, 350, 400, world);
		gameObjectArray[5] = new Wall(490, 200, 510, 300, world);
		gameObjectArray[6] = new Wall(330, 400, 700, 420, world);
		gameObjectArray[7] = new Wall(600, 260, 620, 780, world);
		
		//Monster
		gameObjectArray[8] = new Monster1(695, 600, 710, 630, world);
		gameObjectArray[9] = new Monster1(675, 700, 705, 730, world);
	    gameObjectArray[10] = new Monster1(675, 800, 705, 830, world);
	    
	    /*
		gameObjectArray[11] = new Wall(500, 700, 510, 900, world);
		gameObjectArray[12] = new Wall(700, 600, 710, 1100, world);
		gameObjectArray[13] = new Wall(500, 1100, 710, 1110, world);
		gameObjectArray[14] = new Wall(320, 900, 510, 910, world);
		gameObjectArray[15] = new Wall(320, 900, 330, 1250, world);
		*/
	}
	
	public void draw(Canvas canvas, Resources resources){
		Paint paint = new Paint();
		
		// BackGround
		canvas.drawColor(Color.BLACK);
		
		try{
			for(int i=0; i<gameObjectArray.length; i++){
				gameObjectArray[i].draw(canvas, resources);
				if(i == 8|| i == 9){
					gameObjectArray[i].horizontalTranslation(630, 730, 40f);
				}
			}
		}catch (Exception e) {
			Log.d("Draw", "Draw world object exception:" + e.toString());
		}
	}
}
