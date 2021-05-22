package lotto.domain;

import java.util.Objects;

public class Money {
    private final int money;

    private Money(final int money) {
        this.money = money;
    }

    public static Money from(final int money) {
        validateMoney(money);
        return new Money(money);
    }

    private static void validateMoney(final int money) {
        if (money % Lotto.PRICE != 0) {
            throw new IllegalArgumentException(String.format("로또는 %d원 단위로 구입 가능합니다.", Lotto.PRICE));
        }
    }

    public boolean isPossibleBuyLotto(final int count) {
        return money > (count * Lotto.PRICE);
    }

    public int getMoney() {
        return money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
