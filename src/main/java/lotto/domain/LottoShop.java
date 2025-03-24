package lotto.domain;

public class LottoShop {

    public LottoPurchase purchase(Money money) {
        return new LottoPurchase(money);
    }

}
