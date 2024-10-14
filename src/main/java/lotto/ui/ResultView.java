package lotto.ui;

import java.util.Map;
import lotto.domain.LotteryMachine;
import lotto.domain.Rank;
import lotto.model.RankSummary;

public class ResultView {

    private static final String PURCHASED_LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String RANK_SUMMARY_MESSAGE = "당첨 통계";
    private static final String DIVIDING_LINE = "---------";
    private static final String COUNT_UNIT = "개";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)\n";
    private static final String PROFIT = "이익";
    private static final String LOSS = "손해";

    private static final String THREE_MATCHES_MESSAGE = "3개 일치 (5000원)- ";
    private static final String FOUR_MATCHES_MESSAGE = "4개 일치 (50000원)- ";
    private static final String FIVE_MATCHES_MESSAGE = "5개 일치 (1500000원)- ";
    private static final String SIX_MATCHES_MESSAGE = "6개 일치 (2000000000원)- ";

    private ResultView() {
        throw new UnsupportedOperationException("유틸형 클래스는 생성할 수 없습니다");
    }

    public static void printLottoInfo(LotteryMachine machine) {
        printPurchasedLottoCount(machine);
        printLotto(machine);
    }

    private static void printPurchasedLottoCount(LotteryMachine machine) {
        System.out.printf((PURCHASED_LOTTO_COUNT_MESSAGE) + "%n", machine.getPurchasedLottoCount());
    }

    private static void printLotto(LotteryMachine machine) {
        machine.getLottoNumbers()
                .forEach(numbers -> System.out.printf("[%s]%n", numbers));
    }

    public static void printRankSummary(RankSummary rankSummary) {
        printBlankLine();
        System.out.println(RANK_SUMMARY_MESSAGE);

        Map<Rank, Long> rankCounts = rankSummary.getRankCounts();

        System.out.println(THREE_MATCHES_MESSAGE + rankCounts.getOrDefault(Rank.THREE_MATCHES, 0L) + COUNT_UNIT);
        System.out.println(FOUR_MATCHES_MESSAGE + rankCounts.getOrDefault(Rank.FOUR_MATCHES, 0L) + COUNT_UNIT);
        System.out.println(FIVE_MATCHES_MESSAGE + rankCounts.getOrDefault(Rank.FIVE_MATCHES, 0L) + COUNT_UNIT);
        System.out.println(SIX_MATCHES_MESSAGE + rankCounts.getOrDefault(Rank.SIX_MATCHES, 0L) + COUNT_UNIT);

        System.out.printf(PROFIT_RATE_MESSAGE,
                rankSummary.getProfitRate(),
                rankSummary.getProfitRate() >= 1 ? PROFIT : LOSS);
    }

    private static void printBlankLine() {
        System.out.println();
    }

    private static void printDividingLine() {
        System.out.println(DIVIDING_LINE);
    }
}
