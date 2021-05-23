package lotto.domains;

public class Cash {
    private static final int MINIMUM_AMOUNT = 1000;
    private final int amount;

    public Cash(int amount) {
        isGreaterThanZero(amount);
        this.amount = amount;
    }

    public int numberOfPurchasesAvailable(Cash cash) {
        return this.amount / cash.amount;
    }

    private void isGreaterThanZero(int amount){
        if (amount < MINIMUM_AMOUNT){
            throw new IllegalArgumentException("1000 보다 큰숫자를 입력해주세요");
        }
    }
}
