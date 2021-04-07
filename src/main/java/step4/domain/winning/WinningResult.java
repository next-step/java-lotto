package step4.domain.winning;

import step3.domain.rank.Rank;

import java.util.Map;

public final class WinningResult {

    private final Map<Rank, Integer> winningResult;

    private WinningResult(Map<Rank, Integer> winningResult) {
        this.winningResult = winningResult;
    }

    public static WinningResult of(Map<Rank, Integer> winningResult) {
        return new WinningResult(winningResult);
    }
}
