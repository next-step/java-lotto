package lotto.domain;

public class LottoPrice {
    public static final Integer LOTTO_PRICE = 1000;

    private LottoPrice() {
    }

    public static int possibleTotalLottoCount(int budget) {
        return budget / LOTTO_PRICE;
    }
}
