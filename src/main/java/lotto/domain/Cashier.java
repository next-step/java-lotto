package lotto.domain;

import java.util.Objects;

public class Cashier {

    Money money;

    public Cashier(Money money) {
        validateThousandUnits(money);
        this.money = money;
    }

    public Cashier(String money) {
        this(new Money(money));
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
