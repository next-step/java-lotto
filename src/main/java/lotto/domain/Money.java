package lotto.domain;

public class Money {
    private static final long MONEY_OF_ONE_TICKET = 1000;

    private final long value;

    public Money(long value) {
        validate(value);
        this.value = value;
    }

    public int computeLottoTickets() {
        return (int) (value / MONEY_OF_ONE_TICKET);
    }

    public double calculateYield(long sum) {
        return Math.floor(((double) sum / value) * 100) / 100;
    }

    private void validate(long value) {
        if (value < MONEY_OF_ONE_TICKET) {
            throw new IllegalArgumentException("로또를 살 수가 없습니다.");
        }
    }
}
