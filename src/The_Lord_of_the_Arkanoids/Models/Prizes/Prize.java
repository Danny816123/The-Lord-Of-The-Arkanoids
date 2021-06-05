package The_Lord_of_the_Arkanoids.Models.Prizes;

import The_Lord_of_the_Arkanoids.Models.Player;

import java.awt.*;
import java.util.TimerTask;

public abstract class Prize {
    private int width;
    private int height;
    private int x;
    private int y;
    private final int velocity;
    private final Color Color = new Color(25, 236, 9, 128);
    private boolean isVisible;
    private boolean isUtilized;
    private int elapsedTime;
    private int id;

    public Prize(int width, int height, int x, int y) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.velocity = 1;
        this.isVisible = false;
        this.isUtilized = false;
        this.elapsedTime = 0;
    }

    public boolean isUtilized() {
        return isUtilized;
    }

    public void setUtilized(boolean utilized) {
        isUtilized = utilized;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getVelocity() {
        return velocity;
    }

    public java.awt.Color getColor() {
        return Color;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public int getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(int elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract void usePrize(Player myPlayer);

    public void sendPrize(){
        Prize prize = this;
        java.util.Timer timerrr = new java.util.Timer();
        TimerTask task11 = new TimerTask() {
            @Override
            public void run() {
                if (prize.getY() < 900) {
                    prize.setY(prize.getY() + prize.getVelocity());
                } else {
                    timerrr.cancel();
                }
            }
        };
        timerrr.scheduleAtFixedRate(task11, 0, 10);
    }
}
