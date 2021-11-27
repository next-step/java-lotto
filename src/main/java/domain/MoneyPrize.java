package domain;

import java.util.*;

public class MoneyPrize {
    private static final double LOTTERY_PRICE = 1000;

    private final List<Integer> moneyPrize;

    public MoneyPrize(RankGroup rankGroup) {
        this.moneyPrize = Collections.unmodifiableList(moneyPrizeByLotteryRank(rankGroup));
    }

    private List<Integer> moneyPrizeByLotteryRank(RankGroup rankGroup) {
        List<Integer> moneyPrize = new ArrayList<>();
        int loopNumber = rankGroup.size();
        for (int i = 0; i < loopNumber; i++) {
            moneyPrize.add(LotteryPrizeCalculation.winningAmount(rankGroup.rank(i), rankGroup.bonusBall(i)));
        }

        return moneyPrize;
    }

    public double lotteryProfit(int lotteryCount) {
        int money = moneyPrize.stream()
                .mapToInt(winnerPrize -> winnerPrize)
                .sum();

        return calculateDivide(money, lotteryCount);
    }

    private double calculateDivide(int money, int count) {
        return money / (count * LOTTERY_PRICE);
    }

    public int value(int index) {
        return moneyPrize.get(index);
    }
}
