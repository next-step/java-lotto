package lotto.domain;

public class PurchaseAmount {

    private final int amount;

    public PurchaseAmount(int amount) {
        validatePositiveAmount(amount);
        this.amount = amount;
    }

    private void validatePositiveAmount(int amount) {
        if (amount < 0)
            throw new IllegalArgumentException(String.format("paid amount(%d) should not be negative value.", amount));
    }

    private void validateDividedAmount(int amount, int ticketPrice) {
        if (amount % ticketPrice != 0)
            throw new IllegalArgumentException(String.format("lotto machine can take %d per ticket. but you paid %d.", ticketPrice, amount));
    }

    public int getTicketCount(int price) {
        validateDividedAmount(amount, price);
        return amount / price;
    }

}
