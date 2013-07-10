package com.game.object;

import org.jbox2d.collision.CircleDef;
import org.jbox2d.collision.PolygonDef;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.World;

import com.example.csci3310project10.R;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.Log;
import android.view.View;

public class Wall extends GameObject{
	public float left;
	public float top;
	public float right;
	public float bottom;
	
	private Body body;
	
	public void draw(Canvas canvas, Resources resources){		
		Paint mPaint = new Paint();
		
		// Flame
		Bitmap bitmap = BitmapFactory.decodeResource(resources, R.drawable.lava);
		
		RectF rect = new RectF(left, top, right, bottom);
		
		canvas.drawBitmap(bitmap, null, rect, mPaint);	
	}
	
	public Wall(float initLeft, float initTop, float initRight, float initBottom, World physicsWorld){
		left = initLeft;
		top = initTop;
		right = initRight;
		bottom = initBottom;

		PolygonDef shape = new PolygonDef();		
		shape.density = 0.1f;  
		shape.friction = 0.0f;  	
		shape.setAsBox((float)(initRight - initLeft)/2.0f, (float)(initBottom - initTop)/2.0f);
		
		  
		BodyDef bodyDef = new BodyDef();  
		bodyDef.position.set((float)(initRight + initLeft)/2.0f, (float)(initBottom + initTop)/2.0f);
		
		body = physicsWorld.createStaticBody(bodyDef);
		body.createShape(shape);  
		body.setMassFromShapes();	 
	}

	@Override
	public void horizontalTranslation(int initX, int endX, float speedIndex) {
		// TODO Auto-generated method stub
		// Dummy
	}
}
