package game.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by ikydp on 08.08.2016.
 */
public class Boom extends GameObject {
    public Boom(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void draw(Graphics graphics) {


        graphics.setColor(Color.RED);

        int leftUpperCornerX = getX() - getWidth() / 2;
        int leftUpperCornerY = getY() - getHeight() / 2;

        graphics.drawOval(leftUpperCornerX, leftUpperCornerY, getWidth(), getHeight());
        graphics.fillOval(leftUpperCornerX, leftUpperCornerY, getWidth(), getHeight());

        Image im = null;

        try {
            im = ImageIO.read(new File("C:\\Gameshoot\\src\\main\\java\\game\\res\\Exp_type_A.png"));
        } catch (IOException e) {}
        graphics.drawImage(im,1600,128,1725,120, getX(), getY(),getWidth(), getHeight(), null);


    }
}
