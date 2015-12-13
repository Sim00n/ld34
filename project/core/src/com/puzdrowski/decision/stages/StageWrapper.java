package com.puzdrowski.decision.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.puzdrowski.decision.Game;

public class StageWrapper {

	Game game;
	Stage stage;
	Skin skin;
	
	public StageWrapper(Game game) {
		this.game = game;
		initialize();
	}
	
	public void initialize() {
		stage = new Stage();
		//stage.setDebugAll(true);
		skin = new Skin(Gdx.files.internal("libgdx/uiskin.json"));
		skin.add("default", new BitmapFont());	
		elements();	
	}
	
	public void elements() {}
	
	public void render() {
		stage.draw();
	}
	
	public void update(float tick) {
		stage.act(tick);
	}
	
	public Stage getStage() {
		return stage;
	}
	
}
