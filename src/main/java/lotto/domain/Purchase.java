package lotto.domain;

public class Purchase {

    public static final int LOTTO_TICKET_PRICE = 1_000;

    private final int purchase;

    private Purchase(final int purchase){

        this.purchase = purchase;
    }

    public static Purchase from(final String amount) {

        validate(amount);
        return new Purchase(convert(amount));
    }

    private static void validate(final String purchase) {

        if (purchase == null || purchase.isEmpty()) {
            throw new IllegalArgumentException("구매금액은 입력해야 합니다.");
        }
    }

    private static int convert(final String purchase) {

        return Integer.parseInt(purchase);
    }

    public int available() {

        return Math.floorDiv(this.purchase, LOTTO_TICKET_PRICE);
    }

    public int getPurchase() {

        return purchase;
    }
}
