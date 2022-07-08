//Game2 class extends Game class. runs everything exactly the same, except removes win conditions based on time,
//enabling infinite play time.
public class Game2 extends Game {

	public Game2() {
		super();
	}

	public void update() {
		controller.update();
		long now = System.currentTimeMillis();
		this.timer++;

		if (now - this.startTime > 300 && this.timer > 190) {
			scene.addTieFighter();
			this.startTime = now;
		}

		if (now - this.nodeTime > 1750 && this.timer > 190) {
			scene.addNode();
			this.nodeTime = now;
		}

		if (now - this.destroyerTime > 4000 && this.timer > 240) {
			scene.addStarDestroyer();
			this.destroyerTime = now;
		}

		if (now - this.deathTime > 7000 && this.timer > 280) {
			scene.addDeathStar();
			this.deathTime = now;
		}
		
		scene.update();
		Player player = scene.getPlayer();
		Endor endor = scene.getEndor();

		for (PowerNode node : scene.getNodes()) {
			if (player.isTouching(node)) {
				this.energy++;
			}
		}

		if (energy >= 20) {
			energy = 0;
			boost++;
			scene.getTieFighters().clear();
		}

		if (StdDraw.hasNextKeyTyped() == true) {
			char key = StdDraw.nextKeyTyped();
			if (key == 'f' && boost >= 1) {
				scene.getStarDestroyers().clear();
				scene.getDeathStars().clear();
				boost--;
			}
		}

		for (Enemy tiefighter : scene.getTieFighters()) {
		if (player.isTouching(tiefighter)) {
			isOver = true;
			for (int i = 0; i < 1000; i++) {
					crawl4.draw();
					update();
				}
			}
		}

		for (StarDestroyer destroyer : scene.getStarDestroyers()) {
			if (player.isTouching(destroyer)) {
				isOver = true;
				for (int i = 0; i < 1000; i++) {
					crawl4.draw();
					update();
				}
			}
		}

		for (DeathStar deathstar : scene.getDeathStars()) {
			if (player.isTouching(deathstar)) {
				isOver = true;
				for (int i = 0; i < 1000; i++) {
					crawl4.draw();
					update();
				}
			}
		}
	}
}