package study.lotto.domain;

public class Amount {
    private static final String MIN_AMOUNT_ERROR_MESSAGE = "최소 금액은 %d원 입니다.";
    private static final int AMOUNT_MIN = 0;
    private int amount;

    public Amount(int amount) {
        if(amount < AMOUNT_MIN) {
            // todo custom exception
            throw new IllegalArgumentException(MIN_AMOUNT_ERROR_MESSAGE);
        }
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
