package lotto.dto;

import java.util.Objects;

public class Price {
    private static final int ZERO = 0;

    private int price;

    public Price(final int price) {
        checkAvailablePrice(price);
        this.price = price;
    }

    private void checkAvailablePrice(final int price) {
        if (price <= ZERO) {
            throw new RuntimeException("금액을 잘못 입력 하셨습니다.");
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Price price1 = (Price) o;
        return price == price1.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }

    public int lotteryCount(final int won) {
        return price / won;
    }
}
