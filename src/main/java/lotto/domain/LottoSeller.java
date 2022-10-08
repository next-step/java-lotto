package lotto.domain;

public class LottoSeller {
    private static final int LOTTO_PRICE = 1000;

    public static int sellLotto(int amount) {
        return amount / LOTTO_PRICE;
    }
}
