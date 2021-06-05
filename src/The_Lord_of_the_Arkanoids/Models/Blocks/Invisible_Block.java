package The_Lord_of_the_Arkanoids.Models.Blocks;

import The_Lord_of_the_Arkanoids.Models.Ball;
import The_Lord_of_the_Arkanoids.Models.Player;

import java.awt.*;

public class Invisible_Block extends Block{

    public Invisible_Block(int width, int height, int x, int y) {
        super(width, height, x, y);
        this.setColor(new Color(0,0,0, 0));
        this.setId(2);
        this.setVisible(false);
    }

    @Override
    public boolean Collision(Player myPlayer, Ball ball) {
        if (!this.isBroken()) {
            myPlayer.setScore(myPlayer.getScore() + 20);
            this.setBroken(true);
            return true;
        }
        return false;
    }
}
