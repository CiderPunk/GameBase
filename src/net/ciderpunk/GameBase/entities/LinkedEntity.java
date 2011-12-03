package net.ciderpunk.GameBase.entities;

public class LinkedEntity {

	protected LinkedEntity oNext;
	protected LinkedEntity oPrev;
	
	public synchronized void remove(){
		if (oNext != null){
			oNext.oPrev = oPrev;
		}
		oPrev.oNext = oNext;
		oNext = null;
		oPrev = null;
	}
	
	public synchronized void insert(LinkedEntity e){
		if (oNext != null){
			oNext.oPrev = e;
		}
		e.oNext = oNext;
		e.oPrev = this;
		oNext = e;
	}
	
	public synchronized LinkedEntity getNext(){
		return oNext;
	}
	
	
}
