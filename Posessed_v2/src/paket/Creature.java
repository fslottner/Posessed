package paket;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

public abstract class Creature extends GameObject {
	
	protected Random r = new Random();
	protected Handler handler;
	protected Color color;
	protected int speed;
	
	protected ArrayList<Ability> abilities = new ArrayList<Ability>();

	public Creature(int x, int y, int sizeX, int sizeY, ID id, int speed, Color color, Handler handler) {
		super(x, y, sizeX, sizeY, id);
		this.speed = speed;
		this.color = color;
		this.handler = handler;
	}
	
	public void startMoveUp() {
		velY -= speed;
	}
	
	public void stopMoveUp() {
		velY += speed;
	}

	public void startMoveDown() {
		velY += speed;
	}
	
	public void stopMoveDown() {
		velY -= speed;
	}

	public void startMoveLeft() {
		velX -= speed;
	}
	
	public void stopMoveLeft() {
		velX += speed;
	}

	public void startMoveRight() {
		velX += speed;
	}
	
	public void stopMoveRight() {
		velX -= speed;
	}
	

	public void setSpeed(int speed) {
		this.speed =speed;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	@Override
	public void tick() {
		
		velX = Library.clamp(velX, -speed, speed);
		velY = Library.clamp(velY, -speed, speed);
		
		super.tick();
	}
	
}
