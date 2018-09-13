package paket;

import java.util.LinkedList;

public class Library {
	
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

}
