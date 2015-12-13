package com.puzdrowski.decision;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.puzdrowski.decision.entity.Entity.TYPE;
import com.puzdrowski.decision.entity.FactorEntity;
import com.puzdrowski.decision.entity.FactorEntity.FACTORS;
import com.puzdrowski.decision.input.Keyboard;
import com.puzdrowski.decision.stages.GameStage;

public class GameWorld {

	private Game game;
	private SpriteBatch batch;
	private OrthographicCamera camera;

	private GameStage gameStage;

	private Texture txt_background, board, button, big_button, big_button_hover, button_hover_t;
	private BitmapFont font;
	
	private enum SCREEN {WELCOME, GAME, PAUSE, EXIT};
	private SCREEN screen;
	
	private boolean rolling = false;
	private float rollingSpeed = 0.0f;
	private float rollingDamping = 0.0f;
	private float rollingTimer = 0.0f;
	private static final float ROLLING_DAMPING_DAMPING= 0.995f;
	public static final float ROLLING_LIMIT = 15f;
	
	FactorEntity[] outer = new FactorEntity[22];
	FactorEntity[] middle = new FactorEntity[12];
	FactorEntity[] inner = new FactorEntity[6];
	FactorEntity currentFactor;
	
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
		
		txt_background = new Texture(Gdx.files.internal("textures/bg_alt.png"));
		board = new Texture(Gdx.files.internal("textures/board.png"));
		button = new Texture(Gdx.files.internal("textures/button.png"));
		big_button = new Texture(Gdx.files.internal("textures/big_button.png"));
		big_button_hover = new Texture(Gdx.files.internal("textures/big_button_hover.png"));
		button_hover_t = new Texture(Gdx.files.internal("textures/button_hover.png"));
		
		font = new BitmapFont();
		font.setColor(new Color(0.5f, 0.45f, 0.5f, 1));
		
		for(int i = 0; i < button_hover.length; i++) {
			button_hover[i] = false;
		}
		
		float theta = 0.0f;
		theta = 360f/22f;
		//22
		outer[0] = new FactorEntity(button, button_hover_t, theta, TYPE.OUTER, 0, FACTORS.ALCOHOL_TAX);
		outer[1] = new FactorEntity(button, button_hover_t, theta, TYPE.OUTER, 1, FACTORS.ANIMAL_PROTECTION);
		outer[2] = new FactorEntity(button, button_hover_t, theta, TYPE.OUTER, 2, FACTORS.BAN_ON_ALCOHOL);
		outer[3] = new FactorEntity(button, button_hover_t, theta, TYPE.OUTER, 3, FACTORS.BAN_ON_DRUGS);
		outer[4] = new FactorEntity(button, button_hover_t, theta, TYPE.OUTER, 4, FACTORS.BAN_ON_SMOKING);
		outer[5] = new FactorEntity(button, button_hover_t, theta, TYPE.OUTER, 5, FACTORS.CCTV);
		outer[6] = new FactorEntity(button, button_hover_t, theta, TYPE.OUTER, 6, FACTORS.CIA_PRISONS);
		outer[7] = new FactorEntity(button, button_hover_t, theta, TYPE.OUTER, 7, FACTORS.CLIMATE_WARMING);
		outer[8] = new FactorEntity(button, button_hover_t, theta, TYPE.OUTER, 8, FACTORS.CONFORMITY);
		outer[9] = new FactorEntity(button, button_hover_t, theta, TYPE.OUTER, 9, FACTORS.CORPORATION_TAX);
		outer[10] = new FactorEntity(button, button_hover_t, theta, TYPE.OUTER, 10, FACTORS.DIVERSITY);
		outer[11] = new FactorEntity(button, button_hover_t, theta, TYPE.OUTER, 11, FACTORS.ELECTRIC_CARS);
		outer[12] = new FactorEntity(button, button_hover_t, theta, TYPE.OUTER, 12, FACTORS.FISHING_QUOTAS);
		outer[13] = new FactorEntity(button, button_hover_t, theta, TYPE.OUTER, 13, FACTORS.GENDER_EQUALITY);
		outer[14] = new FactorEntity(button, button_hover_t, theta, TYPE.OUTER, 14, FACTORS.GENEVA_CONVENTION);
		outer[15] = new FactorEntity(button, button_hover_t, theta, TYPE.OUTER, 15, FACTORS.GLOBAL_POLICE);
		outer[16] = new FactorEntity(button, button_hover_t, theta, TYPE.OUTER, 16, FACTORS.HIGH_UNIVERSITY_COST);
		outer[17] = new FactorEntity(button, button_hover_t, theta, TYPE.OUTER, 17, FACTORS.INDUSTRY_REGULATION);
		outer[18] = new FactorEntity(button, button_hover_t, theta, TYPE.OUTER, 18, FACTORS.INFO_FREEDOM);
		outer[19] = new FactorEntity(button, button_hover_t, theta, TYPE.OUTER, 19, FACTORS.MARRIAGE_EQUALITY);
		outer[20] = new FactorEntity(button, button_hover_t, theta, TYPE.OUTER, 20, FACTORS.MEDICAL_RESEARCH);
		outer[21] = new FactorEntity(button, button_hover_t, theta, TYPE.OUTER, 21, FACTORS.MILITARIZATION);
		
