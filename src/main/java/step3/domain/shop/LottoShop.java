package step3.domain.shop;

import step3.domain.lotto.Lotto;

import java.util.List;

public final class LottoShop {

    public List<Lotto> getLottos(int money) {
        return null;
    }

    private static class LottoShopHolder {
        public static final LottoShop instance = new LottoShop();
    }

    private LottoShop() { }

    public static final LottoShop getInstance() {
        return LottoShopHolder.instance;
    }


}
