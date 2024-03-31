package lotto.prize;

public class StandardPrizeRate implements PrizeRateStrategy {

    @Override
    public double getRate(int earningMoney, int spendMoney) {
        return (earningMoney) / (double) (spendMoney);

    }
}
