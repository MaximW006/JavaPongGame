import java.awt.*;
import java.util.*;
import javax.swing.*;

public class GameFrame extends JFrame{
  GamePanel myPanel;

  GameFrame (){
    myPanel = new GamePanel();
    this.add(myPanel);
    this.setTitle("Pong Game");
    this.setBackground(Color.black);
    this.setVisible(true);
    this.pack();
    this.setLocationRelativeTo(null);
  }
}