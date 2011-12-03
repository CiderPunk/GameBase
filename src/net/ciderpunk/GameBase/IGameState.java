package net.ciderpunk.GameBase;

import java.awt.*;

public interface IGameState {
	public void start(Component oComponent);
	public void stop(Component oComponent);
	public void init();
	public void update();
	public void draw(Graphics2D oGraphics);
}
