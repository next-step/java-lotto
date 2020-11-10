package lotto.lib;

import lotto.asset.LottoConst;

public class PurchaseCalculator {
    private PurchaseCalculator() {}

    protected static int getNumOfLottos(int money, int price) {
        MoneyValidator.validateMoney(money);
        PriceValidator.validatePrice(price);
        return money / price;
    }

    public static int getNumOfLottos(int money) {
        return getNumOfLottos(money, LottoConst.PRICE);
    }
}
