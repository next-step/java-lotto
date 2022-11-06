package lotto.domain;

import lotto.exception.ErrorCode;
import lotto.exception.LotteryGameException;

import java.util.Objects;

public class Price {
    private static final int MINIMUM_PRICE = 0;
    private final int price;

    public Price(int price) {
        validateOutOfRange(price);
        this.price = price;
    }

    public Price(String price) {
        this(parseInt(price));
    }

    private static int parseInt(String price) {
        if (Objects.isNull(price) || price.isEmpty()) {
            throw new LotteryGameException(ErrorCode.NULL_OR_EMPTY);
        }
        return Integer.parseInt(price);
    }

    private void validateOutOfRange(int price) {
        if (price <= MINIMUM_PRICE) {
            throw new LotteryGameException(ErrorCode.OUT_OF_RANGE_PRICE);
        }
    }

    public Amount calculateAmount(Price price) {
        return new Amount(this.price / price.price);
    }

    public double divide(int price) {
        return price / this.price;
    }
}
