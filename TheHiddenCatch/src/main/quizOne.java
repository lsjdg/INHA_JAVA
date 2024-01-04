package main;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class quizOne extends JFrame{
    public quizOne(){
        setTitle("The Hidden Catch!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);

        JLabel title = new JLabel("JAVA QUIZ #1");
        title.setFont(new Font("SansSerif", Font.BOLD, 50));
        JLabel subtitle = new JLabel("solve and get a dlwlrma chance!");
        subtitle.setFont(new Font("SansSerif", Font.BOLD, 20));

        JButton submit = new JButton("Submit");
        Font buttonFont = new Font("SansSerif", Font.BOLD, 20);
        submit.setFont((buttonFont));
        submit.setPreferredSize(new Dimension(200, 100));

        JPanel row1 = new JPanel();
        row1.setLayout(new BoxLayout(row1, BoxLayout.Y_AXIS));
        row1.add(Box.createVerticalGlue());
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        row1.add(title);
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        row1.add(subtitle);
        row1.add(Box.createVerticalGlue());
        row1.setPreferredSize(new Dimension(this.getWidth(), 300));
        c.add(row1);

        JPanel row2 = new JPanel();
        row2.setLayout(new BoxLayout(row2, BoxLayout.Y_AXIS));
        JLabel question = new JLabel("True or False? : Arraylists in JAVA use generic types");
        question.setFont(new Font("SansSerif", Font.BOLD, 20));
        question.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel answerBox = new JPanel();
        answerBox.setLayout(new BoxLayout(answerBox, BoxLayout.X_AXIS));
        ButtonGroup answers = new ButtonGroup();
        JRadioButton t = new JRadioButton("True");
        JRadioButton f = new JRadioButton("False");
        answers.add(t);
        answers.add(f);
        answerBox.add(t);
        answerBox.add(f);

        row2.add(question);
        row2.add(Box.createVerticalStrut(50));
        row2.add(answerBox);
        row2.setPreferredSize(new Dimension(this.getWidth(), 600));
        c.add(row2);

        JPanel row3 = new JPanel();
        row3.setPreferredSize(new Dimension(this.getWidth(), 200));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        row3.setLayout(new BoxLayout(row3, BoxLayout.X_AXIS));
        row3.add(Box.createHorizontalGlue());
        buttonPanel.add(submit);
        row3.add(buttonPanel);

        c.add(row3);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message;
                ImageIcon newIcon;
                if (t.isSelected()) {
                    newIcon = new ImageIcon("./src/img/iuHappy.jpeg");
                    message = "Correct! Get your extra chance.";
                    levelOne.itemCount++;
                } else {
                    newIcon = new ImageIcon("./src/img/iuSad.jpeg");
                    message = "Wrong! No extra chance.";
                }

                Object[] options = {"Continue"};
                Image image = newIcon.getImage();
                Image resizedImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon resizedIcon = new ImageIcon(resizedImage);

                int option = JOptionPane.showOptionDialog(null, message,
                        "Result", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, resizedIcon, options, options[0]);

                if (option == JOptionPane.OK_OPTION) {
                    new levelTwo();
                }
            }
        });

    }

    public static void main(String[] args){
        new quizOne();
    }
}


