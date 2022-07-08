//class file for player class
public class Player {
	
	//class variables
	private String image;
	private double x;
	private double y;
	private int width;
	private int height;
	private int speed;

	//constructor assigning variable values
	public Player(double x, double y) {
		this.image = "Assets/xwing.png";
		this.x = x;
		this.y = y;
		this.width = 80;
		this.height = 40;
		this.speed = 12;
	}

	//draws player to the screen
	public void draw() {
		StdDraw.picture(x, y, image, width, height);
	}

	//moves player to new x,y location
	public void move(double x, double y) {
		this.x = x;
		this.y = y;
	}

	//getter for x location so other classes can access
	public double getX() {
		return this.x;
	}

	//getter for y location so other classes can access
	public double getY() {
		return this.y;
	}

	//getter for speed so other classes can access
	public double getSpeed() {
		return this.speed;
	}

	//lines 48-103 compares player location to all other asset locations on the screen to accomplish various game mechanics
	public boolean isTouchingX(PowerNode gameObject) {
		int hitbox = 60;
		return this.x <= gameObject.getX() + hitbox && gameObject.getX() <= this.x + hitbox;
	}

	public boolean isTouchingY(PowerNode gameObject) {
		int hitbox = 30;
		return this.y <= gameObject.getY() + hitbox && gameObject.getY() <= this.y + hitbox;
	}

	public boolean isTouching(PowerNode gameObject) {
		return this.isTouchingX(gameObject) && this.isTouchingY(gameObject);
	}

	public boolean isTouchingX(Enemy gameObject) {
		int hitbox = 60;
		return this.x <= gameObject.getX() + hitbox && gameObject.getX() <= this.x + hitbox;
	}

	public boolean isTouchingY(Enemy gameObject) {
		int hitbox = 30;
		return this.y <= gameObject.getY() + hitbox && gameObject.getY() <= this.y + hitbox;
	}

	public boolean isTouching(Enemy gameObject) {
		return this.isTouchingX(gameObject) && this.isTouchingY(gameObject);
	}

	public boolean isTouchingX(StarDestroyer gameObject) {
		int hitbox = 80;
		return this.x <= gameObject.getX() + hitbox && gameObject.getX() <= this.x + hitbox;
	}

	public boolean isTouchingY(StarDestroyer gameObject) {
		int hitbox = 40;
		return this.y <= gameObject.getY() + hitbox && gameObject.getY() <= this.y + hitbox;
	}

	public boolean isTouching(StarDestroyer gameObject) {
		return this.isTouchingX(gameObject) && this.isTouchingY(gameObject);
	}

	public boolean isTouchingX(DeathStar gameObject) {
		int hitbox = 100;
		return this.x <= gameObject.getX() + hitbox && gameObject.getX() <= this.x + hitbox;
	}

	public boolean isTouchingY(DeathStar gameObject) {
		int hitbox = 100;
		return this.y <= gameObject.getY() + hitbox && gameObject.getY() <= this.y + hitbox;
	}

	public boolean isTouching(DeathStar gameObject) {
		return this.isTouchingX(gameObject) && this.isTouchingY(gameObject);
	}
}