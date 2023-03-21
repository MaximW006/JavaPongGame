import java.awt.*;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;


class Ball extends Rectangle{

  Random random;
  int xVelocity;
  int yVelocity;
  int initialSpeed = 2;

  Ball(int x, int y, int width, int height){
    super(x,y,width,height);
    random = new Random();
    int randomXDirection = random.nextInt(2);
    if(randomXDirection == 0) {
      randomXDirection --;
    }
    setXDirection(randomXDirection * initialSpeed);

    int randomYDirection = random.nextInt(2);
    if(randomYDirection == 0) {
      randomYDirection --;
    }
    setYDirection(randomYDirection *initialSpeed);
    
  }
  // X
  public void setXDirection(int randomXDirection) {
    xVelocity = randomXDirection;
  }
  


  // Y
  public void setYDirection(int randomYDirection){
    yVelocity = randomYDirection;
  }
  
}

