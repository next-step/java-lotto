package lotto.domain;

import lotto.domain.exception.UnpurchasableAmountOfMoneyException;
import lotto.util.NullCheckUtil;

import java.math.BigInteger;
import java.util.Objects;

public class Cashier {

    private static final Money LOTTO_PRICE = new Money(1000);

    private final Money money;

    public Cashier(Money money) {
        NullCheckUtil.validate(money);
        validateMinimum(money);
        this.money = money;
    }

    public Cashier(String money) {
        this(new Money(money));
    }

    private void validateMinimum(Money money) {
        if (money.lessThan(LOTTO_PRICE)) {
            throw UnpurchasableAmountOfMoneyException.getInstance();
        }
    }

    public int countPlayLotto() {
        return this.money.divide(LOTTO_PRICE)
                .intValue();
    }

    public Money receiveLeftMoney() {
        Money totalLottoPrice = LOTTO_PRICE.multiply(BigInteger.valueOf(countPlayLotto()));
        return money.subtract(totalLottoPrice);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cashier cashier = (Cashier) o;
        return Objects.equals(money, cashier.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
