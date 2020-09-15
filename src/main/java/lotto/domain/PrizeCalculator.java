package lotto.domain;

import java.math.BigDecimal;

public class PrizeCalculator {

    private PrizeCalculator(){
    }

    public static BigDecimal rateOfPrize(Winners winners){
        return calcUsedMoney(winners.getSize()).divide(winners.calcWinnerPrize());
    }

    private static BigDecimal calcUsedMoney(int lottoCount) {
        return BigDecimal.valueOf(lottoCount).multiply(Lotto.PRICE);
    }
}
