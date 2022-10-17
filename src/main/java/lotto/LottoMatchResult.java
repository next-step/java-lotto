package lotto;

import java.util.Objects;
import java.util.Optional;

import lotto.model.LottoReward;

public class LottoMatchResult {
    private final int count;
    private final boolean bonusNumberMatched;

    private LottoMatchResult(int count, boolean bonusNumberMatched) {
        this.count = count;
        this.bonusNumberMatched = bonusNumberMatched;
    }

    public static LottoMatchResult of(int count) {
        return new LottoMatchResult(count, false);
    }

    public Optional<LottoReward> getLottoReward() {
        return LottoReward.findByMatchResult(this.count, this.bonusNumberMatched);
    }

    public boolean rewardable() {
        return getLottoReward().isPresent();
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

    @Override
    public String toString() {
        return "일치개수: " + count;
    }
}
