package lotto.domain;

import java.util.Objects;

public class Budget {
    private static final String NOT_ENOUGH_BALANCE_MESSAGE = "가진 돈 보다 더 많은 돈을 사용하려고 합니다.";
    private static final String BUDGET_NOT_BE_NEGATIVE_MESSAGE = "예산은 음수이면 안 됩니다.";
    private final int amount;

    private Budget(int amount) {
        this.amount = amount;
    }

    public static Budget valueOf(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(BUDGET_NOT_BE_NEGATIVE_MESSAGE);
        }
        return new Budget(amount);
    }

    public Budget use(int amount) {
        if (amount > this.amount) {
            throw new IllegalArgumentException(NOT_ENOUGH_BALANCE_MESSAGE);
        }
        return new Budget(this.amount - amount);
    }

    public Budget deposit(int amount) {
        return new Budget(this.amount + amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Budget budget = (Budget) o;
        return amount == budget.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(amount);
    }
}
