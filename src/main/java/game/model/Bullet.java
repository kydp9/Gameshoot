package game.model;

import java.awt.*;

/**
 * Created by ikydp on 07.08.2016.
 */
public class Bullet  extends  CollisionObject implements  Movable{

        //скорость
        private double speed;
        //направление  (в градусах от 0 до 360)
        private double direction;

        //текущее значение вектора движения (dx,dy)
        private double dx;
        private double dy;

    public double getTarx() {
        return tarx;
    }

    public double getTary() {
        return tary;
    }

    private double  tarx;
    private double  tary;
        //заморожен ли объект или может двигаться
private double valX;
    private double valY;

    public double getValX() {
        return valX;
    }

    public double getValY() {
        return valY;
    }

    public Bullet(int x, int y, double speed, double direction, double tarx , double tary)
        {
            super(x, y);
this.tarx = x;
            this.tary = y;
this.direction = direction;
            this.speed = speed;
this.tary = tary;
            this.tarx = tarx;
            this.setHeight(30);
           this.setWidth(30);
// получаем координаты точки куда смотрел прицел. и вычесляем угол под каким надо запустить пулю.
            double theta = Math.atan2(tary - y,tarx - x );
this.setLive(true);

            this.valX = ( speed) * Math.cos(theta);
            this.valY = ( speed) * Math.sin(theta);



        }

        public double getSpeed()
        {
            return speed;
        }

        public void setSpeed(double speed)
        {
            this.speed = speed;
        }

        public double getDirection()
        {
            return direction;
        }

        public double getDx()
        {
            return dx;
        }

        public double getDy()
        {
            return dy;
        }



    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.magenta);

        int leftUpperCornerX = getX() - getWidth() / 2;
        int leftUpperCornerY = getY() - getHeight() / 2;

        graphics.drawOval(leftUpperCornerX, leftUpperCornerY, getWidth(), getHeight());
        graphics.fillOval(leftUpperCornerX, leftUpperCornerY, getWidth(), getHeight());
    }

    @Override
    public void move(int x, int y) {


        this.setX(getX() + (int)getValX());
        this.setY(getY() + (int)getValY());
    }
}


