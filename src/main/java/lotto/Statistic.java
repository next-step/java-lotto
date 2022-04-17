package lotto;

import java.util.Arrays;
import java.util.List;

public enum Statistic {

    ZERO(0, 0),
    ONE(1, 0),
    TWO(2, 0),
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    private final int matchCount;
    private final int winnings;

    Statistic(int matchCount, int winnings) {
        this.matchCount = matchCount;
        this.winnings = winnings;
    }

    public static Statistic findRank(int matchCount) {
        return Arrays.stream(values())
                .filter(statistic -> statistic.matchCount == matchCount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("0 ~ 6이외의 matchCount 는 발생할 수 없습니다."));
    }

    public static double calculateRate(int price, List<Statistic> statistics) {
        int totalWinnings = calculateTotalWinnings(statistics);

        double rate = (double) totalWinnings / price;
        return Math.floor(rate * 100) / 100;
    }

    private static int calculateTotalWinnings(List<Statistic> statistics) {
        return statistics.stream()
                .mapToInt(i -> i.winnings)
                .sum();
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinnings() {
        return winnings;
    }
}
