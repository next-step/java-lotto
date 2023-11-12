package src;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    public static final int LOTTO_PRICE = 1000;

    private final Games games;

    private Lotto(Games games) {
        this.games = games;
    }

    public static Lotto lotto(int gameCount) {
        List<Game> games = new ArrayList<>(gameCount);

        for (int idx = 0; idx < gameCount; idx++) {
            games.add(Game.newGame());
        }

        return new Lotto(new Games(games));
    }

    public static Lotto byGames(Games games) {
        return new Lotto(games);
    }

    public int gameCount() {
        return games.gameSize();
    }

    public double profitRate() {
        return games.profitRate(LOTTO_PRICE);
    }

    public void match(Game winningGame) {
        games.matchGames(winningGame);
    }

    public MatchStatus matchStatus() {
        return games.matchStatus();
    }
}
