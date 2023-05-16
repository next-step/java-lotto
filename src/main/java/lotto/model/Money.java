package lotto.model;

import java.util.Objects;

public class Money {
    private static final int ONE_LOTTO_TICKET_PRICE = 1_000;
    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public int getLottoTicketCount() {
        return this.money / ONE_LOTTO_TICKET_PRICE;
    }

    private void validate(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("금액은 음수일 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
