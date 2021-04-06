package lotto.domain;

import java.util.Objects;

public class Money {
    private static final int ONE_GAME_MONEY = 1_000;

    private final int money;

    public Money(int money) {
        if (money < ONE_GAME_MONEY) {
            throw new IllegalArgumentException(String.format("로또 구입금액은 최소 %d 이상을 입력해 주세요.", ONE_GAME_MONEY));
        }
        this.money = money;
    }

    public int lottoGameCount() {
        return money / ONE_GAME_MONEY;
    }

    public int intValue() {
        return money;
    }

    public Money remainMoney(int purchaseLottoCount) {
        return new Money(money - (purchaseLottoCount * ONE_GAME_MONEY));
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
