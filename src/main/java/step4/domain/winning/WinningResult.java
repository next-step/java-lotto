package step4.domain.winning;

import step4.domain.rank.Rank;
import step4.exception.MapNullPointerException;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

public final class WinningResult {

    public static final long ZERO = 0L;

    private final Map<Rank, Long> winningResult;

    private WinningResult(Map<Rank, Long> winningResult) {
        validateNull(winningResult);
        this.winningResult = winningResult;
    }

    public static final WinningResult of(Map<Rank, Long> winningResult) {
        return new WinningResult(winningResult);
    }

    public static final Map<Rank, Long> values() {
        Map<Rank,Long> winningMap = new EnumMap<>(Rank.class);
        for(Rank rank : Rank.values()) {
            winningMap.put(rank, ZERO);
        }
        return winningMap;
    }

    public final long getWinningCount(Rank rank) {
        return winningResult.get(rank);
    }

    private final void validateNull(Map<Rank, Long> winningResult) {
        if (Objects.isNull(winningResult)) {
            throw new MapNullPointerException();
        }
    }

}
