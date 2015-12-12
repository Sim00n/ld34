package com.puzdrowski.decision;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.puzdrowski.decision.input.Keyboard;
import com.puzdrowski.decision.stages.GameStage;

public class GameWorld {

	private Game game;
	private SpriteBatch batch;
	private OrthographicCamera camera;

	private GameStage gameStage;

	private Texture txt_background, board, button, big_button, big_button_hover;
	private BitmapFont font;
	
	private enum SCREEN {WELCOME, GAME, PAUSE, EXIT};
	private SCREEN screen;
	
	private float theta = 0.0f;
	private boolean rolling = false;
	private float rollingSpeed = 0.0f;
	private float rollingDamping = 0.0f;
	private float rollingTimer = 0.0f;
	private static final float ROLLING_DAMPING_DAMPING= 0.995f;
	
	private boolean[] button_hover = new boolean[4];
	
	public GameWorld(Game game) {
		this.game = game;
		initialize();
	}
	
	private void initialize() {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Game.WIDTH, Game.HEIGHT);
		batch = new SpriteBatch();
		
		gameStage = new GameStage(this.game);
		screen = SCREEN.GAME;
		
		txt_background = new Texture(Gdx.files.internal("textures/background_big.png"));
		board = new Texture(Gdx.files.internal("textures/board.png"));
		button = new Texture(Gdx.files.internal("textures/button.png"));
		big_button = new Texture(Gdx.files.internal("textures/big_button.png"));
		big_button_hover = new Texture(Gdx.files.internal("textures/big_button_hover.png"));
		
		font = new BitmapFont();
		font.setColor(new Color(0.5f, 0.45f, 0.5f, 1));
		
		for(int i = 0; i < button_hover.length; i++) {
			button_hover[i] = false;
		}
	}
	
	public void update(float tick) {
		switch(screen) {
			case GAME:
				gameStage.update(tick);
			break;
			default:
			break;		
		}
		
		roll(tick);
		buttons(tick);
	}
	
	private void roll(float tick) {
		if(rolling) {
			rollingSpeed += rollingDamping;
			rollingDamping *= ROLLING_DAMPING_DAMPING;
			if(rollingSpeed <= 15) {
				rolling = false;
				rollingTimer = 5.0f;
			}
		} else {
			if(rollingTimer > 0) {
				rollingTimer -= tick;
			}
			if(Keyboard.isDown(Keyboard.ROLL)) {
				startRolling();
			}
		}
	}
	
	private void startRolling() {
		if(rollingTimer <= 0 && !rolling) {
			rolling = true;
			rollingSpeed = 500.0f;
			rollingDamping = -3.0f;
		}
	}
	
	private void buttons(float tick) {
		int mX = Gdx.input.getX();
		int mY = Game.HEIGHT - Gdx.input.getY();
		
		button_hover[0] = (mX > 0 && mX < 164 && mY > Game.HEIGHT/1.6f && mY < Game.HEIGHT/1.6f + 164);
		button_hover[1] = (mX > 0 && mX < 164 && mY > 0 && mY < 164);
		button_hover[2] = (mX > Game.WIDTH - 164 && mX < Game.WIDTH && mY > Game.HEIGHT/1.6f && mY < Game.HEIGHT/1.6f + 164);
		button_hover[3] = (mX > Game.WIDTH - 165 && mX < Game.WIDTH && mY > 0 && mY < 164);
		
		if(button_hover[0] && Gdx.input.isButtonPressed(Input.Keys.LEFT)) {
			startRolling();
		}
	}
	
	public void render() {		
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		
		batch.begin();
		
		batch.draw(txt_background, 0f, 0f, Game.WIDTH, Game.HEIGHT);
		batch.draw(board, 0, Game.HEIGHT - 150, Game.WIDTH, 250);
				
		theta = 360f/22f;
		for(int i = 0; i < 22; i++) {
			int x = (int) (Game.WIDTH/2 - 40 + Math.cos(Math.toRadians(theta * i - rollingSpeed)) * 550);
			int y = (int) (Game.HEIGHT/2 - 100 + Math.sin(Math.toRadians(theta * i - rollingSpeed)) * 280);
			batch.draw(button, x, y, 80, 80);						
		}
		
		theta = 360f/12f;
		for(int i = 0; i < 12; i++) {
			int x = (int) (Game.WIDTH/2 - 40 + Math.cos(Math.toRadians(theta * i - ((int) rollingSpeed))) * 340);
			int y = (int) (Game.HEIGHT/2 - 100 + Math.sin(Math.toRadians(theta * i - ((int) rollingSpeed))) * 180);
			batch.draw(button, x, y, 80, 80);
		}
				
		theta = 360f/6f;
		for(int i = 0; i < 6; i++) {
			int x = (int) (Game.WIDTH/2 - 40 + Math.cos(Math.toRadians(theta * i - ((int) rollingSpeed))) * 130);
			int y = (int) (Game.HEIGHT/2 - 100 + Math.sin(Math.toRadians(theta * i - ((int) rollingSpeed))) * 100);
			batch.draw(button, x, y, 80, 80);
		}
				
		if(button_hover[0])
			batch.draw(big_button_hover, 0, Game.HEIGHT/1.60f, 164, 164);
		else
			batch.draw(big_button, 0, Game.HEIGHT/1.60f, 164, 164);
		if(rollingTimer > 0)
			font.draw(batch, "Advance\n     (" + (int)rollingTimer + ")", 164/3, Game.HEIGHT/1.60f + 164/1.75f);
		else
			font.draw(batch, "Advance", 164/3, Game.HEIGHT/1.60f + 164/1.75f);
		
		if(button_hover[1])
			batch.draw(big_button_hover, 0, 0, 164, 164);
		else
			batch.draw(big_button, 0, 0, 164, 164);
		font.draw(batch, "Quit", 164/2.50f, 164/1.75f);
		
		if(button_hover[2])
			batch.draw(big_button_hover, Game.WIDTH - 164, Game.HEIGHT/1.60f, 164, 164);
		else
			batch.draw(big_button, Game.WIDTH - 164, Game.HEIGHT/1.60f, 164, 164);
		font.draw(batch, "Switch", Game.WIDTH - 165 + 165/2.5f, Game.HEIGHT/1.33f);
		
		if(button_hover[3])
			batch.draw(big_button_hover, Game.WIDTH - 164, 0, 164, 164);
		else
			batch.draw(big_button, Game.WIDTH - 164, 0, 164, 164);
		font.draw(batch, "Help", Game.WIDTH - 164 + 164/2.50f, 164/1.70f);
		
		batch.end();
		
		Metrics.render(batch);
		
		/*switch(screen) {
		case GAME:
			gameStage.render();
		break;
		default:
		break;
		}*/
		
	}	
	
}

