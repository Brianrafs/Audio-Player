package com.player.ui;

import com.player.AudioPlayer;
import com.player.Main;

import javax.swing.*;


public class PlayerUI extends JFrame {
    private final AudioPlayer player;

    public PlayerUI(AudioPlayer player) {
        this.player = player;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Audio Player");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JButton playButton = new JButton("Play");
        playButton.setBounds(30, 30, 100, 30);
        playButton.addActionListener(e -> player.pressPlay());

        JButton stopButton = new JButton("Stop");
        stopButton.setBounds(150, 30, 100, 30);
        stopButton.addActionListener(e -> player.pressStop());

        JButton nextButton = new JButton("Next");
        nextButton.setBounds(30, 80, 100, 30);
        nextButton.addActionListener(e -> player.pressNext());

        JButton prevButton = new JButton("Previous");
        prevButton.setBounds(150, 80, 100, 30);
        prevButton.addActionListener(e -> player.pressPrevious());

        add(playButton);
        add(stopButton);
        add(nextButton);
        add(prevButton);
    }

    public static void main(String[] args) {
        Main.main(new String[0]);
    }
}
