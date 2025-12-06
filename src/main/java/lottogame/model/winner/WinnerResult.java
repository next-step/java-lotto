package lottogame.model.winner;

import static java.util.Objects.isNull;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WinnerResult {

    private Map<Rank, Integer> winStandardToWinCount;

    public WinnerResult() {
        this(getInitWinStandardMap());
    }

    public WinnerResult(Map<Rank, Integer> winStandardToWinCount) {
        this.winStandardToWinCount = winStandardToWinCount;
    }

    private static Map<Rank, Integer> getInitWinStandardMap() {
        return Arrays.stream(Rank.values())
                .filter(winStandard -> !winStandard.isNothing())
                .collect(Collectors.toMap(
                        Function.identity(),
                        winStandard -> 0
                ));
    }

    public void addWinResult(Rank rank) {
        if (isNull(rank)) {
            return;
        }

        if (rank.isNothing()) {
            return;
        }

        Integer countBy = this.winStandardToWinCount.getOrDefault(rank, 0);
        this.winStandardToWinCount.put(
                rank,
                countBy + 1
        );
    }

    public int findWinCount(Rank rank) {
        if (isNull(rank) || rank.isNothing()) {
            return 0;
        }

        return this.winStandardToWinCount.get(rank);
    }

    public int sumTotalWinReturn() {
        return this.winStandardToWinCount.keySet().stream()
                .mapToInt(this::calculateWinReturnBy)
                .sum();
    }

    private int calculateWinReturnBy(Rank rank) {
        return rank.calculateWinReturn(this.findWinCount(rank));
    }
}
