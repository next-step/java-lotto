package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class Analyzer {

    private final double payment;

    public Analyzer(final int payment, final List<Integer> numberOfMatches,
        final List<Integer> bonusNumbers) {
        this.payment = payment;
        countWinningResults(numberOfMatches, bonusNumbers);
    }

    private static void countWinningResults(final List<Integer> numberOfMatches,
        final List<Integer> bonusNumbers) {
        for (int i = 0; i < numberOfMatches.size(); i++) {
            int match = numberOfMatches.get(i);
            int bonus = bonusNumbers.get(i);
            if (match != Ranking.FIFTH.getNumberOfMatches()) {
                bonus = 0;
            }
            Ranking.of(match, bonus).addWinningCount();
        }
    }

    public double calculateProfitPercent() {
        return sumTotalPrizeMoney() / payment;
    }

    private int sumTotalPrizeMoney() {
        return Arrays.stream(Ranking.values())
            .map(Ranking::operate)
            .mapToInt(Integer::intValue).sum();
    }
}
