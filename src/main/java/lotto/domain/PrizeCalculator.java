package lotto.domain;

import java.math.BigDecimal;

public class PrizeCalculator {

    private PrizeCalculator(){
    }

    public static BigDecimal rateOfPrize(Winners winners){
        return calcTotalPrize(winners);
    }

    private static BigDecimal calcTotalPrize(Winners winners) {
        BigDecimal usedMoney = BigDecimal.ZERO;
        BigDecimal totalPrize = BigDecimal.ZERO;

        for(Rank rank : Rank.values()){
            BigDecimal winningMoeny = rank.getWinningMoney();
            BigDecimal count = winners.getWinnersCount(rank).toBigDecimal();

            totalPrize = totalPrize.add(winningMoeny.multiply(count));
            usedMoney = usedMoney.add(Lotto.PRICE.multiply(count));
        }

        return totalPrize.divide(usedMoney);
    }
}
