package views;

import data.Messages;
import domain.Lotto;
import domain.PrizeEnum;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultView {

    public static void println(int num) {
        System.out.println(num);
    }

    public static void println(String str) {
        System.out.println(str);
    }

    public static void printLottoNumber(List<Lotto> lottos) {
        lottos.forEach(lotto -> println(convertToString(lotto.getLottoNumbers())));
    }

    public static String convertToString(List<Integer> lottoNumbers) {
        return Arrays.toString(lottoNumbers.toArray());
    }

    public static void printSummary(List<Integer> winNumbers, List<Lotto> lottos) {

        Map<Long, Integer> summaryMap = getSummary(winNumbers, lottos);

        BigDecimal totalAmount = BigDecimal.valueOf(lottos.size() * InputView.TICKET_PRICE);

        BigDecimal sumPrizeAmount = BigDecimal.ZERO;

        for (PrizeEnum prizeEnum : PrizeEnum.values()) {

            long hitCnt = prizeEnum.getHit();
            BigDecimal prizeAmt = prizeEnum.getPrizeAmt();
            int exactTicketCnt = summaryMap.getOrDefault(hitCnt, 0);

            System.out.printf(Messages.PRIZE_RESULT, hitCnt, prizeAmt.toPlainString(), exactTicketCnt);

            sumPrizeAmount = sumPrizeAmount.add(prizeAmt.multiply(BigDecimal.valueOf(exactTicketCnt)));
        }

        System.out.printf(Messages.TOTAL_PRIZE_RATIO, sumPrizeAmount.divide(totalAmount, 2, RoundingMode.HALF_UP).doubleValue());
    }

    private static Map<Long, Integer> getSummary(List<Integer> winNumbers, List<Lotto> lottos) {
        Map<Long, Integer> summaryMap = new HashMap<>();
        for (Lotto lotto : lottos) {
            long existsCnt = lotto.getLottoNumbers()
                    .stream()
                    .filter(winNumbers::contains)
                    .count();

            summaryMap.put(existsCnt, summaryMap.getOrDefault(existsCnt, 0) + 1);
        }
        return summaryMap;
    }

    public static void printWinNumbers(String[] lottoNumbers) {
        println(Arrays.toString(lottoNumbers));
    }
}
