package net.ciderpunk.GameBase;

import java.awt.*;
import java.awt.image.BufferStrategy;

import javax.swing.*;

public class Screen extends Canvas  implements Runnable
{
	
	JFrame oFrame;
	protected BufferStrategy oBuffer;
	IGameState oCurrentState;
	
	
  private Screen(Dimension oSize)
  {
		oFrame = new JFrame("Tanktris");
		JPanel oPanel = (JPanel) oFrame.getContentPane();
	
		this.setSize(oSize);
		setPreferredSize(oSize);
		setMinimumSize(oSize);
		setMaximumSize(oSize);
		oPanel.setSize(oSize);
		oPanel.add(this);
		oFrame.pack();	
		setBounds(0,0,oSize.width, oSize.height);
		oFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		oFrame.setVisible(true);
		oFrame.setIgnoreRepaint(true);
		oFrame.setResizable(false);	
		oFrame.setLocationRelativeTo(null);
		this.createBufferStrategy(2);
		oBuffer = this.getBufferStrategy();
//		this.addKeyListener(this);
  }
  
  
	//updates display
	public void Update(){
		BufferStrategy oBS = this.getBufferStrategy();
		if (!oBS.contentsLost()){
			oBS.show();
		}
	}
  


	public void run(IGameState oInitialState) {
		oCurrentState = oInitialState;
		double fTimePerFrame = 1000.0f / 60.0f;
		long lTicks = 0;
		long lLastTime, lStartTime;
		lLastTime = lStartTime = System.currentTimeMillis();
		System.out.println("started");
		while (oCurrentState != null){
			//update current state
			oCurrentState.update();
			//draw stuff
			Graphics2D oG = (Graphics2D) oBuffer.getDrawGraphics();
	
			//oG.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
			oCurrentState.draw(oG);
			oG.dispose();
			
			//flip buffers
			if (!oBuffer.contentsLost()){
				oBuffer.show();
			}

			//get time till next frame.
			lTicks++;
			long lNextFrame = (long) Math.floor(fTimePerFrame * lTicks) + lStartTime;
			long lDiff = lNextFrame - System.currentTimeMillis();
			//check for long delays
			if (lDiff < -20){
				//reset
				lStartTime = System.currentTimeMillis();
				lTicks = 0;
				System.out.println("frame resynch, delay: " + lDiff);
			}
			
			while(lDiff > 6){
			//	try { Thread.sleep(lDiff / 2); } catch (Exception e) {}
				try { Thread.sleep(1); } catch (Exception e) {}
				lDiff = lNextFrame - System.currentTimeMillis();
			}
		}
		oFrame.dispose();
		//close
	}


	public void stop(){
		setState(null);
	}
	
	
	
	protected void setState(IGameState oState){
		if(oCurrentState != null){
			oCurrentState.stop(this);
		}
		oCurrentState = oState;
		if(oCurrentState != null){
			oCurrentState.start(this);
		}
	
	}
	
	

	
/*
	public void keyPressed(KeyEvent e){
		int iKeyCode = e.getKeyCode();
		if (iKeyCode == KeyEvent.VK_ESCAPE){
			this.stop();
		}
	}


	public void keyReleased(KeyEvent arg0) {
	}



	public void keyTyped(KeyEvent arg0) {
	}
*/

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
 

}