package main;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

class Range {
    private Point lowerLeft;
    private Point upperRight;

    public Range(int x1, int y1, int x2, int y2) {
        lowerLeft = new Point(x1, y1);
        upperRight = new Point(x2, y2);
    }

    public Point getLowerLeft() {
        return lowerLeft;
    }

    public Point getUpperRight() {
        return upperRight;
    }

    public boolean contains(Point p) {
        return p.getX() >= lowerLeft.getX() && p.getX() <= upperRight.getX() &&
                p.getY() >= lowerLeft.getY() && p.getY() <= upperRight.getY();
    }
}

class TimerThread extends Thread {
    private JLabel time;
    private int seconds = 60;
    private boolean running = true;

    public TimerThread(JLabel time) {
        this.time = time;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(1000);
                seconds--;
                SwingUtilities.invokeLater(() -> time.setText("Time left: " + seconds));

                if (seconds <= 0) {
                    running = false;
                    JButton button = new JButton("Retake Course");
                    button.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            new home();
                            Window window = SwingUtilities.getWindowAncestor(button);
                            window.dispose();
                        }
                    });
                    ImageIcon newIcon = new ImageIcon("./src/img/iuAngry.jpeg");
                    Image image = newIcon.getImage();
                    Image resizedImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    ImageIcon resizedIcon = new ImageIcon(resizedImage);
                    JOptionPane pane = new JOptionPane("You got a F on JAVA...", JOptionPane.INFORMATION_MESSAGE,
                            JOptionPane.DEFAULT_OPTION, resizedIcon, new Object[]{button});
                    JDialog dialog = pane.createDialog("Past Deadline!");
                    dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                    dialog.setVisible(true);
                    running = false;
                }


            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public void changeTime(int x) {
        seconds += x;
    }

    public void stopTimer() {
        running = false;
    }

    public int getSeconds() {
        return seconds;
    }
}


public class levelOne extends JFrame {
    private int findCount = 0;
    public static int itemCount = 5;
    public static int squareCount = 3;
    private JLabel itemCountLabel;
    private JLabel squareCountLabel;
    private JLabel timerLabel;
    private JLabel imageLabel;
    private ArrayList<Range> answers = new ArrayList<Range>() {{
        add(new Range(1462, 488, 1617, 527));
        add(new Range(1195, 525, 1251, 555));
        add(new Range(1486, 740, 1605, 845));
        add(new Range(920, 601, 1003, 644));
        add(new Range(322, 504, 467, 556));
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

    public levelOne() {
        setTitle("The Hidden Catch!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        timerLabel = new JLabel("Time left: ");
        itemCountLabel = new JLabel("Items left: " + itemCount);
        squareCountLabel = new JLabel("Squares left: " + squareCount);
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
                ImageIcon imageIcon = new ImageIcon(new ImageIcon("./src/img/level1.jpeg").
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
                    if (itemCount > 0) {
                        timerThread.changeTime(10);
                        itemCount--;
                        itemCountLabel.setText("Items left: " + itemCount);
                    }
                }
                if (e.getKeyChar() == 's' && squareCount > 0) {
                        squareCount--;
                        squareCountLabel.setText("Squares left: " + squareCount);
                    if (!answers.isEmpty()) {
                        Range firstUnfoundAnswer = answers.get(0);
                        int centerX = (int) (firstUnfoundAnswer.getLowerLeft().getX() + firstUnfoundAnswer.getUpperRight().getX()) / 2;
                        int centerY = (int) (firstUnfoundAnswer.getLowerLeft().getY() + firstUnfoundAnswer.getUpperRight().getY()) / 2;
                        int clipX = centerX;
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
                    ImageIcon newIcon = new ImageIcon("./src/img/iuHappy.jpeg");
                    int timeLeft = timerThread.getSeconds();
                    end.timeLeftSum += timeLeft;
                    Object[] options = {"Yes"};
                    Image image = newIcon.getImage();
                    Image resizedImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    ImageIcon resizedIcon = new ImageIcon(resizedImage);
                    int n = JOptionPane.showOptionDialog(null,
                            "Level Clear! Ready for quiz?\nTime Left: " + timeLeft, "Congrats!",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, resizedIcon, options, options[0]);
                    if (n == JOptionPane.YES_OPTION) {
                        timerThread.stopTimer();
                        new quizOne();
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
        new levelOne();
    }
}
