package lotto.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;

public enum Prize {

    SIX(6, 2_000_000_000),
    FIVE(5, 1_500_000),
    FOUR(4, 50000),
    THREE(3, 5000);

    private int hit;
    private int value;

    Prize(int hit, int value) {
        this.hit = hit;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static int getValueByHit(int hit) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.hit == hit)
                .map(Prize::getValue)
                .findFirst()
                .orElse(0);
    }

    public static LinkedHashMap<Prize, Integer> calculateStatistic(int totalPrize) {
        LinkedHashMap<Prize, Integer> statistic = new LinkedHashMap<>();
        int prize = totalPrize;
        for (Prize price : Prize.values()) {
            statistic.put(price, prize / price.getValue());
            prize %= price.getValue();
        }
        return statistic;
    }

    public static double calculateProfit(int prize, int buyPrice) {
        return Math.floor(prize / (double) buyPrice * 100) / 100.0;
    }
}
