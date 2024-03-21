package lotto.domain;

public class LotteryShop {
    public static final int LOTTO_PRICE = 1000;

    private LotteryShop() {}

    public static Lottos purchase(int cash) {
        final int amount = purchaseAmount(cash);
        return AutoLottoGenerator.tickets(amount);
    }

    private static int purchaseAmount(int cash) {
        return cash / LOTTO_PRICE;
    }
}
