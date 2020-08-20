package lotto.domain;

import java.math.BigDecimal;
import java.util.EnumMap;

public class LottoResult {
    private final EnumMap<Rank, Integer> winningResult;
    private static final int ROUND_UP_SCALE = 2;

    public LottoResult(EnumMap<Rank, Integer> winningResult) {
        this.winningResult = winningResult;
    }

    private BigDecimal calculateTotalWinning() {
        return winningResult.entrySet().stream()
                .map(entry -> BigDecimal.valueOf(entry.getKey().getWinningMoney())
                                        .multiply(BigDecimal.valueOf(entry.getValue())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calculateRate(BigDecimal price) {
        BigDecimal totalWinning = calculateTotalWinning();
        return totalWinning.divide(price, ROUND_UP_SCALE, BigDecimal.ROUND_HALF_UP);
    }

    public int getRankCount(Rank rank) {
        return winningResult.getOrDefault(rank, 0);
    }
}
