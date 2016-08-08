package game.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by ikydp on 08.08.2016.
 */
public class Aim extends GameObject {
    public Aim(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.PINK);

        int leftUpperCornerX = getX() - getWidth() / 2;
        int leftUpperCornerY = getY() - getHeight() / 2;
        Image im = null;
        try {
            im = ImageIO.read(new File("C:\\Gameshoot\\src\\main\\java\\game\\res\\aim.png"));
        } catch (IOException e) {}
        graphics.drawImage(im, getX()-50, getY()-50,100, 100, null);
    }
}
