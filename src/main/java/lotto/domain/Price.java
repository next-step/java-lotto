package lotto.domain;

import java.util.Objects;

public class Price {
    public static final int UNIT_OF_PRICE = 1000;
    private final long price;

    public Price(long price) {
        validateMinimumPrice(price);
        validateRemainderPrice(price);
        this.price = price;
    }

    public Long getPrice() {
        return this.price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price1 = (Price) o;
        return this.price == price1.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.price);
    }

    private void validateRemainderPrice(long price) {
        if (price % UNIT_OF_PRICE != 0) {
            throw new IllegalArgumentException("금액은 1,000원 단위로만 입력 가능합니다.");
        }
    }

    private void validateMinimumPrice(long price) {
        if (price / UNIT_OF_PRICE == 0) {
            throw new IllegalArgumentException("최소 금액은 1,000원 입니다.");
        }
    }

    public boolean canBuy(int manualWishCount) {
        return this.price >= manualWishCount * UNIT_OF_PRICE;
    }
}
