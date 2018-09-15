package paket;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Random;

public class Player extends Creature{
	
	private NPC npc = null;
	int posessRange;
	
	public Player(int x, int y, int sizeX, int sizeY, ID id, int speed, int posessRange, Color color, Handler handler) {
		super(x, y, sizeX, sizeY, id, speed, color, handler);
		this.handler = handler;
		this.speed = speed;
		this.posessRange = posessRange;
	}
	
	public void setNPC(NPC npc) {
		this.npc = npc;
	}
	
	public NPC getNPC() {
		return npc;
	}
	
	@Override
	public void startMoveUp() {
		if (npc == null) {
			super.startMoveUp();
		} else {
			npc.startMoveUp();
		}
		
	}

	@Override
	public void startMoveDown() {
		if (npc == null) {
			super.startMoveDown();
		} else {
			npc.startMoveDown();
		}
		
	}

	@Override
	public void startMoveLeft() {
		if (npc == null) {
			super.startMoveLeft();
		} else {
			npc.startMoveLeft();
		}
		
	}

	@Override
	public void startMoveRight() {
		if (npc == null) {
			super.startMoveRight();
		} else {
			npc.startMoveRight();
		}
		
	}

	@Override
	public void stopMoveUp() {
		if (npc == null) {
			super.stopMoveUp();
		} else {
			npc.stopMoveUp();
		}
		
	}

	@Override
	public void stopMoveDown() {
		if (npc == null) {
			super.stopMoveDown();
		} else {
			npc.stopMoveDown();
		}
		
	}

	@Override
	public void stopMoveLeft() {
		if (npc == null) {
			super.stopMoveLeft();
		} else {
			npc.stopMoveLeft();
		}
		
	}

	@Override
	public void stopMoveRight() {
		if (npc == null) {
			super.stopMoveRight();
		} else {
			npc.stopMoveRight();
		}
		
	}
	
	public void quickPosessCheck() {
		NPC closestNPC = Library.getClosest(this, Library.filterClass(NPC.class, handler.object));
		if (closestNPC != null) {
			System.out.println("NPC");
			if (Library.getDistance(this, closestNPC) <= posessRange) {
				posess(closestNPC);
				System.out.println("close");
				
			}
		}

	}
	
	public void posess(NPC npc) {
		
		velX = 0;
		velY = 0;
		x = npc.getX();
		y = npc.getY();
		this.npc = npc;

		npc.setUseBrainF();
	}
	
	public void unposess() {
		npc = null;
	}
	
	public void tick() {
		
		if (npc != null) {
			x = npc.getX();
			y = npc.getY();
		}
		
		super.tick();
		
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
