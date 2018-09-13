package paket;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

	private Handler handler;

	public KeyInput(Handler handler) {
		this.handler = handler;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			if (tempObject.getID() == ID.Player) {
				// keyEvents for player
				
				Player p = (Player) tempObject;

				switch (key) {
				case KeyEvent.VK_UP:
					p.startMoveUp();
					break;
				case KeyEvent.VK_DOWN:
					p.startMoveDown();
					break;
				case KeyEvent.VK_LEFT:
					p.startMoveLeft();
					System.out.println("left pressed");
					break;
				case KeyEvent.VK_RIGHT:
					p.startMoveRight();
					break;
				case KeyEvent.VK_SPACE:
					if (p.getNPC() == null) {
						p.posess((NPC) handler.object.get(1)); 
					}
				}

				tempObject.setVelY(Library.clamp(tempObject.getVelY(), -5, 5));

				tempObject.setVelX(Library.clamp(tempObject.getVelX(), -5, 5));

			}

			if (key == KeyEvent.VK_ESCAPE)
				System.exit(0);

		}

	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			if (tempObject.getID() == ID.Player) {
				// keyEvents for player
				
				Player p = (Player) tempObject;
				
				switch (key) {
				case KeyEvent.VK_UP:
					p.stopMoveUp();
					break;
				case KeyEvent.VK_DOWN:
					p.stopMoveDown();
					break;
				case KeyEvent.VK_LEFT:
					p.stopMoveLeft();
					System.out.println("left key released");
					break;
				case KeyEvent.VK_RIGHT:
					p.stopMoveRight();
					break;
				}

				tempObject.setVelY(Library.clamp(tempObject.getVelY(), -5, 5));

				tempObject.setVelX(Library.clamp(tempObject.getVelX(), -5, 5));

			}

		}
	}

}
