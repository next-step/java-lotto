package lotto.domain;

import static lotto.domain.LottoConstant.TICKET_PRICE;

public class PurchaseAmount {
    private final int amount;

    public PurchaseAmount(int amount) {
        validatePositiveAmount(amount);
        validateDividedAmount(amount);
        this.amount = amount;
    }

    private void validatePositiveAmount(int amount) {
        if (amount < 0)
            throw new IllegalArgumentException(String.format("paid amount(%d) should not be negative value.", amount));
    }

    private void validateDividedAmount(int amount) {
        if (amount % TICKET_PRICE != 0)
            throw new IllegalArgumentException(String.format("lotto machine can take %d per ticket. but you paid %d.", TICKET_PRICE, amount));
    }

    public int getTicketCount() {
        return amount / TICKET_PRICE;
    }

    public double getReturnRate(int income) {
        return (double) income / amount;
    }

}
