package main;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class help extends JFrame {
    public help() {
        setTitle("The Hidden Catch!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);

        Font defaultFont = new Font("SansSerif", Font.BOLD, 15);

        JPanel north = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel title = new JLabel("Instructions");
        title.setFont(new Font("SansSerif", Font.BOLD, 50));
        north.add(title);
        c.add(north, BorderLayout.NORTH);

        JPanel west = new JPanel();
        west.setLayout(new BoxLayout(west, BoxLayout.Y_AXIS));
        west.setPreferredSize(new Dimension(600, 600));

        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel help1 = new JLabel("<html>You are to finish a JAVA PROJECT, 'Lab_dlwlrma'.<br>" +
                "The project consists of three tasks.<br>" +
                "Don't panic! dlwlrma will be there to help you.</html>");
        help1.setFont(defaultFont);
        panel1.add(help1);
        west.add(panel1);

        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel help2 = new JLabel("<html>Take a look at the image above.<br>Then click on five differences below IN TIME.<br>" +
                "You can click wherever you want, but beware!<br> Wrong clicks will reduce your time.</html>");
        help2.setFont(defaultFont);
        panel2.add(help2);
        west.add(panel2);

        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel help3 = new JLabel("<html><br> dlwlrma will give extra time when you press 'A'.<br>" +
                "You get a chance for solving JAVA quizzes between every tasks.<br>" +
                "dlwlrma gave you 3 squares of truth. Use them by pressing 'S'.<br>" +
                "You cannot get extra squares, so use wisely!<br>"+
                "Make it to the final task and finish the JAVA PROJECT!</html>");
        help3.setFont(defaultFont);
        panel3.add(help3);
        west.add(panel3);

        JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel help4 = new JLabel("<html><br>If you finish your project before the deadline,<br>" +
                "(it is due 23:30, but submission will be permitted by 23:55)<br>"+
                "Professor LeeWook will give you the honor of <br>leaving your name" +
                " ON THE SCORE BOARD! Good Luck :)</html>");
        help4.setFont(defaultFont);
        panel4.add(help4);
        west.add(panel4);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton home = new JButton("Home");
        home.setFont(defaultFont);
        home.setPreferredSize(new Dimension(200, 100));
        JButton start = new JButton("Start");
        start.setFont(defaultFont);
        start.setPreferredSize(new Dimension(200, 100));
        buttonPanel.add(home);
        buttonPanel.add(start);
        west.add(buttonPanel);
        c.add(west, BorderLayout.WEST);

        JPanel east = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image img = new ImageIcon("./src/img/testPic.jpeg").getImage();
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };
        east.setLayout(new GridLayout(1, 1));
        east.setPreferredSize(new Dimension(north.getWidth()-west.getWidth(), 600));
        c.add(east, BorderLayout.CENTER);



        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new home();
            }
        });

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new levelOne();
            }
        });
    }


    public static void main(String[] args) {
        new help();
    }
}

