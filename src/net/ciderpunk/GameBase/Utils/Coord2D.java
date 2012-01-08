package net.ciderpunk.GameBase.Utils;

public class Coord2D {
	
	public int X;
	public int Y;
	
	protected  static Coord2D UP = new Coord2D(0,-1); 
	protected  static Coord2D DOWN = new Coord2D(0,1); 
	protected  static Coord2D LEFT = new Coord2D(-1,0); 
	protected  static Coord2D RIGHT = new Coord2D(1,0); 
	
	public Coord2D(int x, int y){
		X=x; 
		Y=y;
	}
	
	public Coord2D invert(){
		return new Coord2D(-X,-Y);
	}
	
	public Coord2D add(Coord2D aAddCoord){
		return new Coord2D(X + aAddCoord.X, Y + aAddCoord.Y);
	}
	
	public Coord2D sub(Coord2D aAddCoord){
		return new Coord2D(X - aAddCoord.X, Y - aAddCoord.Y);
	}
	
	
	public Coord2D scale(int aVal){
		return new Coord2D(X * aVal, Y * aVal);
	}
	
	public Coord2D scale(float fVal){
		return new Coord2D(Math.round((float)X * fVal), Math.round((float)Y * fVal));
	}
	
	public static Coord2D getDirection(EDirection aDir){
		switch(aDir){
			case Up:
				return UP;
			case Down:
				return DOWN;
			case Left:
				return LEFT;
			default:
				return RIGHT;
		}
	}
}
