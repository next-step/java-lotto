package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoStatistics;
import lotto.domain.Statistics;

public class ResultView {

    private static final int LOTTO_MAX_MATCH_COUNT = 6;
    private static final int LOTTO_MIN_MATCH_COUNT = 3;
    private static final int LOTTO_BONUS_MATCH_COUNT = 7;
    private static final int CASE_BONUS_BALL = 5;

    public static void printLottoStatistics(LottoStatistics lottoStatistics) {
        OutputView.printLottoStatisticTitle();

        for (int i = LOTTO_MIN_MATCH_COUNT; i <= LOTTO_MAX_MATCH_COUNT; i++) {
            OutputView.printLottoStatistic(i, Statistics.getRank(i).getMoney(),
                Statistics.getCount(lottoStatistics.getResultStatistics(), i));
            if (i == CASE_BONUS_BALL) {
                OutputView.printLottoBonusStatistic(i,
                    Statistics.getRank(LOTTO_BONUS_MATCH_COUNT).getMoney(),
                    Statistics.getCount(lottoStatistics.getResultStatistics(), LOTTO_BONUS_MATCH_COUNT));
            }
        }
        OutputView.printTotalReturn(Double.parseDouble(lottoStatistics.getLottoEarningRate()));
    }

    public static void printLottoNumbers(List<Lotto> lottoLists) {
        for (int i = 0; i < lottoLists.size(); i++) {
            OutputView.printLottoNumber(lottoLists.get(i));
            System.out.println();
        }
    }
}
