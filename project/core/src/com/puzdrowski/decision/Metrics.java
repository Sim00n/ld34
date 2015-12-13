package com.puzdrowski.decision;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Metrics {

	public static boolean showDeltas = false;
	
	public static float HEALTH, HEALTH_D = 0;
	public static float FOOD, FOOD_D = 0;
	public static float TECH, TECH_D = 0;
	public static float ENV, ENV_D = 0;
	public static float SPACE, SPACE_D = 0;
	public static float DRUG, DRUG_D = 0;
	public static float EDUCATION, EDUCATION_D = 0;
	public static float JOBS, JOBS_D = 0;
	public static float INFRASTRUCTURE, INFRASTRUCTURE_D = 0;
	public static float VODKA, VODKA_D = 0;
	public static float WIFI, WIFI_D = 0;
	public static float ENERGY, ENERGY_D = 0;
	public static float LAW, LAW_D = 0;
	public static float PEACE, PEACE_D = 0;
	public static float LOVE, LOVE_D = 0;

	public static float HUNGER, HUNGER_D = 0;
	public static float WAR, WAR_D = 0;
	public static float HAPPINESS, HAPPINESS_D = 0;
	
	static ShapeRenderer sr = new ShapeRenderer();
	static BitmapFont font = new BitmapFont();
	
	public static void init() {
		Metrics.HEALTH = 44 + (int) (Math.random() * 10 - 5);
		Metrics.FOOD = 71 + (int) (Math.random() * 4 - 2);
		Metrics.TECH = 54 + (int) (Math.random() * 10 - 5);
		Metrics.ENV = 33 + (int) (Math.random() * 10 - 5);
		Metrics.SPACE = 12 + (int) (Math.random() * 20 - 10);
		Metrics.DRUG = 58 + (int) (Math.random() * 10 - 5);
		Metrics.EDUCATION = 45 + (int) (Math.random() * 10 - 5);
		Metrics.JOBS = 81 + (int) (Math.random() * 10 - 5);
		Metrics.INFRASTRUCTURE = 20 + (int) (Math.random() * 10 - 5);
		Metrics.VODKA = 50 + (int) (Math.random() * 30 - 15);
		Metrics.WIFI = 67 + (int) (Math.random() * 10 - 5);
		Metrics.ENERGY = 60 + (int) (Math.random() * 10 - 5);
		Metrics.LAW = 64 + (int) (Math.random() * 10 - 5);
		Metrics.PEACE = 80 + (int) (Math.random() * 20 - 10);
		Metrics.LOVE = 55 + (int) (Math.random() * 20 - 10);
		
		Metrics.HUNGER = 30 + (int) (Math.random() * 10 - 5);
		Metrics.WAR = 50 + (int) (Math.random() * 10 - 5);
		Metrics.HAPPINESS = 20 + (int) (Math.random() * 30 - 15);
	}
	
	public static void render(Batch batch) {
		sr.begin(ShapeType.Filled);
		
		sr.setColor(new Color(0.17f, 0.21f, 0.24f, 1f));
		
		sr.box(0 + 30, Game.HEIGHT/1.04f, 0, 180, 10, 10);
		sr.box(0 + 30, Game.HEIGHT/1.09f, 0, 180, 10, 10);
		sr.box(0 + 30, Game.HEIGHT/1.14f, 0, 180, 10, 10);
		
		sr.box(180 + 60, Game.HEIGHT/1.04f, 0, 180, 10, 10);
		sr.box(180 + 60, Game.HEIGHT/1.09f, 0, 180, 10, 10);
		sr.box(180 + 60, Game.HEIGHT/1.14f, 0, 180, 10, 10);
		
		sr.box(360 + 90, Game.HEIGHT/1.04f, 0, 180, 10, 10);
		sr.box(360 + 90, Game.HEIGHT/1.09f, 0, 180, 10, 10);
		sr.box(360 + 90, Game.HEIGHT/1.14f, 0, 180, 10, 10);
		
		sr.box(540 + 120, Game.HEIGHT/1.04f, 0, 180, 10, 10);
		sr.box(540 + 120, Game.HEIGHT/1.09f, 0, 180, 10, 10);
		sr.box(540 + 120, Game.HEIGHT/1.14f, 0, 180, 10, 10);
		
		sr.box(720 + 150, Game.HEIGHT/1.04f, 0, 180, 10, 10);
		sr.box(720 + 150, Game.HEIGHT/1.09f, 0, 180, 10, 10);
		sr.box(720 + 150, Game.HEIGHT/1.14f, 0, 180, 10, 10);
		
		sr.box(900 + 300, Game.HEIGHT/1.04f, 0, 180, 10, 10);
		sr.box(900 + 300, Game.HEIGHT/1.09f, 0, 180, 10, 10);
		sr.box(900 + 300, Game.HEIGHT/1.14f, 0, 180, 10, 10);
		
		sr.setColor(new Color(0.35f, 0.66f, 0.32f, 1f));
		
		sr.box(0 + 30, Game.HEIGHT/1.04f, 0, (HEALTH*1.8f), 10, 10);
		sr.box(0 + 30, Game.HEIGHT/1.09f, 0, (FOOD*1.8f), 10, 10);
		sr.box(0 + 30, Game.HEIGHT/1.14f, 0, (TECH*1.8f), 10, 10);
		
		sr.box(180 + 60, Game.HEIGHT/1.04f, 0, (ENV*1.8f), 10, 10);
		sr.box(180 + 60, Game.HEIGHT/1.09f, 0, (SPACE*1.8f), 10, 10);
		sr.box(180 + 60, Game.HEIGHT/1.14f, 0, (DRUG*1.8f), 10, 10);
		
		sr.box(360 + 90, Game.HEIGHT/1.04f, 0, (EDUCATION*1.8f), 10, 10);
		sr.box(360 + 90, Game.HEIGHT/1.09f, 0, (JOBS*1.8f), 10, 10);
		sr.box(360 + 90, Game.HEIGHT/1.14f, 0, (INFRASTRUCTURE*1.8f), 10, 10);
		
		sr.box(540 + 120, Game.HEIGHT/1.04f, 0, (VODKA*1.8f), 10, 10);
		sr.box(540 + 120, Game.HEIGHT/1.09f, 0, (WIFI*1.8f), 10, 10);
		sr.box(540 + 120, Game.HEIGHT/1.14f, 0, (ENERGY*1.8f), 10, 10);
		
		sr.box(720 + 150, Game.HEIGHT/1.04f, 0, (LAW*1.8f), 10, 10);
		sr.box(720 + 150, Game.HEIGHT/1.09f, 0, (PEACE*1.8f), 10, 10);
		sr.box(720 + 150, Game.HEIGHT/1.14f, 0, (LOVE*1.8f), 10, 10);
		
		sr.box(900 + 300, Game.HEIGHT/1.04f, 0, (HUNGER*1.8f), 10, 10);
		sr.box(900 + 300, Game.HEIGHT/1.09f, 0, (WAR*1.8f), 10, 10);
		sr.box(900 + 300, Game.HEIGHT/1.14f, 0, (HAPPINESS*1.8f), 10, 10);		
		
		if(HEALTH_D < 0 && showDeltas) {
			sr.setColor(new Color(0.85f, 0.16f, 0.12f, 1f));
			sr.box(0 + 30 + (HEALTH*1.8f), Game.HEIGHT/1.04f, 0, -HEALTH_D*1.8f, 10, 10);
		} else {
			sr.setColor(new Color(0.35f, 0.86f, 0.32f, 1f));
			sr.box(0 + 30 + (HEALTH*1.8f), Game.HEIGHT/1.04f, 0, HEALTH_D*1.8f, 10, 10);
		}
		
		if(FOOD_D < 0 && showDeltas) {
			sr.setColor(new Color(0.85f, 0.16f, 0.12f, 1f));
			sr.box(0 + 30 + (FOOD*1.8f), Game.HEIGHT/1.09f, 0, -FOOD_D*1.8f, 10, 10);
		} else {
			sr.setColor(new Color(0.35f, 0.86f, 0.32f, 1f));
			sr.box(0 + 30 + (FOOD*1.8f), Game.HEIGHT/1.09f, 0, FOOD_D*1.8f, 10, 10);
		}
		
		if(TECH_D < 0 && showDeltas) {
			sr.setColor(new Color(0.85f, 0.16f, 0.12f, 1f));
			sr.box(0 + 30 + (TECH*1.8f), Game.HEIGHT/1.14f, 0, -TECH_D*1.8f, 10, 10);
		} else {
			sr.setColor(new Color(0.35f, 0.86f, 0.32f, 1f));
			sr.box(0 + 30 + (TECH*1.8f), Game.HEIGHT/1.14f, 0, TECH_D*1.8f, 10, 10);
		}
		
		if(ENV_D < 0 && showDeltas) {
			sr.setColor(new Color(0.85f, 0.16f, 0.12f, 1f));
			sr.box(180 + 60 + (ENV*1.8f), Game.HEIGHT/1.04f, 0, -ENV_D*1.8f, 10, 10);
		} else {
			sr.setColor(new Color(0.35f, 0.86f, 0.32f, 1f));
			sr.box(180 + 60 + (ENV*1.8f), Game.HEIGHT/1.04f, 0, ENV_D*1.8f, 10, 10);
		}
		
		if(SPACE_D < 0 && showDeltas) {
			sr.setColor(new Color(0.85f, 0.16f, 0.12f, 1f));
			sr.box(180 + 60 + (SPACE*1.8f), Game.HEIGHT/1.09f, 0, -SPACE_D*1.8f, 10, 10);
		} else {
			sr.setColor(new Color(0.35f, 0.86f, 0.32f, 1f));
			sr.box(180 + 60 + (SPACE*1.8f), Game.HEIGHT/1.09f, 0, SPACE_D*1.8f, 10, 10);
		}
		
		if(DRUG_D < 0 && showDeltas) {
			sr.setColor(new Color(0.85f, 0.16f, 0.12f, 1f));
			sr.box(180 + 60 + (DRUG*1.8f), Game.HEIGHT/1.14f, 0, -DRUG_D*1.8f, 10, 10);
		} else {
			sr.setColor(new Color(0.35f, 0.86f, 0.32f, 1f));
			sr.box(180 + 60 + (DRUG*1.8f), Game.HEIGHT/1.14f, 0, DRUG_D*1.8f, 10, 10);
		}
		
		if(EDUCATION_D < 0 && showDeltas) {
			sr.setColor(new Color(0.85f, 0.16f, 0.12f, 1f));
			sr.box(360 + 90 + (EDUCATION*1.8f), Game.HEIGHT/1.04f, 0, -EDUCATION_D*1.8f, 10, 10);
		} else {
			sr.setColor(new Color(0.35f, 0.86f, 0.32f, 1f));
			sr.box(360 + 90 + (EDUCATION*1.8f), Game.HEIGHT/1.04f, 0, EDUCATION_D*1.8f, 10, 10);
		}
		
		if(JOBS_D < 0 && showDeltas) {
			sr.setColor(new Color(0.85f, 0.16f, 0.12f, 1f));
			sr.box(360 + 90 + (JOBS*1.8f), Game.HEIGHT/1.09f, 0, -JOBS_D*1.8f, 10, 10);
		} else {
			sr.setColor(new Color(0.35f, 0.86f, 0.32f, 1f));
			sr.box(360 + 90 + (JOBS*1.8f), Game.HEIGHT/1.09f, 0, JOBS_D*1.8f, 10, 10);
		}
		
		if(INFRASTRUCTURE_D < 0 && showDeltas) {
			sr.setColor(new Color(0.85f, 0.16f, 0.12f, 1f));
			sr.box(360 + 90 + (INFRASTRUCTURE*1.8f), Game.HEIGHT/1.14f, 0, -INFRASTRUCTURE_D*1.8f, 10, 10);
		} else {
			sr.setColor(new Color(0.35f, 0.86f, 0.32f, 1f));
			sr.box(360 + 90 + (INFRASTRUCTURE*1.8f), Game.HEIGHT/1.14f, 0, INFRASTRUCTURE_D*1.8f, 10, 10);
		}
		
		if(VODKA_D < 0 && showDeltas) {
			sr.setColor(new Color(0.85f, 0.16f, 0.12f, 1f));
			sr.box(540 + 120 + (VODKA*1.8f), Game.HEIGHT/1.04f, 0, -VODKA_D*1.8f, 10, 10);
		} else {
			sr.setColor(new Color(0.35f, 0.86f, 0.32f, 1f));
			sr.box(540 + 120 + (VODKA*1.8f), Game.HEIGHT/1.04f, 0, VODKA_D*1.8f, 10, 10);
		}
		
		if(WIFI_D < 0 && showDeltas) {
			sr.setColor(new Color(0.85f, 0.16f, 0.12f, 1f));
			sr.box(540 + 120 + (WIFI*1.8f), Game.HEIGHT/1.09f, 0, -WIFI_D*1.8f, 10, 10);
		} else {
			sr.setColor(new Color(0.35f, 0.86f, 0.32f, 1f));
			sr.box(540 + 120 + (WIFI*1.8f), Game.HEIGHT/1.09f, 0, WIFI_D*1.8f, 10, 10);
		}
		
		if(ENERGY_D < 0 && showDeltas) {
			sr.setColor(new Color(0.85f, 0.16f, 0.12f, 1f));
			sr.box(540 + 120 + (ENERGY*1.8f), Game.HEIGHT/1.14f, 0, -ENERGY_D*1.8f, 10, 10);
		} else {
			sr.setColor(new Color(0.35f, 0.86f, 0.32f, 1f));
			sr.box(540 + 120 + (ENERGY*1.8f), Game.HEIGHT/1.14f, 0, ENERGY_D*1.8f, 10, 10);
		}
		
		if(LAW_D < 0 && showDeltas) {
			sr.setColor(new Color(0.85f, 0.16f, 0.12f, 1f));
			sr.box(720 + 150 + (LAW*1.8f), Game.HEIGHT/1.04f, 0, -LAW_D*1.8f, 10, 10);
		} else {
			sr.setColor(new Color(0.35f, 0.86f, 0.32f, 1f));
			sr.box(720 + 150 + (LAW*1.8f), Game.HEIGHT/1.04f, 0, LAW_D*1.8f, 10, 10);
		}
		
		if(PEACE_D < 0 && showDeltas) {
			sr.setColor(new Color(0.85f, 0.16f, 0.12f, 1f));
			sr.box(720 + 150 + (PEACE*1.8f), Game.HEIGHT/1.09f, 0, -PEACE_D*1.8f, 10, 10);
		} else {
			sr.setColor(new Color(0.35f, 0.86f, 0.32f, 1f));
			sr.box(720 + 150 + (PEACE*1.8f), Game.HEIGHT/1.09f, 0, PEACE_D*1.8f, 10, 10);
		}
		
		if(LOVE_D < 0 && showDeltas) {
			sr.setColor(new Color(0.85f, 0.16f, 0.12f, 1f));
			sr.box(720 + 150 + (LOVE*1.8f), Game.HEIGHT/1.14f, 0, -LOVE_D*1.8f, 10, 10);
		} else {
			sr.setColor(new Color(0.35f, 0.86f, 0.32f, 1f));
			sr.box(720 + 150 + (LOVE*1.8f), Game.HEIGHT/1.14f, 0, LOVE_D*1.8f, 10, 10);
		}
		
		if(HUNGER_D < 0 && showDeltas) {
			sr.setColor(new Color(0.85f, 0.16f, 0.12f, 1f));
			sr.box(900 + 300 + (HUNGER*1.8f), Game.HEIGHT/1.04f, 0, -HUNGER_D*1.8f, 10, 10);
		} else {
			sr.setColor(new Color(0.35f, 0.86f, 0.32f, 1f));
			sr.box(900 + 300 + (HUNGER*1.8f), Game.HEIGHT/1.04f, 0, HUNGER_D*1.8f, 10, 10);
		}
		
		if(WAR_D < 0 && showDeltas) {
			sr.setColor(new Color(0.85f, 0.16f, 0.12f, 1f));
			sr.box(900 + 300 + (WAR*1.8f), Game.HEIGHT/1.09f, 0, -WAR_D*1.8f, 10, 10);
		} else {
			sr.setColor(new Color(0.35f, 0.86f, 0.32f, 1f));
			sr.box(900 + 300 + (WAR*1.8f), Game.HEIGHT/1.09f, 0, WAR_D*1.8f, 10, 10);
		}
		
		if(HAPPINESS_D < 0 && showDeltas) {
			sr.setColor(new Color(0.85f, 0.16f, 0.12f, 1f));
			sr.box(900 + 300 + (HAPPINESS*1.8f), Game.HEIGHT/1.14f, 0, -HAPPINESS_D*1.8f, 10, 10);
		} else {
			sr.setColor(new Color(0.35f, 0.86f, 0.32f, 1f));
			sr.box(900 + 300 + (HAPPINESS*1.8f), Game.HEIGHT/1.14f, 0, HAPPINESS_D*1.8f, 10, 10);
		}
		
		sr.end();
		
		batch.begin();
		font.getData().scaleX = 0.92f;
		font.getData().scaleY = 0.93f;
		font.setColor(new Color(0.17f, 0.21f, 0.24f, 1f));
		font.draw(batch, "Health", 100, 763);
		font.draw(batch, "Food Availability", 73, 732);
		font.draw(batch, "Technology", 84, 701);
		
		font.draw(batch, "Environment", 290, 763);
		font.draw(batch, "Space Exploration", 270, 732);
		font.draw(batch, "Drug Trafficing", 285, 701);
		
		font.draw(batch, "Education", 510, 763);
		font.draw(batch, "Employment", 500, 732);
		font.draw(batch, "Infrastructure", 500, 701);
		
		font.draw(batch, "Vodka Availability", 695, 763);
		font.draw(batch, "Internet Coverage", 695, 732);
		font.draw(batch, "Energy Production", 693, 701);
		
		font.draw(batch, "Rule of Law", 920, 763);
		font.draw(batch, "World Peace", 916, 732);
		font.draw(batch, "Love", 940, 701);
		
		font.draw(batch, "World Hunger", 1250, 763);
		font.draw(batch, "World Wars", 1255, 732);
		font.draw(batch, "Happiness", 1260, 701);
		batch.end();
	}
	
}
