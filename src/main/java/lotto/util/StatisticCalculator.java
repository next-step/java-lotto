package lotto.util;

import lotto.Rank;

import java.util.List;

public abstract class StatisticCalculator {

    public static double calculateRate(int price, List<Rank> ranks) {
        int totalWinnings = calculateTotalWinnings(ranks);

        double rate = (double) totalWinnings / price;
        return Math.floor(rate * 100) / 100;
    }

    private static int calculateTotalWinnings(List<Rank> ranks) {
        return ranks.stream()
                .mapToInt(Rank::getWinnings)
                .sum();
    }

}
