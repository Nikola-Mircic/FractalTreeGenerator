package fractaltree.input;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import fractaltree.screen.Screen;

public class Input implements KeyListener,MouseListener,MouseMotionListener,MouseWheelListener{
	
	private Screen screen;
	private double startTreeLenght;
	
	public Input(Screen screen) {
		this.screen = screen;
		this.startTreeLenght = screen.getTreeLenght();
	}
	
	private double calculateAngleRad(int xs, int ys, int x, int y) {
		double radians;
		//cos |xs-x|/koren iz (xs-x)^2+(ys-y)^2b
		radians = Math.acos(-(xs-x)/Math.sqrt((xs-x)*(xs-x)+(ys-y)*(ys-y)));
		return radians;
	}
	
	private int calculateAngleDeg(int xs,int ys,int x, int y) {
		return (int)(360*calculateAngleRad(xs, ys, x, y)/(2*Math.PI));
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		screen.addTreeLenght((int)(startTreeLenght*(20-e.getWheelRotation())/20-startTreeLenght));
		screen.repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		screen.setXDir(e.getX());
		
		if(e.getY()<=screen.getHeight()*3/4)
			screen.setYDir(e.getY());
		else
			screen.setYDir(screen.getHeight()*3/4);
		
		screen.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		screen.movingDir = true;
		screen.setXDir(e.getX());
		screen.setYDir(e.getY());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		int x = e.getX();
		int y = Math.min(screen.getHeight()*3/4, e.getY());
		int deg;
		if(y == screen.getHeight()*3/4) {
			if(x>=screen.getWidth()/2){
				deg = 0;
			}else {
				deg = 180;
			}
		}else {
			deg = calculateAngleDeg(screen.getWidth()/2, screen.getHeight()*3/4, x, y);
		}
		screen.movingDir = false;
		screen.setAngle(deg);
		screen.setTreeLenght((int)Math.sqrt((screen.getWidth()/2-x)*(screen.getWidth()/2-x)+
							 (screen.getHeight()*3/4-y)*(screen.getHeight()*3/4-y)));
		startTreeLenght = screen.getTreeLenght();
		screen.repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
