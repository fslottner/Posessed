package paket;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;

public class NPC extends GameObject {
	
	private Random r = new Random();
	private Handler handler;
	private Color color;
	private int speed;
	private boolean useBrain = true;
	
	public NPC(int x, int y, int sizeX, int sizeY, ID id, int speed, Color color, Handler Handler) {
		super(x, y, sizeX, sizeY, id);
		this.handler = handler;
		this.color = color;
		this.speed = speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setUseBrainT() {
		useBrain = true;
	}
	
	public void setUseBrainF() {
		useBrain = false;
	}
	
	public void toggleUseBrain() {
		if (useBrain) useBrain = false;
		else useBrain = true;
	}
	
	public void brain() {
		int rNr = r.nextInt(1000);
		if (rNr == 0) {
			int dir = r.nextInt(8);
			switch (dir) {
			case 0:
				velX = 0;
				velY = 0;
				break;
			case 1:
				velX = 0;
				velY = -speed;
				break;
			case 2:
				velX = speed;
				velY = -speed;
				break;
			case 3:
				velX = speed;
				velY = 0;
				break;
			case 4:
				velX = speed;
				velY = speed;
				break;
			case 5:
				velX = 0;
				velY = speed;
				break;
			case 6:
				velX = -speed;
				velY = speed;
				break;
			case 7:
				velX = -speed;
				velY = 0;
				break;
			case 8:
				velX = -speed;
				velY = -speed;
				break;
			}
		}
	}

	public void tick() {
		
		if (useBrain) brain();

		x += velX;
		y += velY;
		
	}

	public void render(Point sc, Graphics g) {
		g.setColor(color);
		g.fillRect(x - (sizeX / 2) + Game.ScreenCenter.x - sc.x, y - (sizeY / 2) + Game.ScreenCenter.y - sc.y, sizeX, sizeY);
	}

	public Rectangle getBounds() {
		return new Rectangle(x - (sizeX / 2), y - (sizeY / 2), sizeX, sizeY);
	}

}
