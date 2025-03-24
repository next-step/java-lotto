package domain;

public class PurchaseAmount {
    private final int LOTTO_PRICE = 1000;
    private final int amount;

    public PurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public int countOfLotto() {
        return amount / LOTTO_PRICE;
    }

    private void validate(int amount) {
        validateMinimumAmount(amount);
        validateDivisibleByLottoPrice(amount);
    }

    private void validateMinimumAmount(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException("구입 금액은 1000원 이상이어야 합니다.");
        }
    }

    private void validateDivisibleByLottoPrice(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구입 금액은 1000원 단위여야 합니다.");
        }
    }
}
