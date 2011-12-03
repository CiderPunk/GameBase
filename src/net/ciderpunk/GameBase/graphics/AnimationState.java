package net.ciderpunk.GameBase.graphics;


public class AnimationState{
	protected IFrame oCurrentCell;
	protected int iCellIndex;
	protected long lFrameCount;
	protected Animation oCurrentAnim;
	
	public void startAnim(Animation oAnim){
		iCellIndex = 0;
		lFrameCount = 0;
		oCurrentAnim = oAnim;
		oCurrentCell = NullFrame.getInstance();
	}
	
	public long getFrameCount(){
		return lFrameCount;
	}
	
	public IFrame getFrame(){
		return oCurrentCell;
	}
	
	public void update(){
		lFrameCount++;
		oCurrentAnim.update(this);
	}
	
}