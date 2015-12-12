package com.puzdrowski.decision;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.puzdrowski.decision.input.InputProcessor;

public class Game extends ApplicationAdapter {
	
	public static final int WIDTH = 1440;
	public static final int HEIGHT = 768;
	public static final float SCALE = WIDTH / 1920f;
	public static final String TITLE = "Decision";
	
	private static final float STEP = 1/60f;
	private float accum;
	
	private GameWorld world;
	
	@Override
	public void create () {
		Gdx.input.setInputProcessor(new InputProcessor());
		Gdx.graphics.setDisplayMode(WIDTH, HEIGHT, false);
		Metrics.init(); // Let's do this before loading the world just for safety.
		world = new GameWorld(this);
	}

	@Override
	public void render () {
		accum += Gdx.graphics.getDeltaTime();
		while(accum >= STEP) {
			accum -= STEP;
			update(STEP);
			draw();
		}
	}
	
	private void update(float STEP) {
		world.update(STEP);
	}
	
	private void draw() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		world.render();
	}
	
}
