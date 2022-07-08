//importing ArrayList package
import java.util.ArrayList;

//class file for scene class
public class Scene {
		
	private String image;
	private int width;
	private int height;
	private ArrayList<Enemy> tiefighters;
	private ArrayList<PowerNode> nodes;
	private ArrayList<StarDestroyer> stardestroyers;
	private ArrayList<DeathStar> deathstars;
	private Player player;
	private Endor endor;
	private Crawl crawl;

	//constructor assigning variable values
	public Scene() {
		width = 540;
		height = 540;
		image = "Assets/space-background.png";
		nodes = new ArrayList<PowerNode>(); //array list for multiple assets
		tiefighters = new ArrayList<Enemy>(); //array list for multiple assets
		stardestroyers = new ArrayList<StarDestroyer>(); //array list for multiple assets
		deathstars = new ArrayList<DeathStar>(); //array list for multiple assets
		crawl = new Crawl();
		StdDraw.setCanvasSize(width, height);
		StdDraw.setXscale(0.0, width);
		StdDraw.setYscale(height, 0.0);
	}

	//drawning background scene and calling all of the assets draw methods to draw them to screen
	public void draw() {
		StdDraw.picture(width / 2, height / 2, image);
		endor.draw();
		crawl.draw();
		player.draw();

		//calling draw methods and drawing multiples of each asset to the screen
		for (PowerNode node : nodes) {
			node.draw();
		}

		for (Enemy tiefighter : tiefighters) {
			tiefighter.draw();
		}

		for (StarDestroyer stardestroyer : stardestroyers) {
			stardestroyer.draw();
		}

		for (DeathStar deathstar : deathstars) {
			deathstar.draw();
		}
	}

	//add methods for each asset for the game to call them to the screen at the stated intervals in the game class. assigning starting positions
	public void addNode() {
		double x = 32 + (Math.random() * (width - 64));
		double y = -32;
		PowerNode zap = new PowerNode(x, y);
		nodes.add(zap);
	}

	public void addTieFighter() {
		double x = 32 + (Math.random() * (width - 64));
		double y = -32;
		Enemy ship = new Enemy(x, y);
		tiefighters.add(ship);
	}

	public void addStarDestroyer() {
		double x = 32 + (Math.random() * (width - 64));
		double y = - 75;
		StarDestroyer fly = new StarDestroyer(x, y);
		stardestroyers.add(fly);
	}

	public void addDeathStar() {
		double x = 32 + (Math.random() * (width - 64));
		double y = - 100;
		DeathStar buzz = new DeathStar(x, y);
		deathstars.add(buzz);
	}

	//calling each asset's move method to update their positions on the screen
	public void update() {
		for (PowerNode node : nodes) {
			node.move();
		}

		for (Enemy tiefighter : tiefighters) {
			tiefighter.move();
		}

		for (StarDestroyer stardestroyer : stardestroyers) {
			stardestroyer.move();
		}

		for (DeathStar deathstar : deathstars) {
			deathstar.move();
		}
	}	

	//getter and setter methods for each asset to be able to know where to drawn them to the screen
	public Player getPlayer() {
		return this.player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Endor getEndor() {
		return this.endor;
	}

	public void setEndor(Endor endor) {
		this.endor = endor;
	}

	public ArrayList<PowerNode> getNodes() {
		return this.nodes;
	}

	public ArrayList<Enemy> getTieFighters() {
		return this.tiefighters;
	}

	public ArrayList<StarDestroyer> getStarDestroyers() {
		return this.stardestroyers;
	}	

	public ArrayList<DeathStar> getDeathStars() {
		return this.deathstars;
	}
}