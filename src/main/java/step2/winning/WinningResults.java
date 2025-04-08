package step2.winning;

import java.util.Map;

public class WinningResults {
    private Map<Winning, Integer> prizeAmounts;

    public WinningResults(Map<Winning, Integer> result) {
        prizeAmounts = result;
    }

    public int calculatePrize() {
        return prizeAmounts.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    public Integer getWinningResult(Winning winning) {
        return prizeAmounts.get(winning);
    }
}
