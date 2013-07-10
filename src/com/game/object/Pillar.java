package com.game.object;

import org.jbox2d.collision.CircleDef;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.World;

import com.example.csci3310project10.R;

import android.R.anim;
import android.R.drawable;
import android.R.integer;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Movie;
import android.graphics.Paint;
import android.util.Log;

public class Pillar {
	
	public float x;
	public float y;
	private float radius;
	private boolean sensorInitial = true;
	private float xSensorInitial = 0;
	private float ySensorInitial = 0;
	private Body body;
	private Vec2 force = new Vec2(0, 0);
	private Vec2 point;
	private Vec2 pointOld = new Vec2(0, 0);
	private	Movie mMovie;
	private long start;
	//private float xOld = 0;
	//private float yOld = 0;
	
	public Pillar(float _x, float _y, float _radius, World _world){
		x = _x;
		y = _y;
		radius = _radius;
		CircleDef shape = new CircleDef();  
		shape.density = 0.1f;  
		shape.friction = 0.0f;  	
		shape.radius = radius;  
		BodyDef bodyDef = new BodyDef();  
		bodyDef.position.set(x, y);   
		body = _world.createDynamicBody(bodyDef);  
		body.createShape(shape);  
		body.setMassFromShapes();		
	}
			
	public void draw(Canvas canvas, Resources resources){
		Paint mPaint = new Paint();
		int duration;
		mPaint.setAntiAlias(true);  
		mPaint.setColor(Color.GREEN);
		
		//canvas.drawCircle(x, y, radius, mPaint);
		
		// GIF animation part
		try{
			if(mMovie == null){
				mMovie = Movie.decodeStream(resources.openRawResource(R.drawable.rolesia));
				start = android.os.SystemClock.uptimeMillis();
				Log.d("Game", "Movie success");
			}
			
			duration = mMovie.duration();
			
			if(duration == 0){
				duration = 1000;
			}
			
			mMovie.setTime((int)(android.os.SystemClock.uptimeMillis() - start)%duration);
			mMovie.draw(canvas, x - mMovie.width()/2, y - mMovie.height()/2);
		}catch (Exception e) {
			Log.d("Game","Movie exception: "+e.toString());
		}
	}
	
	public void update(float xNew, float yNew){
		if (sensorInitial) {
			xSensorInitial = xNew;
			ySensorInitial = yNew;
			sensorInitial = false;
		}
		
		float xV = (xNew - xSensorInitial) * 40;
		float yV = (yNew - ySensorInitial) * 40;
		Vec2 v = new Vec2(xV, yV);
		body.setLinearVelocity(v);
		x = body.getPosition().x;
		y = body.getPosition().y;
	}
}

