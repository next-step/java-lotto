package domain;

import domain.wrapper.EarningRate;
import domain.wrapper.Money;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;

    public static int buyLottoCount(int price) {
        int lottoCount = price / LOTTO_PRICE;
        return lottoCount;
    }

    public static EarningRate getTotalEarningRate(Money price, Money totalRewards) {
        return new EarningRate((double)totalRewards.getNumber() / (double)price.getNumber());
    }
}
