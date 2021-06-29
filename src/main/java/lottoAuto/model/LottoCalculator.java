package lottoAuto.model;

public class LottoCalculator {
    private static final int LOTTO_PRICE = 1000;
    private static final String CHECK_LOTTO_PRICE_MESSAGE = "로또 1장의 가격은 1000원입니다.";

    public static int calculateAmount(int price) {
        checkLottoPrice(price);
        return price / LOTTO_PRICE;
    }

    private static void checkLottoPrice(int price) {
        if (price < LOTTO_PRICE) {
            throw new IllegalArgumentException(CHECK_LOTTO_PRICE_MESSAGE);
        }
    }
}
