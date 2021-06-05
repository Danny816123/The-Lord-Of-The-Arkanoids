package The_Lord_of_the_Arkanoids.Models.Prizes;

import The_Lord_of_the_Arkanoids.Models.Player;

import java.util.Random;

public class Random_Prize extends Prize{

    public Random_Prize(int width, int height, int x, int y) {
        super(width, height, x, y);
        this.setId(7);
    }

    @Override
    public void usePrize(Player myPlayer) {
        System.out.println("Random_Prize");
        this.setUtilized(true);
        int x = new Random().nextInt(7);
        if (x == 0){
            new Fast_Ball_Prize(this.getWidth(), this.getHeight(), this.getX(), this.getY()).usePrize(myPlayer);
        } else if (x == 1){
            new Multiple_Balls_Prize(this.getWidth(), this.getHeight(), this.getX(), this.getY()).usePrize(myPlayer);
        } else if (x == 2){
            new Large_Board_Prize(this.getWidth(), this.getHeight(), this.getX(), this.getY()).usePrize(myPlayer);
        } else if (x == 3){
            new Small_Board_Prize(this.getWidth(), this.getHeight(), this.getX(), this.getY()).usePrize(myPlayer);
        } else if (x == 4){
            new Fast_Ball_Prize(this.getWidth(), this.getHeight(), this.getX(), this.getY()).usePrize(myPlayer);
        } else if (x == 5){
            new Slow_Ball_Prize(this.getWidth(), this.getHeight(), this.getX(), this.getY()).usePrize(myPlayer);
        } else {
            new Confused_Board_Prize(this.getWidth(), this.getHeight(), this.getX(), this.getY()).usePrize(myPlayer);
        }
    }

}
