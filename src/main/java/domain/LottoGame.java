package domain;

import domain.wrapper.EarningRate;
import domain.wrapper.Money;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;

    public static double getTotalEarningRate(int price, int rewards) {
        if (price == 0) {
            return 0;
        }
        return (double) rewards / (double) price;
    }

    public static int buyLottoCount(int price) {
        int lottoCount = price / LOTTO_PRICE;
        return lottoCount;
    }

    public static EarningRate getTotalEarningRate(Money price, Money totalRewards) {
        return new EarningRate((double)price.getNumber() / (double)totalRewards.getNumber());
    }
}
