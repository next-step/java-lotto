package lotto.domains;

import lotto.exceptions.ExceedPurchasedAmountException;

public class LottoPurchasedAmount {
    private static final int MAX_AMOUNT = 100_000;

    private final int amount;

    public LottoPurchasedAmount(String string) {
        try {
            this.amount = Integer.parseInt(string);

            if (amount <= 0) {
                throw new IllegalArgumentException("구입 금액은 양수여야 합니다.");
            }
            if (amount > MAX_AMOUNT) {
                throw new ExceedPurchasedAmountException("구입 금액은 " + MAX_AMOUNT + "를 초과할 수 없습니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 값만 입력할 수 있습니다. 입력값: " + string);
        }
    }

    public int getAmount() {
        return amount;
    }
}
