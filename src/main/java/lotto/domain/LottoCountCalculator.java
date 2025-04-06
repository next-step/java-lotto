package lotto.domain;

public class LottoCountCalculator {

    private static final int PRICE_PER_TICKET = 1000;

    private LottoCountCalculator() {}

    public static int calculateLottoCount(int amount) {
        return amount / PRICE_PER_TICKET;
    }
}
