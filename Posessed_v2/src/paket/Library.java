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

	public static double getDistance(GameObject obj1, GameObject obj2) {
		int dX = obj2.getX() - obj1.getX();
		int dY = obj2.getY() - obj1.getY();

		double distance = Math.sqrt((dX * dX) + (dY * dY));

		return distance;

	}

	public static <T> LinkedList<T> filterClass(Class<T> c, LinkedList<GameObject> inList) {
		LinkedList<T> outList = new LinkedList<T>();

		for (GameObject obj: inList) {

			if (obj.getClass() == c) {

				T objT = null;
				try {
					objT = c.cast(obj);
					outList.add(objT);

				} catch (ClassCastException e) {
					// this shouldn't really happen anyway
				}

			}

		}
		return outList;
	}

	public static LinkedList<GameObject> filterDistance(GameObject centerObject, LinkedList<GameObject> inList,
			int rad) {
		LinkedList<GameObject> outList = new LinkedList<GameObject>();

		for (GameObject obj: inList) {

			if (getDistance(centerObject, obj) <= rad) {
				outList.add(obj);
			}

		}
		return outList;
	}
	
	public static <T> T getClosest(GameObject centerObject, LinkedList<T> inList) {
		T closestObject = null;
		double minDistance = 0;
		
		for (T obj: inList) {
			double distance = getDistance(centerObject,(GameObject) obj);

			if (distance < minDistance) {
				closestObject = obj;
				minDistance = distance;
			}

		}
		
		return closestObject;
	}

}
