//importing java package used in class file
import java.awt.Font;

//class file for opening game crawl showing game title
public class Crawl {

	//crawl variables
	private String image;
	private int x;
	private int y;
	private int y2;
	private int y3;
	private int y4;
	private int width;
	private int height;
	private int timer;
	private long startTime;
	private long crawlTime;
	private int speed;

	//crawl constructor assigning variable values
	public Crawl() {		
		this.image = "Assets/StarWars.png";
		this.x = 270;
		this.y = 685;
		this.y2 = 1140;
		this.y3 = 1200;
		this.y4 = 1260;
		this.width = 400;
		this.height = 160;
		this.timer = 0;
		startTime = System.currentTimeMillis();
		crawlTime = System.currentTimeMillis();
		this.speed = 7;
	}

	//drawing the title image and words to the screen
	public void draw() {
		long now = System.currentTimeMillis();
		this.crawlTime = now;
		StdDraw.picture(x, y, image, width, height);			
		Font font = new Font("News Gothic", Font.BOLD, 50);
		StdDraw.setFont(font);
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.text(x, y2, "Episode X");
		StdDraw.text(x, y3, "Battle for Endor...");
		StdDraw.text(x, y4, "Again");
		move();
	}

	//moving the y location of the title up the screen
	public void move() {
		this.y -= this.speed;
		this.y2 -= this.speed;
		this.y3 -= this.speed;
		this.y4 -= this.speed;
	}
}