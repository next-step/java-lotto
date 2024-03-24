package lotto.domain.lotto;

import java.util.Objects;

public class LottoMatchCount {
    private final int value;

    public LottoMatchCount(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public boolean equals(int target) {
        return this.value == target;
    }

    public boolean smallerThan(LottoMatchCount target) {
        return this.value < target.value();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoMatchCount that = (LottoMatchCount) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
