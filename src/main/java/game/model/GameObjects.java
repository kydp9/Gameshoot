package game.model;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kydp9 on 07.08.2016.
 */
public class GameObjects {

    private Set<Wall> walls;
    private Set<Box> boxes;
    private Set<Boom> bom;
    private Set<Bullet> bullets;
    private Player player;
    private Aim aim;

    public GameObjects(Set<Wall> walls, Set<Box> boxes, Player player) {
        this.walls = walls;
        this.boxes = boxes;


        this.player = player;
    }
    public GameObjects(Set<Wall> walls, Set<Box> boxes,  Player player,Set<Bullet> bullets,Aim aim) {
        this.walls = walls;
        this.boxes = boxes;
this.aim = aim;
        this.bullets = bullets;
        this.player = player;
    }


    public Aim getAim() {
        return aim;
    }

    public Set<GameObject> getAll() {

        Set<GameObject> all = new HashSet<GameObject>();
        all.addAll(getWalls());
        all.addAll(getBoxes());
all.add(getAim());
        all.add(getPlayer());
        all.addAll(getBullets());

        return all;

    }


    public Set<Bullet> getBullets() {    return bullets;
    }
    public Set<Wall> getWalls() {
        return walls;
    }

    public Set<Box> getBoxes() {
        return boxes;
    }



    public Player getPlayer() {
        return player;
    }
}