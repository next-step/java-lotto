package lotto.model;

import java.util.Objects;

public class Money {
    private final long amount;

    public Money(int amount) {
        this((long) amount);
    }

    public Money(long amount) {
        if (!isValid(amount)) {
            throw new IllegalArgumentException("예산은 0 이상이며 1000원 단위로만 설정 가능합니다.");
        }
        this.amount = amount;
    }

    public int countLottoTickets() {
        return Math.toIntExact(amount / 1_000L);
    }

    public Lottos buyLottos() {
        return new Lottos(countLottoTickets());
    }

    public boolean isZero() {
        return amount == 0;
    }

    public double divideBy(Money money) {
        return (double) this.amount / money.amount;
    }

    private boolean isValid(Long amount) {
        return amount >= 0 && amount % 1000 == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(amount);
    }
}
