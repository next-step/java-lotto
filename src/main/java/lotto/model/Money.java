package lotto.model;

import lotto.exception.InvalidLottoException;

import java.util.Objects;

import static lotto.model.LottoMachine.LOTTO_PER_MONEY;
import static lotto.validation.LottoMachineValidator.assertMoney;

public class Money {
    private final int amount;

    public Money(int amount) {
        this.amount = amount;
        assertMoney(this);
    }

    public int maxQuantity() {
        return this.amount / LOTTO_PER_MONEY;
    }

    public boolean lessThan(int lottoPerMoney) {
        return this.amount < lottoPerMoney;
    }

    public void assertPurchasable(int quantity) {
        if (quantity < 0) {
            throw new InvalidLottoException("음수 값은 허용하지 않습니다");
        }

        if (maxQuantity() < quantity) {
            throw new InvalidLottoException("수동 구매 로또 개수가 최대 구매 개수를 초과할 수 없습니다");
        }
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Money money = (Money) other;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
