package lotto.domains;

import lotto.exceptions.ExceedPurchasedAmountException;

public class LottoPurchasedAmount {
    private static final int MAX_AMOUNT = 100_000;
    private static final int MIN_AMOUNT = 1_000;

    private final int amount;

    public LottoPurchasedAmount(String string) {
        try {
            this.amount = Integer.parseInt(string);
            validateAmount();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 값만 입력할 수 있습니다. 입력값: " + string);
        }
    }

    private void validateAmount() {
        if (amount <= 0) {
            throw new IllegalArgumentException("구입 금액은 양수여야 합니다.");
        }

        if (amount < MIN_AMOUNT) {
            throw new IllegalArgumentException("최소 구입 금액은 1000원 입니다.");
        }

        if (amount > MAX_AMOUNT) {
            throw new ExceedPurchasedAmountException("구입 금액은 " + MAX_AMOUNT + "원을 초과할 수 없습니다.");
        }
    }

    public int getAmount() {
        return amount;
    }
}
