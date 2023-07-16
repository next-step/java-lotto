package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

import static lotto.domain.Lotto.LOTTO_PRICE;

public final class LottoMoney {

    private final long value;

    public LottoMoney(final long value) {
        validateValueRange(value);
        this.value = value;
    }

    public static LottoMoney sum(final List<LottoMoney> lottoMonies) {
        final long sumValue = lottoMonies.stream()
                .mapToLong(LottoMoney::getValue)
                .sum();

        return new LottoMoney(sumValue);
    }

    public boolean isPayable() {
        return value >= LOTTO_PRICE;
    }

    public LottoMoney payLotto() {
        if (!isPayable()) {
            throw new IllegalStateException("로또 구매에 필요한 금액이 부족합니다.");
        }

        return new LottoMoney(value - LOTTO_PRICE);
    }

    public LottoMoney multiply(final long operand) {
        return new LottoMoney(value * operand);
    }

    // TODO: Profit으로 감싸기
    public double ratio(final LottoMoney money) {
        if (money.value == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }

        return this.value / (double) money.value;
    }

    public long getValue() {
        return this.value;
    }

    private void validateValueRange(final long value) {
        if (value < 0) {
            throw new IllegalArgumentException("구입 금액은 양의 정수여야합니다.");
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LottoMoney that = (LottoMoney) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LottoMoney.class.getSimpleName() + "[", "]")
                .add("value=" + value)
                .toString();
    }
}
