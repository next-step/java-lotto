package lotto.model;

import java.util.Objects;

public class Money {

    public static final Money LOTTO_PRICE = new Money(1000);
    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("금액은 음수일 수 없습니다.");
        }
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("1000원 단위만 입력 가능합니다.");
        }
    }

    public Money buyManualLotto(int manualLottoCount) {
        return new Money(this.money - LOTTO_PRICE.getMoney() * manualLottoCount);
    }

    public int getLottoCount() {
        return this.money / LOTTO_PRICE.getMoney();
    }

    public int getTotalMoney(int lottoCount) {
        return lottoCount * LOTTO_PRICE.getMoney();
    }

    public int getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return String.valueOf(money);
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
