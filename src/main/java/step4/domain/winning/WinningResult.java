package step4.domain.winning;

import step3.domain.rank.Rank;
import step4.exception.MapNullPointerException;

import java.util.Map;
import java.util.Objects;

public final class WinningResult {

    private final Map<Rank, Integer> winningResult;

    private WinningResult(Map<Rank, Integer> winningResult) {
        validateNull(winningResult);
        this.winningResult = winningResult;
    }

    public static final WinningResult of(Map<Rank, Integer> winningResult) {
        return new WinningResult(winningResult);
    }

    private final void validateNull(Map<Rank, Integer> winningResult) {
        if (Objects.isNull(winningResult)) {
            throw new MapNullPointerException();
        }
    }

}
