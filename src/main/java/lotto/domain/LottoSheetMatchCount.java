package lotto.domain;

import java.util.Objects;

public class LottoSheetMatchCount {
    private final int lottoSheetMatchCount;

    public LottoSheetMatchCount(int lottoSheetMatchCount) {
        this.lottoSheetMatchCount = lottoSheetMatchCount;
    }

    public LottoSheetMatchCount() {
        this(0);
    }

    public LottoSheetMatchCount add() {
        return new LottoSheetMatchCount(this.lottoSheetMatchCount + 1);
    }

    public int getValue() {
        return this.lottoSheetMatchCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoSheetMatchCount that = (LottoSheetMatchCount) o;
        return lottoSheetMatchCount == that.lottoSheetMatchCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoSheetMatchCount);
    }
}
