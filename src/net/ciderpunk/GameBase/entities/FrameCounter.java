package net.ciderpunk.GameBase.entities;

import java.awt.Color;
import java.awt.Graphics2D;

public class FrameCounter extends PositionedEntity {

	long lStartTime;
	int iFrames;
	String sFps;
	
	public FrameCounter(int x,int y){
		super(x,y);
		lStartTime = System.currentTimeMillis();
		iFrames = 0;
		sFps = "";
	}
	
	
	@Override
	public void update() {
		long lCurrentTime = System.currentTimeMillis();
		if (lCurrentTime - lStartTime > 1000){
			sFps = "FPS: " + iFrames;
			iFrames = 0;
			lStartTime = lCurrentTime;
		}
		else{
			iFrames++;
		}
	}

	@Override
	public void draw(Graphics2D oG) {
		oG.setColor(Color.WHITE);
		oG.drawString(sFps , iX,iY);
	}

	
	
	
}
