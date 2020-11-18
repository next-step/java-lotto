package lotto_auto.model;

public class LottoStore {

    private final static int LOTTO_TICKET_PRICE = 1000;

    public static LottoBundle buy(int money) {
        throwIfNegativeMoney(money);
        return new LottoBundle(money / LOTTO_TICKET_PRICE);
    }

    private static void throwIfNegativeMoney(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException();
        }
    }

}
