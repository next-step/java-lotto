package step4.domain.winning;

import step4.domain.rank.Rank;
import step4.exception.MapNullPointerException;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

public final class WinningResult {

    public static final int ZERO = 0;

    private final Map<Rank, Integer> winningResult;

    private WinningResult(Map<Rank, Integer> winningResult) {
        validateNull(winningResult);
        this.winningResult = winningResult;
    }

    public static final WinningResult of(Map<Rank, Integer> winningResult) {
        return new WinningResult(winningResult);
    }

    public static final Map<Rank, Integer> values() {
        Map<Rank,Integer> winningMap = new EnumMap<>(Rank.class);
        for(Rank rank : Rank.values()) {
            winningMap.put(rank, ZERO);
        }
        return winningMap;
    }

    private final void validateNull(Map<Rank, Integer> winningResult) {
        if (Objects.isNull(winningResult)) {
            throw new MapNullPointerException();
        }
    }

    public final int getWinningCount(Rank rank) {
        return winningResult.get(rank);
    }
}
