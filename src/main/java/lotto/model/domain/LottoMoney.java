package lotto.model.domain;

import java.util.Objects;

public final class LottoMoney implements Comparable<LottoMoney> {

    private final long value;

    private LottoMoney(final long value) {
        this.value = value;
    }

    public static LottoMoney valueOf(final long value) {
        validate(value);
        return new LottoMoney(value);
    }

    private static void validate(final long value) {
        if (value < 0L) {
            throw new IllegalArgumentException("돈은 음수가 될 수 없습니다. 현재 액수: " + value);
        }
    }

    public long getValue() {
        return value;
    }

    public long sizeOfLottos(final long cost) {
        return value / cost;
    }

    public LottoMoney change(final long cost) {
        return new LottoMoney(value % cost);
    }

    public double rate(final LottoMoney purchase) {
        return value / (double) purchase.value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LottoMoney lottoMoney = (LottoMoney) o;
        return value == lottoMoney.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(final LottoMoney o) {
        return Long.compare(value, o.value);
    }
}
