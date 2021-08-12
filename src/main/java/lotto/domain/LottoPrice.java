package lotto.domain;

import lotto.exception.InvalidBudgetException;
import lotto.exception.InvalidManualLottoCountException;

import java.util.Objects;

public class LottoPrice {
    private static final int PRICE_OF_LOTTO_TICKET = 1000;

    private final int budget;

    private LottoPrice(int budget) {
        validate(budget);
        this.budget = budget;
    }

    private void validate(int budget) {
        if (budget < PRICE_OF_LOTTO_TICKET) {
            throw new InvalidBudgetException();
        }
    }

    public static LottoPrice of(int money) {
        return new LottoPrice(money);
    }

    public int getMaxQuantity() {
        return budget / PRICE_OF_LOTTO_TICKET;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoPrice lottoPrice = (LottoPrice) o;
        return budget == lottoPrice.budget;
    }

    @Override
    public int hashCode() {
        return Objects.hash(budget);
    }

    public void checkOverPrice(int manualLottoCount) {
        if (manualLottoCount * PRICE_OF_LOTTO_TICKET > budget) {
            throw new InvalidManualLottoCountException();
        }
    }

    public double getRatio(double totalAmount) {
        return totalAmount / budget;
    }
}
