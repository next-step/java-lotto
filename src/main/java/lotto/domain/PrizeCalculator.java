package lotto.domain;

import java.math.BigDecimal;

public class PrizeCalculator {

    private PrizeCalculator(){
    }

    public static BigDecimal rateOfPrize(Winners winners){
        return winners.calcWinnerPrize().divide(calcUsedMoney(winners.getSize()), 2, BigDecimal.ROUND_CEILING);
    }

    private static BigDecimal calcUsedMoney(int lottoCount) {
        return BigDecimal.valueOf(lottoCount).multiply(Lotto.PRICE);
    }
}
