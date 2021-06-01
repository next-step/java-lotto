package lottery.domain;

import java.util.Objects;

public class Price {

    public static final int MINIMUM_PRICE = 0;

    private final Integer price;

    public Price(int price) {
        validatePrice(price);

        this.price = price;
    }

    public int calculatePerLottery() {
        return price / 1000;
    }

    private void validatePrice(int price) {
        if (price < MINIMUM_PRICE) {
            throw new IllegalArgumentException("금액은 0원이상 이어야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price1 = (Price) o;
        return Objects.equals(price, price1.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }
}
