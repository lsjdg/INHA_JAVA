package main;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.sound.sampled.*;
import java.io.*;

public class home extends JFrame{
    public home(){
        setTitle("The Hidden Catch!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);

        JLabel title = new JLabel("The Hidden Catch!");
        title.setFont(new Font("SansSerif", Font.BOLD, 50));
        JLabel subtitle = new JLabel("JAVA PROJECT: Lab_dlwlrma");
        subtitle.setFont(new Font("SansSerif", Font.BOLD, 20));
        JLabel credits = new JLabel("credits: 12224427 Lee SeungJun");
        credits.setFont(new Font("SansSerif", Font.BOLD, 20));

        JButton help = new JButton("Help");
        JButton start = new JButton("Start");
        Font buttonFont = new Font("SansSerif", Font.BOLD, 20);
        help.setFont(buttonFont);
        help.setPreferredSize(new Dimension(200, 100));
        start.setFont((buttonFont));
        start.setPreferredSize(new Dimension(200, 100));

        JPanel row1 = new JPanel();
        row1.setLayout(new BoxLayout(row1, BoxLayout.Y_AXIS));
        row1.setAlignmentX(Component.CENTER_ALIGNMENT);
        row1.add(Box.createVerticalGlue());
        row1.add(title);
        row1.add(subtitle);
        row1.add(Box.createVerticalGlue());
        row1.setPreferredSize(new Dimension(this.getWidth(), 300));
        c.add(row1);

        JPanel row2 = new JPanel();
        row2.setLayout(new BorderLayout());
        row2.setPreferredSize(new Dimension(this.getWidth(), 600));
        ImageIcon originalImageIcon = new ImageIcon("./src/img/iuMain.jpeg");
        int originalWidth = originalImageIcon.getIconWidth();
        int originalHeight = originalImageIcon.getIconHeight();
        int scaledWidth = 1000;
        int scaledHeight = (int) (((float) originalHeight / originalWidth) * scaledWidth);
        Image scaledImage = originalImageIcon.getImage().getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledImageIcon);
        row2.add(imageLabel, BorderLayout.CENTER);
        c.add(row2);


        JPanel row3 = new JPanel();
        row3.setPreferredSize(new Dimension(this.getWidth(), 200));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        row3.setLayout(new BoxLayout(row3, BoxLayout.X_AXIS));
        row3.add(credits);
        row3.add(Box.createHorizontalGlue());
        buttonPanel.add(help);
        buttonPanel.add(start);
        row3.add(buttonPanel);

        c.add(row3);

        help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new help();
            }
        });

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new levelOne();
            }
        });
        loadAudio("./src/audio/friday.wav");
    }

    public void loadAudio(String filePath) {
        try {
            Clip clip = AudioSystem.getClip();
            File audioFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            clip.open(audioStream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    public static void main(String[] args){
        new home();
    }
}


