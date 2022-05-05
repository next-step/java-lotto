package lotto.domain;

import java.util.Map;
import java.util.Objects;

public class LottoGroupResult {
    private static final int DECIMAL_SECOND_POSITION = 100;
    private static final int ZERO = 0;
    private static final double REFERENCE_POINT = 1.00;

    private final Map<LottoRank, Integer> lottoGroupResult;

    public LottoGroupResult(Map<LottoRank, Integer> lottoGroupResult) {
        validateLottoGroupResult(lottoGroupResult);
        this.lottoGroupResult = lottoGroupResult;
    }

    public int getLottoMatchCount(LottoRank lottoRank) {
        return lottoGroupResult.getOrDefault(lottoRank, ZERO);
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

        return Objects.equals(lottoGroupResult, that.lottoGroupResult);
    }

    @Override
    public int hashCode() {
        return lottoGroupResult != null ? lottoGroupResult.hashCode() : 0;
    }
}
