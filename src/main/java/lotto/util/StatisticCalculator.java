package lotto.util;

import lotto.Rank;

import java.util.List;

public abstract class StatisticCalculator {

    public static double calculateRate(int price, List<Rank> ranks) {
        int totalWinnings = Rank.findTotalWinnings(ranks);

        double rate = (double) totalWinnings / price;
        return Math.floor(rate * 100) / 100;
    }

}
