package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.Map;

public class WinningResult {

    private final Map<Rank, Integer> result;

    public WinningResult(Map<Rank, Integer> result) {
        this.result = result;
    }

    public BigDecimal calculateProfitRate(int buyCash) {
        BigDecimal prizeMoney = calculatePrizeMoney();
        return prizeMoney.divide(new BigDecimal(buyCash), 2, RoundingMode.DOWN);
    }

    public BigDecimal calculatePrizeMoney() {
        BigDecimal prizeMoney = BigDecimal.ZERO;
        for (Rank rank : result.keySet()) {
            prizeMoney = prizeMoney.add(new BigDecimal(result.get(rank) * rank.getPrizeMoney()));
        }
        return prizeMoney;
    }

    public Map<Rank, Integer> getResult() {
        return new LinkedHashMap<>(result);
    }
}
