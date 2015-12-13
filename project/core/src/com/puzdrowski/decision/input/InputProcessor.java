package com.puzdrowski.decision.input;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Input.Keys;

public class InputProcessor extends InputAdapter {
	public boolean keyDown(int k) {
		if(k == Keys.GRAVE) {
			Keyboard.setKey(Keyboard.END, true);
		}
		if(k == Keys.H) {
			Keyboard.setKey(Keyboard.HELP, true);
		}
		
		return true;
	}
	
	public boolean keyUp(int k) {
		if(k == Keys.GRAVE) {
			Keyboard.setKey(Keyboard.END, false);
		}
		if(k == Keys.H) {
			Keyboard.setKey(Keyboard.HELP, false);
		}
		
		return true;
	}
}
