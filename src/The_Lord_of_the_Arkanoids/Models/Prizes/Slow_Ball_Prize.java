package The_Lord_of_the_Arkanoids.Models.Prizes;

import The_Lord_of_the_Arkanoids.Models.Player;

import java.util.Timer;
import java.util.TimerTask;

public class Slow_Ball_Prize extends Prize{

    public Slow_Ball_Prize(int width, int height, int x, int y) {
        super(width, height, x, y);
        this.setId(5);
    }

    @Override
    public void usePrize(Player myPlayer) {
        System.out.println("Slow_Ball_Prize");
        this.setUtilized(true);
        Timer timer = new Timer();
        myPlayer.setScore(myPlayer.getScore() + 10);
        Slow_Ball_Prize f = this;
        Player iPlayer = new Player(myPlayer);
        for (int i = 0; i < myPlayer.getBallsList().size(); i++) {
            if (myPlayer.getBallsList().get(i).getxVelocity() > 0) myPlayer.getBallsList().get(i).setxVelocity(2);
            else myPlayer.getBallsList().get(i).setxVelocity(-2);
            if (myPlayer.getBallsList().get(i).getyVelocity() > 0) myPlayer.getBallsList().get(i).setyVelocity(2);
            else myPlayer.getBallsList().get(i).setyVelocity(-2);
        }
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (f.getElapsedTime() < 10000) f.setElapsedTime(f.getElapsedTime() + 10);
                else {
                    for (int i = 0; i < Math.min(iPlayer.getBallsList().size(), myPlayer.getBallsList().size()); i++) {
                        myPlayer.getBallsList().get(i).setxVelocity(iPlayer.getBallsList().get(i).getxVelocity());
                        myPlayer.getBallsList().get(i).setyVelocity(iPlayer.getBallsList().get(i).getyVelocity());
                    }
                    f.setElapsedTime(0);
                    timer.cancel();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 10);
    }
}
