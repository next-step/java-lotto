package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.util.Statistics;

public class ResultView {

    public static void printLottoStatistics(List<Statistics> lottoResults, String earningRate) {
        OutputView.printLottoStatisticTitle();

        for (int i = 3; i <= 6; i++) {
            OutputView.printLottoStatistic(i, Statistics.getRank(i).getMoney(),
                Statistics.getCount(lottoResults, i));
            if (i == 5) {
                OutputView.printLottoBonusStatistic(i, Statistics.getRank(7).getMoney(),
                    Statistics.getCount(lottoResults, 7));
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
