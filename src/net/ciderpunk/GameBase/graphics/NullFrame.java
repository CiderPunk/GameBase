package net.ciderpunk.GameBase.graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;


public class NullFrame implements IFrame {

	static protected NullFrame oNullFrame = new NullFrame();
		
	
	//get instance
	public static NullFrame getInstance(){
		return oNullFrame;
	}
	
	
	@Override
	public void draw(Graphics oG, int x, int y) {

	}

	@Override
	public void drawRotate(Graphics2D oG, int x, int y, double iRads) {
	}

}
