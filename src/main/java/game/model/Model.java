package game.model;




import game.controller.EventListener;

import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;


/**
 * Created by Kydp9 on 07.08.2016.
 */
public class Model
{   private  GameObjects gameObjects;
    private int currentLevel = 666;
    public EventListener eventListener;
    public  static  final int FIELD_SELL_SIZE = 20;
    public    static  final int FIELD_MULTIPLER = 2;
    public  static final int FIELD_MAX = FIELD_MULTIPLER*FIELD_SELL_SIZE*FIELD_SELL_SIZE;
    LevelLoader levelLoader = new LevelLoader();
    public void setEventListener(EventListener      eventListener) {
        this.eventListener = eventListener;
    }
public  GameObjects getGameObjects(){
    return gameObjects;
}

    public void restartLevel(int level) {
        this.gameObjects = levelLoader.getLevel();
    }

    public void restart() {
        restartLevel(currentLevel);
    }
    public void startNextLevel() {
        currentLevel = currentLevel + 1;
        restartLevel(currentLevel);
    }


    public void click(double x, double y)
    {  int px = gameObjects.getPlayer().getX();
        int py = gameObjects.getPlayer().getY();
       gameObjects.getBullets().add(new Bullet(px,py,10,40,x,y));

    }
    public void mouseAim(double x, double y)
    {   gameObjects.getAim().setX((int)x);
        gameObjects.getAim().setY((int)y);


    }
    public void update()
    {Random random = new Random();
        Player player = gameObjects.getPlayer();

            for(Box box : gameObjects.getBoxes())
            {  box.move(random.nextInt(10)-5,random.nextInt(10)-5);
                for(Bullet bullet : gameObjects.getBullets())
                {

                if(bullet.isIntersec(box) )
                {
                    bullet.setLive(false);
                    box.setLive(false);
                    /*
                    Boom boom = new Boom(bullet.getX(),bullet.getY(),50,50);
                    */
                }
                if(box.isIntersec(player))
                {
                    player.setLive(false);
                }
                if(box.isOUT())
                {
                    box.setLive(false);
                }
                if(bullet.isOUT())
                {
                    bullet.setLive(false);
                }
                    bullet.move((int)bullet.getTarx(),(int)bullet.getTary());

            }
        }
if(gameObjects.getBoxes().size()<21){

   if( random.nextInt(10) == 5)
   {
       int one = random.nextInt(Model.FIELD_SELL_SIZE) *Model.FIELD_SELL_SIZE*Model.FIELD_MULTIPLER + Model.FIELD_SELL_SIZE / 2;
       int two = random.nextInt(Model.FIELD_SELL_SIZE) *Model.FIELD_SELL_SIZE*Model.FIELD_MULTIPLER+ Model.FIELD_SELL_SIZE / 2;

       if( Math.abs(player.getX()-one)> Model.FIELD_SELL_SIZE*3 && Math.abs(player.getY()-two) >Model.FIELD_SELL_SIZE*3) {
           gameObjects.getBoxes().add(new Box(one, two));
       }
   }

}



             removeDead();
        checkCompletion();
    }


    public void move(Direction direction)
    {

        Player player = gameObjects.getPlayer();

        if (checkWallCollision(player, direction)) {
            return;
        }
        if (checkBoxCollision(direction)){
            return;
        }

        int sellSize = FIELD_SELL_SIZE;
        switch (direction) {
            case LEFT:
                player.move(-sellSize, 0);
                break;
            case RIGHT:
                player.move(sellSize, 0);
                break;
            case UP:
                player.move(0, -sellSize);
                break;
            case DOWN:
                player.move(0, sellSize);
        }



        for(Bullet bullet : gameObjects.getBullets())
        {
            bullet.move((int)bullet.getTarx(),(int)bullet.getTary());
        }

        checkCompletion();




    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction){

        for (Wall wall : gameObjects.getWalls()){

            if(gameObject.isCollision(wall, direction)){
                return true;
            }
        }
        return false;
    }


    public boolean checkBoxCollision(Direction direction){

        Player player = gameObjects.getPlayer();

        // найдем во что уперся игрок
        GameObject  stoped = null;
        for (GameObject gameObject: gameObjects.getAll()){
            if (!(gameObject instanceof Player) && player.isCollision(gameObject, direction)){
                stoped = gameObject;
            }
        }

        if ((stoped == null)){
            return false;
        }
        if (stoped instanceof Box){

         player.setLive(false);

    }

        return false;

    }

    public void checkCompletion() {



            if(!gameObjects.getPlayer().isLive())
            {
                eventListener.gameOver();
            }
        }

    public void removeDead()
    {

        if(!gameObjects.getBullets().isEmpty()) {
            Iterator<Bullet> iter = gameObjects.getBullets().iterator();

            while (iter.hasNext()) {
                Bullet fake = iter.next();

                if (!fake.isLive())
                    iter.remove();
            }
        }
        if(!gameObjects.getBoxes().isEmpty()) {
            Iterator<Box> iter = gameObjects.getBoxes().iterator();

            while (iter.hasNext()) {
                Box fake = iter.next();

                if (!fake.isLive())
                    iter.remove();
            }
        }

    }

}
