package lotto;

public class Amount {

    private final int amount;

    public Amount(int amount) {
        validateAmountUnderZero(amount);
        this.amount = amount;
    }

    private void validateAmountUnderZero(int amount) {
        if (amount <= 0) {
            throw new LotteryGameException(ErrorCode.AMOUNT_UNDER_ZERO);
        }
    }
}
