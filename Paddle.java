import java.awt.*;
import java.awt.event.*;

public class Paddle extends Rectangle {
  int id;
  int yVelocity;
  int speed = 30;

  Paddle(int x, int y, int paddleWidth, int paddleHeight, int id) {
    super(x, y, paddleWidth, paddleHeight);
    this.id = id;
  }

  public void keyPressed(KeyEvent e) {
    switch (id) {
      case 1:
        if (e.getKeyCode() == KeyEvent.VK_W) {
          setYDirection(-speed);
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
          setYDirection(speed);
        }
        break;
      case 2:
        if (e.getKeyCode() == KeyEvent.VK_UP) {
          setYDirection(-speed);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
          setYDirection(speed);
        }
        break;
    }
  }

  public void keyRelease(KeyEvent e) {
    switch (id) {
      case 1:
        if (e.getKeyCode() == KeyEvent.VK_W) {
          setYDirection(0);
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
          setYDirection(0);
        }
        break;
      case 2:
        if (e.getKeyCode() == KeyEvent.VK_UP) {
          setYDirection(0);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
          setYDirection(0);
        }
        break;
    }
  }

  public void setYDirection(int yDirection) {
    yVelocity = yDirection;
  }

  public void move() {
    y = y + yVelocity;
    // y += yVelocity;
  }

  public void draw(Graphics g) {
    if (id == 1) {
      g.setColor(Color.blue);
    } else {
      g.setColor(Color.red);
    }
    g.fillRect(x, y, width, height);
  }
}