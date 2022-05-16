package lotto.domain;

import java.util.Objects;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    private static final String BUY_PRICE_VALID_ERROR_MESSAGE = "1,000원 단위로만 구매 가능합니다.";
    private static final String WRONG_NUMBER_EXCEPTION = "숫자형식이 아닙니다.";

    private final double money;

    public Money(String money) {
        this(parseDouble(money));
    }

    public Money() {
        this(0);
    }

    public Money(double money) {
        validate(money);
        this.money = money;
    }

    private static double parseDouble(String money) {
        try {
            return Double.parseDouble(money);
        } catch (Exception e) {
            throw new IllegalArgumentException(WRONG_NUMBER_EXCEPTION);
        }
    }

    private void validate(double money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(BUY_PRICE_VALID_ERROR_MESSAGE);
        }
    }

    public double calculateReturnRate(Money winningMoney) {
        return winningMoney.money / this.money;
    }

    public Money sumMoney(Money money) {
        return new Money(this.money + money.money);
    }

    public int getMaxPurchasableQuantity() {
        return (int) (money / LOTTO_PRICE);
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

    @Override
    public String toString() {
        return Double.toString(money);
    }
}
