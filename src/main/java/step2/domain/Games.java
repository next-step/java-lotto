package step2.domain;

import java.util.List;

public class Games {

    private List<Game> games;
    private int gameCount;

    public void init(Seed seed, int amountPerGame) {
        gameCount = seed.amount() / amountPerGame;
    }

    public int size() {
        return gameCount;
    }
}
