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
					//tempObject.setVelY(tempObject.getVelY() - 5);
					p.startMoveUp();
					break;
				case KeyEvent.VK_DOWN:
					//tempObject.setVelY(tempObject.getVelY() + 5);
					p.startMoveDown();
					break;
				case KeyEvent.VK_LEFT:
					//tempObject.setVelX(tempObject.getVelX() - 5);
					p.startMoveLeft();
					break;
				case KeyEvent.VK_RIGHT:
					//tempObject.setVelX(tempObject.getVelX() + 5);
					p.startMoveRight();
					break;
				}

				tempObject.setVelY(Game.clamp(tempObject.getVelY(), -5, 5));

				tempObject.setVelX(Game.clamp(tempObject.getVelX(), -5, 5));

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
					//tempObject.setVelY(tempObject.getVelY() + 5);
					p.stopMoveUp();
					break;
				case KeyEvent.VK_DOWN:
					//tempObject.setVelY(tempObject.getVelY() - 5);
					p.stopMoveDown();
					break;
				case KeyEvent.VK_LEFT:
					//tempObject.setVelX(tempObject.getVelX() + 5);
					p.stopMoveLeft();
					break;
				case KeyEvent.VK_RIGHT:
					//tempObject.setVelX(tempObject.getVelX() - 5);
					p.stopMoveRight();
					break;
				}

				tempObject.setVelY(Game.clamp(tempObject.getVelY(), -5, 5));

				tempObject.setVelX(Game.clamp(tempObject.getVelX(), -5, 5));

			}

		}
	}

}
