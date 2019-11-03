package lotto.domain;

import java.util.Map;

public class Money {

    private static int LOTTO_PRICE = 1000;
    private final int money;

    public Money(int money) {
        this.money = money;
    }

    public double getProfitRate(Map<LottoRank, Long> rankGroup) {
        long totalProfit = rankGroup
                .entrySet()
                .stream()
                .map(e -> e.getKey().getWinning() * e.getValue())
                .reduce(0L, Long::sum);

        return totalProfit / money;
    }

    public int getLottoCount() {
        return money / LOTTO_PRICE;
    }
    }
}
