package paket;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject {
	
	private Random r = new Random();
	private Handler handler;
	private int speed;
	private NPC npc = null;
	
	public Player(int x, int y, int sizeX, int sizeY, ID id, int speed, Handler handler) {
		super(x, y, sizeX, sizeY, id);
		this.handler = handler;
		this.speed = speed;
	}
	
	public void startMoveUp() {
		velY -= 5;
	}
	
	public void stopMoveUp() {
		velY += 5;
	}

	public void startMoveDown() {
		velY += 5;
	}
	
	public void stopMoveDown() {
		velY -= 5;
	}

	public void startMoveLeft() {
		velX -= 5;
	}
	
	public void stopMoveLeft() {
		velX += 5;
	}

	public void startMoveRight() {
		velX += 5;
	}
	
	public void stopMoveRight() {
		velX -= 5;
	}
	
	public void setSpeed(int speed) {
		this.speed =speed;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setNPC(NPC npc) {
		this.npc = npc;
	}
	
	public NPC getNPC() {
		return npc;
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		if (npc != null) {
			x = npc.getX();
			y = npc.getY();
		}
		
		collision();
	}
	
	private void collision() {
		for (int i = 0; i < handler.object.size(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			
			/*if (tempObject.getID() == ID.BasicEnemy) {
				if (getBounds().intersects(tempObject.getBounds())) {
					// collision code
					
					HUD.HEALTH -= 1;
				}
			}*/
			
		}
	}
	
	public void render(Point sc, Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x - (sizeX / 2) + Game.ScreenCenter.x - sc.x, y - (sizeY / 2) + Game.ScreenCenter.y - sc.y, sizeX, sizeY);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x - (sizeX / 2), y - (sizeY / 2), sizeX, sizeY);
	}
	
}
