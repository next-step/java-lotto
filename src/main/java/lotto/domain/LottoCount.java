package lotto.domain;

import java.util.Objects;
import java.util.StringJoiner;

import static lotto.domain.Lotto.LOTTO_PRICE;

public class LottoCount {

    private final int value;

    public LottoCount(final int value) {
        validateValueRange(value);
        this.value = value;
    }

    private void validateValueRange(final long value) {
        if (value <= 0) {
            throw new IllegalArgumentException("수동 로또 개수는 양의 정수여야 합니다.");
        }
    }

    public LottoMoney toTotalLottoPrice() {
        return new LottoMoney((long) value * LOTTO_PRICE);
    }

    public long getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LottoCount that = (LottoCount) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LottoCount.class.getSimpleName() + "[", "]")
                .add("value=" + value)
                .toString();
    }
}
