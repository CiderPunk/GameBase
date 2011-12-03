package net.ciderpunk.GameBase.graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;

public interface IFrame {
	//draw image
	public void draw(Graphics oG, int x, int y);
	//draw image with some rotation
	public void drawRotate(Graphics2D oG, int x, int y, double iRads);
}
