package lotto;

import java.util.Objects;

import lotto.model.LottoReward;

public class LottoMatchResult {
    private final int count;

    private LottoMatchResult(int count) {
        this.count = count;
    }

    public static LottoMatchResult of(int count) {
        return new LottoMatchResult(count);
    }

    public LottoReward getLottoReward() {
        return LottoReward.findByMatchResult(this);
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
