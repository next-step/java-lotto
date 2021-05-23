package lotto.domain;

import java.util.Objects;

public class Price {
    public static final int LOTTO_PRICE = 1000;
    private final long price;

    public Price(long price) {
        validateMinimumPrice(price);
        validateRemainderPrice(price);
        this.price = price;
    }

    public Long getPrice() {
        return this.price;
    }

    public Long getCountAvailableForBuy() {
        return this.price / LOTTO_PRICE;
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
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위로만 입력 가능합니다.");
        }
    }

    private void validateMinimumPrice(long price) {
        if (price / LOTTO_PRICE == 0) {
            throw new IllegalArgumentException("최소 구매 가격은 1,000원 입니다.");
        }
    }
}
