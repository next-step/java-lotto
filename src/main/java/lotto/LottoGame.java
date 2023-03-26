package lotto;

public class LottoGame {

    public int getLottoCount(int money) {
        return money / LOTTO_PRICE;
    }

    private static int LOTTO_PRICE = 1000;
}
