package game.model;


import java.util.HashSet;

import java.util.Set;


/**
 * Created by Kydp9 on 07.08.2016.
 */
public class LevelLoader {




    public GameObjects getLevel() {

            Set<Box> boxes = new HashSet<>();
            Set<Wall> walls = new HashSet<>();

            Set<Bullet> bullets = new HashSet<>();


            Player player;
            player = new Player(Model.FIELD_SELL_SIZE * Model.FIELD_SELL_SIZE / 2 + Model.FIELD_SELL_SIZE / 2,
                    (Model.FIELD_SELL_SIZE - 2) * Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE / 2 ,
                    100,100);
            Bullet bullet = new Bullet(400, 400, Model.FIELD_SELL_SIZE / 2, 10, 500, 500);
            bullets.add(bullet);

            boxes.add(new Box(5 * Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE / 2, 5 * Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE / 2));

            // стены
            for (int y = 0; y < Model.FIELD_SELL_SIZE*Model.FIELD_MULTIPLER; y++) {

                for (int x = 0; x < Model.FIELD_SELL_SIZE*Model.FIELD_MULTIPLER; x++) {
                    if (x == 0 || y == 0 || x == Model.FIELD_SELL_SIZE *Model.FIELD_MULTIPLER- 1 || y == Model.FIELD_SELL_SIZE*Model.FIELD_MULTIPLER - 1) {
                        walls.add(new Wall(x * Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE / 2, y * Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE / 2));
                    }
                }
            }
Aim aim = new Aim(0,0);

            return new GameObjects(walls, boxes, player, bullets,aim);



    }
}