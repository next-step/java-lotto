package com.hskim.lotto.model;

import java.util.Objects;

public class GameNum {

    private int gameNum;

    public GameNum(int gameNum) {

        this.gameNum = gameNum;
    }

    public void playGame() {

        gameNum--;
    }

    public boolean isPlayable(){

        return gameNum > 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameNum)) return false;
        GameNum gameNum1 = (GameNum) o;
        return gameNum == gameNum1.gameNum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameNum);
    }
}
