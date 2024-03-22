package lotto.domain;

import java.util.Objects;

public class Price {

    private final int price;

    public Price(int price) {
        if (price < Rule.LOTTO_PRICE.getValue()) {
            throw new IllegalArgumentException(String.format("구입 금액은 %d원 이상이어야 합니다.", Rule.LOTTO_PRICE.getValue()));
        }
        this.price = price;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Price price1 = (Price) object;
        return price == price1.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }

}
