package lotto.domain;

public class LottoPurchaseAmount {
    public static final Money AMOUNT_OF_LOTTO_TICKET = new Money(1000);

    private Money purchaseAmount;
    private int purchaseManualTicketCount;
    private int purchaseAutoTicketCount;

    public LottoPurchaseAmount(Money amount, int manualTicketCount) {
        validate(amount, manualTicketCount);

        this.purchaseAmount = amount;
        this.purchaseManualTicketCount = manualTicketCount;
        this.purchaseAutoTicketCount = (int) amount.divide(AMOUNT_OF_LOTTO_TICKET) - manualTicketCount;
    }

    public LottoPurchaseAmount(long amount) {
        this(new Money(amount), 0);
    }

    private void validate(Money amount, int manualTicketCount) {
        if (amount.divide(AMOUNT_OF_LOTTO_TICKET) < manualTicketCount) {
            throw new IllegalArgumentException("수동으로 구매하는 로또의 금액이 구입금액보다 큽니다.");
        }

        if (amount.isLessThan(AMOUNT_OF_LOTTO_TICKET) || !amount.isMultipleOf(AMOUNT_OF_LOTTO_TICKET)) {
            throw new IllegalArgumentException("구매금액은 1000원 이상 및 1000원 단위로 입력해야 합니다.");
        }
    }

    public int getAutoTicketCount() {
        return this.purchaseAutoTicketCount;
    }
}
