package The_Lord_of_the_Arkanoids.Graphics;

import The_Lord_of_the_Arkanoids.Models.Player;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Frame1 extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JScrollPane scrollPane;
    private JTable table;
    private JButton btnNewButton_1;
    private JButton btnNewButton;

    public Frame1() throws FileNotFoundException {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 915, 925);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 800, 900);
        contentPane.add(panel);
        panel.setLayout(null);



        File dir = new File("Players");
        File[] directoryListing = dir.listFiles();
        ArrayList<Player> playerList = new ArrayList<>();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                Scanner beholder = new Scanner(child);
                Player myPlayer = new Player(beholder.nextLine());
                myPlayer.setScore(Integer.parseInt(beholder.nextLine()));
                beholder.nextLine();
                myPlayer.setOver(Boolean.parseBoolean(beholder.nextLine()));
                playerList.add(myPlayer);
            }
        }
        playerList.sort(Comparator.comparing(Player::getScore).reversed());
        String[][] playerMatrix = new String[playerList.size()][3];
        for (int i = 0; i < playerList.size(); i++) {
            Player player = playerList.get(i);
            playerMatrix[i] = new String[]{player.getName(), String.valueOf(player.getScore()), String.valueOf(player.isOver())};
        }

        table = new JTable(playerMatrix, new String[]{"Name", "Score", "Is game finished"});
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 495, 780, 350);
        panel.add(scrollPane);

        JLabel lblNewLabel_2 = new JLabel("THE LORD OF THE ARKANOIDS");
        lblNewLabel_2.setForeground(new Color(255, 215, 0));
        lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD, 49));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(0, 0, 800, 145);
        panel.add(lblNewLabel_2);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(0, 0, 800, 900);
        lblNewLabel.setIcon(new ImageIcon("rhrqpid--2-.jpg"));
        panel.add(lblNewLabel);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(800, 0, 100, 900);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        btnNewButton_1 = new JButton("Load Game");
        btnNewButton_1.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton_1.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        btnNewButton_1.setFocusable(false);
        btnNewButton_1.setBounds(0, 727, 100, 62);
        btnNewButton_1.setBorder(BorderFactory.createEtchedBorder());
        btnNewButton_1.addActionListener(this);
        panel_1.add(btnNewButton_1);

        btnNewButton = new JButton("New Game");
        btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton.setBounds(0, 630, 100, 62);
        btnNewButton.setFocusable(false);
        btnNewButton.setHorizontalTextPosition(JButton.CENTER);
        btnNewButton.setVerticalTextPosition(JButton.BOTTOM);
        btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        btnNewButton.setBorder(BorderFactory.createEtchedBorder());
        btnNewButton.addActionListener(this);
        panel_1.add(btnNewButton);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setBounds(0, 0, 100, 900);
        lblNewLabel_1.setIcon(new ImageIcon("Webp.net-resizeimage.jpg"));
        panel_1.add(lblNewLabel_1);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnNewButton) {
            this.dispose();
            new Frame3().setVisible(true);
        }
        if(e.getSource() == btnNewButton_1) {
            this.dispose();
            new Frame33().setVisible(true);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        new Frame1().setVisible(true);
    }
}
