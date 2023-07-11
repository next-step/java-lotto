package lotto.domain;

public class Money {

    private static final int MIN_PURCHASE_MONEY = 1_000;
    private static final int MAX_PURCHASE_MONEY = 100_000;
    private static final String MONEY_RANGE_EXCEPTION_MESSAGE =
            "로또는 " + MIN_PURCHASE_MONEY + "원 이상 " + MAX_PURCHASE_MONEY + "원 이하만 구매할 수 있습니다";
    private final int value;

    public Money(final String value) {
        validate(value);
        this.value = Integer.parseInt(value);
    }

    private void validate(final String value) {
        if (!value.matches("\\d+")) {
            throw new IllegalArgumentException();
        }
        
        int money = Integer.parseInt(value);

        if (money < MIN_PURCHASE_MONEY || MAX_PURCHASE_MONEY < money) {
            throw new IllegalArgumentException(MONEY_RANGE_EXCEPTION_MESSAGE);
        }
    }
}
