package lotto.model;

import java.util.Objects;

public class LottoMatchCount {
    private final Integer matchCount;

    private LottoMatchCount(Integer matchCount) {
        this.matchCount = matchCount;
    }

    public static LottoMatchCount of(Integer matchCount) {
        return new LottoMatchCount(matchCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoMatchCount)) return false;
        LottoMatchCount that = (LottoMatchCount) o;
        return Objects.equals(matchCount, that.matchCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCount);
    }
}
