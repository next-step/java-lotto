package lotto.view;

import lotto.dto.LottoResult;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.Rank;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ResultView {

    private static final String OUTPUT_BUYING_LOTTOS = "%d개를 구매했습니다.";
    private static final String DELIMITER = ", ";
    private static final String OUTPUT_OPEN_BRACKET = "[";
    private static final String OUTPUT_CLOSE_BRACKET = "]";

    private static final String OUTPUT_STATISTICS = "당첨 통계";
    private static final String OUTPUT_LINE = "=========";
    private static final String OUTPUT_WINNINGS = "%d개 일치 (%s원)- %d개";
    private static final String OUTPUT_SECOND_WINNINGS = "%d개 일치, 보너스 볼 일치(%s원)- %d개";

    private static final int YIELD_BASIS = 1;
    private static final String OUTPUT_YIELD = "총 수익률은 %.2f 입니다. (기준이 1이기 때문에 결과적으로 %s(이)라는 의미임)";
    private static final String YIELD_LOSS = "손해";
    private static final String YIELD_PROFIT = "이익";

    private static final List<Rank> PRINT_RANKS = Rank.reverseValues();
    private static final long DEFAULT_COUNT = 0L;

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

        System.out.println(getYieldText(lottoResult.getYield(buyingMoney)));
    }

    private static void printStatistics(LottoResult lottoResult) {
        Map<Rank, Long> rankResult = getRankResult(lottoResult.getRankResult());

        PRINT_RANKS.stream()
                .forEach(rank -> printStatistics(rank, rankResult.getOrDefault(rank, DEFAULT_COUNT)));
    }

    private static Map<Rank, Long> getRankResult(List<Rank> rankResult) {
        return rankResult.stream()
                .filter(rank -> rank != Rank.OTHER)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private static void printStatistics(Rank rank, Long count) {
        if (rank == Rank.SECOND) {
            System.out.println(String.format(OUTPUT_SECOND_WINNINGS, rank.matchCount(), rank.winnings(), count));
            return;
        }
        System.out.println(String.format(OUTPUT_WINNINGS, rank.matchCount(), rank.winnings(), count));
    }

    private static String getYieldText(double yield) {
        if (isLoss(yield)) {
            return String.format(OUTPUT_YIELD, yield, YIELD_LOSS);
        }
        return String.format(OUTPUT_YIELD, yield, YIELD_PROFIT);
    }

    private static boolean isLoss(double yield) {
        return yield < YIELD_BASIS;
    }
}
