package lotto.domain;

public class Amount {

    private static final int MINIMUM_AMOUNT = 0;

    private final int amount;

    private Amount(int amount) {
        isGreaterThanZero(amount);
        this.amount = amount;
    }

    public static Amount from(int amount) {
        return new Amount(amount);
    }

    private void isGreaterThanZero(int amount) {
        if (amount < MINIMUM_AMOUNT) {
            throw new IllegalArgumentException("0 이상 수를 입력해주세요");
        }
    }

    public Amount calculateAutoLottos(Money lottoAmount) {
        isOverThenTotalAmount(lottoAmount);
        return new Amount(lottoAmount.getAutoLottoAmount(amount));
    }

    private void isOverThenTotalAmount(Money lottoAmount) {
        if (lottoAmount.isOverTotalQuantity(amount)) {
            throw new IllegalArgumentException("구입 금액보다 많습니다.");
        }
    }

    public int getAmount() {
        return amount;
    }
}
