package com.player.states;

import com.player.AudioPlayer;

public class LockedState implements State {

    @Override
    public void pressPlay(AudioPlayer player) {
        player.setState(new ReadyState());
    }

    @Override
    public void pressStop(AudioPlayer player) {
        if (player.isPlaying()) {
            player.setPlaying(false);
            player.setState(new ReadyState());
        } else {
            System.out.println("Player está travado.");
        }
    }

    @Override
    public void pressNext(AudioPlayer player) {
    }

    @Override
    public void pressPrevious(AudioPlayer player) {
    }
}
