package src.domain;

import java.util.ArrayList;
import java.util.List;

public class Games {

    private final List<Game> values;

    public Games(List<Game> values) {
        this.values = values;
    }

    public int gameSize() {
        return values.size();
    }

    public double profitRate(long lottoPrice) {
        return matchStatus().profit() / (lottoPrice * gameSize());
    }

    public MatchStatus matchStatus() {
        List<Integer> matchCounts = new ArrayList<>(values.size());
        for (Game game: values) {
            matchCounts.add(game.matchCount());
        }

        return MatchStatus.matchStatus(matchCounts);
    }

    public void matchGames(Game winningGame) {
        for (Game game: values) {
            game.match(winningGame);
        }
    }
}
