package The_Lord_of_the_Arkanoids.Models.Blocks;

import The_Lord_of_the_Arkanoids.Models.Ball;
import The_Lord_of_the_Arkanoids.Models.Player;
import The_Lord_of_the_Arkanoids.Models.Prizes.Prize;

import java.awt.*;

public class Prize_Block extends Block{

    public Prize_Block(int width, int height, int x, int y) {
        super(width, height, x, y);
        this.setColor(new Color(219, 208, 13, 128));
        this.setId(4);
    }

    @Override
    public boolean Collision(Player myPlayer, Ball ball) {
        if (this.isVisible() && !this.isBroken()) {
            myPlayer.setScore(myPlayer.getScore() + 20);
            this.setBroken(true);
            this.setVisible(false);
            for (Prize prize: myPlayer.getPrizesList()) {
                if (prize.getX() == this.getX() && prize.getY() == this.getY()){
                    prize.setVisible(true);
                    prize.sendPrize();
                    return true;
                }
            }
            return true;
        }
        return false;
    }
}
