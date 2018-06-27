package paket;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5265788895333134855L;

	public static final int WIDTH = 1000, HEIGHT = WIDTH / 12 * 9;
	
	public static final Point ScreenCenter = (new Point(WIDTH / 2, HEIGHT / 2));

	private Thread thread;
	private boolean running = false;

	private ScreenPosition screenPosition;
	private Random r;
	private Handler handler;
	private HUD hud; 
	
	private Player player;

	public Game() {

		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));

		new Window(WIDTH, HEIGHT, "Posessed", this);
		
		hud = new HUD();

		r = new Random();
		
		player = new Player(WIDTH / 2, HEIGHT / 2, 50, 50, ID.Player, 5, handler);
		
		screenPosition = new ScreenPosition((new Point(WIDTH / 2, HEIGHT / 2)), player, 220);

		handler.addObject(player);
		handler.addObject(new NPC(100, 100, 30, 30, ID.NPC, 7, Color.blue, handler));
		handler.addObject(new NPC(450, 200, 60, 60, ID.NPC, 3, Color.green, handler));
	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running)
				render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;

			}
		}
		stop();

	}

	private void tick() {
		handler.tick();
		hud.tick();
		screenPosition.tick();
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		Point sp = screenPosition.getSP();
		
		handler.render(sp, g);
		
		hud.render(g);

		g.dispose();
		bs.show();

	}

	public static int clamp(int var, int min, int max) {
		if (var >= max)
			return var = max;
		if (var <= min)
			return var = min;
		else
			return var;
	}
	
	public static double distance(GameObject obj1, GameObject obj2) {
		int dX = obj2.getX() - obj1.getX();
		int dY = obj2.getY() - obj1.getY();
		
		double distance = Math.sqrt((dX * dX) + (dY * dY));
		
		return distance;
	}

	public static void main(String args[]) {
		new Game();
	}

}
