package lotto.domain;

import java.util.Objects;

public class LottoMatchNumbers {
    private final int matchCount;

    public LottoMatchNumbers(int matchCount) {
        this.matchCount = matchCount;
    }

    public int matchCount() {
        return this.matchCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoMatchNumbers that = (LottoMatchNumbers) o;
        return matchCount == that.matchCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCount);
    }
}
