package step3.domain.shop;

public final class LottoShop {

    private static class LottoShopHolder {
        public static final LottoShop instance = new LottoShop();
    }

    private LottoShop() { }

    public static final LottoShop getInstance() {
        return LottoShopHolder.instance;
    }


}
