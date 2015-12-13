package com.puzdrowski.decision.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Align;
import com.puzdrowski.decision.Game;
import com.puzdrowski.decision.entity.FactorEntity;

public class HintStage extends StageWrapper {

	private Window window;
	private HorizontalGroup hz;
	private Label text;
	private Label stats;
	private Image image;
	public boolean showing;
	
	public HintStage(Game game) {
		super(game);
		showing = false;
	}

	public void updateData(FactorEntity fe) {
		window.getTitleLabel().setText(fe.getTitle());
		image.setDrawable(new SpriteDrawable(new Sprite(fe.getIcon())));
		image.setScale(0.8f);
		image.setPosition(15f, 0);
		text.setText("\n"+fe.getDesc());
		if(fe.isAffective()) {
			stats.setText(fe.getStats());
		} else {
			stats.setText("\n"+fe.getStats().replaceAll("\\-", "").replaceAll("\\+", "-"));
		}
	}
	
	@Override
	public void update(float tick) {
		super.update(tick);
		if(showing) {
			window.setX(Gdx.input.getX());
			window.setY(Game.HEIGHT - Gdx.input.getY());
		}
	}
	
	@Override
	public void elements() {
		super.elements();
		
		window = new Window("Hint", skin);
		window.setSize(700, 200);
		window.align(Align.top);
		window.setScale(0.8f);
		
		image = new Image(new Texture(Gdx.files.internal("textures/icons/police.png")));
		hz = new HorizontalGroup();
		hz.align(Align.center);
		
		Table t = new Table();
		Table t2 = new Table();
		
		text = new Label("123", skin);
		text.setAlignment(Align.center);
		text.setWrap(true);
		text.setWidth(300);
		t.add(text).width(300f);
				
		stats = new Label("123", skin);
		stats.setWrap(true);
		stats.setWidth(200);
		stats.setAlignment(Align.center);
		t2.add(stats).width(200f).padLeft(30f);
		
		hz.align(Align.top);
		hz.addActor(image);
		hz.addActor(t);
		hz.addActor(t2);
		
		window.add(hz);
		stage.addActor(window);
	}	
	
	@Override
	public void render() {
		if(showing)
			super.render();
	}
}
