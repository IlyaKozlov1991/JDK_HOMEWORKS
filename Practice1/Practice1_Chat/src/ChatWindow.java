import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ChatWindow extends JFrame {
    private static final int WIDTH = 700;
    private static final int HEIGHT = 500;
    private static final int POS_X = 100;
    private static final int POSY_Y = 50;
    private static final String USER = System.getProperty("user.name");
    private static final String HOST = System.getProperty("os.name");
    private static JPanel chatPanel;
    private static JPanel buttonsPanel;
    private static JButton exitButton = new JButton("Выход");
    private static JButton sendButton = new JButton("Отправить");
    private static JTextArea inputText, outputText;

    public ChatWindow() throws HeadlessException {
        setBounds(POS_X, POSY_Y, WIDTH, HEIGHT);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 0));

        chatPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        chatPanel.setBorder(BorderFactory.createTitledBorder("Чат"));
        outputText = new JTextArea();
        outputText.setPreferredSize(new Dimension((int) (WIDTH * 0.9), HEIGHT / 3));
        outputText.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        outputText.setLineWrap(true);
        outputText.setEditable(false);
        outputText.setForeground(Color.GREEN);
        chatPanel.add(outputText);

        buttonsPanel = new JPanel(new GridLayout(2, 0));
        JPanel subPanle1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        inputText = new JTextArea();
        inputText.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        inputText.setPreferredSize(new Dimension((int) (WIDTH * 0.9), HEIGHT / 4));
        subPanle1.add(inputText);

        inputText.setLineWrap(true);
        inputText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!inputText.getText().isBlank()) {
                    if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                        sendByKeyEnter();
                    }
                } else {
                    inputText.setText("");
                }
            }
        });
        exitButton.setMinimumSize(new Dimension(60, 30));
        exitButton.setMaximumSize(new Dimension(80, 30));
        exitButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        exitButton.setFocusable(false);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        sendButton.setMinimumSize(new Dimension(60, 30));
        sendButton.setMaximumSize(new Dimension(60, 30));
        sendButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        sendButton.setFocusable(false);
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!inputText.getText().isEmpty()) {
                    sendByButton();
                }
            }
        });

        JPanel subPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 50));
        subPanel2.add(exitButton);
        subPanel2.add(sendButton);

        buttonsPanel.add(subPanle1);
        buttonsPanel.add(subPanel2);

        add(chatPanel);
        add(buttonsPanel);

        pack();
        setVisible(true);
        inputText.requestFocus();
    }

    private void sendByButton() {
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm"));
        outputText.append(time + ": "+ USER + ": " + inputText.getText() + System.lineSeparator());
        inputText.setText("");
        outputText.append(time + ": "+ HOST + ": ВОТ МОЙ ОТВЕТ\n" + System.lineSeparator());
    }

    private void sendByKeyEnter() {
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm"));
        outputText.append(time + ": "+ USER + ": " + inputText.getText());
        inputText.setText("");
        outputText.append(time + ": "+ HOST + ": ВОТ МОЙ ОТВЕТ\n" + System.lineSeparator());
    }
}
