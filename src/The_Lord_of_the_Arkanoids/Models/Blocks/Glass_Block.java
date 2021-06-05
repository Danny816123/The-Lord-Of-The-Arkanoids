package The_Lord_of_the_Arkanoids.Models.Blocks;

import The_Lord_of_the_Arkanoids.Models.Ball;
import The_Lord_of_the_Arkanoids.Models.Player;

import java.awt.*;

public class Glass_Block extends Block{

    public Glass_Block(int width, int height, int x, int y) {
        super(width, height, x, y);
        this.setColor(new Color(13, 212, 219, 128));
        this.setId(0);
    }

    @Override
    public boolean Collision(Player myPlayer, Ball ball) {
        if (this.isVisible() && !this.isBroken()) {
            myPlayer.setScore(myPlayer.getScore() + 10);
            this.setBroken(true);
            this.setVisible(false);
            return true;
        }
        return false;
    }
}
