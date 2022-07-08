//class file for SD class
public class StarDestroyer {

	//class variables
	private String image;
	private double x;
	private double y;
	private int width;
	private int height;
	private int speed;

	//constructor assigning variable vaules
	public StarDestroyer(double x, double y) {
		this.image = "Assets/StarDestroyer.png";
		this.x = x;
		this.y = y;
		this.width = 150;
		this.height = 150;		
		this.speed = 7;
	}

	//drawing SD to the screen
	public void draw() {
		StdDraw.picture(x, y, image, width, height);
	}

	//changing SD y values to move them down the screen
	public void move() {
		this.y += this.speed;
	}

	//getter for SD x value so other classes can access
	public double getX() {
		return this.x;
	}

	//getter for SD y value so other classes can access
	public double getY() {
		return this.y;
	}
}