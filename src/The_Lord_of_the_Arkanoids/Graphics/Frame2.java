package The_Lord_of_the_Arkanoids.Graphics;

import The_Lord_of_the_Arkanoids.Models.Ball;
import The_Lord_of_the_Arkanoids.Models.Blocks.Blinking_Block;
import The_Lord_of_the_Arkanoids.Models.Blocks.Block;
import The_Lord_of_the_Arkanoids.Models.Player;
import The_Lord_of_the_Arkanoids.Models.Prizes.Prize;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.TimerTask;

public class Frame2 extends JFrame implements ActionListener, KeyListener {

    private JPanel contentPane;
    private Player player;
    private Timer timer;
    private JLabel lblNewLabel_2_1;
    private JLabel lblNewLabel_2_1_1;
    private JPanel panel_1;
    private JButton btnNewButton_3;
    private JButton btnNewButton_4;
    private JButton btnNewButton_2;
    private JButton btnNewButton_1;
    private JButton btnNewButton;
    private java.util.Timer timerr;
    private java.util.Timer timerrr;
    private Image icon;
    private JPanel panel;

    public Frame2(Player playerr) {
        this.player = playerr;
        timer = new Timer(10, this);
        timer.start();
        this.addKeyListener(this);
        this.setFocusable(true);

        timerr = new java.util.Timer();
        TimerTask task1 = new TimerTask() {
            @Override
            public void run() {
                java.util.Timer timerrr = new java.util.Timer();
                ArrayList<Blinking_Block> blinking_blockArrayList = new ArrayList<>();
                for (ListIterator<Block> iterator = player.getBlocksList().listIterator(); iterator.hasNext();) {
                    Block block = iterator.next();
                    if (block.getId() == 3) blinking_blockArrayList.add((Blinking_Block) block);
                }
                TimerTask task11 = new TimerTask() {
                    @Override
                    public void run() {
                        for (ListIterator<Blinking_Block> iterator = blinking_blockArrayList.listIterator(); iterator.hasNext();) {
                            Blinking_Block block = iterator.next();
                            if (!block.isBroken()) {
                                if (block.getElapsedTime() < 10000) {
                                    block.setElapsedTime(block.getElapsedTime() + 50);
                                    block.setVisible(block.getElapsedTime() < 5000);
                                } else {
                                    block.setElapsedTime(0);
                                    timerrr.cancel();
                                }
                            }
                        }
                    }
                };
                timerrr.scheduleAtFixedRate(task11, 0, 50);
            }
        };
        timerr.scheduleAtFixedRate(task1, 0, 10000);

        for (Prize prize : player.getPrizesList()) {
            if (prize.getElapsedTime() != 0){
                prize.usePrize(player);
                player.setScore(player.getScore() - 10);
            }
            if (prize.isVisible()){
                prize.sendPrize();
            }
        }

        timerrr = new java.util.Timer();
        TimerTask task11 = new TimerTask() {
            @Override
            public void run() {
                player.addNewRow();
            }
        };
        timerrr.scheduleAtFixedRate(task11, 35000, 35000);

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 915, 935);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        panel = new JPanel(){
            @Override
            public void paint(Graphics g) {
                super.paint(g); // paint background
                paintGraphic((Graphics2D) g);
            }
        };
        panel.setBounds(0, 0, 800, 900);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(0, 0, 800, 900);
        lblNewLabel.setIcon(new ImageIcon("rhrqpid--2-.jpg"));
        panel.add(lblNewLabel);

        panel_1 = new JPanel();
        panel_1.setBounds(800, 0, 100, 900);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel_2_3 = new JLabel(player.getName());
        lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_3.setForeground(Color.YELLOW);
        lblNewLabel_2_3.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        lblNewLabel_2_3.setBounds(0, 11, 100, 57);
        panel_1.add(lblNewLabel_2_3);


        JLabel lblNewLabel_2 = new JLabel("Score:");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setForeground(Color.YELLOW);
        lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        lblNewLabel_2.setBounds(0, 130, 100, 57);
        panel_1.add(lblNewLabel_2);

