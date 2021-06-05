package The_Lord_of_the_Arkanoids.Models;

import The_Lord_of_the_Arkanoids.Models.Blocks.*;
import The_Lord_of_the_Arkanoids.Models.Prizes.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Player {
    private String name;
    private int score;
    private int life;
    private boolean isOver;
    private final ArrayList<Ball> ballsList;
    private final ArrayList<Block> blocksList;
    private final ArrayList<Prize> prizesList;
    private Board board;

    public Player(Player copyPlayer){
        this.name = copyPlayer.getName();
        this.score = copyPlayer.getScore();
        this.life = copyPlayer.getLife();
        this.isOver = copyPlayer.isOver();
        this.ballsList = copyPlayer.getBallsList();
        this.blocksList = copyPlayer.getBlocksList();
        this.prizesList = copyPlayer.getPrizesList();
        this.board = copyPlayer.getBoard();
    }

    public Player(String name) {
        this.name = name;
        this.isOver = false;
        this.score = 0;
        this.ballsList = new ArrayList<>();
        this.blocksList = new ArrayList<>();
        this.prizesList = new ArrayList<>();
        this.life = 3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public ArrayList<Ball> getBallsList() {
        return ballsList;
    }

    public ArrayList<Block> getBlocksList() {
        return blocksList;
    }

    public ArrayList<Prize> getPrizesList() {
        return prizesList;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public boolean isOver() {
        return isOver;
    }

    public void setOver(boolean over) {
        isOver = over;
    }

    public void addNewRow(){
        for (Prize block: this.prizesList) {
            block.setY(block.getY() + 20);
        }
        for (Block block: this.blocksList) {
            block.setY(block.getY() + 20);
        }
        HashMap<Block, Prize> prizeMap = new HashMap<>();
        ArrayList<Block> newRow = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            newRow.add(new Prize_Block(i,0,0,0));
        }

        for (int i = 0; i < 3; i++) {
            newRow.add(new Glass_Block(-1,0,0,0));
            newRow.add(new Wooden_Block(-1,0,0,0));
            newRow.add(new Invisible_Block(-1,0,0,0));
            newRow.add(new Blinking_Block(-1,0,0,0));
        }
        Collections.shuffle(newRow);
        for (Block block: newRow) {
            if (block.getWidth() == 0) prizeMap.put(block, new Fire_Ball_Prize(0,0,0,0));
            else if (block.getWidth() == 1) prizeMap.put(block, new Multiple_Balls_Prize(0,0,0,0));
            else if (block.getWidth() == 2) prizeMap.put(block, new Large_Board_Prize(0,0,0,0));
            else if (block.getWidth() == 3) prizeMap.put(block, new Small_Board_Prize(0,0,0,0));
            else if (block.getWidth() == 4) prizeMap.put(block, new Fast_Ball_Prize(0,0,0,0));
            else if (block.getWidth() == 5) prizeMap.put(block, new Slow_Ball_Prize(0,0,0,0));
            else if (block.getWidth() == 6) prizeMap.put(block, new Confused_Board_Prize(0,0,0,0));
            else if (block.getWidth() == 7) prizeMap.put(block, new Random_Prize(0,0,0,0));
        }

        for (int i = 0; i < newRow.size(); i++) {
            if (newRow.get(i).getWidth() != -1) {
                prizeMap.get(newRow.get(i)).setWidth(40);
                prizeMap.get(newRow.get(i)).setHeight(20);
                prizeMap.get(newRow.get(i)).setX(i * 40);
                prizeMap.get(newRow.get(i)).setY(0);
                this.prizesList.add(prizeMap.get(newRow.get(i)));
            }
            newRow.get(i).setWidth(40);
            newRow.get(i).setHeight(20);
            newRow.get(i).setX(i * 40);
            newRow.get(i).setY(0);
        }
        this.blocksList.addAll(newRow);
    }

    public void save(){
        try {
            File myObj = new File("Players/" + this.name + ".txt");
            myObj.createNewFile();
            FileWriter myWriter = new FileWriter(myObj);
            myWriter.write(this.name);
            myWriter.write(System.lineSeparator());
            myWriter.write(String.valueOf(this.score));
            myWriter.write(System.lineSeparator());
            myWriter.write(String.valueOf(this.life));
            myWriter.write(System.lineSeparator());
            myWriter.write(String.valueOf(this.isOver));
            myWriter.write(System.lineSeparator());
            myWriter.write(String.valueOf(this.board.getLength()));
            myWriter.write(System.lineSeparator());
            myWriter.write(String.valueOf(this.board.getX()));
            myWriter.write(System.lineSeparator());
            myWriter.write(String.valueOf(this.board.getY()));
            myWriter.write(System.lineSeparator());
            myWriter.write(String.valueOf(this.board.isConfused()));
            myWriter.write(System.lineSeparator());
            myWriter.write(String.valueOf(this.ballsList.size()));
            myWriter.write(System.lineSeparator());
            for (Ball ball: this.ballsList) {
                myWriter.write(String.valueOf(ball.getLength()));
                myWriter.write(System.lineSeparator());
                myWriter.write(String.valueOf(ball.getX()));
                myWriter.write(System.lineSeparator());
                myWriter.write(String.valueOf(ball.getY()));
                myWriter.write(System.lineSeparator());
                myWriter.write(String.valueOf(ball.getxVelocity()));
                myWriter.write(System.lineSeparator());
                myWriter.write(String.valueOf(ball.getyVelocity()));
                myWriter.write(System.lineSeparator());
                myWriter.write(String.valueOf(ball.isBurning()));
                myWriter.write(System.lineSeparator());
            }
            myWriter.write(String.valueOf(this.blocksList.size()));
            myWriter.write(System.lineSeparator());
            for (Block block: this.blocksList) {
                myWriter.write(String.valueOf(block.getId()));
                myWriter.write(System.lineSeparator());
                myWriter.write(String.valueOf(block.getWidth()));
                myWriter.write(System.lineSeparator());
                myWriter.write(String.valueOf(block.getHeight()));
                myWriter.write(System.lineSeparator());
                myWriter.write(String.valueOf(block.getX()));
                myWriter.write(System.lineSeparator());
                myWriter.write(String.valueOf(block.getY()));
                myWriter.write(System.lineSeparator());
                myWriter.write(String.valueOf(block.getElapsedTime()));
                myWriter.write(System.lineSeparator());
                myWriter.write(String.valueOf(block.isVisible()));
                myWriter.write(System.lineSeparator());
                myWriter.write(String.valueOf(block.isBroken()));
                myWriter.write(System.lineSeparator());
            }
            myWriter.write(String.valueOf(this.prizesList.size()));
            myWriter.write(System.lineSeparator());
            for (Prize prize: this.prizesList) {
                myWriter.write(String.valueOf(prize.getId()));
                myWriter.write(System.lineSeparator());
                myWriter.write(String.valueOf(prize.getWidth()));
                myWriter.write(System.lineSeparator());
                myWriter.write(String.valueOf(prize.getHeight()));
                myWriter.write(System.lineSeparator());
                myWriter.write(String.valueOf(prize.getX()));
                myWriter.write(System.lineSeparator());
                myWriter.write(String.valueOf(prize.getY()));
                myWriter.write(System.lineSeparator());
                myWriter.write(String.valueOf(prize.getElapsedTime()));
                myWriter.write(System.lineSeparator());
                myWriter.write(String.valueOf(prize.isVisible()));
                myWriter.write(System.lineSeparator());
                myWriter.write(String.valueOf(prize.isUtilized()));
                myWriter.write(System.lineSeparator());
            }
            myWriter.flush();
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Save error occurred.");
        }
    }

    public static Player loadPlayer(String playerName){
        Player myPlayer = new Player(playerName);
        try {
            File myObj = new File("Players/" + playerName + ".txt");
            Scanner beholder = new Scanner(myObj);
            beholder.nextLine();
            myPlayer.setScore(Integer.parseInt(beholder.nextLine()));
            myPlayer.setLife(Integer.parseInt(beholder.nextLine()));
            myPlayer.setOver(Boolean.parseBoolean(beholder.nextLine()));
            if (myPlayer.isOver) myPlayer = newGame(playerName);
            else {
                myPlayer.setBoard(new Board(Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine())));
                myPlayer.getBoard().setConfused(Boolean.parseBoolean(beholder.nextLine()));
                int a = Integer.parseInt(beholder.nextLine());
                for (int i = 0; i < a; i++) {
                    Ball ball = new Ball(Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()));
                    ball.setBurning(Boolean.parseBoolean(beholder.nextLine()));
                    myPlayer.getBallsList().add(ball);
                }
                int b = Integer.parseInt(beholder.nextLine());
                for (int i = 0; i < b; i++) {
                    int j = Integer.parseInt(beholder.nextLine());
                    if (j == 0) {
                        Block block = new Glass_Block(Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()));
                        block.setElapsedTime(Integer.parseInt(beholder.nextLine()));
                        block.setVisible(Boolean.parseBoolean(beholder.nextLine()));
                        block.setBroken(Boolean.parseBoolean(beholder.nextLine()));
                        myPlayer.blocksList.add(block);
                    } else if (j == 1) {
                        Block block = new Wooden_Block(Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()));
                        block.setElapsedTime(Integer.parseInt(beholder.nextLine()));
                        block.setVisible(Boolean.parseBoolean(beholder.nextLine()));
                        block.setBroken(Boolean.parseBoolean(beholder.nextLine()));
                        myPlayer.blocksList.add(block);
                    } else if (j == 2) {
                        Block block = new Invisible_Block(Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()));
                        block.setElapsedTime(Integer.parseInt(beholder.nextLine()));
                        block.setVisible(Boolean.parseBoolean(beholder.nextLine()));
                        block.setBroken(Boolean.parseBoolean(beholder.nextLine()));
                        myPlayer.blocksList.add(block);
                    } else if (j == 3) {
                        Block block = new Blinking_Block(Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()));
                        block.setElapsedTime(Integer.parseInt(beholder.nextLine()));
                        block.setVisible(Boolean.parseBoolean(beholder.nextLine()));
                        block.setBroken(Boolean.parseBoolean(beholder.nextLine()));
                        myPlayer.blocksList.add(block);
                    } else {
                        Block block = new Prize_Block(Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()));
                        block.setElapsedTime(Integer.parseInt(beholder.nextLine()));
                        block.setVisible(Boolean.parseBoolean(beholder.nextLine()));
                        block.setBroken(Boolean.parseBoolean(beholder.nextLine()));
                        myPlayer.blocksList.add(block);
                    }
                }
                int c = Integer.parseInt(beholder.nextLine());
                for (int i = 0; i < c; i++) {
                    int j = Integer.parseInt(beholder.nextLine());
                    if (j == 0) {
                        Prize prize = new Fire_Ball_Prize(Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()));
                        prize.setElapsedTime(Integer.parseInt(beholder.nextLine()));
                        prize.setVisible(Boolean.parseBoolean(beholder.nextLine()));
                        prize.setUtilized(Boolean.parseBoolean(beholder.nextLine()));
                        myPlayer.prizesList.add(prize);
                    } else if (j == 1) {
                        Prize prize = new Multiple_Balls_Prize(Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()));
                        prize.setElapsedTime(Integer.parseInt(beholder.nextLine()));
                        prize.setVisible(Boolean.parseBoolean(beholder.nextLine()));
                        prize.setUtilized(Boolean.parseBoolean(beholder.nextLine()));
                        myPlayer.prizesList.add(prize);
                    } else if (j == 2) {
                        Prize prize = new Large_Board_Prize(Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()));
                        prize.setElapsedTime(Integer.parseInt(beholder.nextLine()));
                        prize.setVisible(Boolean.parseBoolean(beholder.nextLine()));
                        prize.setUtilized(Boolean.parseBoolean(beholder.nextLine()));
                        myPlayer.prizesList.add(prize);
                    } else if (j == 3) {
                        Prize prize = new Small_Board_Prize(Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()));
                        prize.setElapsedTime(Integer.parseInt(beholder.nextLine()));
                        prize.setVisible(Boolean.parseBoolean(beholder.nextLine()));
                        prize.setUtilized(Boolean.parseBoolean(beholder.nextLine()));
                        myPlayer.prizesList.add(prize);
                    } else if (j == 4) {
                        Prize prize = new Fast_Ball_Prize(Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()));
                        prize.setElapsedTime(Integer.parseInt(beholder.nextLine()));
                        prize.setVisible(Boolean.parseBoolean(beholder.nextLine()));
                        prize.setUtilized(Boolean.parseBoolean(beholder.nextLine()));
                        myPlayer.prizesList.add(prize);
                    } else if (j == 5) {
                        Prize prize = new Slow_Ball_Prize(Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()));
                        prize.setElapsedTime(Integer.parseInt(beholder.nextLine()));
                        prize.setVisible(Boolean.parseBoolean(beholder.nextLine()));
                        prize.setUtilized(Boolean.parseBoolean(beholder.nextLine()));
                        myPlayer.prizesList.add(prize);
                    } else if (j == 6) {
                        Prize prize = new Confused_Board_Prize(Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()));
                        prize.setElapsedTime(Integer.parseInt(beholder.nextLine()));
                        prize.setVisible(Boolean.parseBoolean(beholder.nextLine()));
                        prize.setUtilized(Boolean.parseBoolean(beholder.nextLine()));
                        myPlayer.prizesList.add(prize);
                    } else {
                        Prize prize = new Random_Prize(Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()), Integer.parseInt(beholder.nextLine()));
                        prize.setElapsedTime(Integer.parseInt(beholder.nextLine()));
                        prize.setVisible(Boolean.parseBoolean(beholder.nextLine()));
                        prize.setUtilized(Boolean.parseBoolean(beholder.nextLine()));
                        myPlayer.prizesList.add(prize);
                    }
                }
                beholder.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Load error occurred.");
            myPlayer = newGame(playerName);
        }
        return myPlayer;
    }

    public static Player newGame(String playerName){
        Player myPlayer = new Player(playerName);
        for (int i = 0; i < 15; i++) myPlayer.addNewRow();
        myPlayer.getBallsList().add(new Ball(40, 380, 840, 2, -4));
        myPlayer.setBoard(new Board(200, 300, 880));

        return myPlayer;
    }
}