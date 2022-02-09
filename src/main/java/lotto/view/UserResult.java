package lotto.view;

import java.util.Arrays;
import java.util.Comparator;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.domain.RankResult;

public class UserResult {

    private final static String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private final static String RANK_STATISTICS = "당첨 통계";
    private final static String DOT_LINE = "---------";
    private final static String RESULT_MESSAGE = "%s개 일치 (%d원)- %d개\n";
    private final static String SECOND_RESULT_MESSAGE = "%s개 일치, 보너스 볼 일치 (%d원)- %d개\n";
    private final static String TOTAL_RATIO_MESSAGE = "총 수익률은 %.2f입니다.";

    private UserResult(){

    }

    public static void printLottoBundle(final Lottos lottos){
        System.out.println(lottos.getLottosSize()+LOTTO_COUNT_MESSAGE);
        printLottoNumber(lottos);
    }

    public static void printRank(final RankResult rankResult){
        System.out.println(RANK_STATISTICS);
        System.out.println(DOT_LINE);
        printRankDetail(rankResult);

    }

    public static void printResult(final RankResult rankResult, final Rank rank){
        if (printSecond(rankResult, rank)) {
            return;
        }
        System.out.printf(RESULT_MESSAGE, rankMatchCount(rank), rankPrize(rank), rankResultValue(rankResult, rank));
    }

    public static void printPrizeRatio(final Money totalPrize, final Money money){
        System.out.printf(TOTAL_RATIO_MESSAGE, ratioValue(totalPrize, money));
    }

    private static Integer rankResultValue(RankResult rankResult, Rank rank) {
        return rankResult.getRankResult().get(rank);
    }

    private static int rankPrize(Rank rank) {
        return rank.getPrize().getValue();
    }

    private static int rankMatchCount(Rank rank) {
        return rank.getMatchCount();
    }

    private static float ratioValue(Money totalPrize, Money money) {
        return totalPrize.getValue() / (float) money.getValue();
    }

    private static boolean printSecond(final RankResult rankResult, final Rank rank) {
        if(rank == rank.SECOND) {
            System.out.printf(SECOND_RESULT_MESSAGE, rankMatchCount(rank), rankPrize(rank), rankResultValue(rankResult, rank));
            return true;
        }
        return false;
    }

    private static void printLottoNumber(Lottos lottos) {
        lottos.lottos()
            .forEach(lotto -> System.out.println(lotto.getLottoNumber()));
    }

    private static void printRankDetail(RankResult rankResult) {
        Arrays.stream(Rank.values())
            .sorted(Comparator.reverseOrder())
            .filter(Rank::get)
            .forEach(Rank->printResult(rankResult, Rank));
    }
}
