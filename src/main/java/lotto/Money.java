package lotto;

import java.util.Objects;

public class Money {
    private Long money;

    public Money(Long money) {
        validateNegative(money);
        this.money = money;
    }

    private void validateNegative(Long money) {
        if (isNegative(money)) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }

    private boolean isNegative(Long money) {
        return money < 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return Objects.equals(money, money1.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}