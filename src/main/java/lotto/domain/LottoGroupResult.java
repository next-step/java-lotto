package lotto.domain;

import java.util.Map;

public class LottoGroupResult {
    private static final int DECIMAL_SECOND_POSITION = 100;
    private static final int ZERO = 0;
    private static final double REFERENCE_POINT = 1.00;
    private final Map<Rank, Integer> lottoGroupResult;

    public LottoGroupResult(Map<Rank, Integer> lottoGroupResult) {
        this.lottoGroupResult = lottoGroupResult;
    }

    public int getLottoMatchCount(Rank rank) {
        return lottoGroupResult.getOrDefault(rank, ZERO);
    }

    public double getEarningRatio(int totalPrice) {
        if (totalPrice == ZERO) {
            return REFERENCE_POINT;
        }
        return Math.floor(winningPrice() / Double.valueOf(totalPrice) * DECIMAL_SECOND_POSITION) / Double.valueOf(DECIMAL_SECOND_POSITION);
    }

    private int winningPrice() {
        return this.lottoGroupResult.entrySet().stream().mapToInt(result -> result.getKey().winningMoney() * result.getValue()).sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoGroupResult that = (LottoGroupResult) o;

        return lottoGroupResult != null ? lottoGroupResult.equals(that.lottoGroupResult) : that.lottoGroupResult == null;
    }

    @Override
    public int hashCode() {
        return lottoGroupResult != null ? lottoGroupResult.hashCode() : 0;
    }
}
