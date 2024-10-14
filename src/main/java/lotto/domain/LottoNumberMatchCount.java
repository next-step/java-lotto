package lotto.domain;

import java.util.Objects;

public class LottoNumberMatchCount {
    private final int lottoNumberMatchCount;

    public LottoNumberMatchCount(int lottoNumberMatchCount) {
        this.lottoNumberMatchCount = lottoNumberMatchCount;
    }

    public int getValue() {
        return this.lottoNumberMatchCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumberMatchCount that = (LottoNumberMatchCount) o;
        return lottoNumberMatchCount == that.lottoNumberMatchCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumberMatchCount);
    }
}
