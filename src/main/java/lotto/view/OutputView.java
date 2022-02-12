package lotto.view;

import java.util.Arrays;
import java.util.Comparator;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.RankResult;
import lotto.domain.dto.LottoCalculationDTO;

public class OutputView {

    private final static String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private final static String RANK_STATISTICS = "당첨 통계";
    private final static String DOT_LINE = "---------";
    private final static String RESULT_MESSAGE = "%s개 일치 (%d원)- %d개\n";
    private final static String SECOND_RESULT_MESSAGE = "%s개 일치, 보너스 볼 일치 (%d원)- %d개\n";
    private final static String TOTAL_RATIO_MESSAGE = "총 수익률은 %.2f입니다.";
    private final static String PURCHASED_LOTTO_RESULT = "수동으로 %d장, 자동으로 %d개를 구매했습니다.\n";

    private OutputView() {

    }

    public static void printCountMessage(LottoCalculationDTO resultDto) {
        System.out.printf(PURCHASED_LOTTO_RESULT, resultDto.getNumberOfLottoManual(), resultDto.getNumberOfLottoAutomatical());
        for (Lotto lotto : resultDto.getLottos()) {
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
        if (rank.isSencod(rank)) {
            System.out.printf(SECOND_RESULT_MESSAGE, rank.getMatchCount(),
                rank.getPrize().getValue(), rankResult.getRankResult().get(rank));
            return;
        }
        System.out.printf(RESULT_MESSAGE, rank.getMatchCount(), rank.getPrize().getValue(),
            rankResult.getRankResult().get(rank));
    }

    public static void printPrizeRatio(double ratio) {
        System.out.printf(TOTAL_RATIO_MESSAGE, ratio);
    }
}
