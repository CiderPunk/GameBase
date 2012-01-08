package net.ciderpunk.GameBase.Utils;

public class Direction{
	public static EDirection getDirection(int iDir){
		switch(iDir){
		case 0:
			return EDirection.Up;
		case 1:
			return EDirection.Down;
		case 2:
			return EDirection.Left;
		default:
			return EDirection.Right;
		}
	}
	
	
	public static EDirection OppositeDir(EDirection dir){
		switch(dir){
			case Up:
				return EDirection.Down;
			case Down:
				return EDirection.Up;
			case Left:
				return EDirection.Right;
			default:
				return EDirection.Left;
		}
	}
}