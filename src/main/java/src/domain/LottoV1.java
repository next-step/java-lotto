package src.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoV1 {

    public static final int LOTTO_PRICE = 1000;

    private final Games games;

    private LottoV1(Games games) {
        this.games = games;
    }

    public static LottoV1 lotto(int gameCount) {
        List<Game> games = new ArrayList<>(gameCount);

        for (int idx = 0; idx < gameCount; idx++) {
            games.add(Game.newGame());
        }

        return new LottoV1(new Games(games));
    }

    public static LottoV1 byGames(Games games) {
        return new LottoV1(games);
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

    public Games games() {
        return games;
    }
}
