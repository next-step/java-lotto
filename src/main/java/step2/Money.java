package step2;

public class Money {
    private static final Integer LOTTO_PRICE = 1000;
    public static final String MONEY_NEGATIVE_ERROR = "0보다 큰 금액을 입력해주세요.";
    public static final String MONEY_AMOUNT_ERROR = "로또 금액보다 큰 금액을 입력해주세요.";

    private final int money;

    public Money(int money) {
        this.money = money;

        validateMoney();
    }

    private void validateMoney() {
        if(money < 0) {
            throw new IllegalArgumentException(MONEY_NEGATIVE_ERROR);
        }

        if(money < LOTTO_PRICE) {
            throw new IllegalArgumentException(MONEY_AMOUNT_ERROR);
        }
    }
}
