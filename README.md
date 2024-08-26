# Java Audio Player

Este projeto é um simples player de áudio desenvolvido em Java, utilizando o padrão de design **State** para gerenciar o comportamento do player em diferentes estados. A aplicação possui uma interface gráfica construída com **Swing** e suporta a reprodução de arquivos de áudio nos formatos **WAV** e **MP3**.

## Sumário

- [Funcionalidades](#funcionalidades)
- [Requisitos](#requisitos)
- [Diagrama de Classe](#diagrama-de-classe)
- [Estrutura do Projeto](#estrutura-do-projeto)

## Funcionalidades

- **Reprodução de Áudio**: Reproduz arquivos de áudio nos formatos WAV e MP3.
- **Controles de Reproduçāo**: Controles para Play, Stop, Próxima faixa e Faixa anterior.
- **Padrão de Design State**: Gerenciamento de estados do player, como Ready, Playing, e Locked.

## Requisitos

- **Java 8** ou superior.
- **Maven** (para gerenciar dependências).
- **JLayer** (para suporte à reprodução de MP3).

## Diagrama de Classe

```classDiagram
    class AudioPlayer {
        - State state
        - boolean isPlaying
        - List~String~ playlist
        - int currentTrack
        - Player mp3Player
        - Thread playerThread
        + AudioPlayer()
        + void setState(State state)
        + void setPlaying(boolean playing)
        + boolean isPlaying()
        + void startPlayback()
        + void stopPlayback()
        + void nextTrack()
        + void previousTrack()
        + void pressPlay()
        + void pressStop()
        + void pressNext()
        + void pressPrevious()
    }

    class State {
        <<interface>>
        + void pressPlay(AudioPlayer player)
        + void pressStop(AudioPlayer player)
        + void pressNext(AudioPlayer player)
        + void pressPrevious(AudioPlayer player)
    }

    class ReadyState {
        + void pressPlay(AudioPlayer player)
        + void pressStop(AudioPlayer player)
        + void pressNext(AudioPlayer player)
        + void pressPrevious(AudioPlayer player)
    }

    class PlayingState {
        + void pressPlay(AudioPlayer player)
        + void pressStop(AudioPlayer player)
        + void pressNext(AudioPlayer player)
        + void pressPrevious(AudioPlayer player)
    }

    class LockedState {
        + void pressPlay(AudioPlayer player)
        + void pressStop(AudioPlayer player)
        + void pressNext(AudioPlayer player)
        + void pressPrevious(AudioPlayer player)
    }

    AudioPlayer --> State : has
    State <|.. ReadyState : implements
    State <|.. PlayingState : implements
    State <|.. LockedState : implements
```

## Estrutura do Projeto

```audio-player/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── player/
│   │   │   │   │   ├── AudioPlayer.java
│   │   │   │   │   ├── states/
│   │   │   │   │   │   ├── LockedState.java
│   │   │   │   │   │   ├── PlayingState.java
│   │   │   │   │   │   ├── ReadyState.java
│   │   │   │   │   │   ├── State.java
│   │   │   │   │   ├── ui/
│   │   │   │   │   │   ├── PlayerUI.java
│   │   │   │   │   └── App.java
│   └── resources/
│       ├── track1.wav
│       ├── track2.wav
│       ├── track3.wav
│       ├── ...
````
