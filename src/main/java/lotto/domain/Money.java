package lotto.domain;

import java.util.Map;

public class Money {
    private final int LOTTO_PRICE = 1_000;

    private int price;

    public Money(int price) {
        this.price = price;
    }

    public int buyCount() {
        return price / LOTTO_PRICE;
    }

    public double revenueRate(Map<Rank, Integer> lottoPrizeMap) {
        int totalPrice = lottoPrizeMap.keySet().stream()
                .filter(prize -> prize != Rank.NOT_MATCH)
                .mapToInt(prize -> lottoPrizeMap.get(prize) * prize.getPrice())
                .sum();

        return Math.round((totalPrice/price)*100)/(double) 100;
    }
}
