package game.view;



import game.controller.Controller;
import game.controller.EventListener;
import game.model.GameObjects;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class View extends JFrame {
    private Controller controller;
    private Field field;
   private EventListener eventListener;
    public View(Controller controller) {
        this.controller = controller;
    }

    public void init() {



        field = new Field(this);
        add(field);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(820, 840);
        setLocationRelativeTo(null);
        setTitle("Shooter=( ");
        setVisible(true);
this.createBufferStrategy(2);

// попытка ускорить
        /*
        createBufferStrategy(2);
        BufferStrategy strategy = getBufferStrategy();
        long lastLoopTime = System.currentTimeMillis();

        while (true) {
            // work out how long its been since the last update, this
            // will be used to calculate how far the entities should
            // move this loop
            long delta = System.currentTimeMillis() - lastLoopTime;
            lastLoopTime = System.currentTimeMillis();

            // Get hold of a graphics context for the accelerated
            // surface and blank it out
            Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
            g.setColor(Color.black);
            g.fillRect(0,0,800,600);

            // finally, we've completed drawing so clear up the graphics
            // and flip the buffer over
            g.dispose();
            strategy.show();

            // finally pause for a bit. Note: this should run us at about
            // 100 fps but on windows this might vary each loop due to
            // a bad implementation of timer
            try { Thread.sleep(10); } catch (Exception e) {}
        }
         */
    }

   public void setEventListener(EventListener      eventListener){
        field.setEventListener(eventListener);
    }
public  void update()
{
    this.field.repaint();
}


    public GameObjects getGameObjects(){
        return   controller.getGameObjects();
    }
  public void completed(int level)
  {
      this.update();
      JOptionPane.showMessageDialog(null, level + "Completed", "Level", JOptionPane.INFORMATION_MESSAGE);
      controller.startNextLevel();
  }
    public void gameOver()
    {
        this.update();
        JOptionPane.showMessageDialog(null, "Game OVER", "yes it is OVER", JOptionPane.INFORMATION_MESSAGE);
        controller.restart();
    }


}
