package lotto.domain;

import java.util.Objects;

public class Money {

    private static final int ZERO = 0;
    private static final String MONEY_POSITIVE_INTEGER_ERR_MESSAGE = "금액은 양의 정수만 입력 가능 합니다.";
    private static final String MONEY_NEGATIVE_INTEGER_ERR_MESSAGE = "금액은 음수가 될 수 없습니다.";

    private final double money;

    public Money() {
        money = ZERO;
    }

    public Money(final double money) {
        validatePositive(money);
        this.money = money;
    }

    private void validatePositive(final double money) {
        if (money < ZERO) {
            throw new IllegalArgumentException(MONEY_POSITIVE_INTEGER_ERR_MESSAGE);
        }
    }

    public Money getTotalPurchaseAmount(final int buyCount) {
        return new Money(this.money * buyCount);
    }

    public Money plus(final Money money) {
        return new Money(this.money + money.money);
    }

    public Money minus(final Money money) {
        double calc = this.money - money.money;
        if (calc < ZERO) {
            throw new IllegalArgumentException(MONEY_NEGATIVE_INTEGER_ERR_MESSAGE);
        }

        return new Money(this.money - money.money);
    }

    public Money divide(final Money money) {
        return new Money(this.money / money.money);
    }

    public Money multiply(final Money money) {
        return new Money(this.money * money.money);
    }

    public double getEarningRate(final Money investmentAmount) {
        return Math.floor(this.divide(investmentAmount).getMoney() * 100) / 100;
    }

    public double getMoney() {
        return money;
    }

    public int getHowManyBuyItem(final Money itemPrice) {
        return (int) Math.floor(this.money / itemPrice.money);
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
