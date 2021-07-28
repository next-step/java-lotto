package step2.domain;

public class Shop {
    public static final int LOTTO_PRICE = 1000;

    public static Lottos buyLotto(int money) {
        return Lottos.createLottos(getLottoCount(money));
    }

    private static int getLottoCount(int money) {
        return money / LOTTO_PRICE;
    }
}
