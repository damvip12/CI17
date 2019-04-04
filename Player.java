package program;

import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Vector;

public class Player {
    BufferedImage image;
    Vector2D position , bulletPosition1 , bulletPosition2 ;
    BufferedImage bulletImage , bulletImage1 , bulletImage2;
    ArrayList<Vector2D> bulletPositions, bulletPositions1 , bulletPositions2;

    public Player() {
        image = SpriteUtils.loadImage("assets/images/players/straight/0.png");

        position = new Vector2D(300, 300);
        bulletPosition1 = new Vector2D(300,300);
        bulletPosition2 = new Vector2D(300,300);

        bulletImage = SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
        bulletImage1 = SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
        bulletImage2 = SpriteUtils.loadImage("assets/images/player-bullets/a/0.png");

        bulletPositions = new ArrayList<>();
        bulletPositions1 = new ArrayList<>();
        bulletPositions2 = new ArrayList<>();
    }

    public void render(Graphics g) {
        g.drawImage(image, (int)position.x, (int)position.y, null);
        // bullets render
        for (int i = 0; i < bulletPositions.size() ; i++) {
            Vector2D bulletPosition = bulletPositions.get(i);
            g.drawImage(
                    bulletImage,
                    (int) bulletPosition.x,
                    (int) bulletPosition.y,
                    null
            );
        }

        for(int i = 0 ; i < bulletPositions1.size(); i++) {
            Vector2D bulletPosition1 = bulletPositions1.get(i);
            g.drawImage(
                    bulletImage1,
                    (int) bulletPosition1.x,
                    (int) bulletPosition1.y,
                    null
            );
        }

        for(int i = 0 ; i < bulletPositions2.size(); i++) {
            Vector2D bulletPosition2 = bulletPositions2.get(i);
            g.drawImage(
                    bulletImage2,
                    (int) bulletPosition2.x,
                    (int) bulletPosition2.y,
                    null
            );
        }
    }

    public void run() {
        this.move();
        this.limitPosition();
        this.bulletsRun();
        this.fire();
    }

    int count = 0;
    public void fire() {
        count++;
        if(GameWindow.isFirePress && count > 15) {
            Vector2D bulletPosition = position.clone();
            Vector2D bulletPositon1 = position.clone();
            Vector2D bulletPositon2 = position.clone();
            bulletPositions.add(bulletPosition);
            bulletPositions1.add(bulletPositon1);
            bulletPositions2.add(bulletPositon2);
            count = 0;
        }
        else if(GameWindow.isFirePress1 && count > 3 ) {
            Vector2D bulletPosition = position.clone();
            bulletPositions.add(bulletPosition);
            count = 0;
        }
    }

    public void bulletsRun() {
        for (int i = 0; i < bulletPositions.size(); i++) {
            Vector2D bulletPosition = bulletPositions.get(i);
            bulletPosition.add(0, -5);
        }
        for (int i = 0; i < bulletPositions1.size(); i++) {
            Vector2D bulletPosition = bulletPositions1.get(i);
            bulletPosition.add(3,-5);
        }
        for (int i = 0 ; i < bulletPositions2.size() ; i++) {
            Vector2D bulletPosition = bulletPositions2.get(i);
            bulletPosition.add(-3,-5);
        }
    }

    public void move() {
        double playerSpeed = 3;
        double vx = 0;
        double vy = 0;

        if(GameWindow.isUpPress) {
            vy -= playerSpeed;
        }
        if(GameWindow.isRightPress) {
            vx += playerSpeed;
        }
        if(GameWindow.isDownPress) {
            vy += playerSpeed;
        }
        if(GameWindow.isLeftPress) {
            vx -= playerSpeed;
        }

        if(vx != 0 && vy != 0) {
            double v = playerSpeed / Math.sqrt(2);
            vx = Math.signum(vx) * v; // 1 * 5 * sqrt(2)
            vy = Math.signum(vy) * v; // -1 * 5 * sqrt(2)
        }

        position.add(vx, vy);
    }

    public void limitPosition() {
        position.setX(Mathx.clamp(position.x, 0, 384 - 32));
        position.setY(Mathx.clamp(position.y, 0, 600 - 48));

        bulletPosition1.setX(Mathx.clamp(bulletPosition1.x,0,384 - 32));
        bulletPosition1.setY(Mathx.clamp(bulletPosition1.y,0,600 - 48));
    }
}
