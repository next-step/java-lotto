package src;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Lotto {

    public static final int LOTTO_PRICE = 1000;

    private final List<Game> games;

    private Map<WinningAmount, Integer> matchStatus = new EnumMap<>(WinningAmount.class);

    private double profit = 0.0;

    private Lotto(int gameCount) {
        this.games = new ArrayList<>(gameCount);
    }

    public static Lotto lotto(int gameCount) {
        Lotto lotto = new Lotto(gameCount);

        for (int idx = 0; idx < gameCount; idx++) {
            lotto.games.add(Game.newGame());
        }

        return lotto;
    }

    public static Lotto byGames(List<Game> games) {
        Lotto lotto = new Lotto(games.size());
        lotto.games.addAll(games);

        return lotto;
    }

    public int gameCount() {
        return games.size();
    }

    public Map<WinningAmount, Integer> matchStatus() {
        return matchStatus;
    }

    public double profitRate() {
        return profit / (LOTTO_PRICE * gameCount());
    }

    public void match(Game winningGame) {
        matchGames(winningGame);
        calculateProfit();
    }

    private void matchGames(Game winningGame) {
        matchStatus = new EnumMap<>(WinningAmount.class);
        for (Game game: games) {
            game.match(winningGame);
            WinningAmount winningAmount = WinningAmount.byMatchedCount(game.matchCount());
            Integer winningGameCount = matchStatus.getOrDefault(winningAmount, 0);
            matchStatus.put(winningAmount, winningGameCount + 1);
        }
    }

    private void calculateProfit() {
        for (Map.Entry<WinningAmount, Integer> entry: matchStatus.entrySet()) {
            profit += entry.getKey().amount * entry.getValue();
        }
    }
}
