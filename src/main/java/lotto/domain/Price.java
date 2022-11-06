package lotto.domain;

import lotto.exception.ErrorCode;
import lotto.exception.LotteryGameException;

import java.util.Objects;

public class Price {
    private static final int LOTTERY_TICKET_PRICE = 1000;
    private final int price;

    public Price(int price) {
        validateOutOfRange(price);
        validateDivideByTicketPrice(price);
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
        if (price <= LOTTERY_TICKET_PRICE) {
            throw new LotteryGameException(ErrorCode.OUT_OF_RANGE_PRICE);
        }
    }

    public Amount calculateAmount() {
        return new Amount(this.price / LOTTERY_TICKET_PRICE);
    }

    private void validateDivideByTicketPrice(int price) {
        if (price % LOTTERY_TICKET_PRICE != 0) {
            throw new LotteryGameException(ErrorCode.CANNOT_DIVIDE_BY_TICKET_PRICE);
        }
    }

    public double divide(int price) {
        return price / this.price;
    }
}
