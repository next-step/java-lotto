package lotto.domain;

import java.util.Objects;

import static lotto.utils.Constants.MSG_MANUAL_NUMBER_GREATER_THAN_TOTAL_NUMBER;

public class LottoGameCount {
    private Integer lottoGameCount;
    private Integer lottoManualCount;

    public LottoGameCount(Integer lottoGameCount, Integer lottoManualCount) {
        if (lottoGameCount < lottoManualCount) {
            throw  new IllegalArgumentException(MSG_MANUAL_NUMBER_GREATER_THAN_TOTAL_NUMBER);
        }
        this.lottoGameCount = lottoGameCount;
        this.lottoManualCount = lottoManualCount;
    }

    public boolean isPurchasedManual() {
        return lottoManualCount > 0;
    }

    public Integer getLottoGameCount() {
        return lottoGameCount;
    }

    public Integer getLottoAutoCount() {
        return lottoGameCount - lottoManualCount;
    }

    public Integer getLottoManualCount() {
        return lottoManualCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoGameCount that = (LottoGameCount) o;
        return Objects.equals(lottoGameCount, that.lottoGameCount) &&
                Objects.equals(lottoManualCount, that.lottoManualCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoGameCount, lottoManualCount);
    }
}
