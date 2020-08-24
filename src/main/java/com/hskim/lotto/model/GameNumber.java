package com.hskim.lotto.model;

import java.util.Objects;

public class GameNumber {

    private int gameNum;

    public GameNumber(int gameNum) {
        this.gameNum = gameNum;
    }

    public void playGame() {
        gameNum--;
    }

    public boolean isPlayable() {
        return gameNum > 0;
    }

    public int getGameNum() {
        return gameNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameNumber)) return false;
        GameNumber gameNumber1 = (GameNumber) o;
        return gameNum == gameNumber1.gameNum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameNum);
    }
}
