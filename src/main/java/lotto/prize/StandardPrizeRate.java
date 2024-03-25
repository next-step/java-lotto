package lotto.prize;

import lotto.prize.PrizeRateStrategy;

public class StandardPrizeRate implements PrizeRateStrategy {

    @Override
    public double getRate(int earningMoney, int spendMoney) {
        return (earningMoney) / (double) (spendMoney);

    }
}
