package lotto.view;

import java.util.Arrays;
import java.util.Comparator;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.domain.RankResult;

public class OutputView {

    private final static String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private final static String RANK_STATISTICS = "당첨 통계";
    private final static String DOT_LINE = "---------";
    private final static String RESULT_MESSAGE = "%s개 일치 (%d원)- %d개\n";
    private final static String SECOND_RESULT_MESSAGE = "%s개 일치, 보너스 볼 일치 (%d원)- %d개\n";
    private final static String TOTAL_RATIO_MESSAGE = "총 수익률은 %.2f입니다.";

    private OutputView() {

    }

    public static void printCountMessage(Lottos lottos) {
        System.out.println(lottos.getLottosSize() + LOTTO_COUNT_MESSAGE);
        for (Lotto lotto : lottos.lottos()) {
            System.out.println(lotto.getLottoNumber());
        }
    }

    public static void printRank(RankResult rankResult) {
        System.out.println(RANK_STATISTICS);
        System.out.println(DOT_LINE);
        Arrays.stream(Rank.values())
            .sorted(Comparator.reverseOrder())
            .filter(Rank::get)
            .forEach(Rank -> printResult(rankResult, Rank));

    }

    public static void printResult(RankResult rankResult, Rank rank) {
        if (printSecond(rankResult, rank)) {
            return;
        }
        System.out.printf(RESULT_MESSAGE, rank.getMatchCount(), rank.getPrize().getValue(),
            rankResult.getRankResult().get(rank));
    }

    public static void printPrizeRatio(Money totalPrize, Money money) {
        System.out.printf(TOTAL_RATIO_MESSAGE, totalPrize.getValue() / (float) money.getValue());
    }

    private static boolean printSecond(RankResult rankResult, Rank rank) {
        if (rank == rank.SECOND) {
            System.out.printf(SECOND_RESULT_MESSAGE, rank.getMatchCount(),
                rank.getPrize().getValue(), rankResult.getRankResult().get(rank));
            return true;
        }
        return false;
    }


}
