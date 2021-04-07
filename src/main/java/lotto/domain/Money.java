package lotto.domain;

import java.util.Objects;

public class Money {
    private static final int ONE_GAME_MONEY = 1_000;
    private static final boolean DEFAULT_EMPTY_MONEY = false;

    private final int money;

    public Money(int money) {
        this(money, DEFAULT_EMPTY_MONEY);
    }

    public Money(int money, boolean isEmptyMoney) {
        if (!isEmptyMoney && money < ONE_GAME_MONEY) {
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
        if (purchaseLottoCount > lottoGameCount()) {
            throw new IllegalArgumentException(String.format("구매할 수 있는 최대 수는 %d 입니다.", lottoGameCount()));
        }
        int purchaseLottoMoney = purchaseLottoCount * ONE_GAME_MONEY;
        return new Money(money - purchaseLottoMoney, isEmptyMoney(purchaseLottoMoney));
    }

    private boolean isEmptyMoney(int money) {
        return this.money - money == 0;
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
