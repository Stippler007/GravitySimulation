/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stippler.martin;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.image.BufferStrategy;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Stippler
 */
public class Game extends JFrame
{
  private List<Circle> circles;
  public static int WIDTH=800;
  public static int HEIGHT=600;
          
  public static void main(String[] args)
  {
    Game game = new Game();
    game.setSize(WIDTH,HEIGHT);
    game.setLocationRelativeTo(null);
    game.setResizable(false);
    game.setVisible(true);
    game.makeStrat();
    game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    game.run();
  }

  private BufferStrategy strat;

  public void run()
  {
    this.circles=createTestData();
    
    
    long lastFrame = System.currentTimeMillis();
    while (true)
    {
      long thisFrame = System.currentTimeMillis();
      float tslf = (float) (thisFrame - lastFrame) / 1000;
      lastFrame = thisFrame;
      
      for (int i = 0; i < circles.size(); i++)
      {
        circles.get(i).update(tslf);
      }
      repaintScreen();
      try
      {
        Thread.sleep(15);
      }
      catch (InterruptedException ex)
      {}
    }
  }
  private List<Circle> createTestData()
  {
    List<Circle> circles=new ArrayList<>();
    
    circles.add(new Circle(getWidth()/4, getHeight()/4, 10, circles));
    circles.add(new Circle(getWidth()/3, getHeight()/3, 10, circles));
    Random r=new Random();
//    for (int i = 3; i < 4; i++)
//    {
//      for (int j = 3; j < 500; j++)
//      {
//        circles.add(new Circle(getWidth()/i, getHeight()/j, r.nextInt(10)+1,circles));
//      }
//    }
//    
    return circles;
  }
  public void makeStrat()
  {
    createBufferStrategy(2);
    strat = getBufferStrategy();
  }

  public void repaintScreen()
  {
    Graphics2D g = (Graphics2D) strat.getDrawGraphics();
    draw(g);
    g.dispose();
    strat.show();
  }

  private void draw(Graphics2D g)
  {
    g.clearRect(0, 0, getWidth(), getHeight());
    circles.forEach(c->c.draw(g));
  }
}
