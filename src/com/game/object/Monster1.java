package com.game.object;

import org.jbox2d.collision.CircleDef;
import org.jbox2d.collision.PolygonDef;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.World;

import com.example.csci3310project10.R;

import android.R.integer;
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

public class Monster1 extends GameObject{
	public float left;
	public float top;
	public float right;
	public float bottom;
	private Body body;
	private boolean rightWard;
	
	public void draw(Canvas canvas, Resources resources){		
		Paint mPaint = new Paint();
		Bitmap bitmap = BitmapFactory.decodeResource(resources, R.drawable.kingusuraimu);
		
		RectF rect = new RectF(left, top, right, bottom);
		
		mPaint.setColor(Color.GREEN);
		//canvas.drawCircle(body.getPosition().x, body.getPosition().y, 15*0.9f, mPaint);
		
		canvas.drawBitmap(bitmap, null, rect, mPaint);

	}
	
	public Monster1(float initLeft, float initTop, float initRight, float initBottom, World physicsWorld){
		left = initLeft;
		top = initTop;
		right = initRight;
		bottom = initBottom;
		rightWard = Math.random() > 0.5? true:false;
		
		CircleDef shape = new CircleDef();		
		shape.density = 0.3f;  
		shape.friction = 0.0f;  	
		shape.radius = (float)(initRight - initLeft)/2 * 0.9f;
		  
		BodyDef bodyDef = new BodyDef();  
		bodyDef.position.set((float)(initRight + initLeft)/2.0f, (float)(initBottom + initTop)/2.0f);
		
		body = physicsWorld.createDynamicBody(bodyDef);
		body.createShape(shape);  
		body.setMassFromShapes();	 
	}
	
	public void horizontalTranslation(int initX, int endX, float speedIndex){
		if(rightWard){
			//left+=speedIndex;
			//right+=speedIndex;
			body.setLinearVelocity(new Vec2(speedIndex, 0));
			if(right>endX){
				rightWard = false;
			}
		}
		else{
			//left-=speedIndex;
			//right-=speedIndex;
			body.setLinearVelocity(new Vec2(-speedIndex, 0));
			if(left<initX){
				rightWard = true;
			}
			//Log.d("Game", "Left="+left+" Body="+body.getPosition().x+" result="+speedIndex*velocityRate);
			//Log.d("Game", "Top="+top+" Body="+body.getPosition().y);
		}
		
		left = body.getPosition().x-15;
		right = body.getPosition().x+15;
	}
}
