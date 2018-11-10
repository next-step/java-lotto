package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningStatus {

    private final Map<Prize, Integer> result = new HashMap<>();

    public WinningStatus(List<Lotto> lottoGames, WinningNumber winningNumber) {
        initialize(lottoGames, winningNumber);
    }

    private void initialize(List<Lotto> lottoGames, WinningNumber winningNumber) {
        for (Lotto lotto : lottoGames) {
            Prize prize = Prize.matchPrize(lotto.match(winningNumber), false);

            result.put(prize, result.getOrDefault(prize, 0) + 1);
        }
    }

    public int getPrizeCount(Prize prize) {
        return result.getOrDefault(prize, 0);
    }

    public double getProfit() {
        int total = result.values().stream().mapToInt(i -> i).sum();
        int win = total - result.getOrDefault(Prize.NONE, 0);

        return Double.parseDouble(String.format("%.2f", (win / (double) total)));
    }
}
