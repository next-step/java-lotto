package lotto.domain;

public class LottoPurchaseAmount {
    public static final int AMOUNT_OF_LOTTO_TICKET = 1000;

    private final int amount;

    public LottoPurchaseAmount(int amount) {
        validate(amount);

        this.amount = amount;
    }

    private void validate(int amount) {
        if (amount % AMOUNT_OF_LOTTO_TICKET != 0) {
            throw new IllegalArgumentException("금액은 1000원 단위로 입력해야 합니다.");
        }
    }

    public int getTicketCount() {
        return amount / AMOUNT_OF_LOTTO_TICKET;
    }
}
