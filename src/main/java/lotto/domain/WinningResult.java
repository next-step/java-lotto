package lotto.domain;

import java.util.Collections;
import java.util.Map;

import static lotto.utils.CommonConstant.NUMBER_ZERO;

public class WinningResult {

    private Map<Rank, Long> winningResult;

    public WinningResult(Map<Rank, Long> winningResult) {
        this.winningResult = winningResult;
        initMap(winningResult);
    }

    private Map<Rank, Long> initMap(Map<Rank, Long> winningResult) {
        for (Rank rank : Rank.values()) {
            winningResult.put(rank, winningResult.getOrDefault(rank, Long.valueOf(NUMBER_ZERO)));
        }
        return winningResult;
    }

    public Long getWinningResult(Rank rank) {
        return winningResult.get(rank);
    }

    public Map<Rank, Long> getWinningResult() {
        return Collections.unmodifiableMap(winningResult);
    }

    @Override
    public String toString() {
        return "WinningResult{" +
                "winningResult=" + winningResult +
                '}';
    }
}
