package lotto.domain;

public class TicketAmount {
    private final int amount;

    public TicketAmount(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("로또 티켓의 갯수는 0개 이상입니다.");
        }
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isGreaterThan(TicketAmount other) {
        return this.amount > other.amount;
    }

    public TicketAmount minus(TicketAmount other) {
        return new TicketAmount(this.amount - other.amount);
    }
}
