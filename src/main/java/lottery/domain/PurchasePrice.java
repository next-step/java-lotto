package lottery.domain;

public class PurchasePrice {

    private static final int PRICE_OF_A_LOTTERY = 1000;
    private static final String EXCEPTION_MESSAGE_INVALID_PRICE_FORMAT = "구입 금액은 %d 보다 많아야 합니다. 입력: %d";
    private static final String EXCEPTION_MESSAGE_UNIT_MATCH_FORMAT = "구입 단위는 %d 입니다. 입력: %d";

    private final int price;

    private PurchasePrice(final int price) {
        this.price = price;
    }

    public static PurchasePrice of(final int price) {
        if (price < PRICE_OF_A_LOTTERY) {
            throw new IllegalArgumentException(String.format(EXCEPTION_MESSAGE_INVALID_PRICE_FORMAT, PRICE_OF_A_LOTTERY, price));
        }

        if (price % PRICE_OF_A_LOTTERY != 0) {
            throw new IllegalArgumentException(String.format(EXCEPTION_MESSAGE_UNIT_MATCH_FORMAT, PRICE_OF_A_LOTTERY, price));
        }

        return new PurchasePrice(price);
    }

    public int affordableTicketCount() {
        return price / PRICE_OF_A_LOTTERY;
    }

    public int price() {
        return price;
    }
}
