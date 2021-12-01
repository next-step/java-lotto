package lotto.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
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

    public EnumMap<Rank, Integer> getResult(List<Integer> winNumbers) {
        EnumMap<Rank, Integer> result = new EnumMap<>(Rank.class);
        for (Game game : this.games) {
            Rank rank = game.win(winNumbers);
            result.merge(rank, 1, (k, v) -> result.get(rank) + 1);
        }
        return result;
    }

    public long totalAward(List<Integer> winNumbers) {
        return getResult(winNumbers).entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().award * entry.getValue())
                .sum();
    }
}
