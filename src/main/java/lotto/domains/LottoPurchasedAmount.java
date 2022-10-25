package lotto.domains;

import lotto.exceptions.ExceedPurchasedAmountException;

public class LottoPurchasedAmount {
    private static final int MAX_AMOUNT = 100_000;
    private static final int MIN_AMOUNT = 1_000;

    private final int amount;

    public static LottoPurchasedAmount of(String string) {
        try {
            int amount = Integer.parseInt(string);

            if (amount < MIN_AMOUNT) {
                throw new IllegalArgumentException("최소 구입 금액은 1000원 입니다.");
            }

            if (amount > MAX_AMOUNT) {
                throw new ExceedPurchasedAmountException("구입 금액은 " + MAX_AMOUNT + "원을 초과할 수 없습니다.");
            }

            return new LottoPurchasedAmount(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 값만 입력할 수 있습니다. 입력값: " + string);
        }
    }

    private LottoPurchasedAmount(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("구입 금액은 양수여야 합니다.");
        }

        this.amount = amount;
    }

    public LottoPurchasedAmount spend(int amount) {
        return new LottoPurchasedAmount(this.amount - amount);
    }

    public int getAmount() {
        return amount;
    }
}
