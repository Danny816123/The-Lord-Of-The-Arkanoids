package The_Lord_of_the_Arkanoids.Models.Prizes;

import The_Lord_of_the_Arkanoids.Models.Ball;
import The_Lord_of_the_Arkanoids.Models.Player;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Fire_Ball_Prize extends Prize{


    public Fire_Ball_Prize(int width, int height, int x, int y) {
        super(width, height, x, y);
        this.setId(0);
    }

    @Override
    public void usePrize(Player myPlayer) {
        System.out.println("Fire_Ball_Prize");
        this.setUtilized(true);
        Timer timer = new Timer();
        myPlayer.setScore(myPlayer.getScore() + 10);
        Fire_Ball_Prize f = this;
        for (Ball ball: myPlayer.getBallsList()) {
            ball.setBurning(true);
        }
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (f.getElapsedTime() < 10000) f.setElapsedTime(f.getElapsedTime() + 10);
                else {
                    for (Ball ball: myPlayer.getBallsList()) {
                        ball.setBurning(false);
                    }
                    f.setElapsedTime(0);
                    timer.cancel();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 10);
    }
}
