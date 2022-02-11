package lotto.domain.budget;

import java.util.Objects;
import lotto.utils.Parser;

public class Budget {

    private static final String LACK_OF_MONEY_EXCEPTION_MESSAGE = "로또 구입 가격보다 예산이 적습니다.";

    private int value;

    public Budget(final String budget) {
        this.value = Parser.parseInt(budget);
    }

    public int getNumberOfPurchase(final int priceOfLotto) {
        validatePossibleToPurchase(priceOfLotto);
        return this.value / priceOfLotto;
    }

    public void deduct(final int amount) {
        validatePossibleToPurchase(amount);
        this.value -= amount;
    }

    private void validatePossibleToPurchase(final int priceOfLotto) {
        if (canNotPurchase(priceOfLotto)) {
            throw new IllegalArgumentException(LACK_OF_MONEY_EXCEPTION_MESSAGE);
        }
    }

    private boolean canNotPurchase(final int priceOfLotto) {
        return this.value < priceOfLotto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Budget budget = (Budget) o;
        return value == budget.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
