package lotto.domain;

import java.util.Objects;
import lotto.settings.LottoSettings;

public class Money {

    private final int amount;

    public Money(int amount) {
        validMoney(amount);
        this.amount = amount;
    }

    private void validMoney(int amount) {
        if (isNegative(amount)) {
            throw new IllegalArgumentException("돈은 음수일수 없습니다.");
        }
        if (isInvalidBaseUnit(amount)) {
            throw new IllegalArgumentException("돈은 1000원 단위이여야 합니다.");
        }
    }

    private boolean isNegative(int fee) {
        return fee < 0;
    }

    private boolean isInvalidBaseUnit(int fee) {
        return fee % baseAmount() != 0;
    }

    private static int baseAmount() {
        return LottoSettings.DEFAULT_PRICE.value();
    }

    public Money subtractedBill(int count) {
        return new Money(this.amount - baseAmount() * count);
    }

    public int countBill() {
        return this.amount / baseAmount();
    }

    public boolean isOver(Money value) {
        return this.amount > value.amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money = (Money) o;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
