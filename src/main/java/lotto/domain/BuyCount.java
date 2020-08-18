package lotto.domain;

import lotto.exception.LottoExceptionMessage;
import utils.StringUtils;

public class BuyCount {
    public static final int DEFAULT_LOTTO_MONEY_UNIT = 1_000;

    private int buyCount;

    private BuyCount(int buyCount) {
        this.buyCount = buyCount;
    }

    public static BuyCount of(String lottoMoney) {
        int buyCount = getValidLottoMoney(lottoMoney) / DEFAULT_LOTTO_MONEY_UNIT;

        return new BuyCount(buyCount);
    }

    private static int getValidLottoMoney(String money) {
        int lottoMoney = StringUtils.toNumber(money);
        validateMoneyUnit(lottoMoney);

        return lottoMoney;
    }

    private static void validateMoneyUnit(int lottoMoney) {
        if (lottoMoney % DEFAULT_LOTTO_MONEY_UNIT != 0) {
            throw new IllegalArgumentException(LottoExceptionMessage.INVALID_MONEY_UNIT);
        }
    }

    public boolean canBuy() {
        return buyCount > 0;
    }

    public void subtract() {
        buyCount--;
    }
}
