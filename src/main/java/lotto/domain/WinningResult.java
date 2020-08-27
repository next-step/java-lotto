package lotto.domain;

import java.util.Map;

import static lotto.utils.CommonConstant.NUMBER_ZERO;

public class WinningResult {

    private Map<Rank, Long> winningResult;
    // Count 만들기

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

//    public Map<Rank, Long> putRank(Rank rank) {
//        if (winningResult.get(rank) != null) {
//            winningResult.put(rank, winningResult.get(rank) + NUMBER_ONE);
//        }
//        return winningResult;
//    }

    public Long getWinningResult(Rank rank) {
        return winningResult.get(rank);
    }

}
