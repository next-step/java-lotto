package lottogame.model.winner;

import static java.util.Objects.isNull;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WinnerResult {

    private Map<WinStandard, Integer> winStandardToWinCount;

    public WinnerResult() {
        this(getInitWinStandardMap());
    }

    public WinnerResult(Map<WinStandard, Integer> winStandardToWinCount) {
        this.winStandardToWinCount = winStandardToWinCount;
    }

    private static Map<WinStandard, Integer> getInitWinStandardMap() {
        return Arrays.stream(WinStandard.values())
                .filter(winStandard -> !winStandard.isNothing())
                .collect(Collectors.toMap(
                        Function.identity(),
                        winStandard -> 0
                ));
    }

    public void addWinResult(WinStandard winStandard) {
        if (isNull(winStandard)) {
            return;
        }

        if (winStandard.isNothing()) {
            return;
        }

        Integer countBy = this.winStandardToWinCount.getOrDefault(winStandard, 0);
        this.winStandardToWinCount.put(
                winStandard,
                countBy + 1
        );
    }

    public int findWinCount(WinStandard winStandard) {
        if (isNull(winStandard) || winStandard.isNothing()) {
            return 0;
        }

        return this.winStandardToWinCount.get(winStandard);
    }

    public int sumTotalWinReturn() {
        return this.winStandardToWinCount.keySet().stream()
                .mapToInt(this::calculateWinReturnBy)
                .sum();
    }

    private int calculateWinReturnBy(WinStandard winStandard) {
        return winStandard.calculateWinReturn(this.findWinCount(winStandard));
    }
}