		theta = 360f/12f;
		//12
		middle[0] = new FactorEntity(button, button_hover_t, theta, TYPE.MIDDLE, 0, FACTORS.MINIMUM_WAGE);
		middle[1] = new FactorEntity(button, button_hover_t, theta, TYPE.MIDDLE, 1, FACTORS.NASA);
		middle[2] = new FactorEntity(button, button_hover_t, theta, TYPE.MIDDLE, 2, FACTORS.NUCLEAR_ENERGY);
		middle[3] = new FactorEntity(button, button_hover_t, theta, TYPE.MIDDLE, 3, FACTORS.POPULATION_GROWTH);
		middle[4] = new FactorEntity(button, button_hover_t, theta, TYPE.MIDDLE, 4, FACTORS.POPULATION_TRACKING);
		middle[5] = new FactorEntity(button, button_hover_t, theta, TYPE.MIDDLE, 5, FACTORS.PROPERTY_TAX);
		middle[6] = new FactorEntity(button, button_hover_t, theta, TYPE.MIDDLE, 6, FACTORS.QUANTUM_COMPUTING);
		middle[7] = new FactorEntity(button, button_hover_t, theta, TYPE.MIDDLE, 7, FACTORS.RELIGIOUS_FREEDOM);
		middle[8] = new FactorEntity(button, button_hover_t, theta, TYPE.MIDDLE, 8, FACTORS.STD_PREVENTION);
		middle[9] = new FactorEntity(button, button_hover_t, theta, TYPE.MIDDLE, 9, FACTORS.UNITED_NATIONS);
		middle[10] = new FactorEntity(button, button_hover_t, theta, TYPE.MIDDLE, 10, FACTORS.VACCINES);
		middle[11] = new FactorEntity(button, button_hover_t, theta, TYPE.MIDDLE, 11, FACTORS.HIGH_UNEMPLOYMENT);
				
		theta = 360f/6f;
		// 6
		inner[0] = new FactorEntity(button, button_hover_t, theta, TYPE.INNER, 0, FACTORS.UTILITY_TAX);
		inner[1] = new FactorEntity(button, button_hover_t, theta, TYPE.INNER, 1, FACTORS.OPEN_TRADE);
		inner[2] = new FactorEntity(button, button_hover_t, theta, TYPE.INNER, 2, FACTORS.RENEWABLE_ENERGY);
		inner[3] = new FactorEntity(button, button_hover_t, theta, TYPE.INNER, 3, FACTORS.SEWER_TREATMENT);
		inner[4] = new FactorEntity(button, button_hover_t, theta, TYPE.INNER, 4, FACTORS.EPIDEMICS);
		inner[5] = new FactorEntity(button, button_hover_t, theta, TYPE.INNER, 5, FACTORS.DISASTER_PREVENTION);
		
