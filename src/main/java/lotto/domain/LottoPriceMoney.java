package lotto.domain;

public class LottoPriceMoney extends Money {
    private static final int LOTTO_PRICE = 1000;

    private LottoPriceMoney() {
        super(LOTTO_PRICE);
    }

    public static LottoPriceMoney getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {
        private static final LottoPriceMoney instance = new LottoPriceMoney();
    }
}
