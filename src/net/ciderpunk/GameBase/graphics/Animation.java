package net.ciderpunk.GameBase.graphics;

import java.util.ArrayList;


public class Animation {

	private  ArrayList<Cell> aCells;
	private long lTotalFrames;
	private boolean bLoop;
	
	//constructors
	public Animation(){
		this(true);
	}
	
	public Animation(boolean loop){
		aCells = new ArrayList<Cell>();
		bLoop = loop;
	}
	
	/*
	//add a new cell to an animation sequence
	public void addFrame(Frame oFrame, long lDelay){
		addFrame((IFrame) oFrame, lDelay);
	}
	*/
	//add a new cell to an animation sequence
	public void addFrame(IFrame oFrame, long lFrames){
		lTotalFrames += lFrames;
		aCells.add(new Cell(oFrame, lTotalFrames));
	}
	
	//update an instance of the animation
	public void update(AnimationState oState){
		if (oState.lFrameCount > lTotalFrames){
			if (bLoop){
				oState.iCellIndex = 0;
				oState.lFrameCount = 0;
			}
			else{
				return;
			}
		}
		while( ((Cell) aCells.get(oState.iCellIndex)).lFrames < oState.lFrameCount){
			oState.iCellIndex++;
		}
		oState.oCurrentCell =  (IFrame) ((Cell) aCells.get(oState.iCellIndex)).oFrame;
	}

	
	protected class Cell{
		IFrame oFrame;
		long lFrames;
		public Cell(IFrame frame, long time){
			oFrame = frame;
			lFrames = time;
		}
	}
	

	
	
}
