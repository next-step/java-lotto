package lotto.view;

import lotto.dto.LottoResult;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.Rank;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {

    private static final String OUTPUT_BUYING_LOTTOS = "%d개를 구매했습니다.";
    private static final String DELIMITER = ", ";
    private static final String OUTPUT_OPEN_BRACKET = "[";
    private static final String OUTPUT_CLOSE_BRACKET = "]";
    private static final String OUTPUT_STATISTICS = "당첨 통계";
    private static final String OUTPUT_LINE = "=========";
    private static final String OUTPUT_WINNINGS = "%d개 일치 (%d원)- %d개";
    private static final String OUTPUT_YIELD = "총 수익률은 %.2f 입니다.";

    private ResultView() {
        throw new AssertionError();
    }

    public static void printBuyingLottos(Lottos buyingLottos) {
        System.out.println(String.format(OUTPUT_BUYING_LOTTOS, buyingLottos.size()));

        List<Lotto> lottos = buyingLottos.get();
        for (Lotto lotto : lottos) {
            printLottos(lotto);
        }
    }

    private static void printLottos(Lotto lotto) {
        StringBuilder sb = new StringBuilder();
        sb.append(OUTPUT_OPEN_BRACKET);
        sb.append(lotto.get()
                .stream()
                .map(num -> String.valueOf(num))
                .collect(Collectors.joining(DELIMITER)));
        sb.append(OUTPUT_CLOSE_BRACKET);
        System.out.println(sb);
    }

    public static void printResult(Money buyingMoney, LottoResult lottoResult) {
        System.out.println(OUTPUT_STATISTICS);
        System.out.println(OUTPUT_LINE);

        long winningsSum = printStatistics(lottoResult);

        printYield(buyingMoney, winningsSum);
    }

    private static long printStatistics(LottoResult lottoResult) {
        Map<Rank, Integer> rankResult = lottoResult.getRankResult();
        long winningsSum = lottoResult.getWinningsSum();
        for (Map.Entry<Rank, Integer> result : rankResult.entrySet()) {
            Rank rank = result.getKey();
            int count = result.getValue();
            System.out.println(String.format(OUTPUT_WINNINGS, rank.matchCount(), rank.winnings(), count));
        }
        return winningsSum;
    }

    private static void printYield(Money buyingMoney, long result) {
        System.out.println(String.format(OUTPUT_YIELD, buyingMoney.getYield(result)));
    }
}
