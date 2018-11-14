package lotto.domain;

public class LottoShop {

    private static final int LOTTO_PRICE = 1_000;

    private LottoShop() {

    }

    public static LottoSet buy(int amount) {
        int count = amount / LOTTO_PRICE;
        return LottoSet.create(count);
    }
}
