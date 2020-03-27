package lotto.dto;

import java.util.Objects;

public class Price {
    private int price;

    public Price(final int price) {
        if (price <= 0) {
            throw new RuntimeException("금액을 잘못 입력 하셨습니다.");
        }
        this.price = price;
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
}
