//importing java package used in class file
import java.awt.Font;

//class file for end game crawl depending on the game outcome
public class Crawl3 {

	//crawl variables
	private String image;
	private int x;
	private int y;
	private int y2;
	private int y3;
	private int width;
	private int height;
	private int timer;
	private long startTime;
	private long crawl3Time;
	private int speed;

	//crawl constructor assigning variable values
	public Crawl3() {		
		this.image = "Assets/RebelFleet.jpg";
		this.x = 270;
		this.y = 570;
		this.y2 = 600;
		this.y3 = 630;
		this.width = 540;
		this.height = 540;
		this.timer = 0;
		startTime = System.currentTimeMillis();
		crawl3Time = System.currentTimeMillis();
		this.speed = 7;
		StdDraw.setCanvasSize(width, height);
		StdDraw.setXscale(0.0, width);
		StdDraw.setYscale(height, 0.0);
	}

	//drawing the new scene and words to the screen
	public void draw() {
		long now = System.currentTimeMillis();
		this.crawl3Time = now;	
		StdDraw.picture(width / 2, height / 2, image);			
		Font font = new Font("News Gothic", Font.BOLD, 30);
		StdDraw.setFont(font);
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.text(x, y, "What an Ace Pilot!");
		StdDraw.text(x, y2, "The Rebel Fleet has arrived!");
		StdDraw.text(x, y3, "Endor is saved!");
		StdDraw.show(100);
		move();
	}

	//moving the y location of the words up the screen
	public void move() {
		this.y -= this.speed;
		this.y2 -= this.speed;
		this.y3 -= this.speed;
	}
}