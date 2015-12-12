package com.puzdrowski.decision.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.puzdrowski.decision.Game;

public class FactorEntity extends Entity {

	private boolean isCurrent;
	private boolean isAffective;
	
	public FactorEntity(Texture texture, int x, int y, float theta, TYPE type, int i) {
		super(texture, x, y, theta, type, i);
		this.isCurrent = false;
		this.isAffective= false;
	}

	public void update(float tick, float rollingSpeed) {
		super.update(tick);

		if(type == TYPE.OUTER) {
			x = (int) (Game.WIDTH/2 - 40 + Math.cos(Math.toRadians(theta * order - rollingSpeed)) * 550);
			y = (int) (Game.HEIGHT/2 - 100 + Math.sin(Math.toRadians(theta * order - rollingSpeed)) * 280);
		} else if(type == TYPE.MIDDLE) {
			x = (int) (Game.WIDTH/2 - 40 + Math.cos(Math.toRadians(theta * order - rollingSpeed)) * 340);
			y = (int) (Game.HEIGHT/2 - 100 + Math.sin(Math.toRadians(theta * order - rollingSpeed)) * 180);
		} else if(type == TYPE.INNER) {
			x = (int) (Game.WIDTH/2 - 40 + Math.cos(Math.toRadians(theta * order - rollingSpeed)) * 130);
			y = (int) (Game.HEIGHT/2 - 100 + Math.sin(Math.toRadians(theta * order - rollingSpeed)) * 100);
		}
	}
	
	@Override
	public void render(Batch batch) {
		if(isCurrent)
			batch.draw(texture, x, y, 90, 90);
		else
			batch.draw(texture, x, y, 80, 80);
	}
	
	public void toggle(boolean tog) {
		isCurrent = tog;
	}
	
	public void toggle() {
		isCurrent = !isCurrent;
	}
	
	public void toggleAffect(boolean tog) {
		isAffective = tog;
	}
	
	public void toggleAffect() {
		isAffective = !isAffective;
	}
}
