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
}
