package lotto.model;

import java.util.*;

public class LottoResult {

    private Map<Prize, Integer> countOfEachPrize;

    private LottoResult(Map<Prize, Integer> countOfEachPrize) {
        this.countOfEachPrize = countOfEachPrize;
    }

    public static LottoResult of(List<Prize> prizes) {
        Map<Prize, Integer> prizeMap = new EnumMap<>(Prize.class);
        for (Prize prize : prizes) {
            int count = prizeMap.getOrDefault(prize, 0);
            prizeMap.put(prize, ++count);
        }
        return new LottoResult(prizeMap);
    }

    public int getCount(Prize prize) {
        return countOfEachPrize.getOrDefault(prize, 0);
    }

    public long getTotalMoney() {
        return countOfEachPrize.keySet()
                .stream()
                .mapToLong(this::getPrizeMoney)
                .sum();
    }

    public double getRateOfReturn() {
        return (double) getTotalMoney() / totalMoneyOfBuyLotto();
    }

    private long getPrizeMoney(Prize prize) {
        return prize.getMoney() * getCount(prize);
    }

    private long totalMoneyOfBuyLotto() {
        return countTotalOfBuyLotto() * Lotto.PRICE_VALUE;
    }

    private int countTotalOfBuyLotto() {
        return countOfEachPrize.keySet()
                .stream()
                .mapToInt(this::getCount)
                .sum();
    }

    @Override
    public String toString() {
        return "LottoResult{" +
                "countOfEachPrize=" + countOfEachPrize +
                '}';
    }
}
