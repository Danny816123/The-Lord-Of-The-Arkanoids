package The_Lord_of_the_Arkanoids.Models;

public class Board {
    private  int length;
    private final int y;
    private int x;
    private boolean isConfused;

    public Board(int length, int x, int y) {
        this.length = length;
        this.y = y;
        this.x = x;
        this.isConfused = false;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public boolean isConfused() {
        return isConfused;
    }

    public void setConfused(boolean confused) {
        isConfused = confused;
    }

    public int colDistance(Ball ball){
        return Math.abs(this.x + (this.length/2) - (ball.getX() + (ball.getLength()/2)));
    }
}
