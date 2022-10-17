package lotto.domain;

import java.util.Objects;

import static lotto.expressions.LottoAmountExpression.toInt;
import static lotto.expressions.LottoAmountExpression.validateAmount;

public class LottoAmount {
    private static final int PRICE_PER_LOTTO = 1000;

    private final int amount;

    public LottoAmount(String amount) {
        this(toInt(amount));
    }

    public LottoAmount(int amount) {
        this.amount = validateAmount(amount);
    }

    public int calcLottoCount() {
        return amount / PRICE_PER_LOTTO;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoAmount that = (LottoAmount) o;
        return amount == that.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
