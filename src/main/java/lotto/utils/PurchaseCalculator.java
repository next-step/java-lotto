package lotto.utils;

import lotto.asset.LottoConst;
import lotto.utils.validator.MoneyValidator;
import lotto.utils.validator.PriceValidator;

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
