package lotto.domain;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class WinningResults {

    private Map<Prize, WinningResult> winningResults;

    public WinningResults() {
        winningResults = new TreeMap<>();
    }

    public WinningResult get(Prize prize) {
        return winningResults.get(prize);
    }

    protected WinningResult put(Prize prize, WinningResult winningResult) {
        return winningResults.put(prize, winningResult);
    }

    public Set<Prize> keySet() {
        return winningResults.keySet();
    }

    public double calculateEarningsRate(final long money) {
        long totalPrizeMoney = 0;

        Set<Prize> winningResultsKeys = winningResults.keySet();

        for (Prize prize : winningResultsKeys) {
            totalPrizeMoney += prize.getMoney() * winningResults.get(prize).getMatchCount();
        }

        return totalPrizeMoney / (double) money;
    }
}
