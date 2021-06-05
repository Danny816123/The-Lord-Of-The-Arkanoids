package The_Lord_of_the_Arkanoids.Models.Prizes;

import The_Lord_of_the_Arkanoids.Models.Ball;
import The_Lord_of_the_Arkanoids.Models.Player;

import java.util.Timer;
import java.util.TimerTask;

public class Confused_Board_Prize extends Prize{

    public Confused_Board_Prize(int width, int height, int x, int y) {
        super(width, height, x, y);
        this.setId(6);
    }

    @Override
    public void usePrize(Player myPlayer) {
        System.out.println("Confused_Board_Prize");
        this.setUtilized(true);
        Timer timer = new Timer();
        myPlayer.setScore(myPlayer.getScore() + 10);
        Confused_Board_Prize f = this;
        myPlayer.getBoard().setConfused(true);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (f.getElapsedTime() < 10000) f.setElapsedTime(f.getElapsedTime() + 10);
                else {
                    myPlayer.getBoard().setConfused(false);
                    f.setElapsedTime(0);
                    timer.cancel();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 10);
    }
}
