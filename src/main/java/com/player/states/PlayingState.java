package com.player.states;

import com.player.AudioPlayer;

public class PlayingState implements State {

    @Override
    public void pressPlay(AudioPlayer player) {
        player.setPlaying(false);
        player.setState(new ReadyState());
    }

    @Override
    public void pressStop(AudioPlayer player) {
        player.setPlaying(false);
        player.setState(new LockedState());
    }

    @Override
    public void pressNext(AudioPlayer player) {
        player.nextTrack();
    }

    @Override
    public void pressPrevious(AudioPlayer player) {
        player.previousTrack();
    }
}
