package com.puzdrowski.decision.stages;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.utils.Align;
import com.puzdrowski.decision.Game;

public class GameStage extends StageWrapper {

	private Window window;
	
	public GameStage(Game game) {
		super(game);
	}

	@Override
	public void elements() {
		super.elements();
		
		window = new Window("Test", skin);
		window.align(Align.center);
		
		Table internalTable = new Table();
		Label label = new Label("test", skin);
		internalTable.add(label).pad(20);
		
		window.add(internalTable);
		table.add(window);
		table.add(internalTable);
	}	
	
	@Override
	public void render() {
		super.render();
	}
}
