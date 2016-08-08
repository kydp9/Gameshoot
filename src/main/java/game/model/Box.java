package game.model;

import java.awt.*;
import java.util.Random;

/**
 * Created by Kydp9 on 07.08.2016.
 */
public class Box extends  CollisionObject  implements  Movable
{   private  Color customColor;
    public Box(int x, int y)
    {
        super(x, y);
        Random random = new Random();
        int red = random.nextInt(254);
        int green = random.nextInt(254);
                int bluy =random.nextInt(254);
        this.customColor = new Color(red,green,bluy);
        if(red<100 && green < 100 && bluy < 100)
        {
            this.customColor = (Color.green);
        }

    }



    @Override
    public void move(int x, int y)
    {
        this.setX(this.getX() + x);
        this.setY(this.getY() + y);
    }

    @Override
    public void draw(Graphics graphics)
    {
        graphics.setColor(customColor);
        int leftUpperCornerX = getX() - getWidth() / 2;
        int leftUpperCornerY = getY() - getHeight() / 2;

        graphics.drawRect(leftUpperCornerX, leftUpperCornerY, getWidth(), getHeight());
        graphics.fillRect(leftUpperCornerX, leftUpperCornerY, getWidth(), getHeight());
    }
}
