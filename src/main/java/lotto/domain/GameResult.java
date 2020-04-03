package lotto.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class GameResult {

    private Map<Prize, Integer> result;

    public GameResult() {
        initialize();
    }

    private void initialize() {
        result = new HashMap<>();
        for (Prize prize : Prize.values()) {
            result.put(prize, 0);
        }
    }

    public void addWinResult(Prize prize) {
        result.put(prize, result.get(prize) + 1);
    }

    public Integer getWinResult(Prize prize) {
        return result.get(prize);
    }

    public double getProfit(Money purchaseAmount) {
        return (double)getTotalPrizeAmount() / (double)purchaseAmount.getAmount();
    }

    private long getTotalPrizeAmount() {
        return result.keySet().stream()
                .mapToInt(this::getTotal)
                .sum();
    }

    private int getTotal(Prize prize) {
        return result.get(prize) * prize.getAmount();
    }
}
