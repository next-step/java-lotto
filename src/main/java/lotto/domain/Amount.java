package lotto.domain;

import java.util.Objects;

public class Amount {
    private final int amount;

    public Amount(int amount) {
        this.checkMinusAmount(amount);

        this.amount = amount;
    }

    private void checkMinusAmount(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("금액은 음수일 수 없습니다.");
        }
    }

    public int calculateUnitCount(int unitAmount) {
        return this.amount / unitAmount;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount = (Amount) o;
        return this.amount == amount.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