		endRolling();
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
		factors(tick);
	}
	
	private void roll(float tick) {
		if(rolling) {
			rollingSpeed += rollingDamping;
			rollingDamping *= ROLLING_DAMPING_DAMPING;
			if(rollingSpeed <= ROLLING_LIMIT) {
				rolling = false;
				rollingTimer = 5.0f;
				endRolling();
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
	
	private void endRolling() {
		FactorEntity oldFactor = currentFactor;
		if(oldFactor != null) {
			oldFactor.toggle(false);
		}
		int set = (int) (Math.random() * 3);
		if(set == 0) {
			currentFactor = outer[(int) (Math.random() * outer.length)];
		} else if (set == 1) {
			currentFactor = middle[(int) (Math.random() * middle.length)];
		} else if (set == 2) {
			currentFactor = inner[(int) (Math.random() * inner.length)];
		}
		
		evolve(oldFactor, currentFactor);
		
		currentFactor.toggle(true);
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
		
		button_hover[0] = (mX > Game.WIDTH/1.34f && mX < Game.WIDTH/1.34f + 96 && mY > Game.HEIGHT/1.155f && mY < Game.HEIGHT/1.155f + 96);
		button_hover[1] = (mX > 0 && mX < 64 && mY > 0 && mY < 64);
		button_hover[3] = (mX > 0 + 64 && mX < 0 + 64 + 64 && mY > 0 && mY < 164);
		
		if(button_hover[0] && Gdx.input.isButtonPressed(Input.Keys.LEFT)) {
			startRolling();
		} else if(button_hover[1] && Gdx.input.isButtonPressed(Input.Keys.LEFT)) {
			Gdx.app.exit();
		}
	}
	
	private void factors(float tick) {
		for(int i = 0; i < 22; i++) {
			outer[i].update(tick, rollingSpeed);						
		}
		for(int i = 0; i < 12; i++) {
			middle[i].update(tick, rollingSpeed);
		}
		for(int i = 0; i < 6; i++) {
			inner[i].update(tick, rollingSpeed);
		}
	}
	
	public void render() {		
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		
		batch.begin();
		
		batch.draw(txt_background, 0f, 0f, Game.WIDTH, Game.HEIGHT);
		batch.draw(board, 0, Game.HEIGHT - 150, Game.WIDTH, 250);
				
		for(int i = 0; i < 22; i++) {
			outer[i].render(batch);						
		}
		for(int i = 0; i < 12; i++) {
			middle[i].render(batch);
		}
		for(int i = 0; i < 6; i++) {
			inner[i].render(batch);
		}
		
		if(button_hover[0])
			batch.draw(big_button_hover, Game.WIDTH/1.34f, Game.HEIGHT/1.155f, 96, 96);
		else
			batch.draw(big_button, Game.WIDTH/1.34f, Game.HEIGHT/1.155f, 96, 96);
		if(rollingTimer > 0)
			font.draw(batch, "Advance\n    (" + (int)rollingTimer + ")",  Game.WIDTH/1.314f, Game.HEIGHT/1.050f);
		else
			font.draw(batch, "Roll", Game.WIDTH/1.299f, Game.HEIGHT/1.064f);
		
		if(button_hover[1])
			batch.draw(big_button_hover, 0, 0, 64, 64);
		else
			batch.draw(big_button, 0, 0, 64, 64);
		font.draw(batch, "Quit", 64/3.3f, 64/1.58f);
		
		if(button_hover[3])
			batch.draw(big_button_hover, 0 + 64, 0, 64, 64);
		else
			batch.draw(big_button, 0 + 64, 0, 64, 64);
		font.draw(batch, "Help",  0 + 64 + 64/3.3f, 64/1.58f);
		
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
	
	private void evolve(FactorEntity old, FactorEntity current) {
				
		Metrics.HEALTH_D = Metrics.FOOD_D = Metrics.TECH_D = Metrics.ENV_D = Metrics.SPACE_D = Metrics.DRUG_D = Metrics.EDUCATION_D = Metrics.JOBS_D = Metrics.INFRASTRUCTURE_D = Metrics.VODKA_D = Metrics.WIFI_D = Metrics.ENERGY_D = Metrics.LAW_D = Metrics.PEACE_D = Metrics.LOVE = 0f;
		
		for(int i = 0; i < outer.length; i++) {
			FactorEntity fe = outer[i];
			FACTORS f = fe.getFactor();
			int a = (fe.isAffective())? 1 : -1;
			
			if(f == FACTORS.POPULATION_GROWTH) {
				Metrics.FOOD_D 				+= a * -0.3f;
				Metrics.INFRASTRUCTURE_D 	+= a * -0.5f;
				Metrics.ENERGY_D 			+= a * 0.3f;
			}
			if(f == FACTORS.RELIGIOUS_FREEDOM) {
				Metrics.EDUCATION_D 		+= a * 0.4f;
				Metrics.LAW_D 				+= a * 0.4f;
				Metrics.PEACE_D 			+= a * 0.6f;
			}
			if(f == FACTORS.CLIMATE_WARMING) {
				Metrics.FOOD_D 				+= a * -0.9f;
				Metrics.ENV_D 				+= a * -1.2f;
				Metrics.JOBS_D 				+= a * 0.6f;
				Metrics.INFRASTRUCTURE_D	+= a * -0.8f;
				Metrics.ENERGY_D 			+= a * 0.3f;
				Metrics.PEACE_D 			+= a * -0.1f;
			}
			if(f == FACTORS.MILITARIZATION) {
				Metrics.INFRASTRUCTURE_D 	+= a * 0.3f;
				Metrics.ENERGY_D 			+= a * 0.5f;
				Metrics.LAW_D 				+= a * 0.9f;
				Metrics.PEACE_D				+= a * -0.1f;
			}
			if(f == FACTORS.NASA) {
				Metrics.HEALTH_D 			+= a * 0.8f;
				Metrics.FOOD				+= a * 0.5;
				Metrics.TECH_D				+= a * 1.5f;
				Metrics.EDUCATION_D 		+= a * 0.45f;
			}
			if(f == FACTORS.NUCLEAR_ENERGY) {
				Metrics.HEALTH				+= a * -0.1f;
				Metrics.FOOD				+= a * 0.2;
				Metrics.TECH				+= a * 0.3f;
				Metrics.ENV					+= a * -0.1f;
				Metrics.SPACE				+= a * 0.5f;
				Metrics.EDUCATION			+= a * 0.1f;
				Metrics.ENERGY				+= a * 1.1f;
				Metrics.PEACE				+= a * -0.5f;
			}
			if(f == FACTORS.QUANTUM_COMPUTING) {
				Metrics.TECH				+= a * 1.2f;
				Metrics.EDUCATION			+= a * 0.4f;
				Metrics.WIFI				+= a * 1.0f;
				Metrics.ENERGY				+= a * 0.3f;
				Metrics.PEACE				+= a * 0.1f;
			}
			if(f == FACTORS.ELECTRIC_CARS) {
				Metrics.TECH				+= a * 1.1f;
				Metrics.SPACE				+= a * 0.8f;
				Metrics.JOBS				+= a * 0.2f;
				Metrics.ENERGY				+= a * 0.86;
			}
			if(f == FACTORS.VACCINES) {
				Metrics.HEALTH				+= a * 1.2f;
				Metrics.SPACE				+= a * 0.1f;			
				Metrics.PEACE				+= a * 0.1f;
			}
			if(f == FACTORS.STD_PREVENTION) {
				Metrics.HEALTH				+= a * 1.1f;
				Metrics.SPACE				+= a * 0.1f;
				Metrics.PEACE				+= a * 0.1f;
			}
			if(f == FACTORS.HIGH_UNIVERSITY_COST) {
				Metrics.HEALTH				+= a * -0.3f;
				Metrics.TECH				+= a * -0.76f;
				Metrics.SPACE				+= a * -1.3f;
				Metrics.EDUCATION			+= a * -1.2f;
				Metrics.WIFI				+= a * -0.2f;
				Metrics.ENERGY				+= a * -0.1f;
			}
			if(f == FACTORS.GLOBAL_POLICE) {
				Metrics.DRUG				+= a * -1.6f;
				Metrics.VODKA				+= a * -0.2f;
				Metrics.LAW					+= a * 1.1f;
				Metrics.LOVE				+= a * 0.2f;
			}
			if(f == FACTORS.INDUSTRY_REGULATION) {
				Metrics.HEALTH				+= a * 1.9f;
				Metrics.TECH				+= a * 0.2f;
				Metrics.SPACE				+= a * -0.23f;
				Metrics.JOBS				+= a * -0.53f;
				Metrics.INFRASTRUCTURE		+= a * -9.3f;
				Metrics.ENERGY				+= a * -0.2f;
			}
			if(f == FACTORS.UNITED_NATIONS) {
				Metrics.TECH				+= a * 0.3f;
				Metrics.FOOD				+= a * 0.7;
				Metrics.ENV					+= a * 0.3;
				Metrics.PEACE				+= a * 1.6f;
				Metrics.LOVE				+= a * 1.1f;
			}
			if(f == FACTORS.BAN_ON_ALCOHOL) {
				Metrics.HEALTH				+= a * 1.1f;
				Metrics.ENV					+= a * 0.3;
				Metrics.VODKA				+= a * -5.2f;
				Metrics.PEACE				+= a * -0.5f;
			}
			if(f == FACTORS.BAN_ON_DRUGS) {
				Metrics.HEALTH				+= a * 1.7f;
				Metrics.ENV					+= a * 0.3;
				Metrics.VODKA				+= a * -0.1f;
				Metrics.PEACE				+= a * -0.5f;
				Metrics.LAW					+= a * -0.9f;
			}
			if(f == FACTORS.MEDICAL_RESEARCH) {
				Metrics.HEALTH				+= a * 1.7f;
				Metrics.ENV					+= a * 0.8;
				Metrics.PEACE				+= a * 0.5f;
				Metrics.EDUCATION			+= a * 2.5f;
				Metrics.SPACE				+= a * 0.75f;
			}
			if(f == FACTORS.FISHING_QUOTAS) {
				Metrics.FOOD				+= a * -0.2f;
				Metrics.ENV					+= a * 1.5f;
				Metrics.JOBS				+= a * -0.7f;
				Metrics.PEACE				+= a * -0.3f;
			}
			if(f == FACTORS.ANIMAL_PROTECTION) {
				
			}
		}
		
		/**
		 * Main:
		 * HEALTH, FOOD, TECH, ENV, SPACE, DRUG, EDUCATION, JOBS, INFRASTRUCTURE,
		 * VODKA, WIFI, ENERGY, LAW, PEACE, LOVE
		 * 
		 * Side:
		 * HUNGER, WAR, HAPPINESS
		 * 
		 * Factors:
		 * POPULATION_GROWTH, RELIGIOUS_FREEDOM, CLIMATE_WARMING, MILITARIZATION,
		 * NASA, NUCLEAR_ENERGY, QUANTUM_COMPUTING, ELECTRIC_CARS, VACCINES, STD_PREVENTION,
		 * HIGH_UNIVERSITY_COST, GLOBAL_POLICE, INDUSTRY_REGULATION, UNITED_NATIONS,
		 * BAN_ON_ALCOHOL, BAN_ON_DRUGS, MEDICAL_RESEARCH, FISHING_QUOTAS, ANIMAL_PROTECTION,
		 * INFO_FREEDOM, MINIMUM_WAGE, GENEVA_CONVENTION, BAN_ON_SMOKING, CONFORMITY, DIVERSITY,
		 * GENDER_EQUALITY, MARRIAGE_EQUALITY, CIA_PRISONS, POPULATION_TRACKING, CCTV, 
		 * ALCOHOL_TAX, CORPORATION_TAX, PROPERTY_TAX, HIGH_UNEMPLOYMENT, UTILITY_TAX,
		 * OPEN_TRADE, RENEWABLE_ENERGY, SEWER_TREATMENT, EPIDEMICS, DISASTER_PREVENTION
		 */
		
		Metrics.HEALTH 			+= Metrics.HEALTH_D;
		Metrics.FOOD 			+= Metrics.FOOD_D;
		Metrics.TECH			+= Metrics.TECH_D;
		Metrics.ENV				+= Metrics.ENV_D;
		Metrics.SPACE			+= Metrics.SPACE_D;
		Metrics.DRUG 			+= Metrics.DRUG_D;
		Metrics.EDUCATION		+= Metrics.EDUCATION_D;
		Metrics.JOBS			+= Metrics.JOBS_D;
		Metrics.INFRASTRUCTURE	+= Metrics.INFRASTRUCTURE_D;
		Metrics.VODKA			+= Metrics.VODKA_D;
		Metrics.WIFI			+= Metrics.WIFI_D;
		Metrics.ENERGY			+= Metrics.ENERGY_D;
		Metrics.LAW				+= Metrics.LAW_D;
		Metrics.PEACE			+= Metrics.PEACE_D;
		Metrics.LOVE			+= Metrics.LOVE_D;
		
		Metrics.showDeltas = true;
			
	}
	
}

















