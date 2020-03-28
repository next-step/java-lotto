package step2;

public class Money {
    private static final Integer LOTTO_PRICE = 1000;
    private static final Integer AMOUNT_ZERO = 0;
    public static final String MONEY_NEGATIVE_ERROR = "0보다 큰 금액을 입력해주세요.";
    public static final String MONEY_AMOUNT_ERROR = "로또 금액보다 큰 금액을 입력해주세요.";

    private final int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        checkIsNegativeMoney(money);
        checkMoneyAmount(money);
    }

    private void checkIsNegativeMoney(int money) {
        if(money < AMOUNT_ZERO) {
            throw new IllegalArgumentException(MONEY_NEGATIVE_ERROR);
        }
    }

    private void checkMoneyAmount(int money) {
        if(money < LOTTO_PRICE) {
            throw new IllegalArgumentException(MONEY_AMOUNT_ERROR);
        }
    }
}
