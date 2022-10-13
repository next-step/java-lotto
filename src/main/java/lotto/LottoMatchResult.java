package lotto;

import java.util.Objects;

public class LottoMatchResult {
    private final int count;

    public LottoMatchResult(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoMatchResult)) {
            return false;
        }
        LottoMatchResult that = (LottoMatchResult) o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
