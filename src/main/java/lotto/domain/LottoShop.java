package lotto.domain;

public class LottoShop {

    private static final int LOTTO_PRICE = 1_000;

    private LottoShop() {

    }

    public static LottoSet buy(int money) {
        return LottoSet.create(money / LOTTO_PRICE);
    }

    public static LottoSet buy(LottoWallet lottoWallet) {
        int numberOfBuy = lottoWallet.numberOfBuy(LOTTO_PRICE);
        return LottoSet.create(numberOfBuy);
    }
}
