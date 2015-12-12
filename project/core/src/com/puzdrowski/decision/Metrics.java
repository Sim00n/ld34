package com.puzdrowski.decision;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Metrics {

	public static int HEALTH;
	public static int FOOD;
	public static int TECH;
	public static int ENV;
	public static int SPACE;
	public static int DRUG;
	public static int EDUCATION;
	public static int JOBS;
	public static int INFRASTRUCTURE;
	public static int VODKA;
	public static int WIFI;
	public static int ENERGY;
	public static int LAW;
	public static int PEACE;
	public static int LOVE;
	
	public static int HUNGER;
	public static int WAR;
	public static int HAPPINESS;
	
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
		
		sr.setColor(new Color(0.47f, 0.21f, 0.24f, 1f));
		
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
		
		sr.box(0 + 30, Game.HEIGHT/1.04f, 0, HEALTH, 10, 10);
		sr.box(0 + 30, Game.HEIGHT/1.09f, 0, FOOD, 10, 10);
		sr.box(0 + 30, Game.HEIGHT/1.14f, 0, TECH, 10, 10);
		
		sr.box(180 + 60, Game.HEIGHT/1.04f, 0, ENV, 10, 10);
		sr.box(180 + 60, Game.HEIGHT/1.09f, 0, SPACE, 10, 10);
		sr.box(180 + 60, Game.HEIGHT/1.14f, 0, DRUG, 10, 10);
		
		sr.box(360 + 90, Game.HEIGHT/1.04f, 0, EDUCATION, 10, 10);
		sr.box(360 + 90, Game.HEIGHT/1.09f, 0, JOBS, 10, 10);
		sr.box(360 + 90, Game.HEIGHT/1.14f, 0, INFRASTRUCTURE, 10, 10);
		
		sr.box(540 + 120, Game.HEIGHT/1.04f, 0, VODKA, 10, 10);
		sr.box(540 + 120, Game.HEIGHT/1.09f, 0, WIFI, 10, 10);
		sr.box(540 + 120, Game.HEIGHT/1.14f, 0, ENERGY, 10, 10);
		
		sr.box(720 + 150, Game.HEIGHT/1.04f, 0, LAW, 10, 10);
		sr.box(720 + 150, Game.HEIGHT/1.09f, 0, PEACE, 10, 10);
		sr.box(720 + 150, Game.HEIGHT/1.14f, 0, LOVE, 10, 10);
		
		sr.box(900 + 300, Game.HEIGHT/1.04f, 0, HUNGER, 10, 10);
		sr.box(900 + 300, Game.HEIGHT/1.09f, 0, WAR, 10, 10);
		sr.box(900 + 300, Game.HEIGHT/1.14f, 0, HAPPINESS, 10, 10);		
		
		sr.end();
		
		batch.begin();
		font.setColor(new Color(0.4f, 0.46f, 0.47f, 1f));
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
