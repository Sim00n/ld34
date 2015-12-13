package com.puzdrowski.decision.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public abstract class Entity {

	protected int x, y;
	protected Texture texture;
	protected float delta;
	protected float theta;
	public static enum TYPE { OUTER, MIDDLE, INNER };
	protected TYPE type;
	protected int order;
	
	public Entity(Texture texture, float theta, TYPE type, int order) {
		this.texture = texture;
		this.x = 0;
		this.y = 0;
		this.theta = theta;
		this.type = type;
		this.order = order;
	}
	
	public void render(Batch batch) {
		
	}
	
	public void update(float tick) {
		
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public float getDelta() {
		return delta;
	}

	public void setDelta(float delta) {
		this.delta = delta;
	}

	public float getTheta() {
		return theta;
	}

	public void setTheta(float theta) {
		this.theta = theta;
	}
	
	
	
	
}
