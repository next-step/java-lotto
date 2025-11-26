package lottogame.model.winner;

import static java.lang.Math.floor;
import static java.util.Objects.isNull;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class WinnerResult {
    private final Map<WinStandard, Integer> winStandardToWinCount;

    public WinnerResult() {
        this(WinStandard.getInitWinStandardMap());
    }

    public WinnerResult(Map<WinStandard, Integer> winStandardToWinCount) {
        this.winStandardToWinCount = winStandardToWinCount;
    }

    public void addWinResult(WinStandard winStandard) {
        if (isNull(winStandard)) {
            return;
        }

        if (winStandard.isNothing()) {
            return;
        }

        Integer countBy = winStandardToWinCount.getOrDefault(winStandard, 0);
        winStandardToWinCount.put(
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

    public double calculateRateOfReturn(int buyPrice) {
        int totalWinReturn = this.winStandardToWinCount.entrySet().stream()
                .mapToInt((entry) -> entry.getKey().returnOfWin() * entry.getValue())
                .sum();

        double rawRate = (double) totalWinReturn / buyPrice * 100;
        return floor(rawRate) / 100.0;
    }

    public String toString(double rateOfReturn) {
        List<Entry<WinStandard, Integer>> sortedLowWinValue = winStandardToWinCount.entrySet().stream()
                .sorted(Entry.comparingByKey(
                        Comparator.comparing(WinStandard::value)
                ))
                .toList();

        StringBuilder sb = new StringBuilder();
        for (Entry<WinStandard, Integer> winEntry : sortedLowWinValue) {
            sb.append(winEntry.getKey().desc())
                    .append(winEntry.getValue() + "개")
                    .append("\n");
        }

        sb.append("총 수익률은 " + rateOfReturn + "입니다.");

        return sb.toString();
    }
}
