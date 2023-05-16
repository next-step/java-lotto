package lotto.domain;

public class LottoPurchaseAmount {
    public static final Money AMOUNT_OF_LOTTO_TICKET = new Money(1000);

    private Money purchaseAmount;
    private int purchaseCount;

    public LottoPurchaseAmount(Money amount) {
        validate(amount);

        this.purchaseAmount = amount;
        this.purchaseCount = (int) amount.divide(AMOUNT_OF_LOTTO_TICKET);
    }

    public LottoPurchaseAmount(long amount) {
        this(new Money(amount));
    }

    private void validate(Money amount) {
        if (amount.isLessThan(AMOUNT_OF_LOTTO_TICKET) || !amount.isMultipleOf(AMOUNT_OF_LOTTO_TICKET)) {
            throw new IllegalArgumentException("구매금액은 1000원 이상 및 1000원 단위로 입력해야 합니다.");
        }
    }

    public int getTicketCount() {
        return this.purchaseCount;
    }
}
