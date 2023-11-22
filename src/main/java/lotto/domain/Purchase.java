package lotto.domain;

public class Purchase {

    private static final int PRICE_OF_LOTTO = 1000;
    private static final String ERROR_PRICE_OF_LOTTO = "구매 금액은 1,000원 이상이여야 합니다.";

    private int amount;
    private int count;

    public Purchase(int amount, int count) {
        this.amount = amount;
        this.count = count;
    }

    public static int purchaseCount(int amount) {
        if (amount < PRICE_OF_LOTTO) {
            throw new IllegalArgumentException(ERROR_PRICE_OF_LOTTO);
        }
        return amount / PRICE_OF_LOTTO;
    }

    public int getAmount() {
        return amount;
    }

    public int getCount() {
        return count;
    }
}