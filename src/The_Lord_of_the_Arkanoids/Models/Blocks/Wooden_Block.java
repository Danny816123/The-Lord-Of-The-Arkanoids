package The_Lord_of_the_Arkanoids.Models.Blocks;

import The_Lord_of_the_Arkanoids.Models.Ball;
import The_Lord_of_the_Arkanoids.Models.Player;

import java.awt.*;

public class Wooden_Block extends Block{

    public Wooden_Block(int width, int height, int x, int y) {
        super(width, height, x, y);
        this.setColor(new Color(102,51,0, 128));
        this.setId(1);
    }

    @Override
    public boolean Collision(Player myPlayer, Ball ball) {
        if (this.isVisible() && !this.isBroken()) {
            if (ball.isBurning()){
                myPlayer.setScore(myPlayer.getScore() + 30);
                this.setBroken(true);
                this.setVisible(false);
            } else {
                if (this.getElapsedTime() > 0) {
                    myPlayer.setScore(myPlayer.getScore() + 30);
                    this.setBroken(true);
                    this.setVisible(false);
                } else {
                    this.setElapsedTime(this.getElapsedTime() + 1);
                }
            }
            return true;
        }
        return false;
    }
}
