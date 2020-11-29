package lotto;

public class PurchaseNumberCalculation {

    private static final int PRICE_PER_TICKET = 1000;

    public static int calculateNumberPurchase(int purchasePrice) {
        validatePrice(purchasePrice);

        return purchasePrice / PRICE_PER_TICKET;
    }

    private static void validatePrice(int purchasePrice) {
        if (purchasePrice < PRICE_PER_TICKET) {
            throw new IllegalArgumentException(Message.VALIDATION_PRICE_LIMIT_MESSAGE);
        }

        if (purchasePrice % PRICE_PER_TICKET != 0) {
            throw new IllegalArgumentException(Message.VALIDATION_PRICE_UNIT_MESSAGE);
        }
    }
}
