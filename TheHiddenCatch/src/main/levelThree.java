package main;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;


public class levelThree extends JFrame {
    private int timeLeft = 60;
    private int findCount = 0;
    private JLabel timerLabel;
    private JLabel itemCountLabel;
    private JLabel squareCountLabel;
    private JLabel imageLabel;
    private ArrayList<Range> answers = new ArrayList<Range>() {{
        add(new Range(372,722,554,775));
        add(new Range(833,603,935,654));
        add(new Range(844,804,1140,839));
        add(new Range(1403,691,1572,750));
        add(new Range(1226,798,1478,858));
    }};
    private ArrayList<Range> answersCopy = new ArrayList<Range>(answers);
    public boolean wasAnswer(Point p){
        for (Range r : answersCopy){
            if (r.contains(p)) {return true;}
        }
        return false;
    }
    private ArrayList<Point> clickPoints = new ArrayList<>();
    private TimerThread timerThread;

    public levelThree() {
        setTitle("The Hidden Catch!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        timerLabel = new JLabel("Time left: ");
        itemCountLabel = new JLabel("Items left: " + levelOne.itemCount);
        squareCountLabel = new JLabel("Squares left: " + levelOne.squareCount);
        timerLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        itemCountLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        squareCountLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        topPanel.add(Box.createRigidArea(new Dimension(100, 0)));
        topPanel.add(timerLabel);
        topPanel.add(Box.createRigidArea(new Dimension(1000, 0)));
        topPanel.add(squareCountLabel);
        topPanel.add(Box.createRigidArea(new Dimension(15, 0)));
        topPanel.add(itemCountLabel);
        c.add(topPanel, BorderLayout.NORTH);

        imageLabel = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.RED);
                g2.setStroke(new BasicStroke(5));
                for (Point p : clickPoints) {
                    g2.drawOval(p.x - 20, p.y - 20, 40, 40);
                }
            }
        };
        c.add(imageLabel, BorderLayout.CENTER);

        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                ImageIcon imageIcon = new ImageIcon(new ImageIcon("./src/img/level3.jpeg").
                        getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH));
                imageLabel.setIcon(imageIcon);
            }
        });

        JPanel bottomPanel = new JPanel();
        JButton home = new JButton("Home");
        bottomPanel.add(home);
        c.add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
        startTimer();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 'a') {
                    if (levelOne.itemCount > 0) {
                        timerThread.changeTime(10);
                        levelOne.itemCount--;
                        itemCountLabel.setText("Items left: " + levelOne.itemCount);
                    }
                }
                if (e.getKeyChar() == 's' && levelOne.squareCount > 0) {
                        levelOne.squareCount--;
                        squareCountLabel.setText("Squares left: " + levelOne.squareCount);
                    if (e.getKeyChar() == 's') {
                        if (!answers.isEmpty()) {
                            Range firstUnfoundAnswer = answers.get(0);
                            int centerX = (int)(firstUnfoundAnswer.getLowerLeft().getX() + firstUnfoundAnswer.getUpperRight().getX()) / 2;
                            int centerY = (int)(firstUnfoundAnswer.getLowerLeft().getY() + firstUnfoundAnswer.getUpperRight().getY()) / 2;
                            //int clipX = Math.max(centerX, 0);
                            int clipX = centerX;
                            //int clipY = Math.max(centerY, 0);
                            int clipY = centerY;

                            Graphics2D g2 = (Graphics2D) imageLabel.getGraphics();

                            g2.setColor(Color.BLUE);
                            g2.setStroke(new BasicStroke(5));
                            g2.drawRect(clipX - 75, clipY - 75, 150, 150);


                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }

                            imageLabel.repaint();
                        }
                    }
                }
            }
        });
        setFocusable(true);
        requestFocus();

        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timerThread.stopTimer();
                new home();
            }
        });

        imageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                boolean found = false;
                Iterator<Range> iterator = answers.iterator();
                while (iterator.hasNext()) {
                    Range answer = iterator.next();
                    if (answer.contains(e.getPoint())) {
                        clickPoints.add(e.getPoint());
                        repaint();
                        findCount++;
                        iterator.remove();
                        found = true;
                        break;
                    }
                }

                if (!found && !wasAnswer(e.getPoint())) {
                    timerThread.changeTime(-10);
                }

                if (findCount == 5) {
                    timerThread.stopTimer();
                    int timeLeft = timerThread.getSeconds();
                    end.timeLeftSum += timeLeft;
                    Object[] options = {"Submit"};
                    ImageIcon newIcon = new ImageIcon("./src/img/iuHappy.jpeg");
                    Image image = newIcon.getImage();
                    Image resizedImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    ImageIcon resizedIcon = new ImageIcon(resizedImage);
                    int n = JOptionPane.showOptionDialog(null,
                            "PROJECT DONE!\nTime Left: " + timeLeft
                            +"\nSubmit before deadline!", "Congrats!",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, resizedIcon, options, options[0]);
                    if (n == JOptionPane.YES_OPTION) {
                        timerThread.stopTimer();
                        new end();
                    }
                }
            }
        });
    }

    public void startTimer() {
        timerThread = new TimerThread(timerLabel);
        timerThread.start();
    }

    public static void main(String[] args) {
        new levelThree();
    }
}