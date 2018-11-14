package lotto.domain;

public class LottoShop {

    private LottoShop() {

    }

    public static LottoSet buy(int amount) {
        int count = amount / 1_000;
        return LottoSet.create(count);
    }
}
