package lotto.domain;

import java.math.BigDecimal;
import java.util.Map;

public class WinningStatistics {
    private Map<Rank, Long> statistics;

    public WinningStatistics(Map<Rank, Long> statistics) {
        this.statistics = statistics;
    }

    public Map<Rank, Long> getStatistics() {
        return statistics;
    }

    public String yield() {

        BigDecimal purchaseAmount = new BigDecimal(String.valueOf(purchaseAmount()));
        BigDecimal total = new BigDecimal(String.valueOf(total()));
        BigDecimal yield = total.divide(purchaseAmount, 2, BigDecimal.ROUND_DOWN);

        return yield.toString();
    }

    private double purchaseAmount() {
        return statistics.size() * LottoConstants.PRICE;
    }

    private double total() {
        long total = 0L;
        for (Rank rank : Rank.values()) {
            total += rank.getMoney() * statistics.getOrDefault(rank, 0L);
        }

        return total;
    }
}
