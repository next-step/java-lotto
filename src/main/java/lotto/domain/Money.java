package lotto.domain;

public class Money {
    private final int buyAmount;
    private final int BUY_AMOUNT_UNIT = 1000;
    private final String BUY_AMOUNT_UNIT_CHECK_TEXT = "금액은 " + BUY_AMOUNT_UNIT + "원 단위로 입력하십시오.";

    public Money(int money) {
        validateCheck(money);
        this.buyAmount = money;
    }

    private void validateCheck(int money) {
        if (money % BUY_AMOUNT_UNIT != 0
                || money <= 0) {
            throw new IllegalArgumentException(BUY_AMOUNT_UNIT_CHECK_TEXT);
        }
    }

    public int getBuyAmount() {
        return this.buyAmount;
    }

    public int getBuyAmoutUnit() {
        return BUY_AMOUNT_UNIT;
    }
}
