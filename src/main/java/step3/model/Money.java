package step3.model;

public class Money {

    private static final String RANGE_VIOLATION_ERROR_MESSAGE = "돈은 양수여야 합니다";
    private static final int MIN = 1;

    private int money;

    public Money(int money) {
        checkPositive(money);
        this.money = money;
    }

    private void checkPositive(int money) {
        if (money < MIN) {
            throw new IllegalArgumentException(RANGE_VIOLATION_ERROR_MESSAGE);
        }
    }

}
