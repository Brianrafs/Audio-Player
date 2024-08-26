package com.player.states;

import com.player.AudioPlayer;

public class ReadyState implements State {

    @Override
    public void pressPlay(AudioPlayer player) {
        player.startPlayback();
        player.setState(new PlayingState());
    }

    @Override
    public void pressStop(AudioPlayer player) {
        player.setState(new LockedState());
    }

    @Override
    public void pressNext(AudioPlayer player) {
    }

    @Override
    public void pressPrevious(AudioPlayer player) {
    }
}
