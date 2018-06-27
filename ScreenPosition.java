package paket;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class ScreenPosition {
	
	Point sp;
	Player player;
	Point prevPlayerPos;
	int maxPCD;

	public ScreenPosition(Point sp, Player player, int maxPCD) {
		this.sp = sp;
		this.player = player;
		this.maxPCD = maxPCD;
		this.prevPlayerPos = new Point(player.getX(), player.getY());
	}
	
	public Point getSP() {
		return sp;
	}
	
	public void tick() {
		if (GetplayerCenterDistance() > maxPCD) {
			sp.x += player.getX() - prevPlayerPos.x;
			sp.y += player.getY() - prevPlayerPos.y;
		}
		
		prevPlayerPos.x = player.getX();
		prevPlayerPos.y = player.getY();

	}
	
	private double GetplayerCenterDistance() {
		int dX = player.getX() - sp.x;
		int dY = player.getY() - sp.y;
		double distance = Math.sqrt((dX * dX) + (dY * dY));
		return distance;
		
	}
	
}
