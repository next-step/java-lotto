package step4.domain.shop;

public class LottoShop {

    private static class LottoShopHolder {
        private static LottoShop lottoShop = new LottoShop();
    }

    public LottoShop() { }

    public static final LottoShop getInstance() {
        return LottoShopHolder.lottoShop;
    }

}
