package game.controller;


import game.model.Direction;

/**
 * Created by Kydp9 on 07.08.2016.
 */
public interface EventListener
 {

    void move(Direction direction);
     void click(double x , double y);
    void restart();
    void startNextLevel();
    void levelCompleted(int level);
void  gameOver();
     void  mouseMoved(double x , double y);

}
