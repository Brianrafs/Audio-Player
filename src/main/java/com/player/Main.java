package com.player;

import com.player.ui.PlayerUI;

public class Main {
    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();
        PlayerUI ui = new PlayerUI(player);
        ui.setVisible(true);
    }
}