package lotto.domain;

public class Money {
    private static final int MIN_PRICE = 1000;
    private static final int MAX_PRICE = 100000;

    private int value;

    public Money(int value) {
        validate(value);
        this.value = value;
    }

    public Money(Money money, int spendMoney) {
        this.value = money.getValue() - spendMoney;
    }

    int getValue() {
        return value;
    }

    int countLotto() {
        return value / MIN_PRICE;
    }

    private void validate(int value) {
        if (value < MIN_PRICE) {
            throw new IllegalArgumentException("로또는 최소 1,000원부터 구매가능합니다.");
        }
        if (value > MAX_PRICE) {
            throw new IllegalArgumentException("한번에 구매 가능한 최대 금액은 100,000원입니다.");
        }
    }

}
