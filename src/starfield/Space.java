
package starfield;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;


/**
 *
 * @author 802709
 */
public class Space extends JPanel {
    
    final int marginX;
    final int marginY;
    private Hero hero;
    private Enemy enemy;
    private Timer timer;    
    
    public Space () {
        super ();
        marginX = 10;
        marginY = 10;
        hero = new Hero(600, 480, Color.CYAN, 20, "dude");
        enemy = new Enemy (50, 50, Color.RED, 20, "Enemy");
        timer = new Timer () ;      
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 100);
}
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        
         g.setColor(Color.WHITE);
         g.setColor(Color.RED);
         g.setColor(Color.GREEN);
         g.setColor(Color.BLUE);
         g.setColor(Color.CYAN);
         g.setColor(Color.ORANGE);
         g.setColor(Color.MAGENTA);
         
         drawStars(g);
         
         hero.draw(g);
         enemy.draw(g);
         //hero.kill();
        //g.dispose();
    }         
      private class ScheduleTask extends TimerTask {	    	   
        @Override
        public void run() {
            
            hero.update();
            enemy.update();
            wallCollisions(hero);
             wallCollisions(enemy);
            repaint();
        }
      }
      public void keyPressed(KeyEvent e) {
          if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
              hero.setDX(4);
          }
          else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
              hero.setDX(-4);
          }
           else if (e.getKeyCode() == KeyEvent.VK_UP) {
              hero.setDY(-4);
          }
           else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
              hero.setDY(4);
          }
           
           else if (e.getKeyCode() == KeyEvent.VK_D) {
              hero.setDX(2);
          }
           else if (e.getKeyCode() == KeyEvent.VK_A) {
              hero.setDX(-2);
          }
            else if (e.getKeyCode() == KeyEvent.VK_W) {
              hero.setDX(-2);
          }
            else if (e.getKeyCode() == KeyEvent.VK_S) {
              hero.setDY(2);
          } 
      }   
        public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            hero.setDX(0);
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            hero.setDX(0);
        if (e.getKeyCode() == KeyEvent.VK_UP)
            hero.setDY(0);
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
            hero.setDY(0);
        if (e.getKeyCode() == KeyEvent.VK_W)
            hero.setDY(0);
        if (e.getKeyCode() == KeyEvent.VK_A)
            hero.setDY(0);
        if (e.getKeyCode() == KeyEvent.VK_S)
            hero.setDY(0);
        if (e.getKeyCode() == KeyEvent.VK_D)
            hero.setDY(0);
        }
   public void drawStars(Graphics g) {
       int x = 0;
       int y = 0;
       for (int i  =  0;  i < 100; i++) {
       
       int rand1 = (int) (Math.random() * 960)  ;
       int rand2 = (int) (Math.random() * 1200)  ;
       //int rand3 = (int) (Math.random() * 100.0) + 1 ;
        x = rand1 ;
        y = rand2;
        
        g.fillOval (x , y , 3, 3);
        
        Color curr = g.getColor();
          if (x % 2 == 0) 
              g.setColor(curr.brighter());
          else
              g.setColor(curr.darker());
          g.fillOval(x, y, 3, 3);
        
        
        System.out.println(rand1+" "+rand2);   
        }
        }
     //Makes the hero and enemy bounce off walls  
    private void wallCollisions(Character c) {
        //walls = this.getWidth(), 0 , this.getHeight(), 0 
        
        if (c.getX()<= 0 || c.getX() >= this.getWidth() ) {
            c.reverseX();
        }
         if (c.getY() <= 0 || c.getY() >= this.getHeight()) {
            c.reverseY();
        }
        //hero's location = hero.getX(), hero.getY()
    }
   } 
    

