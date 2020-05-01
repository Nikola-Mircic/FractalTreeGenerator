package fractaltree.screen;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import fractaltree.input.Input;

public class Screen extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private Input input;
	
	private int width;
	private int height;
	
	private int angle = 90;
	private int treeLenght = 100;
	
	public boolean drawing = false;
	public boolean movingDir = false;
	private int xDir;
	private int yDir;
	
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		input = new Input(this);
		
		addMouseListener(input);
		addMouseMotionListener(input);
		addMouseWheelListener(input);
	}
	
	public void paint(Graphics g) {
			clearScreen(g);
			drawTree(width/2, height*3/4, treeLenght, angle, g);
			if(movingDir){
			drawDir(xDir, yDir, g);

		}
	}
	
	private void clearScreen(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
	}
	
	
	private void drawTree(int xs,int ys,double lenght,double angle, Graphics g) {
		if(lenght>10) {
			//drawing = true;
			double radians = angle*2*Math.PI/360;
			int x = (int)(xs+Math.cos(radians)*lenght);
			int y = (int)(ys-Math.sin(radians)*lenght);
		
			g.setColor(Color.WHITE);
			g.drawLine(xs, ys, x, y);
			
			drawTree(x, y, lenght*0.80, angle+20, g);
			drawTree(x, y, lenght*0.80, angle-20, g);
		}
	}
	
	private void drawDir(int x,int y, Graphics g) {
		g.setColor(Color.RED);
		g.drawLine(width/2, height*3/4, x, y);
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public void setAngle(int a) {
		this.angle = a;
	}
	
	public void setTreeLenght(int lenght) {
		this.treeLenght = lenght;
	}
	
	public void addTreeLenght(int lenght) {
		this.treeLenght += lenght;
	}
	
	public int getTreeLenght() {
		return this.treeLenght;
	}
	
	public void setXDir(int xDir) {
		this.xDir = xDir;
	}
	
	public void setYDir(int yDir) {
		this.yDir = yDir;
	}
}
