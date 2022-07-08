//importing java packages used in the class
import java.awt.Font;
import java.util.Scanner;

//class file to run the game
public class Game {

	//class variables
	public Scene scene;
	public boolean isOver;
	public int width;
	public int height;
	public int timer;
	public int energy;
	public int boost;
	public long startTime;
	public long nodeTime;
	public long destroyerTime;
	public long deathTime;
	public Crawl2 crawl2;
	public Crawl3 crawl3;
	public Crawl4 crawl4;
	public Controller controller;

	//constructor assigning variable values
	public Game() {
		scene = new Scene();
		isOver = false;
		this.width = 540;
		this.height = 540;
		this.timer = 0;
		this.energy = 0;
		this.boost = 0;
		startTime = System.currentTimeMillis();
		nodeTime = System.currentTimeMillis();
		destroyerTime = System.currentTimeMillis();
		deathTime = System.currentTimeMillis();
		crawl2 = new Crawl2();
		crawl3 = new Crawl3();
		crawl4 = new Crawl4();
		Player player = new Player(250, 187.5);
		Endor endor = new Endor(650, 270);
		this.scene.setPlayer(player);
		this.scene.setEndor(endor);
		controller = new Controller(player);
	}

	//class main method stating what order to run methods in
	public static void main (String [] args) {

		Scanner scanner = new Scanner(System.in);
		Game game = null;
		System.out.println("Press 1 for normal gameplay.");
		System.out.println("Press 2 to see how long you can survive.");
		int numOne = scanner.nextInt();
		
		if (numOne == 1) {
			game = new Game();
		}

		if (numOne == 2) {
			game = new Game2();
		}

		//while loop to continually update the game while isOver == false
		while (game.isOver == false) {
			game.update();

			//when isOver is false calls game render method
			if (game.isOver == false) {
				game.render();
			}
		}
	}

	//update method to add assets to the screen and do general scene updates
	public void update() {
		controller.update();
		long now = System.currentTimeMillis();
		this.timer++;

		//adding TIEs to the screen at stated intervals
		if (now - this.startTime > 300 && this.timer > 190) {
			scene.addTieFighter();
			this.startTime = now;
		}

		//adding power nodes to the screen at stated intervals
		if (now - this.nodeTime > 1750 && this.timer > 190) {
			scene.addNode();
			this.nodeTime = now;
		}

		//adding SDs to the screen at stated intervals
		if (now - this.destroyerTime > 4000 && this.timer > 240) {
			scene.addStarDestroyer();
			this.destroyerTime = now;
		}	

		//adding DSs to the screen at stated intervals
		if (now - this.deathTime > 7000 && this.timer > 280) {
			scene.addDeathStar();
			this.deathTime = now;
		}
		
		//calling other class update methods	
		scene.update();
		Player player = scene.getPlayer();
		Endor endor = scene.getEndor();

		//updating the energy counter if player is touching a power node
		for (PowerNode node : scene.getNodes()) {
			if (player.isTouching(node)) {
				this.energy++;
			}
		}	

		//adding 1 to the boost counter when energy gets to 20, clearing TIEs off the screen, and resetting energy counter
		if (energy >= 20) {
			energy = 0;
			boost++;
			scene.getTieFighters().clear();
		}

		//clearing SDs and DSs off the screen if 'f' is pressed and the player has at least one energy boost, then subtracting 1 from the boost counter
		if (StdDraw.hasNextKeyTyped() == true) {
			char key = StdDraw.nextKeyTyped();
			if (key == 'f' && boost >= 1) {
				scene.getStarDestroyers().clear();
				scene.getDeathStars().clear();
				boost--;
			}
		}

		//player wins if the timer reaches 125 and has at least 5 boosts remaining. calls the crawl3 draw method for a slightly different end screen
		if ((timer / 5) >= 125 && boost >= 5) {
			isOver = true;
			for (int i = 0; i < 1000; i++) {
				crawl3.draw();
				update();
			}
		}

		//player wins if the timer reaches 125. calls the crawl2.draw method
		if ((timer / 5) >= 125) {
			isOver = true;
			for (int i = 0; i < 1000; i++) {
				crawl2.draw();
				update();
			}
		}

		//player loses if player touches TIE. calls the crawl4 draw method.
		for (Enemy tiefighter : scene.getTieFighters()) {
			if (player.isTouching(tiefighter)) {
				isOver = true;
				for (int i = 0; i < 1000; i++) {
					crawl4.draw();
					update();
				}
			}
		}


		//player loses if player touches SD. calls the crawl4 draw method.
		for (StarDestroyer destroyer : scene.getStarDestroyers()) {
			if (player.isTouching(destroyer)) {
				isOver = true;
				for (int i = 0; i < 1000; i++) {
					crawl4.draw();
					update();
				}
			}
		}

		//player loses if player touches DS. calls the crawl4 draw method.
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

	//draws HUD info on the game screen
	public void render() {
		scene.draw();
		Font font = new Font("News Gothic", Font.BOLD, 20);
		StdDraw.setFont(font);
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.text(40, 20, "Time: " + timer / 5);
		StdDraw.text(440, 20, "Energy Counter: " + energy);
		StdDraw.text(440, 40, "Power Boost: " + boost);
		StdDraw.show(100);
	}
}