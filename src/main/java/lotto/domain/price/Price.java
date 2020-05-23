package lotto.domain.price;

import lotto.exception.ErrorMessage;
import lotto.exception.NegativeNumberException;

public class Price {

    static final int MIN_PRICE = 0;
    public static final int ONE_TICKET_PRICE = 1000;

    private final int price;

    private Price(final int price) {
        validateNegative(price);
        this.price = price;
    }

    public static Price of(final int price) {
        return new Price(price);
    }

    private void validateNegative(final int price) {
        if (price < MIN_PRICE) {
            throw new NegativeNumberException(price);
        }
    }

    public void validateAvailablePrice() {
        if (price < ONE_TICKET_PRICE) {
            throw new IllegalArgumentException(String.format(ErrorMessage.REQUIRED_MIN_PRICE, MIN_PRICE));
        }
    }

    public float calculateProfitRate(final int totalPrizes) {
        return ((float) totalPrizes / price);
    }

    public int ticketCount() {
        return price / ONE_TICKET_PRICE;
    }

    public int getPrice() {
        return price;
    }
}
