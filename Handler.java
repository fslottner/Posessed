package paket;

import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;

public class Handler {

	LinkedList<GameObject> object = new LinkedList<GameObject>();

	public void tick() {
		for (int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);

			tempObject.tick();
		}
	}

	public void render(Point sc, Graphics g) {
		for (int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);

			tempObject.render(sc, g);
		}
	}

	public void addObject(GameObject object) {
		this.object.add(object);
	}

	public void removeObject(GameObject object) {
		this.object.remove(object);
	}

	public <T> LinkedList<T> filter(Class<T> c) {
		LinkedList<GameObject> inList = object;
		LinkedList<T> outList = new LinkedList<T>();

		for (int i = 0; i < object.size(); i++) {

			GameObject obj = inList.getFirst();
			if (obj.getClass() == c) {
				
				T objT = null;
				try {
					objT = c.cast(obj);
				} catch (ClassCastException e) {
					//this shouldn't really happen anyway
				}
				
				outList.add(objT);
			}
			inList.removeFirst();

		}
		return outList;
	}

}
