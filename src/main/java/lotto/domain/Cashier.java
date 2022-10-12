package lotto.domain;

import java.math.BigInteger;
import java.util.Objects;

public class Cashier {

    public static final BigInteger LOTTO_PURCHASING_UNIT = BigInteger.valueOf(1000);

    private final Money money;

    public Cashier(Money money) {
        validateThousandUnits(money);
        this.money = money;
    }

    public Cashier(String money) {
        this(new Money(money));
    }

    // TODO: 메소드 이름 바꾸기
    public int findCountOfPlayLotto() {
        return this.money.divideBy(LOTTO_PURCHASING_UNIT)
                .intValue();
    }

    private void validateThousandUnits(Money money) {
        if (!money.isThousandUnits()) {
            throw NotThousandUnitsMoneyException.of();
        }
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
