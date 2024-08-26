package com.player;

import com.player.states.*;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AudioPlayer {
    private State state;
    private boolean isPlaying;
    private final List<String> playlist;
    private int currentTrack;
    private Player mp3Player;
    private Thread playerThread;

    public AudioPlayer() {
        this.state = new ReadyState();
        this.isPlaying = false;
        this.playlist = new ArrayList<>();
        this.playlist.add("src/main/resources/Bendito_Eh_O_Rei_Fhop_Music.mp3");
        this.playlist.add("src/main/resources/Fernandinho_Os_Que_Confiam.mp3");
        this.playlist.add("src/main/resources/Oficina_G3_Até Quando.mp3");
        this.currentTrack = 0;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setPlaying(boolean playing) {
        this.isPlaying = playing;
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }

    public void startPlayback() {
        try {
            if (mp3Player != null) {
                stopPlayback();
            }

            FileInputStream fis = new FileInputStream(playlist.get(currentTrack));
            mp3Player = new Player(fis);

            playerThread = new Thread(() -> {
                try {
                    mp3Player.play();
                } catch (JavaLayerException e) {
                    e.printStackTrace();
                }
            });

            playerThread.start();
            this.isPlaying = true;
            System.out.println("Reproduzindo: " + playlist.get(currentTrack));
        } catch (IOException | JavaLayerException e) {
            e.printStackTrace();
        }
    }

    public void stopPlayback() {
        if (mp3Player != null) {
            mp3Player.close();
            playerThread.interrupt();
            this.isPlaying = false;
        }
    }

    public void nextTrack() {
        stopPlayback();
        currentTrack = (currentTrack + 1) % playlist.size();
        startPlayback();
    }

    public void previousTrack() {
        stopPlayback();
        currentTrack = (currentTrack - 1 + playlist.size()) % playlist.size();
        startPlayback();
    }

    public void pressPlay() {
        state.pressPlay(this);
    }

    public void pressStop() {
        state.pressStop(this);
    }

    public void pressNext() {
        state.pressNext(this);
    }

    public void pressPrevious() {
        state.pressPrevious(this);
    }
}