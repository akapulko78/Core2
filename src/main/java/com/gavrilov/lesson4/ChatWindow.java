package com.gavrilov.lesson4;

import javax.swing.*;
import java.awt.*;

public class ChatWindow extends JFrame {

    private JTextField jtf;
    private JTextArea jta;

    public ChatWindow() {
        setTitle("My Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);

        JButton sendButton = new JButton("sent message");
        add(sendButton, BorderLayout.SOUTH);
        sendButton.addActionListener(e -> sendMsg());

        jta = new JTextArea(10, 20);
        jta.setLineWrap(true);
        jta.setEditable(false);

        JScrollPane jsp = new JScrollPane(jta);
        add(jsp, BorderLayout.CENTER);

        jtf = new JTextField(25);

        jtf.addActionListener(e -> sendMsg());//отправка сообщение нажатием ENTER

        JPanel upperPanel = new JPanel(new BorderLayout());
        upperPanel.add(sendButton, BorderLayout.EAST);
        upperPanel.add(jtf, BorderLayout.WEST);
        add(upperPanel, BorderLayout.SOUTH);

        Font font = new Font("Arial", Font.BOLD, 18);
        jta.setFont(font);

        setVisible(true);
    }

    public void sendMsg() {
        jta.append(jtf.getText() + "\n");
        jtf.setText("");
        jtf.grabFocus();
    }
}
