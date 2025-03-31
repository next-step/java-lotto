package lotto.domain;

import static lotto.domain.LottoConstant.TICKET_PRICE;

public class PurchaseAmount {
    private final int amount;

    public PurchaseAmount(int amount) {
        this(amount, 0);
    }

    public PurchaseAmount(int amount, int ticketCount) {
        validatePositiveAmount(amount);
        validateDividedAmount(amount);
        validateBiggerTicketCount(amount, ticketCount);
        this.amount = amount;
    }

    private void validateBiggerTicketCount(int amount, int ticketCount) {
        if(amount / TICKET_PRICE < ticketCount)
            throw new IllegalArgumentException(String.format("Amount paid is not enough to buy %d tickets", ticketCount));
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
