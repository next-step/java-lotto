package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoStatistics;
import lotto.domain.Statistics;

public class ResultView {

    private static final int LOTTO_MAX_GRADE = 6;
    private static final int LOTTO_MIN_GRADE = 3;
    private static final int LOTTO_BONUS_GRADE = 7;
    private static final int CASE_BONUS_BALL = 5;

    public static void printLottoNumbers(List<Lotto> lottoTicket) {
        lottoTicket.stream().forEach(item -> {
            OutputView.printLottoNumber(item);
            System.out.println();
        });
    }

    public static void printLottoStatistics(LottoStatistics lottoStatistics) {
        OutputView.printLottoStatisticTitle();

        printLottoStatistic(lottoStatistics);

        OutputView.printTotalReturn(Double.parseDouble(lottoStatistics.getLottoEarningRate()));
    }

    private static void printLottoStatistic(LottoStatistics lottoStatistics) {
        for (int i = LOTTO_MIN_GRADE; i <= LOTTO_MAX_GRADE; i++) {
            printLottoStatus(lottoStatistics, i);

            if (i == CASE_BONUS_BALL) {
                printLottoStatus(lottoStatistics, LOTTO_BONUS_GRADE);
            }
        }
    }

    private static void printLottoStatus(LottoStatistics lottoStatistics, int lottoGrade) {
        int grade = lottoGrade;
        final int money = Statistics.getRank(grade).getMoney();
        final int count = Statistics.getCount(lottoStatistics.getResultStatistics(), grade);

        OutputView.printLottoStatistic(grade, money, count);
    }
}
