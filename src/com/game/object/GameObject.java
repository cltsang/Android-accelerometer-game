package com.game.object;

import org.jbox2d.dynamics.World;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.view.View;

public abstract class GameObject{
	public abstract void draw(Canvas canvas, Resources resources);
	public abstract void horizontalTranslation(int initX, int endX, float speedIndex);
}
