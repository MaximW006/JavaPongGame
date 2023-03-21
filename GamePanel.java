import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable{
 
  static final int gameWidth = 500;
	static final int gameHeight = (int)(gameWidth * (0.5555));
	static final Dimension screenSize = new Dimension(gameWidth,gameHeight);
	static final int ballDiameter = 20;
	static final int paddleWidth = 25;
	static final int paddleHeight = 100;
	Thread gameThread;
	Image image;
	Graphics graphics;
	Random random;
	Paddle paddleOne;
	Paddle paddleTwo;
	Ball ball;
	Score score;

  GamePanel(){
    newPaddles();
    newBall();
  }

  public void newBall() {
    random = new Random();
    ball = new Ball((gameWidth/2)-(ballDiameter/2),random.nextInt(gameHeight-ballDiameter),ballDiameter,ballDiameter);
  }

  public void newPaddles(){
    paddleOne = new Paddle(0,(gameHeight/2) - (gameHeight/2), paddleWidth, paddleHeight, 1);
    paddleTwo = new Paddle(gameWidth - paddleWidth, (gameHeight/2) - (paddleHeight/2), paddleWidth, paddleHeight, 2);
    
  }
  public void paint(Graphics g) {
    image = createImage(getWidth(), getHeight());
    graphics = image.getGraphics();
    draw(graphics);
    g.drawImage(image, 0, 0, this);
  }
  public void draw(Graphics g) {
    paddleOne.draw(g);
    paddleTwo.draw(g);
    ball.draw(g);
    score.draw(g);
    Toolkit.getDefaultToolkit().sync();  }

 public void move() {
   paddleOne.move();
   paddleTwo.move();
   ball.move();
   
 }
public void checkCollision() {
		
		//bounce ball off top & bottom window edges
		if(ball.y <=0) {
			ball.setYDirection(-ball.yVelocity);
		}
		if(ball.y >= gameHeight-ballDiameter) {
			ball.setYDirection(-ball.yVelocity);
		}
		//bounce ball off paddles
		if(ball.intersects(paddleOne)) {
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity++; //optional for more difficulty
			if(ball.yVelocity>0)
				ball.yVelocity++; //optional for more difficulty
			else
				ball.yVelocity--;
			ball.setXDirection(ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
		}
		if(ball.intersects(paddleTwo)) {
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity++; //optional for more difficulty
			if(ball.yVelocity>0)
				ball.yVelocity++; //optional for more difficulty
			else
				ball.yVelocity--;
			ball.setXDirection(-ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
		}
		//stops paddles at window edges
		if(paddleOne.y<=0)
			paddleOne.y=0;
		if(paddleOne.y >= (gameHeight-paddleHeight))
			paddleOne.y = gameHeight-paddleHeight;
		if(paddleTwo.y<=0)
			paddleTwo.y=0;
		if(paddleTwo.y >= (gameHeight-paddleHeight))
			paddleTwo.y = gameHeight-paddleHeight;
		//give a player 1 point and creates new paddles & ball
		if(ball.x <=0) {
			score.playerTwo++;
			newPaddles();
			newBall();
			System.out.println("Player 2: "+score.playerTwo);
		}
		if(ball.x >= gameWidth-ballDiameter) {
			score.playerOne++;
			newPaddles();
			newBall();
			System.out.println("Player 1: "+score.playerOne);
		}
	}
	public void run() {
		//game loop
		long lastTime = System.nanoTime();
		double amountOfTicks =60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		while(true) {
			long now = System.nanoTime();
			delta += (now -lastTime)/ns;
			lastTime = now;
			if(delta >=1) {
				move();
				checkCollision();
				repaint();
				delta--;
			}
		}
	}
	public class AL extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			paddleOne.keyPressed(e);
			paddleTwo.keyPressed(e);
		}
		public void keyReleased(KeyEvent e) {
			paddleOne.keyReleased(e);
			paddleTwo.keyReleased(e);
		}
	}
}