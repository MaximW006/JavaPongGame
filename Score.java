import java.awt.*;

public class Score extends Rectangle {
  static int gameWidth;
  static int gameHeight;
  int playerOne;
  int playerTwo;
  
  Score(int gameWidth, int gameHeight) {
    Score.gameWidth = gameWidth;
    Score.gameHeight = gameHeight;
    
  }
  public void draw(Graphics g){
    g.setColor(Color.white);
    g.setFont(new Font("Times New Roman", Font.PLAIN, 60));   
    g.drawString(String.valueOf(playerOne/10)+String.valueOf(playerOne/10)); 
    g.drawString(String.valueOf(playerTwo/10)+String.valueOf(playerTwo%10));
  }
}