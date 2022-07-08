//class file for Enemy TIE Fighter asset
public class Enemy {

	//class variables
	private String image;
	private double x;
	private double y;
	private int width;
	private int height;
	private int speed;

	//constructor assigning variable values
	public Enemy(double x, double y) {
		this.image = "Assets/tiefighter.png";
		this.x = x;
		this.y = y;
		this.width = 50;
		this.height = 50;
		this.speed = (int) (3 + Math.random() * 10);
	}

	//drawing TIEs to the screen
	public void draw() {
		StdDraw.picture(x, y, image, width, height);
	}

	//changing TIEs y value so they move down the screen
	public void move() {
		this.y += this.speed;
	}

	//getter for TIEs x value so other classes can access
	public double getX() {
		return this.x;
	}

	//getter for TIEs y value so other classes can access
	public double getY() {
		return this.y;
	}
}