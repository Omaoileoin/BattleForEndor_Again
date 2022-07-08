//class file for the DeathStar asset
public class DeathStar {

	//class variables
	private String image;
	private double x;
	private double y;
	private int width;
	private int height;
	private int speed;

	//constructor assigning variable values 
	public DeathStar(double x, double y) {
		this.image = "Assets/DeathStar.png";
		this.x = x;
		this.y = y;
		this.width = 200;
		this.height = 200;
		this.speed = 7;
	}

	//drawing DS to the screen
	public void draw() {
		StdDraw.picture(x, y, image, width, height);
	}

	//changing DS y values so they move down the screen
	public void move() {
		this.y += this.speed;
	}

	//getter for DS x value for other classes to access
	public double getX() {
		return this.x;
	}

	//getter for DS y value for other classes to access
	public double getY() {
		return this.y;
	}
}