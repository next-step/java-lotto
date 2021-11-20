package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MoneyPrize {
    private final Map<Integer, Integer> moneyPrize;

    private static final int MATCH_NUMBER_MAX = 6;
    private static final int MATCH_NUMBER_MIN = 3;
    private static final double LOTTERY_PRICE = 1000;

    public MoneyPrize(RankGroup rankGroup) {
        this.moneyPrize = Collections.unmodifiableMap(moneyPrizeByLotteryRank(rankGroup));
    }

    private Map<Integer, Integer> moneyPrizeByLotteryRank(RankGroup rankGroup) {
        Map<Integer, Integer> moneyPrize = new HashMap<>();
        for (int i = MATCH_NUMBER_MIN; i <= MATCH_NUMBER_MAX; i++) {
            moneyPrize.put(i, LotteryPrizeCalculation.winningAmount(i, rankGroup.count(i)));
        }

        return moneyPrize;
    }

    public double lotteryProfit(int lotteryCount) {
        int money = 0;
        for (int rank : moneyPrize.keySet()) {
            money += moneyPrize.get(rank);
        }

        return calculateDivide(money, lotteryCount);
    }

    private double calculateDivide(int money, int count) {
        return money / (count * LOTTERY_PRICE);
    }

    public int value(int key) {
        return moneyPrize.get(key);
    }
}
