package lotto.domain;

import java.util.Map;
import java.util.Objects;

public class LottoGroupResult {
    private static final int DECIMAL_SECOND_POSITION = 100;
    private static final int ZERO = 0;
    private static final double REFERENCE_POINT = 1.00;

    private final Map<LottoRank, Integer> lottoRankCount;

    public LottoGroupResult(Map<LottoRank, Integer> lottoRankCount) {
        validateLottoGroupResult(lottoRankCount);
        this.lottoRankCount = lottoRankCount;
    }

    public int getLottoMatchCount(LottoRank lottoRank) {
        return lottoRankCount.getOrDefault(lottoRank, ZERO);
    }

    public double getEarningRatio(int totalPrice) {
        if (totalPrice == ZERO) {
            return REFERENCE_POINT;
        }
        return Math.floor(winningPrice() / (double) totalPrice * DECIMAL_SECOND_POSITION) / DECIMAL_SECOND_POSITION;
    }

    private int winningPrice() {
        return this.lottoRankCount.entrySet().stream().mapToInt(result -> result.getKey().countWinningMoney(result.getValue())).sum();
    }

    private void validateLottoGroupResult(Map<LottoRank, Integer> lottoGroupResult) {
        if (lottoGroupResult == null) {
            throw new IllegalArgumentException("로또 그룹의 결과는 null 일 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoGroupResult that = (LottoGroupResult) o;

        return Objects.equals(lottoRankCount, that.lottoRankCount);
    }

    @Override
    public int hashCode() {
        return lottoRankCount != null ? lottoRankCount.hashCode() : 0;
    }
}
