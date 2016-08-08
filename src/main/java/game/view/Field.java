package game.view;



import game.controller.EventListener;
import game.model.Boom;
import game.model.Direction;
import game.model.GameObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

/**
 * Created by Kydp9 on 07.08.2016.
 */
public class Field extends JPanel
{   private EventListener eventListener;
    private View view;

    public Field(View view)
    {
        this.view = view;
        this.addKeyListener(new KeyHandler());
        this.addMouseListener(new MyMouseListener());
        this.setFocusable(true);


    }

    @Override
    public void paint(Graphics g)
    {



        Image im = null;
        try {
            InputStream is = this.getClass().getResourceAsStream( "/images/Backg.png" );
           im = ImageIO.read(is);

        } catch (IOException e) {}
        g.drawImage(im, 0, 0, null);



        Set<GameObject> gameObjectSet = view.getGameObjects().getAll();

        for (GameObject gameObject : gameObjectSet) {
            gameObject.draw(g);
        }

    }
    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public  class  KeyHandler  extends KeyAdapter    {
        private Field field;



        @Override
        public void keyPressed(KeyEvent e) {

            switch (e.getKeyCode()) {
                case (KeyEvent.VK_LEFT):
                    eventListener.move(Direction.LEFT);
                    break;
                case (KeyEvent.VK_RIGHT):
                    eventListener.move(Direction.RIGHT);
                    break;
                case (KeyEvent.VK_UP):
                    eventListener.move(Direction.UP);
                    break;
                case (KeyEvent.VK_DOWN):
                    eventListener.move(Direction.DOWN);
                    break;
                case (KeyEvent.VK_R):
                    eventListener.restart();
                    break;
            }
        }
    }
    public class MyMouseListener implements MouseListener {
        private Field field;

        private double mX, mY;

        public void mouseClicked(MouseEvent e) {

eventListener.click(e.getX(),e.getY());
        }

        public void mousePressed(MouseEvent e) {

        }

        public void mouseReleased(MouseEvent e) {
            mX =  e.getPoint().getX();
            mY =  e.getPoint().getY();

            eventListener.mouseMoved(mX,mY);

        }

        public void mouseEntered(MouseEvent e) {
            mX = (int) e.getPoint().getX();
            mY = (int) e.getPoint().getY();

            eventListener.mouseMoved(mX,mY);
            mouseMoved(e);

        }

        public void mouseExited(MouseEvent e){

        }

        public void mouseMoved(MouseEvent e) {
            mX = (int) e.getPoint().getX();
            mY = (int) e.getPoint().getY();

            eventListener.mouseMoved(mX,mY);
        }

    }
    }


