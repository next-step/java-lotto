package lotto.domain;

import java.util.Objects;

public class LottoCount {
    private final int count;

    public LottoCount(String count) {
        this(Integer.parseInt(count));
    }

    public LottoCount(int count) {
        this.count = count;
    }

    public LottoCount increase() {
        return new LottoCount(this.count + 1);
    }

    public boolean isCountSame(int count) {
        return this.count == count;
    }

    public LottoCount diffFromPrice(LottoPrice price) {
        return new LottoCount(price.count() - count);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LottoCount that = (LottoCount) o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(count);
    }

    @Override
    public String toString() {
        return String.valueOf(count);
    }
}
