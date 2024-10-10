package lotto.domain.money;

public class Money {

    private final long amount;

    private Money(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("구입금액은 양수여야 합니다.");
        }
        this.amount = amount;
    }

    public static Money of(long amount) {
        return new Money(amount);
    }

    public long getAmount() {
        return amount;
    }

    public int availableLottoTickets(long lottoTicketPrice) {
        return (int) (amount / lottoTicketPrice);
    }
}
