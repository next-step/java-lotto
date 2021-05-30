package lotto.domains;
public class Cash {
    private static final int LOTTO_PRICE = 1000;
    private final int amount;

    public Cash(int amount) {
        validateGreaterThanZero(amount);
        this.amount = amount;
    }

    public int numberOfPurchasesAvailable() {
        return this.amount / LOTTO_PRICE;
    }

    private void validateGreaterThanZero(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException("1000 보다 큰숫자를 입력해주세요");
        }
    }

    public boolean isPurchasesAvailable(int count) {
        return numberOfPurchasesAvailable() >= count;
    }
}
