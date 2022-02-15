package lotto.domain.budget;

import java.util.Objects;
import lotto.utils.Parser;

public class Budget {

    private static final int PRICE_OF_LOTTO = 1000;
    private static final String LACK_OF_MONEY_EXCEPTION_MESSAGE = "로또 구입 가격보다 예산이 적습니다.";
    private final int value;

    public Budget(final String value) {
        this.value = Parser.parseInt(value);
    }

    public Budget(final int value) {
        this.value = value;
    }

    public int getNumberOfPurchase() {
        validatePossibleToPurchase(PRICE_OF_LOTTO);
        return this.value / PRICE_OF_LOTTO;
    }

    public Budget deductionPerLotto(final int numberOfLotto) {
        int amount = numberOfLotto * PRICE_OF_LOTTO;
        validatePossibleToPurchase(amount);

        return new Budget(this.value - amount);
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
