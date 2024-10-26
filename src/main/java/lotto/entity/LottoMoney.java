package lotto.entity;

public class LottoMoney {
    private static final int LOTTO_UNIT_PRICE = 1000;

    private LottoMoney() {
    }

    public static int getLottoCount(int money) {
        return money / LOTTO_UNIT_PRICE;
    }

}
