package lotto;

public class LottoOutlet {
    private static final int LOTTO_PRICE = 1000;

    public static int lottoCount(int money) {
        return money / LOTTO_PRICE;
    }
}
