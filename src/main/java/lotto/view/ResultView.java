package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class ResultView {

    private ResultView() {}

    private static final int LOTTO_MAX_MATCH_COUNT = 6;
    private static final int LOTTO_MIN_MATCH_COUNT = 3;
    private static final int LOTTO_BONUS_MATCH_COUNT = 7;
    private static final int CASE_BONUS_BALL = 5;

    public static void printLottoStatistics(List<Rank> lottoResults, String earningRate) {
        OutputView.printLottoStatisticTitle();

        for (int i = LOTTO_MIN_MATCH_COUNT; i <= LOTTO_MAX_MATCH_COUNT; i++) {
            OutputView.printLottoStatistic(i, Rank.getRank(i).getMoney(),
                Rank.getCount(lottoResults, i));
            if (i == CASE_BONUS_BALL) {
                OutputView.printLottoBonusStatistic(i,
                    Rank.getRank(LOTTO_BONUS_MATCH_COUNT).getMoney(),
                    Rank.getCount(lottoResults, LOTTO_BONUS_MATCH_COUNT));
            }
        }
        OutputView.printTotalReturn(Double.parseDouble(earningRate));
    }

    public static void printLottoNumbers(List<Lotto> lottoLists) {
        for (int i = 0; i < lottoLists.size(); i++) {
            OutputView.printLottoNumber(lottoLists.get(i));
            System.out.println();
        }
    }
}
