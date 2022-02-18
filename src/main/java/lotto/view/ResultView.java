package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoStatistics;
import lotto.domain.Rank;

public class ResultView {

    private ResultView() {
    }

    private static final int LOTTO_MAX_MATCH_COUNT = 6;
    private static final int LOTTO_MIN_MATCH_COUNT = 3;
    private static final int LOTTO_BONUS_MATCH_COUNT = 7;
    private static final int CASE_BONUS_BALL = 5;

    public static void printLottoStatistics(Map<Integer, Integer> rankReport) {
        OutputView.printLottoStatisticTitle();
        for (Integer key : rankReport.keySet()) {
            if(key == 7 && rankReport.get(7) > 0) {
                OutputView.printLottoBonusStatistic(CASE_BONUS_BALL, 1500000, rankReport.get(key));
            }
            else {
                OutputView.printLottoStatistic(key, Rank.getRank(key).getMoney(),
                    rankReport.get(key));
            }
        }
    }

    public static void printLottoNumbers(List<Lotto> lottoLists) {
        for (Lotto lotto : lottoLists) {
            OutputView.printLottoNumber(lotto);
            System.out.println();
        }
    }
}
