package com.puzdrowski.decision.input;

public class Keyboard {

	public static boolean[] keys;
	public static boolean[] pkeys;
	
	public static final int NUM_KEYS = 1;
	
	public static final int END = 0;
	
	static {
		keys = new boolean[NUM_KEYS];
		pkeys = new boolean[NUM_KEYS];
	}
	
	public static void setKey(int i, boolean b) {
		keys[i] = b;
	}
	
	public static void update() {
		for(int i = 0; i < keys.length; i++) {
			pkeys[i] = keys[i];
		}
	}
	
	public static boolean isDown(int i) {
		return keys[i];
	}
	
	public static boolean isPressed(int i) {
		return keys[i] && !pkeys[i];
	}
	
}
