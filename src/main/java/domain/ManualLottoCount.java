package domain;

import java.util.Objects;

public class ManualLottoCount {
    private final long lottoCount;

    public ManualLottoCount(long lottoCount) {
        validateNonNegativeLottoCount(lottoCount);
        this.lottoCount = lottoCount;
    }

    public boolean isBiggerThan(long value) {
        return lottoCount > value;
    }

    private void validateNonNegativeLottoCount(long lottoCount) {
        if (lottoCount < 0) {
            throw new IllegalArgumentException("수동 로또 개수는 0 이상이어야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManualLottoCount that = (ManualLottoCount) o;
        return lottoCount == that.lottoCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoCount);
    }
}
