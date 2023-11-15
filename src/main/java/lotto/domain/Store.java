package lotto.domain;

public class Store {
    public static final int LOTTO_PRICE = 1000;

    public static int purchasableLottoCount(int value) {
        return value/LOTTO_PRICE;
    }
}
