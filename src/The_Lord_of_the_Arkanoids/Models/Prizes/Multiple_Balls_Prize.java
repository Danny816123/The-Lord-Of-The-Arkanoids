package The_Lord_of_the_Arkanoids.Models.Prizes;

import The_Lord_of_the_Arkanoids.Models.Ball;
import The_Lord_of_the_Arkanoids.Models.Player;

public class Multiple_Balls_Prize extends Prize{

    public Multiple_Balls_Prize(int width, int height, int x, int y) {
        super(width, height, x, y);
        this.setId(1);
    }

    @Override
    public void usePrize(Player myPlayer) {
        System.out.println("Multiple_Balls_Prize");
        this.setUtilized(true);
        myPlayer.setScore(myPlayer.getScore() + 10);
        myPlayer.getBallsList().add(new Ball(40, 380, 840, 2, -4));
        myPlayer.getBallsList().add(new Ball(40, 380, 840, -2, -4));
    }
}
