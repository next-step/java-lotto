package lotto.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Round {
    private final List<Game> games;

    public Round(int gameCount, NumberGenerateStrategy numberGenerateStrategy) {
        this.games = new ArrayList<>(gameCount);

        for (int i = 0; i < gameCount; i++) {
            List<Integer> numbers = numberGenerateStrategy.generate();
            this.games.add(new Game(numbers));
        }
    }

    public List<Game> getGames() {
        return Collections.unmodifiableList(games);
    }

    public int gameCount() {
        return games.size();
    }
}
