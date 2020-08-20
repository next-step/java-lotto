package lotto.domain;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

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

    public EnumMap<Rank, Integer> getWinningResult() {
        return winningResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return Objects.equals(winningResult, that.winningResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningResult);
    }
}