        btnNewButton_3 = new JButton("Start");
        btnNewButton_3.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        btnNewButton_3.setBounds(0, 465, 100, 70);
        btnNewButton_3.addActionListener(this);
        btnNewButton_3.setFocusable(false);
        panel_1.add(btnNewButton_3);

        btnNewButton_4 = new JButton("Pause");
        btnNewButton_4.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        btnNewButton_4.setBounds(0, 546, 100, 70);
        btnNewButton_4.addActionListener(this);
        btnNewButton_4.setFocusable(false);
        panel_1.add(btnNewButton_4);

        btnNewButton_2 = new JButton("Save");
        btnNewButton_2.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        btnNewButton_2.setBounds(0, 787, 100, 70);
        btnNewButton_2.addActionListener(this);
        btnNewButton_2.setFocusable(false);
        panel_1.add(btnNewButton_2);

        btnNewButton_1 = new JButton("New save");
        btnNewButton_1.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        btnNewButton_1.setBounds(0, 706, 100, 70);
        btnNewButton_1.addActionListener(this);
        btnNewButton_1.setFocusable(false);
        panel_1.add(btnNewButton_1);

        btnNewButton = new JButton("Restart");
        btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        btnNewButton.setBounds(0, 625, 100, 70);
        btnNewButton.addActionListener(this);
        btnNewButton.setFocusable(false);
        panel_1.add(btnNewButton);

        JLabel lblNewLabel_2_2 = new JLabel("Life:");
        lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_2.setForeground(Color.YELLOW);
        lblNewLabel_2_2.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        lblNewLabel_2_2.setBounds(0, 273, 100, 57);
        panel_1.add(lblNewLabel_2_2);

        lblNewLabel_2_1 = new JLabel(String.valueOf(player.getScore()));
        lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1.setForeground(Color.YELLOW);
        lblNewLabel_2_1.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        lblNewLabel_2_1.setBounds(0, 192, 100, 57);
        panel_1.add(lblNewLabel_2_1);

        lblNewLabel_2_1_1 = new JLabel(String.valueOf(player.getLife()));
        lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1_1.setForeground(Color.YELLOW);
        lblNewLabel_2_1_1.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        lblNewLabel_2_1_1.setBounds(0, 335, 100, 57);
        panel_1.add(lblNewLabel_2_1_1);

        JLabel lblNewLabel_1 = new JLabel();
        lblNewLabel_1.setBounds(0, 0, 100, 900);
        lblNewLabel_1.setIcon(new ImageIcon("Webp.net-resizeimage.jpg"));
        panel_1.add(lblNewLabel_1);

        icon = new ImageIcon("ring.png").getImage();

        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (ListIterator<Ball> iterator = player.getBallsList().listIterator(); iterator.hasNext();) {
            Ball ball = iterator.next();
            if (ball.getX() <= 0 || ball.getX() >= 760) ball.setxVelocity(-1 * ball.getxVelocity());
            if (ball.getY() <= 0) ball.setyVelocity(-1 * ball.getyVelocity());
            for (Block block: player.getBlocksList()) {
                if (xIntersection(new Rectangle(ball.getX(), ball.getY(), ball.getLength(), ball.getLength()), new Rectangle(block.getX(), block.getY(), block.getWidth(), block.getHeight())) || intersection(new Rectangle(ball.getX(), ball.getY(), ball.getLength(), ball.getLength()), new Rectangle(block.getX(), block.getY(), block.getWidth(), block.getHeight()))) {
                    if (block.Collision(player, ball)) {
                        if (!ball.isBurning()) {
                            ball.setxVelocity(-1 * ball.getxVelocity());
                        }
                        break;
                    }
                }
            }
            for (Block block: player.getBlocksList()) {
                if (yIntersection(new Rectangle(ball.getX(), ball.getY(), ball.getLength(), ball.getLength()), new Rectangle(block.getX(), block.getY(), block.getWidth(), block.getHeight())) || intersection(new Rectangle(ball.getX(), ball.getY(), ball.getLength(), ball.getLength()), new Rectangle(block.getX(), block.getY(), block.getWidth(), block.getHeight()))) {
                    if (block.Collision(player, ball)) {
                        if (!ball.isBurning()) {
                            ball.setyVelocity(-1 * ball.getyVelocity());
                        }
                        break;
                    }
                }
            }
            if (intersection(new Rectangle(ball.getX(), ball.getY(), ball.getLength(), ball.getLength()), new Rectangle(player.getBoard().getX(), player.getBoard().getY(), player.getBoard().getLength(), 20)) || yIntersection(new Rectangle(ball.getX(), ball.getY(), ball.getLength(), ball.getLength()), new Rectangle(player.getBoard().getX(), player.getBoard().getY(), player.getBoard().getLength(), 20))) {
                if (ball.getyVelocity() > 0) {
                    if (player.getBoard().colDistance(ball) == 0) {
                        ball.setyVelocity(-1 * ball.getyVelocity());
                    } else {
                        int x = ball.getxVelocity();
                        int y = ball.getyVelocity();
                        if (x < 0) {
                            ball.setxVelocity(y);
                            ball.setyVelocity(x);
                        } else {
                            ball.setxVelocity(-1 * y);
                            ball.setyVelocity(-1 * x);
                        }
                    }
                }
            }
            if (ball.getY() > 860){
                iterator.remove();
                if (player.getBallsList().size() < 1) {
                    player.setLife(player.getLife() - 1);
                    iterator.add(new Ball(40, player.getBoard().getX() + (player.getBoard().getLength()/2) - 20, player.getBoard().getY() - 40, 2, -4));
                }
            }
        }

