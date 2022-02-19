package lotto.view;

import java.util.Arrays;
import java.util.Comparator;
import lotto.domain.Rank;
import lotto.domain.RankResult;
import lotto.domain.dto.LottoCalculationDTO;
import lotto.domain.dto.RankDTO;

public class OutputView {

    private final static String RANK_STATISTICS = "당첨 통계";
    private final static String DOT_LINE = "---------";
    private final static String RESULT_MESSAGE = "%s개 일치 (%d원)- %d개\n";
    private final static String SECOND_RESULT_MESSAGE = "%s개 일치, 보너스 볼 일치 (%d원)- %d개\n";
    private final static String TOTAL_RATIO_MESSAGE = "총 수익률은 %.2f입니다.";
    private final static String PURCHASED_LOTTO_RESULT = "수동으로 %d장, 자동으로 %d개를 구매했습니다.\n";

    public OutputView() {
    }

    public void printCountMessage(LottoCalculationDTO LottoCalculationDto) {
        System.out.printf(PURCHASED_LOTTO_RESULT, LottoCalculationDto.getNumberOfLottoManual(),
            LottoCalculationDto.getNumberOfLottoAutomatical());
        LottoCalculationDto.getLottos().forEach(
            lotto -> System.out.println(lotto.getLottoNumber())
        );
    }

    public void printRankResult(RankDTO rankDto) {
        System.out.println(RANK_STATISTICS);
        System.out.println(DOT_LINE);
        Arrays.stream(Rank.values())
            .sorted(Comparator.reverseOrder())
            .filter(Rank::get)
            .forEach(Rank -> printResult(rankDto.getRankResult(), Rank));

        System.out.printf(TOTAL_RATIO_MESSAGE, rankDto.getPurchaseAmount()
            .getPrizeRatio(rankDto.getRankResult().getTotalPrize(), rankDto.getPurchaseAmount()));
    }

    public void printResult(RankResult rankResult, Rank rank) {
        if (rank.isSecond(rank)) {
            System.out.printf(SECOND_RESULT_MESSAGE, rank.getMatchCount(),
                rank.getPrize(), rankResult.getRankResult(rank));
            return;
        }
        System.out.printf(RESULT_MESSAGE, rank.getMatchCount(), rank.getPrize(),
            rankResult.getRankResult(rank));
    }
}
