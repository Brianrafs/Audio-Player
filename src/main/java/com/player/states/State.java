package com.player.states;

import com.player.AudioPlayer;

public interface State {
    void pressPlay(AudioPlayer player);
    void pressStop(AudioPlayer player);
    void pressNext(AudioPlayer player);
    void pressPrevious(AudioPlayer player);
}
