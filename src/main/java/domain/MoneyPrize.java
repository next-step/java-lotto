package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MoneyPrize {
    private static final int RANK_NUMBER_MAX = 4;
    private static final int RANK_NUMBER_MIN = 1;
    private static final int LOTTERY_PRICE = 1000;
    private final Map<Integer, Integer> moneyPrize;

    public MoneyPrize(RankGroup rankGroup) {
        this.moneyPrize = Collections.unmodifiableMap(moneyPrizeByLotteryRank(rankGroup));
    }

    private Map<Integer, Integer> moneyPrizeByLotteryRank(RankGroup rankGroup) {
        Map<Integer, Integer> moneyPrize = new HashMap<>();
        for (int i = RANK_NUMBER_MIN; i <= RANK_NUMBER_MAX; i++) {
            moneyPrize.put(i, LotteryPrizeCalculation.winningAmount(i, rankGroup.count(i)));
        }

        return moneyPrize;
    }

    public double lotteryProfit(Store store) {
        int money = 0;
        for (int rank : moneyPrize.keySet()) {
            money += moneyPrize.get(rank);
        }

        return Math.round(calculate(money, store.lotteryCount()) * 100) / 100.0;
    }

    private int calculate(int money, int count) {
        return money / (count * LOTTERY_PRICE);
    }

    public int value(int key){
        return moneyPrize.get(key);
    }

    public int size(){
        return moneyPrize.size();
    }
}
