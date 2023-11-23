package lotto.view;

import java.util.List;
import lotto.dto.LottoDto;
import lotto.dto.LottosDto;
import lotto.dto.RankResultDto;

public class OutputView {

    public static final String PURCHASED_LOTTO_COUNT_MESSAGE = "%s개를 구매했습니다.\n";
    public static final String RANK_STATISTICS_MESSAGE = "\n당첨 통계\n" + "---------";
    public static final String TOTAL_YIELD_MESSAGE = "총 수익률은 %s입니다.";
    public static final String RANK_STATISTICS_FORMAT = "%s개 일치 (%s원)- %s개\n";

    public void printPurchasedLottoCnt(long lottoCnt) {
        System.out.printf(PURCHASED_LOTTO_COUNT_MESSAGE, lottoCnt);
    }

    public void printPurchasedLottos(LottosDto purchasedLottos) {
        for (LottoDto lottoDto : purchasedLottos.getLottoDtos()) {
            System.out.println(lottoDto.getLottoNumbers().toString());
        }
    }

    public void printLottoRankStatistics(List<RankResultDto> rankResultDtos) {
        System.out.println(RANK_STATISTICS_MESSAGE);
        for (RankResultDto rankResultDto : rankResultDtos) {
            System.out.printf(RANK_STATISTICS_FORMAT,
                    rankResultDto.getCountOfMatch(),
                    rankResultDto.getPrizeMoney(),
                    rankResultDto.getRankCnt());
        }
    }

    public void printLottoYield(double yield) {
        System.out.printf(TOTAL_YIELD_MESSAGE, yield);
    }
}
