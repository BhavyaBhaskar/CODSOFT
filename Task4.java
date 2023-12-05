// QUIZ APPLICATION WITH TIMER
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Task3 {
    private JFrame frame;
    private JLabel timerLabel;
    private JLabel questionLabel;
    private JButton[] optionButtons;
    private Timer timer;
    private int currentQuestionIndex;
    private int score;
    private int timerSeconds;

    private String[][] questions = {
            {"Which programming language is this quiz written in?", "A. Java", "B. Python", "C. C++", "D. JavaScript", "A"},
            {"Who invented Java Programming?", "A. Guido van Rossum", "B. James Gosling", "C. Dennis Ritchie", "D. Bjarne Stroustrup", "B"},
            {"Which statement is true about Java?", "A. Java is a sequence-dependent programming language", "B. Java is a code dependent programming language", "C. Java is a platform-dependent programming language", "D. Java is a platform-independent programming language", "D"},
            {"Which component is used to compile, debug and execute the java programs?", "A. JRE", "B. JIT", "C. JDK", "D. JVM", "C"},
            {"Which one of the following is not a Java feature?", "A. Object-oriented","B. Use of pointers", "C. Portable", "D. Dynamic and Extensible", "B"},
            {"Which of these cannot be used for a variable name in Java?", "A. identifier & keyword", "B. identifier", "C. keyword", "D. none of the mentioned", "C"}
            // Add more questions here
    };

    public Task3() {
        frame = new JFrame("Quiz Application");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        timerLabel = new JLabel("Time left: ");
        frame.add(timerLabel);

        questionLabel = new JLabel("");
        frame.add(questionLabel);

        optionButtons = new JButton[4];
        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JButton("");
            optionButtons[i].addActionListener(new OptionButtonListener(i));
            frame.add(optionButtons[i]);
        }

        currentQuestionIndex = 0;
        score = 0;
        timerSeconds = 10;

        loadQuestion();
        startTimer();

        frame.setVisible(true);
    }

    private void loadQuestion() {
        if (currentQuestionIndex < questions.length) {
            String[] questionData = questions[currentQuestionIndex];
            questionLabel.setText(questionData[0]);

            for (int i = 0; i < 4; i++) {
                optionButtons[i].setText(questionData[i + 1]);
            }
        } else {
            showResults();
        }
    }

    private void startTimer() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTimer();
            }
        });
        timer.start();
    }

    private void updateTimer() {
        timerLabel.setText("Time left: " + timerSeconds + "s");
        if (timerSeconds > 0) {
            timerSeconds--;
        } else {
            submitAnswer(-1); // Timeout
        }
    }

    private void submitAnswer(int optionIndex) {
        String correctAnswer = questions[currentQuestionIndex][5];

        if (optionIndex != -1 && questions[currentQuestionIndex][optionIndex + 1].charAt(0) == correctAnswer.charAt(0)) {
            score++;
        }

        currentQuestionIndex++;

        if (currentQuestionIndex < questions.length) {
            loadQuestion();
            timerSeconds = 10;
        } else {
            showResults();
        }
    }

    private void showResults() {
        timer.stop();
        JOptionPane.showMessageDialog(frame, "Quiz Completed\nYour score: " + score + "/" + questions.length);
        frame.dispose();
    }

    private class OptionButtonListener implements ActionListener {
        private int optionIndex;

        public OptionButtonListener(int optionIndex) {
            this.optionIndex = optionIndex;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            submitAnswer(optionIndex);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Task3();
            }
        });
    }
}
