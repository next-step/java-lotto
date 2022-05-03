package lotto.view;

import lotto.dto.LottoResult;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.Rank;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    private static final String OUTPUT_BUYING_LOTTOS = "%d개를 구매했습니다.";
    private static final String DELIMITER = ", ";
    private static final String OUTPUT_OPEN_BRACKET = "[";
    private static final String OUTPUT_CLOSE_BRACKET = "]";
    private static final String OUTPUT_STATISTICS = "당첨 통계";
    private static final String OUTPUT_LINE = "=========";
    private static final String OUTPUT_WINNINGS = "%d개 일치 (%d원)- %d개";
    private static final String OUTPUT_YIELD = "총 수익률은 %.2f 입니다.";
    private static final long DEFAULT_COUNT = 0L;
    private static final List<Integer> PRINT_MATCH_COUNTS = IntStream.range(3, 7).boxed().collect(Collectors.toList());

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

        printStatistics(lottoResult);

        printYield(lottoResult.getYield(buyingMoney));
    }

    private static void printStatistics(LottoResult lottoResult) {
        Map<Integer, Long> rankResult = getRankResult(lottoResult.getRankResult());

        for (Integer count : PRINT_MATCH_COUNTS) {
            Rank rank = Rank.of(count);
            System.out.println(String.format(OUTPUT_WINNINGS, rank.matchCount(), rank.winnings(), rankResult.getOrDefault(count, DEFAULT_COUNT)));
        }
    }

    private static Map<Integer, Long> getRankResult(List<Rank> rankResult) {
        return rankResult.stream()
                .filter(rank -> rank != Rank.OTHER)
                .collect(Collectors.groupingBy(Rank::matchCount, Collectors.counting()));
    }

    private static void printYield(double yield) {
        System.out.println(String.format(OUTPUT_YIELD, yield));
    }
}
