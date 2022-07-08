public class Controller {

	private Player player;

	public Controller(Player player) {
		this.player = player;
	}

	//player movement is controlled by the mouse. when the mouse button is pressed, the player moves in the direction of the cursor
	//until the button is let go
	public void onMousePress() {
		if (StdDraw.mousePressed()) {
			double mouseX = StdDraw.mouseX();
			double mouseY = StdDraw.mouseY();
			double playerX = player.getX();
			double playerY = player.getY();

			if (mouseY < playerY) playerY -= player.getSpeed();
			if (mouseY > playerY) playerY += player.getSpeed();
			if (mouseX < playerX) playerX -= player.getSpeed();
			if (mouseX > playerX) playerX += player.getSpeed();
			player.move(playerX, playerY);
		}
	}

	public void update() {
		onMousePress();
	}
}