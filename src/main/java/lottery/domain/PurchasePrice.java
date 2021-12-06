package lottery.domain;

public class PurchasePrice {

    private static final int MINIMUM_LOTTERY_PURCHASE_PRICE = 1000;
    private static final int PRICE_OF_A_LOTTERY = 1000;
    private static final String EXCEPTION_MESSAGE_INVALID_PRICE_FORMAT = "구입 금액은 %d 보다 많아야 합니다. 입력: ";

    final int value;

    private PurchasePrice(final int value) {
        this.value = value;
    }

    public static PurchasePrice of(final int input) {
        if (input < MINIMUM_LOTTERY_PURCHASE_PRICE) {
            throw new IllegalArgumentException(String.format(EXCEPTION_MESSAGE_INVALID_PRICE_FORMAT, input));
        }

        return new PurchasePrice(input);
    }

    public LotteryTickets boughtTickets() {
        final int affordableTicketCount = value / PRICE_OF_A_LOTTERY;

        return LotteryTickets.createWithRandomNumbers(affordableTicketCount);
    }
}
