package game.model;

import java.awt.*;

/**
 * Created by Kydp9 on 07.08.2016.
 */
public abstract class GameObject
{
       int x ;
      int y;
    private  int width;
    private    int height;

    public GameObject(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public GameObject(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.width =  Model.FIELD_SELL_SIZE*2;
        this.height = Model.FIELD_SELL_SIZE*2;
    }


  public abstract void draw(Graphics graphics);

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }
}
