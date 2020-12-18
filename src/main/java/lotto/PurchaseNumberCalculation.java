package lotto;

public class PurchaseNumberCalculation {

    private static final int PRICE_PER_TICKET = 1000;
    private static final String PRICE_LIMIT_MESSAGE = "원 이상을 투입 해주세요";
    private static final String PRICE_UNIT_MESSAGE = "원 단위로 투입 해주세요";

    public static int calculateNumberPurchase(int purchasePrice) {
        validatePrice(purchasePrice);

        return purchasePrice / PRICE_PER_TICKET;
    }

    private static void validatePrice(int purchasePrice) {
        if (purchasePrice < PRICE_PER_TICKET) {
            throw new IllegalArgumentException(PRICE_PER_TICKET + PRICE_LIMIT_MESSAGE);
        }

        if (purchasePrice % PRICE_PER_TICKET != 0) {
            throw new IllegalArgumentException(PRICE_PER_TICKET + PRICE_UNIT_MESSAGE);
        }
    }
}