package lotto.domain;

import java.util.Objects;

public class LottoGameCount {
    private Integer lottoGameCount;

    public LottoGameCount(Integer lottoGameCount) {
        this.lottoGameCount = lottoGameCount;
    }

    public Integer getLottoGameCount() {
        return lottoGameCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoGameCount that = (LottoGameCount) o;
        return Objects.equals(lottoGameCount, that.lottoGameCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoGameCount);
    }
}
