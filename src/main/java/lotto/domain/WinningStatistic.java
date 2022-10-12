package lotto.domain;

import java.util.List;
import java.util.Map;

public class WinningStatistic {
    private final List<MatchingResult> matchingResults;
    private final Map<WinningPrice, WinningGrade> winningGrades;

    public WinningStatistic(List<MatchingResult> matchingResults) {
        this.matchingResults = matchingResults;
        this.winningGrades = initWinningGrades();

        calculateIncome();
    }

    private Map<WinningPrice, WinningGrade> initWinningGrades() {
        return Map.of(
                WinningPrice.FIRST, new WinningGrade(WinningPrice.FIRST),
                WinningPrice.SECOND, new WinningGrade(WinningPrice.SECOND),
                WinningPrice.THIRD, new WinningGrade(WinningPrice.THIRD),
                WinningPrice.FOURTH, new WinningGrade(WinningPrice.FOURTH),
                WinningPrice.FIFTH, new WinningGrade(WinningPrice.FIFTH),
                WinningPrice.MISS, new WinningGrade(WinningPrice.MISS)
        );
    }

    private void calculateIncome() {
        this.matchingResults.forEach(matchingResult -> {
            this.winningGrades.get(
                    WinningPrice.decideWithMatchingCount(matchingResult.matchingNumberCount())
            ).increaseCount();
        });
    }

    public Map<WinningPrice, WinningGrade> getWinningGrades() {
        return this.winningGrades;
    }

    public double totalIncomeRate(int money) {
        int totalIncome = totalIncome();
        return (double) totalIncome / (double) money;
    }

    private int totalIncome() {
        return this.winningGrades.values().stream()
                .mapToInt(WinningGrade::totalWinningPrice)
                .sum();
    }
}



