package lotto.domain;

import java.util.List;
import java.util.Map;

public class WinningStatistic {
    private final List<MatchingResult> matchingResults;
    private final Map<Integer, WinningGrade> winningGrades;

    public WinningStatistic(List<MatchingResult> matchingResults) {
        this.matchingResults = matchingResults;
        this.winningGrades = initWinningGrades();

        calculateIncome();
    }

    private Map<Integer, WinningGrade> initWinningGrades() {
        return Map.of(
                3, new WinningGrade(WinningPrice.THREE),
                4, new WinningGrade(WinningPrice.FOUR),
                5, new WinningGrade(WinningPrice.FIVE),
                6, new WinningGrade(WinningPrice.SIX)
        );
    }

    private void calculateIncome() {
        this.matchingResults.forEach(matchingResult -> this.winningGrades.get(matchingResult.matchingNumberCount()).increaseCount());
    }

    public Map<Integer, WinningGrade> getWinningGrades() {
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



