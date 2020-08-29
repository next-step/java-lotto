package lotto.domain;

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
            winningResult.put(rank, winningResult.getOrDefault(rank, new Count(NUMBER_ZERO).getCount()));
        }
        return winningResult;
    }

    public Long getWinningResult(Rank rank) {
        return winningResult.get(rank);
    }

}
