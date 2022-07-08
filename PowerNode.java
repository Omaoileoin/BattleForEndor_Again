//class file for PN class
public class PowerNode {

	//class variables
	private String image;
	private double x;
	private double y;
	private int width;
	private int height;
	private int speed;

	//constructor assigning variable values
	public PowerNode(double x, double y) {
		this.image = "Assets/node.png";
		this.x = x;
		this.y = y;
		this.width = 32;
		this.height = 32;		
		this.speed = (int) (3 + Math.random() * 10);
	}

	//drawning PNs to the screen
	public void draw() {
		StdDraw.picture(x, y, image, width, height);
	}

	//moving the PNs location so it moves down the screen
	public void move() {
		this.y += this.speed;
	}

	//getter for PNs x value so other classes can access
	public double getX() {
		return this.x;
	}

	//getter for PNs y value so other classes can access
	public double getY() {
		return this.y;
	}
}