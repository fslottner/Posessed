package paket;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public abstract class GameObject {
	
	protected int x, y;
	protected ID id;
	protected int velX, velY;
	protected int sizeX, sizeY;
	
	public GameObject(int x, int y, int sizeX, int sizeY, ID id) {
		this.x = x;
		this.y = y;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.id = id;
	}
	
	public void setX(int x) {
		this. x = x;
	}
	
	public void setY(int y) {
		this. y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setID(ID id) {
		this. id = id;
	}
	
	public ID getID() {
		return id;
	}
	
	public void setVelX(int velX) {
		this.velX = velX; 
	}
	
	public void setVelY(int velY) {
		this.velY = velY; 
	}
	
	public int getVelX() {
		return velX; 
	}
	
	public int getVelY() {
		return velY; 
	}
	
	public int getSizeX() {
		return sizeX; 
	}
	
	public int getSizeY() {
		return sizeY; 
	}
	
	protected void tick() {
		x += velX;
		y += velY;
	}
	
	//public abstract void tick();
	public abstract void render(Point sc, Graphics g);
	public abstract Rectangle getBounds();
	

}
