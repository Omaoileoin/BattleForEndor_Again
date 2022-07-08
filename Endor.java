//class file for Endor asset
public class Endor {

	//class variables
	private String image;
	private double x;
	private double y;
	private int width;
	private int height;

	//constructor assigning variable values
	public Endor(double x, double y) {
		this.image = "Assets/Endor.png";
		this.x = x;
		this.y = y;
		this.width = 500;
		this.height = 500;
	}

	//drawing Endor to the screen
	public void draw() {
		StdDraw.picture(x, y, image, width, height);
	}

	//getter for Endor x value for other classes to access
	public double getX() {
		return this.x;
	}

	//getter for Endor y value for other classes to access
	public double getY() {
		return this.y;
	}
}