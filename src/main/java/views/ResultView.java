package views;

import data.Messages;
import domain.Lottos;
import domain.PrizeEnum;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class ResultView {

    public static void println(int num) {
        System.out.println(num);
    }

    public static void println(String str) {
        System.out.println(str);
    }

    public static void printLottoNumber(Lottos lottos) {
        lottos.getLottos().forEach(lotto -> println(convertToString(lotto.getLottoNumbers())));
    }

    public static String convertToString(List<Integer> lottoNumbers) {
        return Arrays.toString(lottoNumbers.toArray());
    }

    public static void printSummary(Map<PrizeEnum, Integer> summaryMap, BigDecimal totalAmount) {

        BigDecimal sumPrizeAmount = BigDecimal.ZERO;
        for (PrizeEnum prizeEnum : PrizeEnum.values()) {
            int ticketCnt = Optional.ofNullable(summaryMap.get(prizeEnum)).orElse(0);
            BigDecimal prizeAmt = prizeEnum.getPrizeAmt();
            String bonusMessage = PrizeEnum.FIVE_HIT_BONUS_HIT.equals(prizeEnum) ? Messages.BONUS_HIT : Messages.BLANK;

            sumPrizeAmount = sumPrizeAmount.add(prizeAmt.multiply(BigDecimal.valueOf(ticketCnt)));

            System.out.printf(Messages.PRIZE_RESULT, prizeEnum.getHit(), bonusMessage, prizeAmt.toPlainString(), ticketCnt);
        }
        System.out.printf(Messages.TOTAL_PRIZE_RATIO, sumPrizeAmount.divide(totalAmount, 2, RoundingMode.HALF_UP).doubleValue());
    }

    public static void printWinNumbers(String[] lottoNumbers) {
        println(Arrays.toString(lottoNumbers));
    }
}
