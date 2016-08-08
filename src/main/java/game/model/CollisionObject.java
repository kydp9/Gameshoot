 package game.model;


public abstract class CollisionObject extends GameObject
{
   boolean live ;
    protected double radius;
    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public CollisionObject(int x, int y)
{
    super(x, y);
    this.live = true;
    this.radius = getHeight();
}
    public CollisionObject(int x, int y, int width, int height)
    {
        super(x, y,width,height);
        this.live = true;
        this.radius = width/2;
    }


     public  boolean isCollision(GameObject gameObject, Direction direction){
         boolean result = false;

         switch (direction) {

             case LEFT:
                 if (getX() - Model.FIELD_SELL_SIZE == gameObject.getX() && getY() == gameObject.getY())
                     result = true;
                 break;
             case RIGHT:
                 if (getX() + Model.FIELD_SELL_SIZE == gameObject.getX() && getY() == gameObject.getY())
                     result = true;
                 break;
             case UP:
                 if (getX() == gameObject.getX() && getY() - Model.FIELD_SELL_SIZE == gameObject.getY())
                     result = true;
                 break;
             case DOWN:
                 if (getX() == gameObject.getX() && getY() + Model.FIELD_SELL_SIZE == gameObject.getY())
                     result = true;
                 break;
         }
         return result;
     }
    public boolean isIntersec(CollisionObject o)
    {
        double dx = x - o.x;
        double dy = y - o.y;
        double destination = Math.sqrt(dx * dx + dy * dy);
        double destination2 = Math.max(radius, o.radius);
        return destination <= destination2;
    }
    public  boolean isOUT()
    {
        if(getX()<Model.FIELD_SELL_SIZE || getX()>Model.FIELD_MAX)
        {
            return true;
        }
        if(getY()<Model.FIELD_SELL_SIZE || getY()>Model.FIELD_MAX)
        {
            return  true;

        }
        return false;
    }
}
