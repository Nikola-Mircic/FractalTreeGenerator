package fractaltree;

import java.awt.Dimension;

import javax.swing.JFrame;

import fractaltree.input.Input;
import fractaltree.screen.Screen;

public class FractalTree extends JFrame implements Runnable{
	private static final long serialVersionUID = 1L;
	
	private String TITLE = "Fractal Tree";
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 800;
	
	private boolean running = false;
	Thread t;
	
	private static Screen s;
	private static Input input;
	
	private FractalTree(){
		setTitle(TITLE);
		setSize(new Dimension(WIDTH, HEIGHT));
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void start() {
		if(running) return;
		t = new Thread(this);
		running = true;
	}
	
	private void stop() {
		if(!running) return;
		running = false;
		System.exit(0);
	}

	public static void main(String[] args) {
		FractalTree app = new FractalTree();
		s = new Screen(WIDTH, HEIGHT);
		input = new Input(s);
		
		app.add(s);
		app.addKeyListener(input);
		app.start();
	}

	@Override
	public void run() {
		running = true;
	}

}
