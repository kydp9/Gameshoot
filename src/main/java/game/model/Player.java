package game.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Kydp9 on 04.08.2016.
 */
public class Player extends CollisionObject  implements  Movable
{

    public Player(int x, int y)
    {
        super(x, y);

    }

    public Player(int x, int y, int width, int height) {
        super(x, y, width, height);
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




        graphics.setColor(Color.PINK);

        int leftUpperCornerX = getX() - getWidth() / 2;
        int leftUpperCornerY = getY() - getHeight() / 2;
/*
        graphics.drawOval(leftUpperCornerX, leftUpperCornerY, getWidth(), getHeight());
        graphics.fillOval(leftUpperCornerX, leftUpperCornerY, getWidth(), getHeight());
*/
        Image im = null;
        try {

            InputStream is = this.getClass().getResourceAsStream( "/images/player0000.png" );
            im = ImageIO.read(is);

        } catch (IOException e) {}
        graphics.drawImage(im, leftUpperCornerX, leftUpperCornerY,getWidth(), getHeight(), null);


    }
}
