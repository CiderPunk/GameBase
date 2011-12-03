package net.ciderpunk.GameBase.entities;
import java.awt.*;

public abstract class Entity extends LinkedEntity {

	
	public abstract int getX();
	public abstract int getY();
	
	public abstract void update();
	public abstract void draw(Graphics2D oG);
}
