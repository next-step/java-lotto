package lotto;

public class PurchaseNumberCalculation {

    private static final int PRICE_PER_TICKET = 1000;

    public static int calculateNumberPurchase(int purchasePrice) {
        if (purchasePrice < PRICE_PER_TICKET) {
            throw new IllegalArgumentException("1000원 이상을 투입 해주세요");
        }

        if (purchasePrice % PRICE_PER_TICKET != 0) {
            throw new IllegalArgumentException("1000원 단위로 투입 해주세요");
        }

        return purchasePrice / PRICE_PER_TICKET;
    }
}
