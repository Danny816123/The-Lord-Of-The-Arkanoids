package The_Lord_of_the_Arkanoids.Graphics;

import The_Lord_of_the_Arkanoids.Models.Player;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static The_Lord_of_the_Arkanoids.Models.Player.loadPlayer;

public class Frame333 extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JTextField textField;
    private JButton btnNewButton;
    private Player player;

    public Frame333(Player playerr) {
        this.player = playerr;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(173, 216, 230));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Enter player name");
        lblNewLabel.setForeground(new Color(0, 0, 0));
        lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 30));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(38, 11, 351, 41);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(10, 81, 414, 41);
        contentPane.add(textField);
        textField.setColumns(10);

        btnNewButton = new JButton("Enter");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnNewButton.setBounds(159, 170, 114, 49);
        btnNewButton.addActionListener(this);
        setLocationRelativeTo(null);
        contentPane.add(btnNewButton);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnNewButton) {
            this.dispose();
            player.setName(textField.getText());
            player.save();
        }
    }


}
