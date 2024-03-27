package lotto;

public class LottoStore {

    private static final int LOTTO_PRICE = 1000;
    private static final int ZERO = 0;

    public static int sellLotto(Money money) {
        return money / LOTTO_PRICE;
    }
}
