package paket;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Human extends NPC {

	public Human(int x, int y, int sizeX, int sizeY, ID id, int speed, Color color, Handler handler) {
		super(x, y, sizeX, sizeY, id, speed, color, handler);
		
		
	}

	protected void brain() {
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
	
	public void render(Point sc, Graphics g) {
		g.setColor(color);
		g.fillRect(x - (sizeX / 2) + Game.ScreenCenter.x - sc.x, y - (sizeY / 2) + Game.ScreenCenter.y - sc.y, sizeX, sizeY);
	}

	public Rectangle getBounds() {
		return new Rectangle(x - (sizeX / 2), y - (sizeY / 2), sizeX, sizeY);
	}

}
