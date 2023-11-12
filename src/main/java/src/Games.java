package src;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Games {

    private final List<Game> values;

    private Map<WinningAmount, Integer> matchStatus = new EnumMap<>(WinningAmount.class);

    private double profit;

    public Games(List<Game> values) {
        this.values = values;
    }

    public int gameSize() {
        return values.size();
    }

    public Map<WinningAmount, Integer> matchStatus() {
        return matchStatus;
    }

    public double profitRate(long lottoPrice) {
        return profit / (lottoPrice * gameSize());
    }

    public void matchGames(Game winningGame) {
        matchStatus = new EnumMap<>(WinningAmount.class);
        for (Game game: values) {
            game.match(winningGame);
            WinningAmount winningAmount = WinningAmount.byMatchedCount(game.matchCount());
            Integer winningGameCount = matchStatus.getOrDefault(winningAmount, 0);
            matchStatus.put(winningAmount, winningGameCount + 1);
        }

        calculateProfit();
    }

    private void calculateProfit() {
        for (Map.Entry<WinningAmount, Integer> entry: matchStatus.entrySet()) {
            profit += entry.getKey().amount * entry.getValue();
        }
    }
}
