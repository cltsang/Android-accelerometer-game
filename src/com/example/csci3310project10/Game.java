package com.example.csci3310project10;

import org.jbox2d.collision.AABB;
import org.jbox2d.collision.CircleDef;
import org.jbox2d.collision.ContactID;
import org.jbox2d.collision.PolygonDef;
import org.jbox2d.collision.Shape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.ContactListener;
import org.jbox2d.dynamics.World;
import org.jbox2d.dynamics.contacts.ContactPoint;

import com.game.map.*;
import com.game.object.*;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Game extends Activity {
	
	private World world;        //--- var of world
	private AABB worldAABB ;
	private Vec2 gravity;
	private boolean doSleep;	
	float timeStep;
	int iterations;
	//private Body body;         //-- var of obj
	//private final static int RATE = 10;
	//private float x, y;
	private Pillar pillar;
	private Pillar2 pillar2;
	private GameMap map;
	private int _stage;
	private Context _context;
		
	public ContactListener collisionDetection = new ContactListener() {
		@Override
		public void add(ContactPoint arg0) {
			// TODO Auto-generated method stub
			Log.d("Game", "Contact detected");
			
			Body body1 = arg0.shape1.getBody();
		    Body body2 = arg0.shape2.getBody();
		    
		    //System.out.println("test");
		    
		    boolean success = false;
		    if((body1 == Pillar2.body) || body2 == Pillar2.body){
		    	 //System.out.println("test Physics Rectangle caused event");
		    	 success = true;
		    }
		    if (success){
		    	world = new World(worldAABB, gravity, doSleep);
				pillar = new Pillar(400, 250, 15, world);
				pillar2 = new Pillar2(400, 1000, 50, world);
				_stage = _stage +1;
				if (_stage == 5)
				new AlertDialog.Builder(_context)
		        .setTitle("Title").setMessage("You Win!!")
		        .setPositiveButton("OK",
		         new DialogInterface.OnClickListener() {
		         public void onClick(DialogInterface dialog, int which) {
		          }
		          }).show();
				if (_stage == 1) map = new Map1(world);
				if (_stage == 2) map = new Map2(world);
				if (_stage == 3) map = new Map3(world);
				if (_stage == 4) map = new Map4(world);
				world.setListener(this);
		    }
		    else {
		    	world = new World(worldAABB, gravity, doSleep);
				pillar = new Pillar(400, 250, 15, world);
				pillar2 = new Pillar2(400, 1000, 50, world);
				if (_stage == 1) map = new Map1(world);
				if (_stage == 2) map = new Map2(world);
				if (_stage == 3) map = new Map3(world);
				if (_stage == 4) map = new Map4(world);
				world.setListener(this);
		    }
		    
		    

		}

		@Override
		public void persist(ContactPoint arg0) {
			// TODO Auto-generated method stub
			Log.d("Game", "Contact persisting");
		}

		@Override
		public void remove(ContactPoint arg0) {
			// TODO Auto-generated method stub
			Log.d("Game", "Contact removed");
		}
	};	
	
	void restart() {
		
	}

	public Game(int stage, Context context) {
		_stage = stage;
		_context = context;
		worldAABB = new AABB(); 
		worldAABB.lowerBound.set(-1000.0f,-1000.0f);  
		worldAABB.upperBound.set(1200.0f, 1200.0f);
		gravity = new Vec2(0.0f,0.0f);
		doSleep = true; 
		timeStep = 1.0f/60.0f;
		iterations = 10;
		world = new World(worldAABB, gravity, doSleep);
		pillar = new Pillar(400, 250, 15, world);
		
		pillar2 = new Pillar2(400, 1000, 50, world);
		if (stage == 1) map = new Map1(world);
		if (stage == 2) map = new Map2(world);
		if (stage == 3) map = new Map3(world);
		if (stage == 4) map = new Map4(world);
		world.setListener(collisionDetection);
	}
			
	public void positionUpdate(float sensorX, float sensorY){
		pillar.update(sensorX, sensorY);
	}
	
	public void update(){
		world.step(timeStep, iterations);
		
		//pillar.update();
		//pillar2.x = pillar2.body.getPosition().x;
		//pillar2.y = pillar2.body.getPosition().y;
	}

	public void draw(Canvas canvas, Resources resources) {
		canvas.translate(200-pillar.x, 200-pillar.y);
		map.draw(canvas, resources);
		pillar.draw(canvas, resources);
		pillar2.draw(canvas);
	}
}