        for (Prize prize : player.getPrizesList()){
            if (intersection(new Rectangle(prize.getX(), prize.getY(), prize.getWidth(), prize.getHeight()), new Rectangle(player.getBoard().getX(), player.getBoard().getY(), player.getBoard().getLength(), 20)) && !prize.isUtilized()){
                prize.usePrize(player);
            }
        }

        if(e.getSource() == btnNewButton_4) {
            if (timer.isRunning()) {
                timer.stop();
                timerr.cancel();
                timerrr.cancel();
                Player player2 = new Player(player);
                player2.setName(player.getName() + "[PAUSED]");
                player2.save();
            }
        }
        if(e.getSource() == btnNewButton_2) {
            if (timer.isRunning()) {
                timer.stop();
                timerr.cancel();
                timerrr.cancel();
                Player player2 = new Player(player);
                player2.setName(player.getName() + "[PAUSED]");
                player2.save();
            }
            player.save();
        }
        if(e.getSource() == btnNewButton_1) {
            if (timer.isRunning()) {
                timer.stop();
                timerr.cancel();
                timerrr.cancel();
                Player player2 = new Player(player);
                player2.setName(player.getName() + "[PAUSED]");
                player2.save();
            }
            Player player22 = new Player(player);
            new Frame333(player22).setVisible(true);
        }
        if(e.getSource() == btnNewButton) {
            if (!timer.isRunning()) {
                File myObj = new File("Players/" + player.getName() + "[PAUSED]" + ".txt");
                myObj.delete();
            } else {
                timer.stop();
                timerr.cancel();
                timerrr.cancel();
            }
            this.dispose();
            new Frame2(Player.newGame(player.getName())).setVisible(true);
        }
        lblNewLabel_2_1_1.setText(String.valueOf(player.getLife()));
        lblNewLabel_2_1.setText(String.valueOf(player.getScore()));
        if(e.getSource() == btnNewButton_3) {
            if (!timer.isRunning()) {
                this.dispose();
                Player player2 = Player.loadPlayer(player.getName() + "[PAUSED]");
                System.out.println(player.getName());
                player2.setName(player.getName());
                new Frame2(player2).setVisible(true);
                File myObj = new File("Players/" + player.getName() + "[PAUSED]" + ".txt");
                myObj.delete();
            }
        }
        checkForEndGame();
        for (Ball ball: player.getBallsList()) {
            ball.setX(ball.getX() + ball.getxVelocity());
            ball.setY(ball.getY() + ball.getyVelocity());
        }
        contentPane.repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (player.getBoard().isConfused()){
            switch (e.getKeyCode()) {
                case 37 -> {
                    if (player.getBoard().getX() + player.getBoard().getLength() < 800) player.getBoard().setX(player.getBoard().getX() + 20);
                }
                case 39 -> {
                    if (player.getBoard().getX() > 0) player.getBoard().setX(player.getBoard().getX() - 20);
                }
            }
        }else{
            switch (e.getKeyCode()) {
                case 39 -> {
                    if (player.getBoard().getX() + player.getBoard().getLength() < 800) player.getBoard().setX(player.getBoard().getX() + 20);
                }
                case 37 -> {
                    if (player.getBoard().getX() > 0) player.getBoard().setX(player.getBoard().getX() - 20);
                }
            }
        }
    }

    public void paintGraphic(Graphics2D g2D){
        for (Ball ball : player.getBallsList()) {
            g2D.drawImage(icon, ball.getX(), ball.getY(), null);
        }
        
        g2D.setPaint(new Color(7, 50, 158));
        g2D.drawRect(player.getBoard().getX(), player.getBoard().getY(), player.getBoard().getLength(), 20);
        g2D.fillRect(player.getBoard().getX(), player.getBoard().getY(), player.getBoard().getLength(), 20);

        for (Block block: player.getBlocksList()) {
            if (block.isVisible()){
                g2D.setPaint(block.getColor());
                g2D.drawRect(block.getX(), block.getY(), block.getWidth(), block.getHeight());
                g2D.fillRect(block.getX(), block.getY(), block.getWidth(), block.getHeight());
            }
        }

        for (Prize prize: player.getPrizesList()) {
            if (prize.isVisible()){
                g2D.setPaint(prize.getColor());
                g2D.drawRect(prize.getX(), prize.getY(), prize.getWidth(), prize.getHeight());
                g2D.fillRect(prize.getX(), prize.getY(), prize.getWidth(), prize.getHeight());
            }
        }
    }

    public void checkForEndGame(){
        if (player.getLife() < 1){
            player.setOver(true);
            timer.stop();
            timerr.cancel();
            timerrr.cancel();
        } else {
            for (Block block: player.getBlocksList()) {
                if (block.getY() >= 860 && !block.isBroken()){
                    player.setOver(true);
                    timer.stop();
                    timerr.cancel();
                    timerrr.cancel();
                    break;
                }
            }
        }
    }

    public static boolean yIntersection(Rectangle r, Rectangle rr){
        int tw = rr.width;
        int th = rr.height;
        int rw = r.width;
        int rh = r.height;
        if (rw <= 0 || rh <= 0 || tw <= 0 || th <= 0) {
            return false;
        }
        int tx = rr.x;
        int ty = rr.y;
        int rx = r.x;
        int ry = r.y;
        rw += rx;
        rh += ry;
        tw += tx;
        th += ty;
        //      overflow || intersect
        return (((rw >= tx) &&
                (rh == ty) &&
                (tw >= rx)) ||
                ((rw >= tx) &&
                (tw >= rx) &&
                (th == ry)));
    }

    public static boolean xIntersection(Rectangle r, Rectangle rr){
        int tw = rr.width;
        int th = rr.height;
        int rw = r.width;
        int rh = r.height;
        if (rw <= 0 || rh <= 0 || tw <= 0 || th <= 0) {
            return false;
        }
        int tx = rr.x;
        int ty = rr.y;
        int rx = r.x;
        int ry = r.y;
        rw += rx;
        rh += ry;
        tw += tx;
        th += ty;
        //      overflow || intersect
        return (((rw == tx) &&
                (rh >= ty) &&
                (th >= ry)) ||
                ((rh >= ty) &&
                (tw == rx) &&
                (th >= ry)));
    }

    public static boolean intersection(Rectangle r, Rectangle rr){
        int tw = rr.width;
        int th = rr.height;
        int rw = r.width;
        int rh = r.height;
        if (rw <= 0 || rh <= 0 || tw <= 0 || th <= 0) {
            return false;
        }
        int tx = rr.x;
        int ty = rr.y;
        int rx = r.x;
        int ry = r.y;
        rw += rx;
        rh += ry;
        tw += tx;
        th += ty;
        //      overflow || intersect
        return ((rw < rx || rw > tx) &&
                (rh < ry || rh > ty) &&
                (tw < tx || tw > rx) &&
                (th < ty || th > ry));
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
