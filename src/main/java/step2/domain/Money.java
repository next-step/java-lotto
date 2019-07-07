package step2.domain;

import java.util.Objects;

public class Money {
    private static final int NO_MONEY = 0;
    private final Long money;

    public Money(Long money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(Long money) {
        if (money < NO_MONEY) {
            throw new IllegalArgumentException("마이너스 금액은 입력할 수 없습니다.");
        }
    }

    public Long getMoney() {
        return money;
    }

    public Money multiplyMoney(final int size) {
        return new Money(money * size);
    }

    public Money subtractMoney(final Money money) {
        return new Money(this.money - money.money);
    }

    public LottoQuantity getLottoQuantity(final Money lottoPrice) {
        return new LottoQuantity(this.money / lottoPrice.getMoney());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Money money1 = (Money) o;
        return Objects.equals(money, money1.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
