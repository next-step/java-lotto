package lotto.view;

import lotto.dto.LottoResult;
import lotto.dto.LottoStatistics;
import lotto.dto.LottosResult;

public class ResultView {

    private static final String LOTTO_TREM = "************************";
    private static final String OUTPUT_FORMAT_BUY_LOTTO_COUNT = "%d개를 구매했습니다.";
    private static final String OUTPUT_FORMAT_STATISTICS_RESULT = "%d개 일치 (%d원) - %d개";
    private static final String OUTPUT_FORMAT_STATISTICS_PROFIT = "총 수익률은 %.2f입니다.";
    private static final String OUTPUT_STATISTICS_TITLE = "당첨 통계";

    public static void outputBuyLotto(OuputChannel outputChnnel, LottosResult lottosResult) {
        outputChnnel.out(String.format(OUTPUT_FORMAT_BUY_LOTTO_COUNT, lottosResult.size()));

        for (LottoResult lottoResult : lottosResult.getLottosResult()) {
            outputChnnel.out(lottoResult.toString());
        }
        outputChnnel.out(LOTTO_TREM);
    }

    public static void outputStatistics(OuputChannel outputChnnel, LottoStatistics statistics) {

        outputChnnel.out(LOTTO_TREM);
        outputChnnel.out(OUTPUT_STATISTICS_TITLE);
        outputChnnel.out(LOTTO_TREM);

        statistics.getStatisticsValue().forEach(v -> outputChnnel.out(String.format(OUTPUT_FORMAT_STATISTICS_RESULT,
                                                                                    v.getMatchCount(),
                                                                                    v.getReward(),
                                                                                    v.getLottoCount())));

        outputChnnel.out(String.format(OUTPUT_FORMAT_STATISTICS_PROFIT, statistics.getProfitRate()));
    }

}
