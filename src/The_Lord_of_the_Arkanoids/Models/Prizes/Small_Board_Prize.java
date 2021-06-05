package The_Lord_of_the_Arkanoids.Models.Prizes;

import The_Lord_of_the_Arkanoids.Models.Player;

import java.util.Timer;
import java.util.TimerTask;

public class Small_Board_Prize extends Prize{

    public Small_Board_Prize(int width, int height, int x, int y) {
        super(width, height, x, y);
        this.setId(3);
    }

    @Override
    public void usePrize(Player myPlayer) {
        System.out.println("Small_Board_Prize");
        this.setUtilized(true);
        Timer timer = new Timer();
        myPlayer.setScore(myPlayer.getScore() + 10);
        Small_Board_Prize f = this;
        int l = myPlayer.getBoard().getLength();
        myPlayer.getBoard().setLength(myPlayer.getBoard().getLength() - 25);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (f.getElapsedTime() < 10000) f.setElapsedTime(f.getElapsedTime() + 25);
                else {
                    myPlayer.getBoard().setLength(l);
                    f.setElapsedTime(0);
                    timer.cancel();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 10);
    }
}
