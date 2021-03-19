package lotto.domain;

import java.util.Objects;

public class LottoGameResult {
    private final int matchCount;

    public LottoGameResult(int matchCount) {
        this.matchCount = matchCount;
    }

    public int matchCount() {
        return this.matchCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoGameResult that = (LottoGameResult) o;
        return matchCount == that.matchCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCount);
    }
}
