package lotto.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;

public class Round {
    private final List<Game> games;

    public Round(int gameCount, LottoNumberGenerateStrategy lottoNumberGenerateStrategy) {
        this.games = new ArrayList<>(gameCount);

        for (int i = 0; i < gameCount; i++) {
            LottoNumbers lottoNumbers = lottoNumberGenerateStrategy.generate();
            this.games.add(new Game(lottoNumbers));
        }
    }

    public List<Game> getGames() {
        return Collections.unmodifiableList(games);
    }

    public int gameCount() {
        return games.size();
    }

    public EnumMap<Rank, Integer> getResult(LottoNumbers winNumbers) {
        EnumMap<Rank, Integer> result = new EnumMap<>(Rank.class);
        for (Game game : this.games) {
            Rank rank = game.win(winNumbers);
            result.merge(rank, 1, (existValue, initialValue) -> existValue + 1);
        }
        return result;
    }

    public long totalAward(LottoNumbers winNumbers) {
        return getResult(winNumbers).entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().award * entry.getValue())
                .sum();
    }
}
