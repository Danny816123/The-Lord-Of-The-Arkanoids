package The_Lord_of_the_Arkanoids.Models.Blocks;

import The_Lord_of_the_Arkanoids.Models.Ball;
import The_Lord_of_the_Arkanoids.Models.Player;

import java.awt.*;
import java.util.ArrayList;

public abstract class Block {
    private int width;
    private int height;
    private int x;
    private int y;
    private boolean isBroken;
    private boolean isVisible;
    private Color Color;
    private int id;
    private int elapsedTime;

    public Block(int width, int height, int x, int y) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.isBroken = false;
        this.isVisible = true;
        this.elapsedTime = 0;
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

    public boolean isBroken() {
        return isBroken;
    }

    public void setBroken(boolean broken) {
        isBroken = broken;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public java.awt.Color getColor() {
        return Color;
    }

    public void setColor(java.awt.Color color) {
        Color = color;
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

    public abstract boolean Collision(Player myPlayer, Ball ball);
}
