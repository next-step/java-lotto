package lotto;



public class LottoSeller {
    private static final int PRICE_PER_ONE_LOTTO = 1_000;

    public static Lottos sell(Money money, LottoNumberStrategy strategy) {
        return new Lottos(getLottoCountToBuy(money), strategy);
    }

    private static int getLottoCountToBuy(Money money) {
        return money.divide(PRICE_PER_ONE_LOTTO);
    }

}
