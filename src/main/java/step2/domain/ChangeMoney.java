package step2.domain;

import java.util.Objects;

public class ChangeMoney {

    private final int value;

    public ChangeMoney(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("남은 금액은 음수일 수 없습니다.");
        }
        this.value = value;
    }

    public PurchaseCount getRemainCount() {
        return new PurchaseCount(value / PurchaseMoney.DEFAULT_EACH_LOTTO_PRICE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChangeMoney that = (ChangeMoney) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
