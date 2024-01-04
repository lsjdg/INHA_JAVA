package main;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class end extends JFrame {
    public static int timeLeftSum = 0;
    private JTextField nameTextField;
    private JLabel timeLeftLabel;
    private JButton submitButton;
    private JTextArea scoreboardTextArea;
    private JButton retakeButton;

    public end() {
        setTitle("Scoreboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Enter your name");
        title.setFont(new Font("SansSerif", Font.BOLD, 20));
        nameTextField = new JTextField(10);
        timeLeftLabel = new JLabel("Total Time Left: " + timeLeftSum + '\n');
        timeLeftLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        submitButton = new JButton("Submit");
        scoreboardTextArea = new JTextArea();
        retakeButton = new JButton("Retake JAVA?");

        JPanel topPanel = new JPanel();
        topPanel.add(title);
        topPanel.add(nameTextField);
        topPanel.add(timeLeftLabel);
        topPanel.add(submitButton);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());

        JLabel scoreboardLabel = new JLabel("Scoreboard");
        scoreboardLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
        scoreboardLabel.setHorizontalAlignment(SwingConstants.CENTER);
        bottomPanel.add(scoreboardLabel, BorderLayout.NORTH);

        scoreboardTextArea.setFont(new Font("SansSerif", Font.PLAIN, 20));
        scoreboardTextArea.setEditable(false);

        bottomPanel.add(new JScrollPane(scoreboardTextArea), BorderLayout.CENTER);
        bottomPanel.add(retakeButton, BorderLayout.SOUTH);

        add(topPanel, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.CENTER);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                String message = name + " - Total Time Left: " + timeLeftSum;

                writeToFile(message);
                updateScoreboard();

                ImageIcon icon = new ImageIcon("./src/img/iuHappy.jpeg");
                Image image = icon.getImage();
                Image resizedImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon resizedIcon = new ImageIcon(resizedImage);

                JOptionPane.showMessageDialog(null, "Project Submitted Successfully!",
                        "Success", JOptionPane.INFORMATION_MESSAGE, resizedIcon);
            }
        });

        retakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new home();
                dispose();
            }
        });

        setSize(1500, 1000);
        setVisible(true);

        updateScoreboard();
    }

    private void writeToFile(String message) {
        try {
            File file = new File("./src/main/scoreboard.txt");
            FileWriter writer = new FileWriter(file, true);
            writer.write(message + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateScoreboard() {
        try {
            File file = new File("./src/main/scoreboard.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            StringBuilder scoreboard = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                scoreboard.append(line).append("\n");
            }
            bufferedReader.close();
            scoreboardTextArea.setText(scoreboard.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new end();
    }
}