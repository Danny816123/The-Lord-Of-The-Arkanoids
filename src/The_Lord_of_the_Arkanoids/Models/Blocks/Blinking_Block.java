package The_Lord_of_the_Arkanoids.Models.Blocks;

import The_Lord_of_the_Arkanoids.Models.Ball;
import The_Lord_of_the_Arkanoids.Models.Player;
import The_Lord_of_the_Arkanoids.Models.Prizes.Fire_Ball_Prize;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Blinking_Block extends Block{


    public Blinking_Block(int width, int height, int x, int y) {
        super(width, height, x, y);
        this.setColor(new Color(219, 13, 198, 128));
        this.setId(3);
    }

    @Override
    public boolean Collision(Player myPlayer, Ball ball) {
        if (this.isVisible() && !this.isBroken()) {
            myPlayer.setScore(myPlayer.getScore() + 20);
            this.setBroken(true);
            this.setVisible(false);
            return true;
        }
        return false;
    }
}
