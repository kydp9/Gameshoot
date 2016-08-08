package game.controller;


import game.model.Direction;
import game.model.GameObjects;
import game.model.Model;
import game.view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Controller implements  EventListener
{    private View view ;
    private Model model;
private boolean gamerun;
    public boolean isGamerun() {
        return gamerun;
    }


   // попытка ускорить
   private static final long NANOSECOND        = 1000000000;
    private static final double OPTIMAL_TICKS   = 30.0;
    private static final double OPTIMAL_TIME    = NANOSECOND / OPTIMAL_TICKS;
    private long lastLoopTime = System.nanoTime ();
    private long currentTime;
    private double deltaTime;
    private long secondTimer = System.currentTimeMillis ();
   // ------------------------------------

    public void setGamerun(boolean gamerun) {
        this.gamerun = gamerun;
    }

    public Controller()
    {    model = new Model();
        view = new View(this);
        model.restart();
        model.setEventListener(this);

gamerun= true;
        view.init();
        view.setEventListener(this);

    }
  public GameObjects getGameObjects(){
    return   model.getGameObjects();
  }

    public static void main(String[] args) {
        Controller controller = new Controller();

        // попытка ускорить
        /*
        while (controller.isGamerun())
        {
            controller.currentTime = System.nanoTime ();
            controller.deltaTime += (controller.currentTime - controller.lastLoopTime) / OPTIMAL_TIME;
            controller.lastLoopTime = controller.currentTime;
            while (controller.deltaTime >= 1) {
                controller.model.update ();
                controller.view.update();
                controller.deltaTime--;
            }
            if (System.currentTimeMillis () - controller.secondTimer > 1000) {

               controller.secondTimer += 1000;
            }
        }
        */

        Timer t = new Timer(1000/60, new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.model.update();
                controller.view.update();


            }
        });
        t.setRepeats(true);
        t.start();



    }

    @Override
    public void restart()
    {
        model.restart();
        view.update();
    }

    @Override
    public void startNextLevel()
    {
model.startNextLevel();
        view.update();
    }

    @Override
    public void levelCompleted(int level)
    {
view.completed(level);
    }

    @Override
    public void gameOver() {
        setGamerun(false);
        view.gameOver();

    }

    @Override
    public void mouseMoved(double x , double y) {

        model.mouseAim(x,y);
      //  view.update();
    }

    @Override
    public void move(Direction direction)
    {
model.move(direction);
     //   view.update();
    }

    @Override
    public void click(double x, double y) {
        model.click(x,y);
        view.update();
    }



}
