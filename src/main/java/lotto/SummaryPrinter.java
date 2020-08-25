package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class SummaryPrinter {
    private static final int PRIZE_MINIMUM_MATCHED_COUNT = 3;
    private static final int PRIZE_MAXIMUM_MATCHED_COUNT = 6;

    public static void summary(final Lottos lottos, final String[] winningNumber){
        Winners winners = lottos.getWinner(LottoNumber.makeLottoNums(winningNumber));

        BigDecimal total = BigDecimal.ZERO;

        for(int i = PRIZE_MINIMUM_MATCHED_COUNT; i <= PRIZE_MAXIMUM_MATCHED_COUNT; i ++){
            BigDecimal prize = getPrize(i);
            int matchedAmount = winners.getWinnersCount(i);

            print(i, prize, matchedAmount);
            total = calcEarnedPrize(matchedAmount,prize,total);
        }

        System.out.println(String.format("총 수익률은 %s 입니다.", new DecimalFormat("0.00").format(compareEarningRate(lottos, total))));
    }

    private static BigDecimal compareEarningRate(Lottos lottos, BigDecimal earned){
        BigDecimal spent = BigDecimal.valueOf(lottos.getSize()).multiply(BigDecimal.valueOf(Lotto.PRICE)); //쓴돈

        return earned.divide(spent,3, RoundingMode.HALF_EVEN); // 수익률 = 번돈 / 쓴돈

    }

    private static BigDecimal calcEarnedPrize(int matchedAmount, BigDecimal prize, BigDecimal total){
        return total.add(prize.multiply(new BigDecimal(matchedAmount)));
    }

    private static void print(int matchedCount, BigDecimal prize, int matchedAmount){
       String printStr = String.format("%d개 일치(%s)-%d개", matchedCount, new DecimalFormat("0").format(prize), matchedAmount);
       System.out.println(printStr);
    }

    public static BigDecimal getPrize(int matchedCount){
        switch(matchedCount){
            case 6:
                return BigDecimal.valueOf(2000000000L);
            case 5:
                return BigDecimal.valueOf(1500000L);
            case 4:
                return BigDecimal.valueOf(50000L);
            case 3:
                return BigDecimal.valueOf(5000L);
            default:
                return BigDecimal.ZERO;
        }
    }
}
