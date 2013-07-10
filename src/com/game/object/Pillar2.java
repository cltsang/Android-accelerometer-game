package com.game.object;

import org.jbox2d.collision.CircleDef;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.World;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Pillar2{
	private float x;
	private float y;
	private float _radius;
	public static Body body;
	private Vec2 force = new Vec2(0, 0);
	private Vec2 point;
	private Vec2 pointOld = new Vec2(0, 0);
	//private float xOld = 0;
	//private float yOld = 0;
	
	public Pillar2(float xInitial, float yInitial, float radius, World _world){
		x = xInitial;
		y = yInitial;
		_radius = radius;
		CircleDef shape = new CircleDef();  
		shape.density = 0.1f;  
		shape.friction = 0.0f;  	
		shape.radius = _radius;  
		  
		BodyDef bodyDef = new BodyDef();  
		bodyDef.position.set(x, y);   
		body = _world.createStaticBody(bodyDef);  
		body.createShape(shape);  
		body.setMassFromShapes();		
	}
			
	public void draw(Canvas canvas){
		Paint mPaint = new Paint();  
		mPaint.setAntiAlias(true);  
		mPaint.setColor(Color.GREEN);  
		canvas.drawCircle(x, y, _radius, mPaint);  			
	}	
}
